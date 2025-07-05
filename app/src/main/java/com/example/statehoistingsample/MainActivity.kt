package com.example.statehoistingsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.statehoistingsample.ui.theme.StateHoistingSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateHoistingSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                        .padding(WindowInsets.safeDrawing.asPaddingValues())
                        .padding(16.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var clientType by remember { mutableStateOf(ClientType.Personal) }
                    var name by remember { mutableStateOf("") }
                    var companyName by remember { mutableStateOf("") }
                    var contactName by remember { mutableStateOf("") }

                    ClientForm(
                        clientType = clientType,
                        onClientTypeChange = { clientType = it },
                        name = name,
                        onNameChange = { name = it },
                        companyName = companyName,
                        onCompanyNameChange = { companyName = it },
                        contactName = contactName,
                        onContactNameChange = { contactName = it }
                    )
                }
            }
        }
    }
}
