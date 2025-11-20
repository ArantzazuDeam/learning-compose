package com.example.mynewcompose.presentation.components.dialog

import android.icu.util.Calendar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MyDatePickerManager(
    modifier: Modifier,
    snackbarHostState: SnackbarHostState,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        MyFirstDatePickerManager("Elige una fecha (aunque es pa ná)")
        MySecondDatePickerManager("Elige otra fecha (sigue siendo pa ná)")
        MyThirdDatePickerManager("Elige fecha, que ahora sí hago cosas.", snackbarHostState)
    }
}

@Composable
fun MyFirstDatePickerManager(text: String) {
    var showDialog by remember { mutableStateOf(false) }

    MyButtonOpenDialog(text) { showDialog = true }

    if (showDialog) {
        MyFirstDatePicker(
            onDismiss = { showDialog = false },
            onConfirm = { showDialog = false },
        )
    }
}

@Composable
fun MyFirstDatePicker(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, -1) // empieza en el día de ayer
    calendar[Calendar.MONTH] = Calendar.JANUARY // empezamos en el mes de enero de este año
    val currentYear = calendar[Calendar.YEAR] // val anoAtual: Int = Year.now().value // min api 26

    val datePickerState =
        rememberDatePickerState(
            initialSelectedDateMillis = calendar.timeInMillis,
            initialDisplayedMonthMillis = calendar.timeInMillis,
            yearRange = currentYear..currentYear + 10,
            initialDisplayMode = DisplayMode.Input,
        )
    DatePickerDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text("Confirmar")
            }
        },
        colors = DatePickerDefaults.colors(),
    ) {
        DatePicker(
            state = datePickerState,
        )
    }
}

@Composable
fun MySecondDatePickerManager(text: String) {
    var showDialog by remember { mutableStateOf(false) }

    MyButtonOpenDialog(text) { showDialog = true }

    if (showDialog) {
        MySecondDatePicker(
            onDismiss = { showDialog = false },
            onConfirm = { showDialog = false },
        )
    }
}

@Composable
fun MySecondDatePicker(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, -1) // empieza en el día de ayer
    calendar[Calendar.MONTH] = Calendar.JANUARY // empezamos en el mes de enero de este año
    val currentYear = calendar[Calendar.YEAR] // val anoAtual: Int = Year.now().value // min api 26

    val datePickerState =
        rememberDatePickerState(
            initialSelectedDateMillis = calendar.timeInMillis,
            initialDisplayedMonthMillis = calendar.timeInMillis,
            yearRange = currentYear..currentYear + 10,
            initialDisplayMode = DisplayMode.Picker,
            selectableDates =
                object : SelectableDates {
                    override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                        val filterCalendar =
                            Calendar.getInstance().apply {
                                timeInMillis = utcTimeMillis
                            }
                        val day = filterCalendar[Calendar.DAY_OF_YEAR]
                        return day % 2 == 0 // si es par se puede seleccionar, si es un día impar, no
                    }
                },
        )
    DatePickerDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text("Confirmar")
            }
        },
        colors = DatePickerDefaults.colors(),
    ) {
        DatePicker(
            state = datePickerState,
        )
    }
}

@Composable
fun MyThirdDatePickerManager(
    text: String,
    snackbarHostState: SnackbarHostState,
) {
    var showDialog by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    MyButtonOpenDialog(text) { showDialog = true }

    if (showDialog) {
        MyThirdDatePicker(
            onDismiss = { showDialog = false },
            onConfirm = { dateResult ->
                showDialog = false
                if (dateResult != null) {
                    val calendar = Calendar.getInstance().apply { timeInMillis = dateResult }
                    val day = calendar[Calendar.DAY_OF_MONTH]
                    val month = calendar[Calendar.MONTH] + 1
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Día: $day Mes: $month",
                            actionLabel = "Listo (esto no hace na)",
                        )
                    }
                }
            },
        )
    }
}

@Composable
fun MyThirdDatePicker(
    onDismiss: () -> Unit,
    onConfirm: (Long?) -> Unit,
) {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, -1) // empieza en el día de ayer
    calendar[Calendar.MONTH] = Calendar.JANUARY // empezamos en el mes de enero de este año
    val currentYear = calendar[Calendar.YEAR] // val anoAtual: Int = Year.now().value // min api 26

    val datePickerState =
        rememberDatePickerState(
            initialSelectedDateMillis = calendar.timeInMillis,
            initialDisplayedMonthMillis = calendar.timeInMillis,
            yearRange = currentYear..currentYear + 10,
            initialDisplayMode = DisplayMode.Picker,
            selectableDates =
                object : SelectableDates {
                    override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                        val filterCalendar =
                            Calendar.getInstance().apply {
                                timeInMillis = utcTimeMillis
                            }
                        val day = filterCalendar[Calendar.DAY_OF_YEAR]
                        return day % 2 == 0 // si es par se puede seleccionar, si es un día impar, no
                    }
                },
        )
    DatePickerDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            TextButton(onClick = { onConfirm(datePickerState.selectedDateMillis) }) {
                Text("Confirmar")
            }
        },
        colors = DatePickerDefaults.colors(),
    ) {
        DatePicker(
            state = datePickerState,
        )
    }
}
