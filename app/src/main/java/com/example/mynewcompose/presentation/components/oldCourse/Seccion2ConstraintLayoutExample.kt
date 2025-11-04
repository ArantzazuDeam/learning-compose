package com.example.mynewcompose.presentation.components.oldCourse

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
fun ConstraintLayoutExample() {

    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxYellow, boxMagenta, boxGreen) = createRefs()
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                } )
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    top.linkTo(boxRed.bottom)
                    start.linkTo(boxRed.end)
                } )
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    end.linkTo(boxRed.start)
                    bottom.linkTo(boxRed.top)
                } )
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    start.linkTo(boxRed.end)
                    bottom.linkTo(boxRed.top)
                } )

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    top.linkTo(boxRed.bottom)
                    end.linkTo(boxRed.start)
                } )
    }
}

//@Preview
@Composable
fun ConstraintExampleGuide() {
    ConstraintLayout(Modifier.fillMaxSize()) {
//        val topGuide = createGuidelineFromTop(16.dp) // es mejor utilizar porcentajes
        val topGuide = createGuidelineFromTop(0.1f) // 10%
        val startGuide = createGuidelineFromStart(0.25f) // 25%
        val boxRed = createRef()
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(topGuide)
                    start.linkTo(startGuide)
                }
        )
    }
}

//@Preview
@Composable
fun ConstraintExampleBarrier() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed, boxGreen, boxYellow) = createRefs()
        val endBarrier = createEndBarrier(boxRed, boxGreen)

        Box(
            Modifier
                .size(235.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    start.linkTo(parent.start, margin = 32.dp)
                    top.linkTo(boxGreen.bottom, margin = 6.dp)
                } )
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    start.linkTo(parent.start, margin = 16.dp)
                } )
        Box(
            Modifier
                .size(50.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(endBarrier)
                } )
        
    }
}

//@Preview
@Composable
fun ConstraintExampleChain() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed, boxGreen, boxYellow) = createRefs()

        Box(
            Modifier
                .size(75.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(parent.top)
                    bottom.linkTo(boxGreen.top)
                } )
        Box(
            Modifier
                .size(75.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    top.linkTo(boxRed.bottom)
                    bottom.linkTo(boxYellow.top)
                } )
        Box(
            Modifier
                .size(75.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    top.linkTo(boxGreen.bottom)
                    bottom.linkTo(parent.bottom)
                } )

//        createVerticalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.Packed) // apegotonaitos y juntitos
//        createVerticalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.Spread) // valor por defecto
        createVerticalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.SpreadInside) // los aleja todo lo posible

    }
}