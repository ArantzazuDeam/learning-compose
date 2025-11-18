package com.example.mynewcompose.presentation.components.dropdownMenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.example.mynewcompose.R
import com.example.mynewcompose.ui.theme.Orange50
import com.example.mynewcompose.ui.theme.Pink40
import com.example.mynewcompose.ui.theme.PurpleGrey80

@Preview(showSystemUi = true)
@Composable
fun MyDropdownMenuPreview() {
    Scaffold { innerPadding ->
        MyParentDropdownMenu(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyParentDropdownMenu(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MyBasicDropdownMenuWithButton()
        MyNegativeDropdownMenuWithButton()
        MyUndismissableDropdownMenuWithButton()
    }
}

@Composable
fun MyBasicDropdownMenuWithButton() {
    var expandedDropdownState by remember { mutableStateOf(false) }
    Button(
        onClick = { expandedDropdownState = true },
    ) {
        Text(stringResource(R.string.look_options))
    }
    MyBasicDropdownMenu(expandedDropdownState) { expandedDropdownState = it }
}

@Composable
fun MyBasicDropdownMenu(
    expandedDropdownState: Boolean,
    onItemClick: (Boolean) -> Unit,
) {
    DropdownMenu(
        expanded = expandedDropdownState,
        onDismissRequest = { onItemClick(false) },
    ) {
        MyNewDropDownItem(stringResource(R.string.option_number, 1)) { onItemClick(false) }
        MyNewDropDownItem(stringResource(R.string.option_number, 2)) { onItemClick(false) }
        MyNewDropDownItem(stringResource(R.string.option_number, 3)) { onItemClick(false) }
        MyNewDropDownItem(stringResource(R.string.option_number, 4)) { onItemClick(false) }
        MyNewDropDownItem(stringResource(R.string.option_number, 5)) { onItemClick(false) }
    }
}

@Composable
fun MyNegativeDropdownMenuWithButton() {
    var expandedDropdownState by remember { mutableStateOf(false) }
    Button(
        onClick = { expandedDropdownState = true },
        colors =
            ButtonDefaults.buttonColors(
                containerColor = Pink40,
            ),
    ) {
        Text(stringResource(R.string.look_options))
    }
    MyNegativeBasicDropdownMenu(expandedDropdownState) { expandedDropdownState = it }
}

@Composable
fun MyNegativeBasicDropdownMenu(
    expandedDropdownState: Boolean,
    onItemClick: (Boolean) -> Unit,
) {
    DropdownMenu(
        expanded = expandedDropdownState,
        onDismissRequest = { onItemClick(false) },
        offset =
            DpOffset(
                x = 16.dp,
                y = -20.dp,
            ),
    ) {
        MyNewDropDownItem(stringResource(R.string.option_number, 1)) { onItemClick(false) }
        MyNewDropDownItem(stringResource(R.string.option_number, 2)) { onItemClick(false) }
        MyNewDropDownItem(stringResource(R.string.option_number, 3)) { onItemClick(false) }
        MyNewDropDownItem(stringResource(R.string.option_number, 4)) { onItemClick(false) }
        MyNewDropDownItem(stringResource(R.string.option_number, 5)) { onItemClick(false) }
    }
}

@Composable
fun MyUndismissableDropdownMenuWithButton() {
    var expandedDropdownState by remember { mutableStateOf(false) }
    Button(
        onClick = { expandedDropdownState = true },
        colors =
            ButtonDefaults.buttonColors(
                containerColor = Orange50,
            ),
    ) {
        Text(stringResource(R.string.look_options))
    }
    MyUndismissableBasicDropdownMenu(expandedDropdownState) { expandedDropdownState = it }
}

@Composable
fun MyUndismissableBasicDropdownMenu(
    expandedDropdownState: Boolean,
    onItemClick: (Boolean) -> Unit,
) {
    DropdownMenu(
        expanded = expandedDropdownState,
        onDismissRequest = { onItemClick(false) },
        properties = PopupProperties(
            focusable = true,
            dismissOnClickOutside = false,
            dismissOnBackPress = false,
            clippingEnabled = false, // está para que el dropdown no se pueda salir de la vista
        ),
    ) {
        MyNewDropDownItem(stringResource(R.string.option_number, 1)) { onItemClick(false) }
        MyNewDropDownItem(stringResource(R.string.option_number, 2)) { onItemClick(false) }
        MyNewDropDownItem(stringResource(R.string.option_number, 3)) { onItemClick(false) }
        MyNewDropDownItem(stringResource(R.string.option_number, 4)) { onItemClick(false) }
        MyNewDropDownItem(stringResource(R.string.option_number, 5)) { onItemClick(false) }
    }
}

@Composable
fun MyNewDropDownItem(
    text: String,
    onItemClick: () -> Unit,
) {
    DropdownMenuItem(
        modifier =
            Modifier
                .fillMaxWidth()
                .background(PurpleGrey80),
        text = {
            Text(text = text)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_personita),
                contentDescription = null,
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_quaso),
                contentDescription = null,
            )
        },
        colors =
            MenuItemColors(
                textColor = Color.Black,
                leadingIconColor = Color.Blue,
                trailingIconColor = Orange50,
                disabledTextColor = Color.DarkGray,
                disabledLeadingIconColor = Color.DarkGray,
                disabledTrailingIconColor = Color.DarkGray,
            ),
        onClick = { onItemClick() },
    )
}
