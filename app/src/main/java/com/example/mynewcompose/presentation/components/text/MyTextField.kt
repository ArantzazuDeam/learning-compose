package com.example.mynewcompose.presentation.components.text

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.mynewcompose.R
import com.example.mynewcompose.utils.constant.STRING_EMPTY
import com.example.mynewcompose.ui.theme.MyNewTheme.dimens as Dimens

//@Preview(showSystemUi = true)
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
    var user by rememberSaveable { mutableStateOf(STRING_EMPTY) }
    var email by rememberSaveable { mutableStateOf(STRING_EMPTY) }
    var phone by rememberSaveable { mutableStateOf(STRING_EMPTY) }
    var nif by rememberSaveable { mutableStateOf(STRING_EMPTY) }
    var cardNumber by rememberSaveable { mutableStateOf(STRING_EMPTY) }
    var password by rememberSaveable { mutableStateOf(STRING_EMPTY) }
    var repeatPassword by rememberSaveable { mutableStateOf(STRING_EMPTY) }
    var isPasswordHidden by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(Dimens.columnPadding)
                .paddingFromBaseline(Dimens.columnPaddingFromBaseline),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimens.columnVerticalSpacing),
    ) {
        MyLoginTitle()
        MyUserExample(user = user) { user = it }
        MyEmailExample(email = email) { email = it }
        MyPhoneExample(phone = phone) { phone = it }
        MyOutlinedNifTextField(nif = nif) { nif = it }
        MyCreditCardComponent(cardNumber = cardNumber) { cardNumber = it }
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
        text = stringResource(R.string.log_in),
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
        placeholder = { Text(stringResource(R.string.user)) },
        label = { Text(text = stringResource(R.string.add_user_into_text_field)) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = stringResource(R.string.user),
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
        label = { Text(text = stringResource(R.string.add_email_into_text_field)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.AlternateEmail,
                contentDescription = stringResource(R.string.email),
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
        label = { Text(text = stringResource(R.string.add_phone_into_text_field)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Phone,
                contentDescription = stringResource(R.string.phone),
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
        placeholder = { Text(stringResource(R.string.password)) },
        label = { Text(text = stringResource(R.string.add_password_into_text_field)) },
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
        Icon(
            imageVector = getToggleButtonIcon(isPasswordHidden),
            contentDescription = getToggleButtonDescription(isPasswordHidden),
        )
    }
}

fun getToggleButtonIcon(isPasswordHidden: Boolean) = if (isPasswordHidden) Icons.Filled.VisibilityOff else Icons.Filled.Visibility

@Composable
fun getToggleButtonDescription(isPasswordHidden: Boolean) =
    if (isPasswordHidden) {
        stringResource(R.string.hint_show_password)
    } else {
        stringResource(R.string.hint_hide_password)
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
        placeholder = { Text( stringResource(R.string.password)) },
        label = { Text(text = stringResource(R.string.repeat_password_into_text_field)) },
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
        text = if (isPasswordHidden) stringResource(R.string.hint_show) else stringResource(R.string.hint_hide),
        modifier = Modifier.clickable { onToggleButtonClicked() },
    )
}

fun getPassVisualTransformation(isPasswordHidden: Boolean) =
    if (isPasswordHidden) {
        PasswordVisualTransformation()
    } else {
        VisualTransformation.None
    }

@Composable
fun MyOutlinedNifTextField(
    nif: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = nif,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(stringResource(R.string.add_dni_into_text_field)) },
        trailingIcon = { Icon(imageVector = Icons.Filled.PermIdentity, contentDescription = stringResource(R.string.dni)) },
    )
}

@Composable
fun MyCreditCardComponent(
    cardNumber: String,
    onValueChange: (String) -> Unit,
) {
    Spacer(modifier = Modifier.padding(Dimens.spacerPadding))
    MyCreditCardTitle()
    MyBasicCreditCardTextField(cardNumber = cardNumber) { onValueChange(it) }
    Spacer(modifier = Modifier.padding(Dimens.spacerPadding))
}

@Composable
fun MyCreditCardTitle() {
    Text(text = stringResource(R.string.add_credit_card_into_text_field), modifier = Modifier.fillMaxWidth())
}

@Composable
fun MyBasicCreditCardTextField(
    cardNumber: String,
    onValueChange: (String) -> Unit,
) {
    // Este tipo de componente es muy cómodo para personalizarlo cómo queramos.
    BasicTextField(
        value = cardNumber,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier =
            Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(Dimens.basicTextFieldPadding),
    )
}
