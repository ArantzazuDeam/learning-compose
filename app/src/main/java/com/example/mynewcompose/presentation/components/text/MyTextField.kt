package com.example.mynewcompose.presentation.components.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true)
@Composable
fun MyTextFieldParentPreview() {
    Scaffold { innerPadding ->
        MyTextFieldParent(
            Modifier
                .fillMaxSize()
                .padding(innerPadding),
        )
    }
}

@Composable
fun MyTextFieldParent(modifier: Modifier) {
    val user by rememberSaveable { mutableStateOf("User") }

    Column(modifier = modifier.fillMaxSize()) {
        MyUserExample1(user) { }
    }
}

@Composable
fun MyUserExample1(
    user: String,
    onUserChange: (String) -> Unit,
) {
    TextField(user, onValueChange = { onUserChange(it) })
}
