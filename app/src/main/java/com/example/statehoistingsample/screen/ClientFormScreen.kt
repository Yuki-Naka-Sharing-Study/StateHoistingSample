package com.example.statehoistingsample.screen

import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.statehoistingsample.viewmodel.ClientFormViewModel

@Composable
fun ClientFormScreen(viewModel: ClientFormViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    ClientForm(
        clientType = uiState.clientType,
        onClientTypeChange = viewModel::updateClientType,
        name = uiState.name,
        onNameChange = viewModel::updateName,
        companyName = uiState.companyName,
        onCompanyNameChange = viewModel::updateCompanyName,
        contactName = uiState.contactName,
        onContactNameChange = viewModel::updateContactName
    )
}
