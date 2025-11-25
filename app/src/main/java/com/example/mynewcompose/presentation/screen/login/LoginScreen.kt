package com.example.mynewcompose.presentation.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynewcompose.ui.theme.Green100

@Composable
fun LoginScreen(navigateToDetail: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Green100),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.weight(1f))
        Text("Iniciar sesión", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Button(onClick = { navigateToDetail() }) {
            Text("Navegar a la home")
        }
        Spacer(Modifier.weight(1f))
    }
}
