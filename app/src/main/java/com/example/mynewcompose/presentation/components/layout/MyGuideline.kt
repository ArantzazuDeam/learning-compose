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
fun MyGuideline() {
    ConstraintLayout(Modifier.fillMaxSize().background(Color.LightGray)) {
        val redBox = createRef()
        val topGuideline = createGuidelineFromTop(0.5f)
        val startGuideline = createGuidelineFromStart(0.1f)

        Box(
            modifier =
                Modifier
                    .constrainAs(
                        redBox,
                        constrainBlock = {
                            top.linkTo(topGuideline)
                            start.linkTo(startGuideline)
                        },
                    ).size(125.dp)
                    .background(Color.Red),
        )
    }
}
