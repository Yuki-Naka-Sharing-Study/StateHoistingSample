package com.example.statehoistingsample.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.statehoistingsample.ClientType

class ClientFormViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ClientFormUiState())
    val uiState: StateFlow<ClientFormUiState> = _uiState

    fun onClientTypeChange(type: ClientType) {
        _uiState.value = _uiState.value.copy(clientType = type)
    }

    fun onNameChange(name: String) {
        _uiState.value = _uiState.value.copy(name = name)
    }

    fun onCompanyNameChange(companyName: String) {
        _uiState.value = _uiState.value.copy(companyName = companyName)
    }

    fun onContactNameChange(contactName: String) {
        _uiState.value = _uiState.value.copy(contactName = contactName)
    }
}
