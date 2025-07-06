package com.example.statehoistingsample.viewmodel

import com.example.statehoistingsample.screen.ClientType

data class ClientFormUiState(
    val clientType: ClientType = ClientType.Personal,
    val name: String = "",
    val companyName: String = "",
    val contactName: String = ""
)
