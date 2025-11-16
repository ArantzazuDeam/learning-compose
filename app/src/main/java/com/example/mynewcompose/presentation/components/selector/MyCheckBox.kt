package com.example.mynewcompose.presentation.components.selector

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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

@Preview(showSystemUi = true)
@Composable
fun MyCheckbox() {
    Scaffold { innerPadding ->
        MyParentCheckbox(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyParentCheckbox(modifier: Modifier) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MyBasicCheckbox()
        MyCheckboxCheckedDisabled()
        MyCheckboxUncheckedDisabled()
        MyCheckmarkCheckbox()
        CheckboxWithText()
    }
}

@Composable
fun MyBasicCheckbox() {
    var checkboxState by remember { mutableStateOf(true) }
    Checkbox(
        checked = checkboxState,
        onCheckedChange = { checkboxState = it },
        colors =
            CheckboxDefaults.colors(
                checkedColor = Color.Blue,
                uncheckedColor = Color.Cyan,
            ),
    )
}

@Composable
fun MyCheckboxCheckedDisabled() {
    Checkbox(
        checked = true,
        onCheckedChange = { },
        enabled = false,
        colors =
            CheckboxDefaults.colors(
                disabledCheckedColor = Color.LightGray,
            ),
    )
}

@Composable
fun MyCheckboxUncheckedDisabled() {
    Checkbox(
        checked = false,
        onCheckedChange = { },
        enabled = false,
        colors =
            CheckboxDefaults.colors(
                disabledUncheckedColor = Color.Gray,
            ),
    )
}

// region Checkmark
@Composable
fun MyCheckmarkCheckbox() {
    var checkboxState by remember { mutableStateOf(true) }
    Checkbox(
        checked = checkboxState,
        onCheckedChange = { checkboxState = it },
        colors =
            CheckboxDefaults.colors(
                checkedColor = Color.LightGray,
                uncheckedColor = Color.Black,
                checkmarkColor = Color.Green,
            ),
    )
}
// endregion

@Composable
fun MySecondCheckbox(
    checkboxState: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Checkbox(
        checked = checkboxState,
        onCheckedChange = { onCheckedChange(it) },
        colors =
            CheckboxDefaults.colors(
                checkedColor = Color.LightGray,
                uncheckedColor = Color.Black,
                checkmarkColor = Color.Green,
            ),
    )
}

@Composable
fun CheckboxWithText() {
    var checkboxState by remember { mutableStateOf(true) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { checkboxState = !checkboxState },
    ) {
        MySecondCheckbox(checkboxState) { checkboxState = it }
        TextForCheckbox()
    }
}

@Composable
fun TextForCheckbox() {
    Text(
        text = "Pulsa en el cuadradito o en el texto, nen",
        textAlign = TextAlign.Center,
    )
}
