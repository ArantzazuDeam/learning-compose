package com.example.mynewcompose.presentation.components.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.ui.theme.BlueGrey100
import kotlinx.coroutines.launch

@Composable
fun MyButtonOpenSnackbar(snackbarHostState: SnackbarHostState) {
    val scope = rememberCoroutineScope()
    Text(
        text = "Si pulsas este texto se mostrará una snackbar",
        textAlign = TextAlign.Center,
        modifier =
            Modifier
                .padding(16.dp)
                .background(BlueGrey100)
                .clickable {
                    scope.launch {
                        val result =
                            snackbarHostState.showSnackbar(
                                message = "Ejemplo de snackbar",
                                actionLabel = "Deshacer",
                            )
                        if (result == SnackbarResult.ActionPerformed) {
                            // TODO() El usuario pulsó el botón "Deshacer"
                        } else {
                            // TODO() El snackbar se cerró sin que el usuario pulsara nada.
                        }
                    }
                },
    )
}
