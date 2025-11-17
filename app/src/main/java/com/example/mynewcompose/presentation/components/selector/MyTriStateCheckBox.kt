package com.example.mynewcompose.presentation.components.selector

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.presentation.state.CheckBoxState

private val ex1CheckBoxState =
    CheckBoxState(
        id = "ejemplo1",
        label = "Opción 1",
    )

private val ex2CheckBoxState =
    CheckBoxState(
        id = "ejemplo2",
        label = "Opción 2",
        checked = true,
    )

private val ex3CheckBoxState =
    CheckBoxState(
        id = "ejemplo3",
        label = "Opción 3",
        checked = true,
    )

@Preview(showSystemUi = true)
@Composable
fun MyTriStateCheckBoxPreview() {
    Scaffold { innerPadding ->
        MyParentTriStateCheckBox(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyParentTriStateCheckBox(modifier: Modifier) {
    var parentState by remember { mutableStateOf(ToggleableState.Off) }
    var childCheckBoxStateList by remember {
        mutableStateOf(
            listOf(
                ex1CheckBoxState,
                ex2CheckBoxState,
                ex3CheckBoxState,
            ),
        )
    }

    LaunchedEffect(childCheckBoxStateList) {
        val allChecked = childCheckBoxStateList.all { it.checked }
        val noneChecked = childCheckBoxStateList.none { it.checked }

        parentState =
            when {
                allChecked -> ToggleableState.On
                noneChecked -> ToggleableState.Off
                else -> ToggleableState.Indeterminate
            }
    }

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(
                state = parentState,
                colors =
                    CheckboxDefaults.colors(
                        checkedColor = Color.LightGray,
                        uncheckedColor = Color.Black,
                        checkmarkColor = Color.Green,
                    ),
                onClick = {
                    val newParentState = parentState != ToggleableState.On
                    childCheckBoxStateList =
                        childCheckBoxStateList.map { currentState ->
                            currentState.copy(checked = newParentState)
                        }
                },
            )
            Text(text = "Seleccionar todo")
        }
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
        ) {
            childCheckBoxStateList.forEach { currentState ->
                AdvanceCheckboxWithText(
                    checkboxState = currentState,
                ) {
                    childCheckBoxStateList =
                        childCheckBoxStateList.map { stateMap ->
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
}
