package com.example.mynewcompose.presentation.components.dialog

import android.icu.util.Calendar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerDialog
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.ui.theme.Pink40

@Composable
fun MyTimePickerManager(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        MyFirstTimePickerManager("Elige hora, coraçao")
        MySecondTimePickerManager("Elige la hora (horizontal style)") // más feo que pegarle a un padre, no encaja en pantalla
    }
}

@Composable
fun MyFirstTimePickerManager(text: String) {
    var showDialog by remember { mutableStateOf(false) }

    MyButtonOpenDialog(text) { showDialog = true }

    if (showDialog) {
        MyFirstTimePicker(
            onDismiss = { showDialog = false },
            onConfirm = { showDialog = false },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyFirstTimePicker(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    val calendar = Calendar.getInstance()
    val timePickerState =
        rememberTimePickerState(
            initialHour = calendar[Calendar.HOUR],
            initialMinute = calendar[Calendar.MINUTE],
            is24Hour = false,
        )

    TimePickerDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = Pink40,
                    ),
                onClick = { onConfirm() },
            ) {
                Text("¿Aceptamos barco? Digo... ¿hora?")
            }
        },
        title = {
            Text("Elige horita", color = Pink40)
        },
    ) {
        TimePicker(
            state = timePickerState,
            colors =
                TimePickerDefaults.colors(
                    clockDialColor = Color.White,
                    clockDialSelectedContentColor = Color.White,
                    clockDialUnselectedContentColor = Color.Black,
                    selectorColor = Pink40,
                    periodSelectorBorderColor = Pink40,
                    periodSelectorSelectedContainerColor = Pink40,
                    periodSelectorUnselectedContainerColor = Color.White,
                    periodSelectorSelectedContentColor = Color.White,
                    periodSelectorUnselectedContentColor = Color.Black,
                    timeSelectorSelectedContainerColor = Pink40,
                ),
        )
    }
}

@Composable
fun MySecondTimePickerManager(text: String) {
    var showDialog by remember { mutableStateOf(false) }

    MyButtonOpenDialog(text) { showDialog = true }

    if (showDialog) {
        MySecondTimePicker(
            onDismiss = { showDialog = false },
            onConfirm = { showDialog = false },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySecondTimePicker(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    val calendar = Calendar.getInstance()
    val timePickerState =
        rememberTimePickerState(
            initialHour = calendar[Calendar.HOUR],
            initialMinute = calendar[Calendar.MINUTE],
            is24Hour = false,
        )

    TimePickerDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(
                onClick = { onConfirm() },
            ) {
                Text("¿Aceptamos barco? Digo... ¿hora?")
            }
        },
        title = {
            Text("Elige horita")
        },
    ) {
        TimePicker(
            state = timePickerState,
            layoutType = TimePickerLayoutType.Horizontal,
        )
    }
}
