package com.example.mynewcompose.presentation.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun My111Column() {
    ConstraintLayout(
        Modifier.fillMaxSize(),
    ) {
        val (columna1, columna2) = createRefs()
        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(top = 50.dp, start = 5.dp)
                .verticalScroll(rememberScrollState())
                .constrainAs(
                    ref = columna1,
                ) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(columna2.start, margin = 16.dp)
                    width = Dimension.fillToConstraints
                },
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Text(
                text = "Este es el texto 1 de la Columna 1",
                modifier = Modifier.background(Color.Cyan),
            )
            Text(
                text = "Este es el texto 2 de la Columna 1",
                modifier = Modifier.background(Color.Red),
            )
            Text(
                text = "Este es el texto 3 de la Columna 1",
                modifier = Modifier.background(Color.Blue),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 4 de la Columna 1",
                modifier = Modifier.background(Color.Yellow),
            )
            Text(
                text = "Este es el texto 5 de la Columna 1",
                modifier = Modifier.background(Color.Cyan),
            )
            Text(
                text = "Este es el texto 6 de la Columna 1",
                modifier = Modifier.background(Color.Red),
            )
            Text(
                text = "Este es el texto 7 de la Columna 1",
                modifier = Modifier.background(Color.Blue),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 8 de la Columna 1",
                modifier = Modifier.background(Color.Yellow),
            )
            Text(
                text = "Este es el texto 9 de la Columna 1",
                modifier = Modifier.background(Color.Cyan),
            )
            Text(
                text = "Este es el texto 10 de la Columna 1",
                modifier = Modifier.background(Color.Red),
            )
            Text(
                text = "Este es el texto 11 de la Columna 1",
                modifier = Modifier.background(Color.Blue),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 12 de la Columna 1",
                modifier = Modifier.background(Color.Yellow),
            )
            Text(
                text = "Este es el texto 13 de la Columna 1",
                modifier = Modifier.background(Color.Cyan),
            )
            Text(
                text = "Este es el texto 14 de la Columna 1",
                modifier = Modifier.background(Color.Red),
            )
            Text(
                text = "Este es el texto 15 de la Columna 1",
                modifier = Modifier.background(Color.Blue),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 16 de la Columna 1",
                modifier = Modifier.background(Color.Yellow),
            )
            Text(
                text = "Este es el texto 17 de la Columna 1",
                modifier = Modifier.background(Color.Cyan),
            )
            Text(
                text = "Este es el texto 18 de la Columna 1",
                modifier = Modifier.background(Color.Red),
            )
            Text(
                text = "Este es el texto 19 de la Columna 1",
                modifier = Modifier.background(Color.Blue),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 20 de la Columna 1",
                modifier = Modifier.background(Color.Yellow),
            )
            Text(
                text = "Este es el texto 21 de la Columna 1",
                modifier = Modifier.background(Color.Cyan),
            )
            Text(
                text = "Este es el texto 22 de la Columna 1",
                modifier = Modifier.background(Color.Red),
            )
            Text(
                text = "Este es el texto 23 de la Columna 1",
                modifier = Modifier.background(Color.Blue),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 24 de la Columna 1",
                modifier = Modifier.background(Color.Yellow),
            )
            Text(
                text = "Este es el texto 25 de la Columna 1",
                modifier = Modifier.background(Color.Cyan),
            )
            Text(
                text = "Este es el texto 26 de la Columna 1",
                modifier = Modifier.background(Color.Red),
            )
            Text(
                text = "Este es el texto 27 de la Columna 1",
                modifier = Modifier.background(Color.Blue),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 28 de la Columna 1",
                modifier = Modifier.background(Color.Yellow),
            )
            Text(
                text = "Este es el texto 29 de la Columna 1",
                modifier = Modifier.background(Color.Cyan),
            )
            Text(
                text = "Este es el texto 30 de la Columna 1",
                modifier = Modifier.background(Color.Red),
            )
            Text(
                text = "Este es el texto 31 de la Columna 1",
                modifier = Modifier.background(Color.Blue),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Este es el texto 32 de la Columna 1",
                modifier = Modifier.background(Color.Yellow),
            )
        }
        Column(
            Modifier
                .padding(top = 50.dp, end = 12.dp)
                .constrainAs(
                    ref = columna2,
                ) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    start.linkTo(columna1.end, margin = 16.dp)
                    width = Dimension.fillToConstraints
                },
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(
                text = "Este es el texto 1 de la Columna 2",
                modifier =
                    Modifier
                        .background(Color.Green)
                        .weight(1f),
            )
            Text(
                text = "Este es el texto 2 de la Columna 2",
                modifier = Modifier.background(Color.Magenta),
            )
            Text(
                text = "Este es el texto 3 de la Columna 2",
                modifier =
                    Modifier
                        .background(Color.Gray)
                        .weight(2f),
            )
            Text(
                text = "Este es el texto 4 de la Columna 2",
                modifier = Modifier.background(Color.LightGray),
            )
            Text(
                text = "Este es el texto 5 de la Columna 2",
                modifier = Modifier.background(Color.Cyan),
            )
        }
    }
}
