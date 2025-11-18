package com.example.mynewcompose.presentation.components.slider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.utils.constant.FLOAT_HALF

//@Preview(showSystemUi = true)
@Composable
fun MySliderPreview() {
    Scaffold { innerPadding ->
        MyParentSlider(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyParentSlider(modifier: Modifier) {
    Column(
        modifier =
            modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        MyFloatSlider()
        MyThumbDisabledFloatSlider()
        MyTrackDisabledFloatSlider()
    }
}

@Composable
fun MyFloatSlider() {
    var myValue by remember { mutableFloatStateOf(FLOAT_HALF) }
    Slider(
        value = myValue,
        onValueChange = { myValue = it },
        colors =
            SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Magenta,
                inactiveTrackColor = Color.Blue,
            ),
    )
    Text(myValue.toString())
}

@Composable
fun MyThumbDisabledFloatSlider() {
    var myValue by remember { mutableFloatStateOf(FLOAT_HALF) }
    Slider(
        value = myValue,
        onValueChange = { myValue = it },
        enabled = false,
        colors =
            SliderDefaults.colors(
                disabledThumbColor = Color.Black,
            ),
    )
    Text(myValue.toString())
}

@Composable
fun MyTrackDisabledFloatSlider() {
    var myValue by remember { mutableFloatStateOf(FLOAT_HALF) }
    Slider(
        value = myValue,
        onValueChange = { myValue = it },
        enabled = false,
        colors =
            SliderDefaults.colors(
                disabledActiveTrackColor = Color.Yellow,
                disabledInactiveTrackColor = Color.Green,
            ),
    )
    Text(myValue.toString())
}
