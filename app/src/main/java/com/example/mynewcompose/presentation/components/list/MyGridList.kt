package com.example.mynewcompose.presentation.components.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun MyGridList(modifier: Modifier = Modifier) {
    val numberList = List(100) { Random.nextInt(0, 12) }
    val numberListState = remember { mutableStateOf(numberList) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier =
            modifier
                .fillMaxSize()
                .padding(8.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(numberListState.value) { randomNumber ->
            Box(
                modifier =
                    Modifier
                        .background(colorsList[randomNumber])
                        .height(80.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = randomNumber.toString(),
                    color = if (randomNumber in 0..4) Color.Black else Color.White,
                    fontSize = 28.sp,
                )
            }
        }
    }
}

@Composable
fun MyHorizontalGridList(modifier: Modifier = Modifier) {
    val numberList = List(100) { Random.nextInt(0, 12) }
    val numberListState = remember { mutableStateOf(numberList) }

    LazyHorizontalGrid(
        rows = GridCells.Fixed(7),
        modifier =
            modifier
                .fillMaxSize()
                .padding(8.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(numberListState.value) { randomNumber ->
            Box(
                modifier =
                    Modifier
                        .background(colorsList[randomNumber])
                        .width(60.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = randomNumber.toString(),
                    color = if (randomNumber in 0..4) Color.Black else Color.White,
                    fontSize = 28.sp,
                )
            }
        }
    }
}

@Composable
fun MyAdaptativeGridList(modifier: Modifier = Modifier) {
    val numberList = List(100) { Random.nextInt(0, 12) }
    val numberListState = remember { mutableStateOf(numberList) }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(80.dp), // va a pintar todo el número de celdas posibles pero tendrán 80.dp de ancho cada una
        modifier =
            modifier
                .fillMaxSize()
                .padding(8.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(numberListState.value) { randomNumber ->
            Box(
                modifier =
                    Modifier
                        .background(colorsList[randomNumber])
                        .height(80.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = randomNumber.toString(),
                    color = if (randomNumber in 0..4) Color.Black else Color.White,
                    fontSize = 28.sp,
                )
            }
        }
    }
}
