package com.example.mynewcompose.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynewcompose.ui.theme.Pink120
import com.example.mynewcompose.utils.constant.STRING_EMPTY

@Composable
fun HomeScreen(
    navigateBack: () -> Unit,
    navigateToDetail: (String, Boolean) -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Pink120),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.weight(1f))
        Text("Home", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        DetailRow { id, isValid -> navigateToDetail(id, isValid) }
        Spacer(Modifier.weight(1f))
        Button(onClick = { navigateBack() }) {
            Text("Atrás")
        }
        Spacer(Modifier.weight(1f))
    }
}

@Composable
fun DetailRow(navigateToDetail: (String, Boolean) -> Unit) {
    var text by remember { mutableStateOf(STRING_EMPTY) }
    Row(modifier = Modifier.fillMaxWidth()) {
        TextField(value = text, onValueChange = { text = it }, modifier = Modifier.weight(1f))
        Button(onClick = { navigateToDetail(text, true) }) {
            Text("Detail")
        }
    }
}
