package com.example.mynewcompose.presentation.components.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.example.mynewcompose.ui.theme.Pink40
import com.example.mynewcompose.ui.theme.Pink60

@Composable
fun MyMultipleDialogManager(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        MyFirstDialogManager("Muestra el diálogo, coraçao.")
        MySecondDialogManager("Muestra otro diálogo")
    }
}

@Composable
fun MyButtonOpenDialog(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = { onClick() },
        colors =
            ButtonDefaults.buttonColors(
                containerColor = Pink60,
            ),
    ) {
        Text(text)
    }
}

@Composable
fun MyFirstDialogManager(text: String) {
    var showDialog by remember { mutableStateOf(false) }
    MyButtonOpenDialog(text) { showDialog = true }

    if (showDialog) {
        MyFirstDialog(
            onDismiss = { showDialog = false },
            onConfirmButtonClicked = { showDialog = false },
            onDismissButtonClicked = { showDialog = false },
        )
    }
}

@Composable
fun MyFirstDialog(
    onDismiss: () -> Unit,
    onConfirmButtonClicked: () -> Unit,
    onDismissButtonClicked: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = { onDismiss() }, // { showDialog = false },
        confirmButton = {
            Button(
                onClick = { onConfirmButtonClicked() },
                content = {
                    Text("Jeje, sí")
                },
            )
        },
        dismissButton = {
            Button(
                onClick = { onDismissButtonClicked() },
                content = {
                    Text("Pshé, ciérrate anda")
                },
            )
        },
        title = { Text("¡Atención!") },
        text = { Text("¿Ha visto usté que esto es un diálogo?") },
    )
}

@Composable
fun MySecondDialogManager(text: String) {
    var showDialog by remember { mutableStateOf(false) }
    MyButtonOpenDialog(text) { showDialog = true }

    if (showDialog) {
        MySecondDialog(
            onDismiss = { showDialog = false },
            onConfirmButtonClicked = { showDialog = false },
            onDismissButtonClicked = { showDialog = false },
        )
    }
}

@Composable
fun MySecondDialog(
    onDismiss: () -> Unit,
    onConfirmButtonClicked: () -> Unit,
    onDismissButtonClicked: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = { onDismiss() }, // { showDialog = false },
        confirmButton = {
            Button(
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = Pink60,
                    ),
                onClick = { onConfirmButtonClicked() },
                content = {
                    Text("Qué uapo!")
                },
            )
        },
        dismissButton = {
            TextButton(
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Pink60,
                    ),
                onClick = { onDismissButtonClicked() },
                content = {
                    Text("Qué pesá!")
                },
            )
        },
        title = { Text("¡Atención!") },
        text = { Text("¿Ha visto usté que esto es otro diálogo?") },
        icon = {
            Icon(
                modifier = Modifier.size(52.dp),
                imageVector = Icons.Outlined.Info,
                contentDescription = null,
            )
        },
        shape = RoundedCornerShape(20),
        containerColor = Color.White,
        iconContentColor = Pink40,
        titleContentColor = Pink40,
        textContentColor = Pink60,
        tonalElevation = 12.dp,
        properties =
            DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                usePlatformDefaultWidth = true,
                securePolicy = SecureFlagPolicy.SecureOn, // no permite hacer screenshots del diálogo
                decorFitsSystemWindows = true, // Esto a true evita que el diálogo no colapse partes de la app que no deba colapsar.
            ),
    )
}
