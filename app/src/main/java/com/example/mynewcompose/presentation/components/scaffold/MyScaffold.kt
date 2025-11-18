package com.example.mynewcompose.presentation.components.scaffold

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynewcompose.presentation.components.button.MyFab

@Preview(showSystemUi = true)
@Composable
fun MyScaffoldPreview() {
    Scaffold(
        topBar = {
            MyTopAppBar()
        },
        floatingActionButton = {
            MyFab()
        },
    ) { innerPadding ->
        MyParentScaffold(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyParentScaffold(
    modifier: Modifier,
    snackbarHostState: SnackbarHostState? = null,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Esta es mi screen.",
        )
        if (snackbarHostState != null) {
            MyButtonOpenSnackbar(snackbarHostState)
        }
    }
}
