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
fun MyConstraintExample1() {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .background(Color.LightGray),
    ) {
        val (redBox, blueBox, yellowBox, pinkBox, greenBox) = createRefs()
        Box(
            Modifier
                .constrainAs(
                    redBox,
                    constrainBlock = {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                ).size(50.dp)
                .background(Color.Red),
        ) {}
        Box(
            Modifier
                .constrainAs(
                    blueBox,
                    constrainBlock = {
                        top.linkTo(redBox.bottom)
                        start.linkTo(redBox.end)
                    },
                ).size(90.dp)
                .background(Color.Blue),
        ) {
        }
        Box(
            Modifier
                .constrainAs(
                    yellowBox,
                    constrainBlock = {
                        end.linkTo(redBox.start)
                        bottom.linkTo(redBox.top)
                    },
                ).size(60.dp)
                .background(Color.Yellow),
        ) {
        }
        Box(
            Modifier
                .constrainAs(
                    pinkBox,
                    constrainBlock = {
                        start.linkTo(redBox.end)
                        bottom.linkTo(redBox.top)
                    },
                ).size(126.dp)
                .background(Color.Magenta),
        ) {
        }
        Box(
            Modifier
                .constrainAs(greenBox, constrainBlock = {
                    top.linkTo(redBox.bottom)
                    end.linkTo(redBox.start)
                })
                .size(110.dp)
                .background(Color.Green),
        ) {}
    }
}
