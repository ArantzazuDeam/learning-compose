package com.example.mynewcompose.presentation.components.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        TapMyText1(
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Composable
fun TapMyText1(modifier: Modifier) {
    val counter1 = remember { mutableStateOf(0) }
    val counter2 = rememberSaveable { mutableIntStateOf(0) }
    var counter3 by rememberSaveable { mutableIntStateOf(0) }
    ConstraintLayout(modifier.fillMaxSize()) {
        val (tapText1, tapText2, tapText3) = createRefs()
        Text(
            modifier =
                Modifier
                    .constrainAs(
                        tapText1,
                        constrainBlock = {
                            top.linkTo(parent.top, margin = 16.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    ).clickable {
                        counter1.value += 1
                    },
            textAlign = TextAlign.Center,
            text = "Este texto se ha pulsado ${counter1.value} veces \n(o no, porque no guardo el estado entre rotaciones).",
        )

        Text(
            modifier =
                Modifier
                    .constrainAs(
                        tapText2,
                        constrainBlock = {
                            top.linkTo(tapText1.bottom, margin = 30.dp)
                            start.linkTo(tapText1.start)
                            end.linkTo(tapText1.end)
                        },
                    ).clickable {
                        counter2.intValue += 1
                    },
            textAlign = TextAlign.Center,
            text = "Este texto se ha pulsado ${counter2.intValue} veces. \n (fíate de mí, yo sí lo guardo)",
        )

        Text(
            modifier =
                Modifier
                    .constrainAs(
                        tapText3,
                        constrainBlock = {
                            top.linkTo(tapText2.bottom, margin = 30.dp)
                            start.linkTo(tapText1.start)
                            end.linkTo(tapText1.end)
                        },
                    ).clickable {
                        counter3 += 1
                    },
            textAlign = TextAlign.Center,
            text = "Este texto se ha pulsado $counter3 veces. \n (soy igual de fiable que el texto de arriba, pero más cómodo)",
        )
    }
}
