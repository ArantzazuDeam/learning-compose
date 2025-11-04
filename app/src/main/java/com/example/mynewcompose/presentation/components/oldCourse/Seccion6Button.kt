package com.example.mynewcompose.presentation.components.oldCourse

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.ui.theme.MyOldComposeTheme

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyButtonPreview() {
    MyOldComposeTheme {
//        MyButtonExample()
        MyOutlinedButtonExample()
    }
}

@Composable
fun MyButtonExample() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { Log.i("Seccion", "Sección 6 myButtonExample") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Green
            ),
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Text(text = "Hola, soy un botón")
        }
    }
}

@Composable
fun MySecondButtonExample() {
    var enabledButton by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { enabledButton = false },
            enabled = enabledButton,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Green
            ),
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Text(text = "Hola, soy un botón")
        }
    }
}


@Composable
fun MyOutlinedButtonExample() {
    var enabledButton by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { enabledButton = false },
            enabled = enabledButton,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan,
                contentColor = Color.Blue,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.Black
            ),
        ) {
            Text(text = "Hola, soy un Button")
        }

        OutlinedButton(
            onClick = { enabledButton = false },
            enabled = enabledButton,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan,
                contentColor = Color.Blue,
                disabledContainerColor = Color.DarkGray,
                disabledContentColor = Color.White
            ),
        ) {
            Text(text = "Hola, soy un OutlinedButton")
        }

        TextButton(
            onClick = { enabledButton = false },
        ) {
            Text(text = "Hola, soy un TextButton") // Se le puede incluir texto o cualquier componente y tiene las mismas propiedades que los anteriores
        }
    }
}