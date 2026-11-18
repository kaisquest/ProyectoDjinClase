package com.permuta.djinlog.viewmodel

import androidx.compose.material3.Text
import androidx.lifecycle.ViewModel
import com.permuta.djinlog.seeder.DjinModel
import com.permuta.djinlog.seeder.getDjinnFiltered
import com.permuta.djinlog.seeder.listaDjin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


data class DJinnListUIState(
    //No son todos los elementos de la base de datos, sólo son los elementos que se muestra
    //En los ViewModel vamos a trabajar con Modelos porque queremos trabajar con datos en crudo
    val djinList: List<DjinModel> = emptyList(),
    val searchText: String = "",
)


class DJinnViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DJinnListUIState())
    val uiState: StateFlow<DJinnListUIState> = _uiState.asStateFlow()

    fun load() {
        _uiState.value = _uiState.value.copy(djinList = listaDjin)
    }

    fun onSearchTextChange(newText: String) {
        _uiState.value = _uiState.value.copy(
            searchText = newText,
            djinList = getDjinnFiltered(newText),
        )


    }


}
