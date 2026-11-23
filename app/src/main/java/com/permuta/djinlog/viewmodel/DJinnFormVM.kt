package com.permuta.djinlog.viewmodel

import androidx.lifecycle.ViewModel
import com.permuta.djinlog.seeder.TipoDjin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class DJinnFormUIState(
    val name: String = "",
    val description: String = "",
    val tipo: TipoDjin = TipoDjin.FIRE,

    val errorName: String? = null,
    val errorDesc: String? = null,
    val expanded: Boolean = false,
)




class DJinnFormVM : ViewModel() {



    private val _uiState = MutableStateFlow(DJinnFormUIState())

    val uiState: StateFlow<DJinnFormUIState> = _uiState.asStateFlow()


    fun onNameChange(newText: String) {

        _uiState.value = _uiState.value.copy(errorName = null)
        _uiState.value = _uiState.value.copy(name = newText)
        if (_uiState.value.name.isBlank()) {
            _uiState.value = _uiState.value.copy(errorName = "El nombre no puede estar vacío")

        }
    }

    fun onDescChange(newText: String) {
        _uiState.value = _uiState.value.copy(errorDesc = null)
        _uiState.value = _uiState.value.copy(description = newText)
        if (_uiState.value.description.isBlank()) {
            _uiState.value = _uiState.value.copy(errorDesc = "La descripción no puede estar vacío")

        }
    }

    fun isError(): Boolean {
        return _uiState.value.errorName != null || _uiState.value.errorDesc != null
    }


    fun onExpandedChange(it: Boolean): Unit{

        _uiState.value = _uiState.value.copy(expanded = it)

    }
}