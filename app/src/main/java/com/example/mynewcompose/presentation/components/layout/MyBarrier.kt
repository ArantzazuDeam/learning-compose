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
import androidx.constraintlayout.compose.ConstraintLayout

//@Preview
@Composable
fun MyBarrier() {
    ConstraintLayout(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color.DarkGray),
    ) {
        val (greenBox, redBox, yellowBox) = createRefs()
        val myBarrier = createEndBarrier(greenBox, redBox)

        Box(
            modifier =
                Modifier
                    .constrainAs(
                        greenBox,
                        constrainBlock = {
                            top.linkTo(parent.top, margin = 16.dp)
                            start.linkTo(redBox.start)
                            end.linkTo(redBox.end)
                        },
                    ).background(Color.Green)
                    .size(80.dp),
        )
        Box(
            modifier =
                Modifier
                    .constrainAs(
                        redBox,
                        constrainBlock = {
                            top.linkTo(greenBox.bottom)
                            start.linkTo(parent.start)
                        },
                    ).background(Color.Red)
                    .size(160.dp),
        )
        Box(
            modifier =
                Modifier
                    .constrainAs(
                        yellowBox,
                        constrainBlock = {
                            start.linkTo(myBarrier)
                        },
                    ).background(Color.Yellow)
                    .size(60.dp),
        )
    }
}
