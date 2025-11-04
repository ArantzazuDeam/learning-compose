package com.example.mynewcompose.presentation.components.oldCourse

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun showMyTextFieldOutlinedStateHoisting(newText: String, onValueChanged: (String) -> Unit) {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val boxCyan = createRef()
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(16.dp)
        ) {
            MyTextFieldOutlinedStateHoisting(newText, onValueChanged)
        }
    }
}

@Composable
fun MyTextFieldOutlinedStateHoisting(newText: String, onValueChanged: (String) -> Unit) {
//    var myText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = newText,
        onValueChange = { onValueChanged(it) },
        Modifier.padding(24.dp),
        label = { Text ("Escribe tu texto") },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Magenta,
            unfocusedIndicatorColor = Color.Blue
        )
    )
}