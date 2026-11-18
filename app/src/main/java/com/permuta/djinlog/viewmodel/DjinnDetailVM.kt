package com.permuta.djinlog.viewmodel

import androidx.lifecycle.ViewModel
import com.permuta.djinlog.seeder.DjinModel
import com.permuta.djinlog.seeder.getDjinn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


data class DJinnDetailUIState(
    val djinn: DjinModel? = null,
    val errorMsg: String? = null


)

class DjinnDetailVM : ViewModel() {
    private val _uiState = MutableStateFlow(DJinnDetailUIState())
    val uiState: StateFlow<DJinnDetailUIState> = _uiState.asStateFlow()


    fun load(id: Int) {
        val djinn = getDjinn(id)

        _uiState.value = _uiState.value.copy(
            djinn = if djinn == null {
                _uiState.value = _uiState.value.copy(
                    errorMsg = "No se encontró el Djinn."
                )
            } else {
                djinn
            }
        )


    }

}