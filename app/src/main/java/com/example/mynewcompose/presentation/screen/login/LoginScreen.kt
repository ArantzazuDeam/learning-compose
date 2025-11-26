package com.example.mynewcompose.presentation.screen.login

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynewcompose.ui.theme.Green100
import com.example.mynewcompose.ui.theme.redCoral

@Composable
fun LoginScreen(navigateToDetail: () -> Unit) {
    var showView: Boolean by remember { mutableStateOf(false) }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Green100)
                .verticalScroll(rememberScrollState()),
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
        Button(onClick = { showView = true }) {
            Text(text = "Mostrar vista")
        }
        Spacer(Modifier.weight(1f))
    }
    MyOtherView(showView, onBackClicked = { hideView -> showView = hideView })
}

@Composable
fun MyOtherView(
    isViewShown: Boolean,
    onBackClicked: (Boolean) -> Unit,
) {
    if (isViewShown) {
        BackHandler { onBackClicked(false) }
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(redCoral),
            contentAlignment = Alignment.Center,
        ) {
            Text("La otra vista", fontSize = 30.sp)
        }
    }
}
