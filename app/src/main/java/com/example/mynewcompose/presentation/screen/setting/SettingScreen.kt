package com.example.mynewcompose.presentation.screen.setting

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
import com.example.mynewcompose.presentation.model.SettingModel
import com.example.mynewcompose.ui.theme.BlueGrey100
import com.example.mynewcompose.ui.theme.BlueGrey60

@Composable
fun SettingScreen(
    settingModel: SettingModel,
    navigateToHome: () -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(BlueGrey100),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.weight(1f))
        Text("Configuración", fontSize = 30.sp, color = BlueGrey60)
        Spacer(Modifier.weight(1f))
        Text("Identificador: ${settingModel.id}", color = BlueGrey60)
        Text("Modo oscuro: ${settingModel.darkMode}", color = BlueGrey60)
        Spacer(Modifier.weight(1f))
        Button(onClick = { navigateToHome() }) {
            Text("Volver al inicio")
        }
        Spacer(Modifier.weight(1f))
    }
}
