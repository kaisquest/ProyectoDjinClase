package com.permuta.djinlog.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.permuta.djinlog.R
import com.permuta.djinlog.seeder.TipoDjin
import com.permuta.djinlog.seeder.listaDjin
import com.permuta.djinlog.ui.component.HorizontalCard
import com.permuta.djinlog.ui.component.HorizontalCardData


@Composable
fun DJiinListPage() {

    Column(modifier = Modifier.fillMaxSize()) {

        // Barra de búsqueda de momento sin funcionalidad (se implementará en clase)
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(stringResource(R.string.buscar_djinn)) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {

            items(listaDjin.size) { index ->
                var curr = listaDjin[index]
                HorizontalCard(
                    data = HorizontalCardData(
                        id = curr.id,
                        title = curr.nombre,
                        subTitle = "",
                        color = when (curr.tipo) {
                            TipoDjin.FIRE -> Color.Red
                            TipoDjin.AIR -> Color.Cyan
                            TipoDjin.WATER -> Color.Blue
                            TipoDjin.EARTH -> Color.Green
                        },
                        descripcion = curr.descripcion,
                        imageId = when (curr.tipo) {
                            TipoDjin.FIRE -> R.drawable.fire
                            TipoDjin.AIR -> R.drawable.wind
                            TipoDjin.WATER -> R.drawable.water
                            TipoDjin.EARTH -> R.drawable.earth
                        },
                        iconId = when (curr.tipo) {
                            TipoDjin.FIRE -> R.drawable.fire_icon
                            TipoDjin.AIR -> R.drawable.wind_icon
                            TipoDjin.WATER -> R.drawable.water_icon
                            TipoDjin.EARTH -> R.drawable.earth_icon
                        }
                    )
                )
            }
        }
    }
}

@Preview(backgroundColor = 0xFFF0EAE2, showBackground = true)
@Composable
fun DJiinListPagePreview() {
    MaterialTheme() {
        DJiinListPage()
    }
}
