package com.example.mynewcompose.presentation.components.advance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynewcompose.ui.theme.Pink100
import com.example.mynewcompose.ui.theme.Pink40
import kotlinx.coroutines.delay

@Composable
fun LaunchedEffectExample(
    modifier: Modifier = Modifier,
    onFinished: () -> Unit = {},
) {
    var timeLeft by remember { mutableIntStateOf(5) }

    LaunchedEffect(timeLeft) {
        if (timeLeft > 0) {
            delay(1000)
            timeLeft--
        } else {
            onFinished()
        }
    }

    // Si le pones Unit a un launchEffect, esto se va a ejecutar solo la primera vez que se ejecute el composable.
    // Si se recompone la vista no pasa nada.
    // Prohibido poner: true, false o null. Son errores conceptuales y podrían producir crashes o casuísticas raras.
//    LaunchedEffect(Unit) { }

    Box(
        modifier =
            modifier
                .size(150.dp)
                .background(if (timeLeft > 0) Pink100 else Pink40),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = if (timeLeft > 0) timeLeft.toString() else "BOOOM",
            fontSize = 30.sp,
            color = if (timeLeft > 0) Pink40 else Pink100,
        )
    }
}
