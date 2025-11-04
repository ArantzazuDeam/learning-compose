package com.example.mynewcompose.presentation.components.oldCourse

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hola $name! ¿Cómo lo llevas? Ahora estoy en LoginScreen",
        modifier = modifier
    )
}

@Preview(
    name = "PRIMERA PREVIEW",
//    widthDp = 250,
//    heightDp = 20,
    showBackground = true,
    showSystemUi = true,
    apiLevel = 29,
    device = Devices.NEXUS_5
)
@Composable
fun testMySuperText() {
    superText(name = "Pedro")
}

@Composable
fun superText(name: String) {
    Text(text = "IYOOOOO, $name", modifier = Modifier
        .height(50.dp)
        .width(300.dp))
}
