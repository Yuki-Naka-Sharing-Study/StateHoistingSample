package com.example.statehoistingsample.viewmodel

import androidx.lifecycle.ViewModel
import com.example.statehoistingsample.screen.ClientType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ClientFormViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ClientFormUiState())
    val uiState: StateFlow<ClientFormUiState> = _uiState

    fun updateClientType(type: ClientType) {
        _uiState.value = _uiState.value.copy(clientType = type)
    }

    fun updateName(name: String) {
        _uiState.value = _uiState.value.copy(name = name)
    }

    fun updateCompanyName(companyName: String) {
        _uiState.value = _uiState.value.copy(companyName = companyName)
    }

    fun updateContactName(contactName: String) {
        _uiState.value = _uiState.value.copy(contactName = contactName)
    }
}
