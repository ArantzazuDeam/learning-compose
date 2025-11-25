package com.example.mynewcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mynewcompose.presentation.navigation.NavigationWrapper
import com.example.mynewcompose.ui.theme.MyNewComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNewComposeAppTheme {
                NavigationWrapper()
            }
        }
    }
}
