package com.example.mynewcompose.presentation.components.selector

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

//@Preview(showSystemUi = true)
@Composable
fun MyAdvanceRadioButtonPreview() {
    Scaffold { innerPadding ->
        MyParentRadioButtonCheckBox(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyParentAdvanceRadioButtonCheckBox(modifier: Modifier) {
    var selectedName by remember { mutableStateOf("") }
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        RadioButtonComponent(name = "Arantxa", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Alexis", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Javi", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Ertiti", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "María", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Mamá", selectedName = selectedName) { selectedName = it }
    }
}

@Composable
fun RadioButtonComponent(
    name: String,
    selectedName: String,
    onItemSelected: (String) -> Unit,
) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable { onItemSelected(name) }) {
        RadioButton(selected = name == selectedName, onClick = { onItemSelected(name) })
        Text(text = name)
    }
}
