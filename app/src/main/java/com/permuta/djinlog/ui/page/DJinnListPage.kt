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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.permuta.djinlog.R
import com.permuta.djinlog.seeder.TipoDjin
import com.permuta.djinlog.ui.component.HorizontalCard
import com.permuta.djinlog.ui.component.HorizontalCardData
import com.permuta.djinlog.viewmodel.DJinnViewModel


@Composable
fun DJinnListPage(
    onCardClick: (Int) -> Unit,
    vm: DJinnViewModel = viewModel()
) {

    val state by vm.uiState.collectAsState()
    //La función load del viewmodel siempre va rodeado de un LaunchedEffect, porque así no está
    //recargando la página de manera infinita ni buscando datos sin necesidad
    LaunchedEffect(Unit) {
        vm.load()
    }


    Column(modifier = Modifier.fillMaxSize()) {

        // Barra de búsqueda de momento sin funcionalidad (se implementará en clase)
        OutlinedTextField(
            value = state.searchText,
            onValueChange = {
                vm.onSearchTextChange(it)
            },
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

            items(state.djinList.size) { index ->
                var curr = state.djinList[index]
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
fun DJinnListPagePreview() {
    MaterialTheme() {
        DJinnListPage(onCardClick = {})
    }
}
