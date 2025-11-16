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
import com.example.mynewcompose.presentation.state.CheckBoxState

@Preview(showSystemUi = true)
@Composable
fun MyAdvanceCheckboxPreview() {
    Scaffold { innerPadding ->
        MyParentAdvanceCheckbox(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyParentAdvanceCheckbox(modifier: Modifier) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        val termsCheckBoxState =
            CheckBoxState(
                id = "terms",
                label = "Aceptar los términos y condiciones.",
            )
        val newsletterCheckBoxState =
            CheckBoxState(
                id = "newsletter",
                label = "Recibir la newsletter.",
                checked = true,
            )

        val updateCheckBoxState =
            CheckBoxState(
                id = "updates",
                label = "Recibir actualizaciones.",
            )

        var checkboxStateList by remember {
            mutableStateOf(
                listOf(
                    termsCheckBoxState,
                    newsletterCheckBoxState,
                    updateCheckBoxState,
                ),
            )
        }

        checkboxStateList.forEach { currentState ->
            AdvanceCheckboxWithText(
                checkboxState = currentState,
            ) {
                checkboxStateList =
                    checkboxStateList.map { stateMap ->
                        if (stateMap.id == currentState.id) {
                            currentState.copy(checked = !currentState.checked)
                        } else {
                            stateMap
                        }
                    }
            }
        }
    }
}

@Composable
fun AdvanceCheckboxWithText(
    checkboxState: CheckBoxState,
    onCheckedChange: (CheckBoxState) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onCheckedChange(checkboxState) },
    ) {
        MyAdvanceCheckbox(checkboxState.checked) { onCheckedChange(checkboxState) }
        TextForAdvanceCheckbox(checkboxState.label)
    }
}

@Composable
fun MyAdvanceCheckbox(
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
fun TextForAdvanceCheckbox(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
    )
}
