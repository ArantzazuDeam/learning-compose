package com.example.mynewcompose.presentation.components.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true)
@Composable
fun MyScaffoldPreview() {
    Scaffold(
        topBar = {
            MyTopAppBar()
        },
    ) { innerPadding ->
        MyParentScaffold(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyParentScaffold(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text("Esta es mi screen.")
    }
}
