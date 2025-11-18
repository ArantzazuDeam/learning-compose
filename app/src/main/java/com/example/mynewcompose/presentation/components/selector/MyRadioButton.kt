package com.example.mynewcompose.presentation.components.selector

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

//@Preview(showSystemUi = true)
@Composable
fun MyRadioButtonPreview() {
    Scaffold { innerPadding ->
        MyParentRadioButtonCheckBox(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyParentRadioButtonCheckBox(modifier: Modifier) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        MyBasicRadioButtonWithText(text = "Ejemplo 1")
        MyDisabledSelectedRadioButtonWithText(text = "Ejemplo 2")
        MyDisabledUnselectedRadioButtonWithText(text = "Ejemplo 3")
    }
}

@Composable
fun MyBasicRadioButtonWithText(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        MyBasicRadioButton()
        TextForRadioButton(text = text)
    }
}

@Composable
fun MyBasicRadioButton() {
    var state by remember { mutableStateOf(false) }
    RadioButton(
        selected = state,
        onClick = { state = !state },
        enabled = true,
        colors =
            RadioButtonDefaults.colors(
                selectedColor = Color.Magenta,
                unselectedColor = Color.Red,
            ),
    )
}

@Composable
fun TextForRadioButton(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun MyDisabledSelectedRadioButtonWithText(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        MyDisabledSelectedRadioButton()
        TextForRadioButton(text = text)
    }
}

@Composable
fun MyDisabledSelectedRadioButton() {
    RadioButton(
        selected = true,
        onClick = { },
        enabled = false,
        colors =
            RadioButtonDefaults.colors(
                disabledSelectedColor = Color.DarkGray,
            ),
    )
}

@Composable
fun MyDisabledUnselectedRadioButtonWithText(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        MyDisabledUnselectedRadioButton()
        TextForRadioButton(text = text)
    }
}

@Composable
fun MyDisabledUnselectedRadioButton() {
    RadioButton(
        selected = false,
        onClick = { },
        enabled = false,
        colors =
            RadioButtonDefaults.colors(
                disabledUnselectedColor = Color.LightGray,
            ),
    )
}
