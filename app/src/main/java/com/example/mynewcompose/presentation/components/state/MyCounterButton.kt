package com.example.mynewcompose.presentation.components.state

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyFirstButtonCounter() {
    var counter = remember { mutableStateOf(0) }

    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .background(Color.LightGray),
    ) {
        val (button, tapBtn) = createRefs()
        Button(
            modifier =
                Modifier.constrainAs(
                    button,
                    constrainBlock = {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                ),
            onClick = {
                counter.value += 1
            },
        ) {
            Text(text = "Pulsar")
        }
        Text(
            modifier =
                Modifier.constrainAs(tapBtn, constrainBlock = {
                    top.linkTo(button.bottom, margin = 16.dp)
                    start.linkTo(button.start)
                    end.linkTo(button.end)
                }),
            text = "He sido pulsado ${counter.value} veces.",
        )
    }
}

@Composable
fun MySecondButtonCounter() {
    val counter = rememberSaveable { mutableIntStateOf(0) }

    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .background(Color.LightGray),
    ) {
        val (button, tapBtn) = createRefs()
        Button(
            modifier =
                Modifier.constrainAs(
                    button,
                    constrainBlock = {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                ),
            onClick = {
                counter.intValue += 1
            },
        ) {
            Text(text = "Pulsar")
        }
        Text(
            modifier =
                Modifier.constrainAs(tapBtn, constrainBlock = {
                    top.linkTo(button.bottom, margin = 16.dp)
                    start.linkTo(button.start)
                    end.linkTo(button.end)
                }),
            text = "He sido pulsado ${counter.intValue} veces.",
        )
    }
}

//@Preview
@Composable
fun MyThirdButtonCounter() {
    var counter by rememberSaveable { mutableIntStateOf(0) }

    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .background(Color.LightGray),
    ) {
        val (button, tapBtn) = createRefs()
        Button(
            modifier =
                Modifier.constrainAs(
                    button,
                    constrainBlock = {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                ),
            onClick = {
                counter += 1
            },
        ) {
            Text(text = "Pulsar")
        }
        Text(
            modifier =
                Modifier.constrainAs(tapBtn, constrainBlock = {
                    top.linkTo(button.bottom, margin = 16.dp)
                    start.linkTo(button.start)
                    end.linkTo(button.end)
                }),
            text = "He sido pulsado ${counter} veces.",
        )
    }
}
