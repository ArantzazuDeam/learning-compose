package com.example.mynewcompose.presentation.components.oldCourse

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MyOldComposeTheme {
//        MyText()
//        MyTextField()
//        MyTextFieldAdvanced()
//        MyTextFieldOutlined()
        showMyTextFieldOutlined()
    }
}
*/

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Green, fontWeight = FontWeight.ExtraBold)

        Text(
            text = "Esto es un ejemplo",
            color = Color.Magenta,
            style = TextStyle(fontFamily = FontFamily.Cursive)
        )

        Text(
            text = "Esto es un ejemplo",
            color = Color.Blue,
            fontFamily = FontFamily.Cursive,
            fontSize = 20.sp
        )

        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )

        Text(
            text = "Esto es un ejemplo",
            textDecoration = TextDecoration.LineThrough
        )

        Text(
            text = "Esto es un ejemplo",
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline,
                    TextDecoration.LineThrough
                )
            ),
            fontSize = 36.sp
        )
    }
}

@Composable
fun MyTextField() {
    var myText by remember { mutableStateOf("valor por defecto") }
    TextField(
        value = myText,
        onValueChange = { myText = it }) // si escribo en el textField se cambiará el texto
}

@Composable
fun MyTextFieldAdvanced() {
    var myText by remember { mutableStateOf("") }
    TextField(value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "*")
            } else {
                it
            }
        },
        label = { Text(text = "Escribe tu nombre") }
    )

}

@Composable
fun showMyTextFieldOutlined() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val boxCyan = createRef()
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(16.dp)
        ) {
            MyTextFieldOutlined()
        }
    }
}

@Composable
fun MyTextFieldOutlined() {
    var myText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        Modifier.padding(24.dp),
        label = { Text ("Escribe tu texto") },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Magenta,
            unfocusedIndicatorColor = Color.Blue
        )
    )
}