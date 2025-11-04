package com.example.mynewcompose.presentation.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//@Preview
@Composable
fun My118Spacer() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier.fillMaxWidth().weight(1f).background(Color.Cyan),
        )
        MySpacer(30)
        Row(
            Modifier.fillMaxWidth().weight(1f),
        ) {
            Box(
                Modifier.fillMaxHeight().weight(1f).background(Color.Red),
            )
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Green)
                    .padding(horizontal = 36.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = "Hola, soy Ari, no -sti pero sí DEV.", textAlign = TextAlign.Center)
            }
        }
        MySpacer(80)
        Box(
            Modifier.fillMaxWidth().weight(1f).background(Color.Magenta),
        ) {}
    }
}
@Composable
fun MySpacer(size: Int) {
    Spacer(Modifier.height(size.dp))
}
