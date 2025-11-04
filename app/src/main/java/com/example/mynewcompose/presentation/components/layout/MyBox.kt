package com.example.mynewcompose.presentation.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun MySecondBox113() {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color.LightGray),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier =
                Modifier
                    .width(200.dp)
                    .height(100.dp)
                    .background(Color.Cyan)
                    .verticalScroll(
                        rememberScrollState(),
                    ),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Text("Esto es un ejemplo de un texto muy largo en una cajita amplia y no tan chata.")
        }
    }
}

@Composable
fun MyBox110() {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color.LightGray),
        contentAlignment = Alignment.CenterEnd,
    ) {
        Box(
            modifier =
                Modifier
                    .width(50.dp)
                    .height(80.dp)
                    .background(Color.Cyan)
                    .verticalScroll(rememberScrollState()),
        ) {
            Text("Esto es un ejemplo de un texto muy largo en una cajita muy estrecha y no tan chata.")
        }
    }
}
