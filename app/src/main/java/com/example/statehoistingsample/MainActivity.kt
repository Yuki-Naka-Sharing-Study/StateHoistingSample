package com.example.statehoistingsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.statehoistingsample.screen.ClientFormScreen
import com.example.statehoistingsample.ui.theme.StateHoistingSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateHoistingSampleTheme {
                ClientFormScreen()
            }
        }
    }
}
