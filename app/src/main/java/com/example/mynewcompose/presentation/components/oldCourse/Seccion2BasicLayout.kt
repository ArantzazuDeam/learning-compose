package com.example.mynewcompose.presentation.components.oldCourse

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(80.dp)
                .background(Color.Cyan)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text("Esto es un ejemplo", textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
//        Text ("Ejemplo 1", modifier = Modifier.background(Color.Red).weight(1f))
//        Text ("Ejemplo 2", modifier = Modifier.background(Color.Blue).weight(4f))
//        Text ("Ejemplo 3", modifier = Modifier.background(Color.Green).weight(3f))
//        Text ("Ejemplo 4", modifier = Modifier.background(Color.Yellow).weight(2f))

        Text(
            "Ejemplo 1", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 2", modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 3", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 4", modifier = Modifier
                .background(Color.Yellow)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 5", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 6", modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 7", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 8", modifier = Modifier
                .background(Color.Yellow)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 9", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 10", modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 11", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 12", modifier = Modifier
                .background(Color.Yellow)
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}


@Composable
fun MyRow() {
//    Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
//        Text ("Ejemplo 1", modifier = Modifier.background(Color.Red).weight(1f))
//        Text ("Ejemplo 2", modifier = Modifier.background(Color.Blue).weight(4f))
//        Text ("Ejemplo 3", modifier = Modifier.background(Color.Green).weight(3f))
//      }

    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Ejemplo 1", modifier = Modifier
            .background(Color.Red)
            .width(100.dp))
        Text("Ejemplo 2", modifier = Modifier
            .background(Color.Blue)
            .width(100.dp))
        Text("Ejemplo 3", modifier = Modifier
            .background(Color.Green)
            .width(100.dp))
        Text("Ejemplo 1", modifier = Modifier
            .background(Color.Red)
            .width(100.dp))
        Text("Ejemplo 2", modifier = Modifier
            .background(Color.Blue)
            .width(100.dp))
        Text("Ejemplo 3", modifier = Modifier
            .background(Color.Green)
            .width(100.dp))
    }
}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1F)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center) {

            Text("Ejemplo 1")
        }

        MyVerticalSpacer(height = 16)

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1F)
                .background(Color.Black)
                .padding(6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,) {

            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(1F)
                    .background(Color.Red),
                contentAlignment = Alignment.Center) {

                Text("Ejemplo 2")
            }

            MyHorizontalSpacer(width = 12)
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(1F)
                    .background(Color.Green),
                contentAlignment = Alignment.Center) {

                Text("Ejemplo 3")
            }
        }

        MyVerticalSpacer(height = 60)
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1F)
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter) {

            Text("Ejemplo 4")
        }
    }
}

@Composable
fun MyVerticalSpacer(height: Int) {
    Spacer(modifier = Modifier.height(height.dp))
}

@Composable
fun MyHorizontalSpacer(width: Int) {
    Spacer(modifier = Modifier.width(width.dp))
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyOldComposeTheme() {
//        MyComplexLayout()
//    }
//}