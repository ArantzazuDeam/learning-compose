package com.example.mynewcompose.presentation.components.slider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.R

@Preview(showSystemUi = true)
@Composable
fun MyRangeSliderPreview() {
    Scaffold { innerPadding ->
        MyRangeParentSlider(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyRangeParentSlider(modifier: Modifier) {
    Column(
        modifier =
            modifier
                .padding(horizontal = 30.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        MyRangeSlider()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider() {
    val rangeState =
        remember {
            RangeSliderState(
                activeRangeStart = 3f,
                activeRangeEnd = 6f,
                valueRange = 0f..10f,
                steps = 9,
                onValueChangeFinished = {},
            )
        }

    val myRangeSliderColors =
        SliderDefaults.colors(
            thumbColor = Color.Red,
            activeTickColor = Color.Blue,
            inactiveTickColor = Color.Magenta,
            activeTrackColor = Color.Magenta,
            inactiveTrackColor = Color.Blue,
        )
    RangeSlider(
        state = rangeState,
        colors = myRangeSliderColors,
        startThumb = {
            Icon(
                painter = painterResource(R.drawable.ic_personita),
                contentDescription = null,
                tint = Color.Red,
            )
        },
        endThumb = {
            Box(
                contentAlignment = Alignment.Center,
                modifier =
                    Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.Red),
            ) {
                Text(text = rangeState.activeRangeEnd.toString(), color = Color.White)
            }
        },
    )
}
