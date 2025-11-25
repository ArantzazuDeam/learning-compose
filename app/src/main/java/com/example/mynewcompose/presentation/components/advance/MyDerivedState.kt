package com.example.mynewcompose.presentation.components.advance

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.presentation.components.text.MyEmailExample
import com.example.mynewcompose.presentation.components.text.MyPasswordExample
import com.example.mynewcompose.utils.constant.STRING_EMPTY

@Preview
@Composable
fun DerivedStateExample(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf(STRING_EMPTY) }
    var password by remember { mutableStateOf(STRING_EMPTY) }
    var isPasswordHidden by rememberSaveable { mutableStateOf(true) }

//    Este state obliga a que la vista se recomponga por cada letra que escribimos en los campos de password e email
//    val isFormValid = email.contains("@") && password.length > 4
//    Utilizando el derivedStateOf le indicamos que hasta que no se cumplan las condiciones de dentro
//    no recomponga la vista.
//    En ambos casos, a nivel de usuario, se percibe "igual" pero usando derivedStateOf es muuchíiiiisimo más óptimo.
    val isFormValid by remember(password, email) {
        derivedStateOf {
            email.contains("@") && password.length > 4
        }
    }

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        MyEmailExample(email) { email = it }
        MyPasswordExample(
            password = password,
            isPasswordHidden = isPasswordHidden,
            onPasswordChange = { password = it },
            onToggleButtonClicked = { isPasswordHidden = !isPasswordHidden },
        )
        Button(
            onClick = {},
            enabled = isFormValid,
        ) {
            Text("Login")
        }
    }
}
