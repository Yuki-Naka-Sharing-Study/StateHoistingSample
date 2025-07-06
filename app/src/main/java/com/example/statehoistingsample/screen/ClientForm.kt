package com.example.statehoistingsample.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ClientForm(
    clientType: ClientType,
    onClientTypeChange: (ClientType) -> Unit,
    name: String,
    onNameChange: (String) -> Unit,
    companyName: String,
    onCompanyNameChange: (String) -> Unit,
    contactName: String,
    onContactNameChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.safeDrawing.asPaddingValues())
            .padding(16.dp)
    ) {
        Text("契約者の種別を選択してください", style = MaterialTheme.typography.titleMedium)

        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            RadioButton(
                selected = clientType == ClientType.Personal,
                onClick = { onClientTypeChange(ClientType.Personal) }
            )
            Text("個人", modifier = Modifier.padding(start = 4.dp))

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = clientType == ClientType.Corporate,
                onClick = { onClientTypeChange(ClientType.Corporate) }
            )
            Text("法人", modifier = Modifier.padding(start = 4.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (clientType) {
            ClientType.Personal -> {
                OutlinedTextField(
                    value = name,
                    onValueChange = onNameChange,
                    label = { Text("氏名") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            ClientType.Corporate -> {
                OutlinedTextField(
                    value = companyName,
                    onValueChange = onCompanyNameChange,
                    label = { Text("会社名") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = contactName,
                    onValueChange = onContactNameChange,
                    label = { Text("担当者名") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { /* Submit action */ }) {
            Text("送信")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClientForm_Personal_Preview() {
    ClientForm(
        clientType = ClientType.Personal,
        onClientTypeChange = {},
        name = "田中 太郎",
        onNameChange = {},
        companyName = "",
        onCompanyNameChange = {},
        contactName = "",
        onContactNameChange = {}
    )
}

@Preview(showBackground = true)
@Composable
fun ClientForm_Corporate_Preview() {
    ClientForm(
        clientType = ClientType.Corporate,
        onClientTypeChange = {},
        name = "",
        onNameChange = {},
        companyName = "株式会社テック",
        onCompanyNameChange = {},
        contactName = "山田 花子",
        onContactNameChange = {}
    )
}
