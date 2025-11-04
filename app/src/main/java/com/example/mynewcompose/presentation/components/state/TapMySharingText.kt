package com.example.mynewcompose.presentation.components.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

// @Preview(showBackground = true)
@Composable
fun TapMySharingTextDefaultPreview() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        TapMySharingTexts(
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Composable
fun TapMySharingTexts(modifier: Modifier) {
    var counter by rememberSaveable { mutableIntStateOf(0) }

    Column(modifier.fillMaxSize()) {
        TextSharingCounter1(modifier, counter) { counter += 1 }
        TextSharingCounter2(modifier, counter, { counter += 1 })
    }
}

@Composable
fun TextSharingCounter1(
    modifier: Modifier,
    counter: Int,
    onClick: () -> Unit,
) {
    Text(
        modifier =
            modifier
                .fillMaxWidth()
                .clickable {
                    onClick()
                },
        textAlign = TextAlign.Center,
        text = "Este texto se ha pulsado $counter veces \n(Cuando pulses aquí también se actualizará el otro texto).",
    )
}

@Composable
fun TextSharingCounter2(
    modifier: Modifier,
    counter: Int,
    onClick: () -> Unit,
) {
    Text(
        modifier =
            modifier
                .fillMaxWidth()
                .clickable {
                    onClick()
                },
        textAlign = TextAlign.Center,
        text = "Este texto se ha pulsado $counter veces \n(Cuando pulses aquí también se actualizará el otro texto).",
    )
}
