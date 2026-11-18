package com.permuta.djinlog.ui.page

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.permuta.djinlog.R
import com.permuta.djinlog.seeder.TipoDjin
import com.permuta.djinlog.viewmodel.DjinnDetailVM


data class DJinnDetailData(
    val id: Int,
    val name: String,
    val element: String,
    val color: Color,
    val description: String,
    @DrawableRes val imageId: Int,
    @DrawableRes val iconId: Int
)


@Composable
fun DJinnDetailPage(
    id: Int, modifier: Modifier = Modifier,
    vm: DjinnDetailVM = viewModel()
) {

    val state by vm.uiState.collectAsState()

    LaunchedEffect(Unit) {

        vm.load(id)
    }

    if (state.djinn == null){
        Text(stringResource(R.string.djinn_no_encontrado))
        return
    }




    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(
                when (state.djinn!!.tipo) {
                    TipoDjin.FIRE -> R.drawable.fire
                    TipoDjin.AIR -> R.drawable.wind
                    TipoDjin.WATER -> R.drawable.water
                    TipoDjin.EARTH -> R.drawable.earth
                }
            ),
            contentDescription = stringResource(R.string.imagen_djinn),
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(
                    border = BorderStroke(
                        4.dp, when (state.djinn!!.tipo) {
                            TipoDjin.FIRE -> Color.Red
                            TipoDjin.AIR -> Color.Cyan
                            TipoDjin.WATER -> Color.Blue
                            TipoDjin.EARTH -> Color.Green
                        }
                    ), CircleShape
                )
                .background(Color.White)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = state.djinn!!.nombre,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
            Icon(
                painter = painterResource(
                    when (state.djinn!!.tipo) {
                        TipoDjin.FIRE -> R.drawable.fire_icon
                        TipoDjin.AIR -> R.drawable.wind_icon
                        TipoDjin.WATER -> R.drawable.water_icon
                        TipoDjin.EARTH -> R.drawable.earth_icon
                    }
                ),
                contentDescription = stringResource(R.string.icon_djinn),
                tint = Color.Unspecified,
                modifier = Modifier.size(32.dp)
            )
        }

        Text(
            text = state.djinn!!.tipo.toString(),
            fontSize = 16.sp,
            color = Color.Gray
        )

        Text(
            text = state.djinn!!.descripcion,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DJinnDetailPagePreview() {
    MaterialTheme {
        DJinnDetailPage(6)

    }
}
