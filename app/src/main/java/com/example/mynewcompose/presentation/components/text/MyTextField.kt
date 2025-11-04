package com.example.mynewcompose.presentation.components.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    var user by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var repeatPassword by rememberSaveable { mutableStateOf("") }
    var isPasswordHidden by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(32.dp)
                .paddingFromBaseline(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        MyLoginTitle()
        MyUserExample(user = user) { user = it }
        MyEmailExample(email = email) { email = it }
        MyPhoneExample(phone = phone) { phone = it }
        MyPasswordExample(
            password = password,
            isPasswordHidden = isPasswordHidden,
            onPasswordChange = { password = it },
            onToggleButtonClicked = { isPasswordHidden = !isPasswordHidden },
        )
        MyRepeatPasswordExample(
            password = repeatPassword,
            isPasswordHidden = isPasswordHidden,
            onPasswordChange = { repeatPassword = it },
            onToggleButtonClicked = { isPasswordHidden = !isPasswordHidden },
        )
    }
}

@Composable
fun MyLoginTitle() {
    Text(
        text = "Iniciar sesión",
        textAlign = TextAlign.Center,
        fontSize = 32.sp,
    )
}

@Composable
fun MyUserExample(
    user: String,
    onUserChange: (String) -> Unit,
) {
    TextField(
        value = user,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { onUserChange(it) },
        singleLine = true,
        placeholder = { Text("Usuario") },
        label = { Text(text = "Introduce tu usuario") },
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Usuario",
            )
        },
    )
}

@Composable
fun MyEmailExample(
    email: String,
    onUserChange: (String) -> Unit,
) {
    TextField(
        value = email,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { onUserChange(it) },
        singleLine = true,
        label = { Text(text = "Introduce tu email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.AlternateEmail,
                contentDescription = "Email",
            )
        },
    )
}

@Composable
fun MyPhoneExample(
    phone: String,
    onUserChange: (String) -> Unit,
) {
    TextField(
        value = phone,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { onUserChange(it) },
        singleLine = true,
        label = { Text(text = "Introduce tu teléfono") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Phone,
                contentDescription = "Phone",
            )
        },
    )
}

@Composable
fun MyPasswordExample(
    password: String,
    isPasswordHidden: Boolean, // Este boolean podríamos definirlo dentro de la función, pero boeno
    onPasswordChange: (String) -> Unit,
    onToggleButtonClicked: () -> Unit,
) {
    TextField(
        value = password,
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = { onPasswordChange(it) },
        placeholder = { Text("Contraseña") },
        label = { Text(text = "Introduce tu contraseña") },
        visualTransformation = getPassVisualTransformation(isPasswordHidden),
        trailingIcon = { MyToggleButton(isPasswordHidden) { onToggleButtonClicked() } },
    )
}

@Composable
fun MyToggleButton(
    isPasswordHidden: Boolean,
    onToggleButtonClicked: () -> Unit,
) {
    IconButton(onClick = { onToggleButtonClicked() }) {
        val visibilityIcon = if (isPasswordHidden) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
        val description = if (isPasswordHidden) "Show password" else "Hide password"
        Icon(imageVector = visibilityIcon, contentDescription = description)
    }
}

@Composable
fun MyRepeatPasswordExample(
    password: String,
    isPasswordHidden: Boolean, // Este boolean podríamos definirlo dentro de la función, pero boeno
    onPasswordChange: (String) -> Unit,
    onToggleButtonClicked: () -> Unit,
) {
    TextField(
        value = password,
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = { onPasswordChange(it) },
        placeholder = { Text("Contraseña") },
        label = { Text(text = "Repite la contraseña") },
        visualTransformation = getPassVisualTransformation(isPasswordHidden),
        trailingIcon = { MyToggleText(isPasswordHidden) { onToggleButtonClicked() } },
    )
}

@Composable
fun MyToggleText(
    isPasswordHidden: Boolean,
    onToggleButtonClicked: () -> Unit,
) {
    Text(
        text = if (isPasswordHidden) "Mostrar" else "Ocultar",
        modifier = Modifier.clickable { onToggleButtonClicked() },
    )
}

fun getPassVisualTransformation(isPasswordHidden: Boolean) =
    if (isPasswordHidden) {
        PasswordVisualTransformation()
    } else {
        VisualTransformation.None
    }
