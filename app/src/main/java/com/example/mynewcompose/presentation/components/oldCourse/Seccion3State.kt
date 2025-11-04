package com.example.mynewcompose.presentation.components.oldCourse

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyOldComposeTheme() {
//        MyStateExample()
//    }
//}

/*
@Composable
fun MyStateExample() {
//    val counter = remember{ mutableStateOf(0) } // Si roto la pantalla no se mantiene el estado
    val counter = rememberSaveable { mutableStateOf(0) } // Si roto la pantalla se mantiene el estado

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter.value += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado ${counter.value} veces.")
    }
}
**/

@Composable
fun MyStateExample() {
    var counter by rememberSaveable { mutableStateOf(0) } // Si roto la pantalla se mantiene el estado

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado ${counter} veces.")
    }
}