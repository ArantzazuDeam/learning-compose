package com.example.mynewcompose.presentation.screen.home

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
import com.example.mynewcompose.ui.theme.Pink120

@Composable
fun HomeScreen(navigateBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(Pink120),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.weight(1f))
        Text("Home", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Button(onClick = { navigateBack() }) {
            Text("Atrás")
        }
        Spacer(Modifier.weight(1f))
    }
}
