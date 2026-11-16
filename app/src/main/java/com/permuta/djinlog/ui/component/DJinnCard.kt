package com.permuta.djinlog.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.permuta.djinlog.R


data class HorizontalCardData(
    var id: Int,
    var title: String,
    var subTitle: String,
    var color: Color,
    var descripcion: String = "",
    @DrawableRes var imageId: Int,
    @DrawableRes var iconId: Int,
)


@Composable
fun HorizontalCard(data: HorizontalCardData, modifier: Modifier = Modifier) {

    Card(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(data.imageId),
                contentDescription = stringResource(R.string.imagen_djinn),
                modifier = Modifier
                    .width(90.dp)
                    .height(90.dp)
                    .clip(CircleShape)
                    .border(border = BorderStroke(2.dp, data.color), CircleShape)
                    .background(Color.White)
            )

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Text(
                        text = data.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        modifier = Modifier
                    )
                    Icon(painter = painterResource(data.iconId),
                        contentDescription = stringResource(R.string.icon_djinn),
                        tint = Color.Unspecified,
                        modifier = Modifier.size(20.dp))
                }

                Text(
                    text = data.descripcion,
                    fontSize = 12.sp
                )


            }
        }
    }

}

@Preview
@Composable
fun HorizontalCardPreview() {
    MaterialTheme() {
        HorizontalCard(
            data = HorizontalCardData(
                1,
                "Fire",
                "Fire",
                Color.Red,
                descripcion = "Este djinn es raro, parece un charmander",
                R.drawable.fire,
                R.drawable.fire_icon
            )
        )
    }
}


