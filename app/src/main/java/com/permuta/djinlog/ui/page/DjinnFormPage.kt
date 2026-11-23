package com.permuta.djinlog.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.permuta.djinlog.viewmodel.DJinnFormVM


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DJinnFormPage(vm: DJinnFormVM = viewModel()) {

    val state by vm.uiState.collectAsState()
    Column() {
        OutlinedTextField(
            value = state.name,
            onValueChange = { vm.onNameChange(it) },
            label = { Text("Nombre") },
            isError = state.errorName != null,
            supportingText = { Text(state.errorName ?: "") }
        )
        OutlinedTextField(
            value = state.description,
            onValueChange = { vm.onDescChange(it) },
            label = { Text("Descripción") },
            isError = state.errorDesc != null,
            supportingText = { Text(state.errorDesc ?: "") }
        )

        ExposedDropdownMenuBox(
            expanded = state.expanded,
            onExpandedChange = { vm.onExpandedChange(it) }

        ) {
            OutlinedTextField(
                value = state.tipo.name,
                onValueChange = {},
                label = {Text("Tipo")},
                readOnly = false,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(state.expanded)},
                modifier = Modifier.menuAnchor(
                    ExposedDropdownMenuAnchorType.PrimaryEditable
                )

            )


        }


        Button(
            enabled = vm.isError(),
            onClick = {
                //postDJinn(DJinnModel(id = 0, nombre = state.name, state.description, state.tipo))
            }) { Text("Guardar") }

    }
}


@Preview(showBackground = true)
@Composable
fun DJinnFormPreview() {

    DJinnFormPage()
}