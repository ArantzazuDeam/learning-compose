package com.example.mynewcompose.presentation.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

//@Preview
@Composable
fun MyChain() {
    ConstraintLayout(Modifier.fillMaxSize().background(Color.Gray)) {
        val (greenBox, redBox, yellowBox) = createRefs()

        // Spread. Es el que viene por defecto. Se reparten dejando espacio entre sí a partes iguales
//        createHorizontalChain(greenBox, redBox, yellowBox, chainStyle = ChainStyle.Spread)

        // Packed. Se unen todas las boxes en el centro, agrupaditas y pegaditas entre sí.
//        createHorizontalChain(greenBox, redBox, yellowBox, chainStyle = ChainStyle.Packed)

        // SpreadInside. Se alejan entre sí todo lo posible dejando espacio entre ellas a partes iguales.
        createHorizontalChain(greenBox, redBox, yellowBox, chainStyle = ChainStyle.SpreadInside)

        Box(
            modifier =
                Modifier
                    .constrainAs(
                        greenBox,
                        constrainBlock = {
                            start.linkTo(parent.start)
                            end.linkTo(redBox.start)
                            top.linkTo(parent.top)
                        },
                    ).background(Color.Green)
                    .size(75.dp),
        )

        Box(
            modifier =
                Modifier
                    .constrainAs(
                        redBox,
                        constrainBlock = {
                            start.linkTo(greenBox.end)
                            end.linkTo(yellowBox.start)
                            top.linkTo(greenBox.top)
                        },
                    ).background(Color.Red)
                    .size(75.dp),
        )

        Box(
            modifier =
                Modifier
                    .constrainAs(
                        yellowBox,
                        constrainBlock = {
                            top.linkTo(greenBox.top)
                            start.linkTo(redBox.end)
                            end.linkTo(parent.end)
                        },
                    ).background(Color.Yellow)
                    .size(75.dp),
        )
    }
}
