package com.example.statehoistingsample.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.statehoistingsample.ClientType
import com.example.statehoistingsample.viewmodel.ClientFormViewModel

@Composable
fun ClientFormScreen(viewModel: ClientFormViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.safeDrawing.asPaddingValues()) // SafeArea対応
            .padding(16.dp)
    ) {
        Text("契約者の種別を選択してください", style = MaterialTheme.typography.titleMedium)

        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            RadioButton(
                selected = uiState.clientType == ClientType.Personal,
                onClick = { viewModel.onClientTypeChange(ClientType.Personal) }
            )
            Text("個人", modifier = Modifier.padding(start = 4.dp))

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = uiState.clientType == ClientType.Corporate,
                onClick = { viewModel.onClientTypeChange(ClientType.Corporate) }
            )
            Text("法人", modifier = Modifier.padding(start = 4.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (uiState.clientType) {
            ClientType.Personal -> {
                OutlinedTextField(
                    value = uiState.name,
                    onValueChange = viewModel::onNameChange,
                    label = { Text("氏名") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            ClientType.Corporate -> {
                OutlinedTextField(
                    value = uiState.companyName,
                    onValueChange = viewModel::onCompanyNameChange,
                    label = { Text("会社名") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = uiState.contactName,
                    onValueChange = viewModel::onContactNameChange,
                    label = { Text("担当者名") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { /* 送信処理 */ }) {
            Text("送信")
        }
    }
}
