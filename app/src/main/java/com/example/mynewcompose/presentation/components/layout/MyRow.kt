package com.example.mynewcompose.presentation.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun My112Row() {
    ConstraintLayout(
        Modifier.fillMaxSize(),
    ) {
        val (fila1, fila2) = createRefs()
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, start = 5.dp)
                .horizontalScroll(rememberScrollState())
                .constrainAs(
                    ref = fila1,
                ) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(fila2.top, margin = 20.dp)
                    width = Dimension.fillToConstraints
                },
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Text(
                text = "Este es el texto 1 de la Fila 1",
                modifier = Modifier.background(Color.Cyan).height(60.dp),
            )
            Text(
                text = "Este es el texto 2 de la Fila 1",
                modifier = Modifier.background(Color.Red).height(60.dp),
            )
            Text(
                text = "Este es el texto 3 de la Fila 1",
                modifier = Modifier.background(Color.Blue).height(60.dp),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 4 de la Fila 1",
                modifier = Modifier.background(Color.Yellow).height(60.dp),
            )
            Text(
                text = "Este es el texto 5 de la Fila 1",
                modifier = Modifier.background(Color.Cyan).height(60.dp),
            )
            Text(
                text = "Este es el texto 6 de la Fila 1",
                modifier = Modifier.background(Color.Red).height(60.dp),
            )
            Text(
                text = "Este es el texto 7 de la Fila 1",
                modifier = Modifier.background(Color.Blue).height(60.dp),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 8 de la Fila 1",
                modifier = Modifier.background(Color.Yellow).height(60.dp),
            )
            Text(
                text = "Este es el texto 9 de la Fila 1",
                modifier = Modifier.background(Color.Cyan).height(60.dp),
            )
            Text(
                text = "Este es el texto 10 de la Fila 1",
                modifier = Modifier.background(Color.Red).height(60.dp),
            )
            Text(
                text = "Este es el texto 11 de la Fila 1",
                modifier = Modifier.background(Color.Blue).height(60.dp),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 12 de la Fila 1",
                modifier = Modifier.background(Color.Yellow).height(60.dp),
            )
            Text(
                text = "Este es el texto 13 de la Fila 1",
                modifier = Modifier.background(Color.Cyan).height(60.dp),
            )
            Text(
                text = "Este es el texto 14 de la Fila 1",
                modifier = Modifier.background(Color.Red).height(60.dp),
            )
            Text(
                text = "Este es el texto 15 de la Fila 1",
                modifier = Modifier.background(Color.Blue).height(60.dp),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 16 de la Fila 1",
                modifier = Modifier.background(Color.Yellow).height(60.dp),
            )
            Text(
                text = "Este es el texto 17 de la Fila 1",
                modifier = Modifier.background(Color.Cyan).height(60.dp),
            )
            Text(
                text = "Este es el texto 18 de la Fila 1",
                modifier = Modifier.background(Color.Red).height(60.dp),
            )
            Text(
                text = "Este es el texto 19 de la Fila 1",
                modifier = Modifier.background(Color.Blue).height(60.dp),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 20 de la Fila 1",
                modifier = Modifier.background(Color.Yellow),
            )
            Text(
                text = "Este es el texto 21 de la Fila 1",
                modifier = Modifier.background(Color.Cyan),
            )
            Text(
                text = "Este es el texto 22 de la Fila 1",
                modifier = Modifier.background(Color.Red),
            )
            Text(
                text = "Este es el texto 23 de la Fila 1",
                modifier = Modifier.background(Color.Blue).height(60.dp),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 24 de la Fila 1",
                modifier = Modifier.background(Color.Yellow).height(60.dp),
            )
            Text(
                text = "Este es el texto 25 de la Fila 1",
                modifier = Modifier.background(Color.Cyan).height(60.dp),
            )
            Text(
                text = "Este es el texto 26 de la Fila 1",
                modifier = Modifier.background(Color.Red).height(60.dp),
            )
            Text(
                text = "Este es el texto 27 de la Fila 1",
                modifier = Modifier.background(Color.Blue).height(60.dp),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 28 de la Fila 1",
                modifier = Modifier.background(Color.Yellow).height(60.dp),
            )
            Text(
                text = "Este es el texto 29 de la Fila 1",
                modifier = Modifier.background(Color.Cyan).height(60.dp),
            )
            Text(
                text = "Este es el texto 30 de la Fila 1",
                modifier = Modifier.background(Color.Red).height(60.dp),
            )
            Text(
                text = "Este es el texto 31 de la Fila 1",
                modifier = Modifier.background(Color.Blue).height(60.dp),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 32 de la Fila 1",
                modifier = Modifier.background(Color.Yellow).height(60.dp),
            )
        }
        Row(
            Modifier
                .padding(top = 50.dp, end = 12.dp, start = 16.dp)
                .horizontalScroll(rememberScrollState())
                .fillMaxWidth()
                .constrainAs(
                    ref = fila2,
                ) {
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    top.linkTo(fila1.bottom, margin = 15.dp)
                    width = Dimension.fillToConstraints
                },
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(
                text = "Este es el texto 1 de la Fila 2",
                modifier = Modifier.background(Color.Green).height(60.dp),
            )
            Text(
                text = "Este es el texto 2 de la Fila 2",
                modifier = Modifier.background(Color.Magenta).height(60.dp),
            )
            Text(
                text = "Este es el texto 3 de la Fila 2",
                modifier = Modifier.background(Color.Gray).height(60.dp),
            )
            Text(
                text = "Este es el texto 4 de la Fila 2",
                modifier = Modifier.background(Color.LightGray).height(60.dp),
            )
            Text(
                text = "Este es el texto 5 de la Fila 2",
                modifier = Modifier.background(Color.Cyan),
            )
        }
    }
}
