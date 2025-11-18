package com.example.mynewcompose.presentation.components.slider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.R
import com.example.mynewcompose.utils.constant.FLOAT_ZERO

//@Preview(showSystemUi = true)
@Composable
fun MyAdvanceSliderPreview() {
    Scaffold { innerPadding ->
        MyAdvanceParentSlider(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyAdvanceParentSlider(modifier: Modifier) {
    Column(
        modifier =
            modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        MySliderAdvance()
        MyDisabledSliderAdvance()
        MyThumbSliderAdvance()
        MyNumberThumbSliderAdvance()
        MyCustomizedThumbSliderAdvance()
        MyCustomizedSliderAdvance()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySliderAdvance() {
    var example by remember { mutableStateOf(":(") }

    val myAdvanceSliderColors =
        SliderDefaults.colors(
            thumbColor = Color.Red,
            activeTickColor = Color.Blue,
            inactiveTickColor = Color.Magenta,
            activeTrackColor = Color.Magenta,
            inactiveTrackColor = Color.Blue,
        )

    val state =
        remember {
            SliderState(
                value = 5f,
                valueRange = FLOAT_ZERO..10f,
                steps = 9,
                onValueChangeFinished = {
                    example = ":D"
                },
            )
        }
    Slider(state = state, colors = myAdvanceSliderColors)
    Text(example + " (" + state.value.toString() + ")")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDisabledSliderAdvance() {
    val myAdvanceSliderColors =
        SliderDefaults.colors(
            disabledThumbColor = Color.Black,
            disabledActiveTrackColor = Color.Gray,
            disabledInactiveTrackColor = Color.LightGray,
            disabledActiveTickColor = Color.Magenta,
            disabledInactiveTickColor = Color.Blue,
        )

    val state =
        remember {
            SliderState(
                value = 5f,
                valueRange = FLOAT_ZERO..10f,
                steps = 9,
            )
        }
    Slider(state = state, colors = myAdvanceSliderColors, enabled = false)
    Text(state.value.toString())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyThumbSliderAdvance() {
    var example by remember { mutableStateOf(":(") }

    val myAdvanceSliderColors =
        SliderDefaults.colors(
            thumbColor = Color.Red,
            activeTickColor = Color.Blue,
            inactiveTickColor = Color.Magenta,
            activeTrackColor = Color.Magenta,
            inactiveTrackColor = Color.Blue,
        )

    val state =
        remember {
            SliderState(
                value = 5f,
                valueRange = FLOAT_ZERO..10f,
                steps = 9,
                onValueChangeFinished = {
                    example = ":D"
                },
            )
        }
    Slider(
        state = state,
        colors = myAdvanceSliderColors,
        thumb = {
            Icon(painter = painterResource(R.drawable.ic_personita), contentDescription = null)
        },
    )
    Text(example + " (" + state.value.toString() + ")")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNumberThumbSliderAdvance() {
    var example by remember { mutableStateOf(":(") }

    val myAdvanceSliderColors =
        SliderDefaults.colors(
            thumbColor = Color.Red,
            activeTickColor = Color.Blue,
            inactiveTickColor = Color.Magenta,
            activeTrackColor = Color.Magenta,
            inactiveTrackColor = Color.Blue,
        )

    val state =
        remember {
            SliderState(
                value = 5f,
                valueRange = FLOAT_ZERO..10f,
                steps = 9,
                onValueChangeFinished = {
                    example = ":D"
                },
            )
        }
    Slider(
        state = state,
        colors = myAdvanceSliderColors,
        thumb = { thumbState: SliderState ->
            Text(thumbState.value.toString())
        },
    )
    Text(example + " (" + state.value.toString() + ")")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCustomizedThumbSliderAdvance() {
    var example by remember { mutableStateOf(":(") }

    val myAdvanceSliderColors =
        SliderDefaults.colors(
            thumbColor = Color.Red,
            activeTickColor = Color.Blue,
            inactiveTickColor = Color.Magenta,
            activeTrackColor = Color.Magenta,
            inactiveTrackColor = Color.Blue,
        )

    val state =
        remember {
            SliderState(
                value = 5f,
                valueRange = FLOAT_ZERO..10f,
                steps = 9,
                onValueChangeFinished = {
                    example = ":D"
                },
            )
        }
    Slider(
        state = state,
        colors = myAdvanceSliderColors,
        thumb = {
            Box(
                Modifier
                    .width(10.dp)
                    .height(30.dp)
                    .background(Color.Red),
            )
        },
    )
    Text(example + " (" + state.value.toString() + ")")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCustomizedSliderAdvance() {
    var example by remember { mutableStateOf(":(") }

    val myAdvanceSliderColors =
        SliderDefaults.colors(
            thumbColor = Color.Red,
            activeTickColor = Color.Blue,
            inactiveTickColor = Color.Magenta,
            activeTrackColor = Color.Magenta,
            inactiveTrackColor = Color.Blue,
        )

    val state =
        remember {
            SliderState(
                value = 5f,
                valueRange = FLOAT_ZERO..10f,
                steps = 9,
                onValueChangeFinished = {
                    example = ":D"
                },
            )
        }
    Slider(
        state = state,
        colors = myAdvanceSliderColors,
        thumb = {
            Box(
                Modifier
                    .size(50.dp)
                    .background(Color.Blue),
            )
        },
        track = {
            Box(
                Modifier
                    .width(400.dp)
                    .height(30.dp)
                    .background(Color.Red),
            )
        },
    )
    Text(example + " (" + state.value.toString() + ")")
}
