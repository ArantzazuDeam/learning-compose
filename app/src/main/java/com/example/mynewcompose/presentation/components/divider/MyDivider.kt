package com.example.mynewcompose.presentation.components.divider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.ui.theme.Green60
import com.example.mynewcompose.ui.theme.Pink60

@Preview
@Composable
fun MyDivider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
        Row(
            modifier = Modifier.weight(0.25f),
        ) {
            Text("Parte izquierda")
            VerticalDivider(
                thickness = 2.dp,
                color = Green60,
            )
            Text("Parte derecha")
        }

        HorizontalDivider(
            thickness = 6.dp,
            color = Pink60,
        )
        Text(
            "Parte de arriba",
            modifier =
                Modifier
                    .weight(0.5f)
                    .fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
        HorizontalDivider(
            thickness = 2.dp,
            color = Green60,
        )
        Text(
            "Parte de abajo",
            modifier =
                Modifier
                    .weight(0.5f)
                    .fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
    }
}
