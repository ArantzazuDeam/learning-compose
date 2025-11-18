package com.example.mynewcompose.presentation.components.dropdownMenu

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynewcompose.R
import com.example.mynewcompose.ui.theme.Orange50
import com.example.mynewcompose.utils.constant.STRING_EMPTY

@Preview(showSystemUi = true)
@Composable
fun MyExposedDropdownMenuPreview() {
    Scaffold { innerPadding ->
        MyExposedDropdownMenu(modifier = Modifier.padding(innerPadding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropdownMenu(modifier: Modifier) {
    var optionSelected by remember { mutableStateOf(STRING_EMPTY) }
    var expandedExposedDropdownState by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expandedExposedDropdownState,
        onExpandedChange = { expandedExposedDropdownState = !expandedExposedDropdownState },
    ) {
        TextField(
            value = optionSelected,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = stringResource(R.string.language)) },
            modifier =
                Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expandedExposedDropdownState)
            },
        )
        MyDropdownMenuForLanguages(
            expandedDropdownState = expandedExposedDropdownState,
            onExpandedChange = { state -> expandedExposedDropdownState = state },
            onItemClick = { option -> optionSelected = option },
        )
    }
}

@Composable
fun MyDropdownMenuForLanguages(
    expandedDropdownState: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onItemClick: (String) -> Unit,
) {
    val optionList = listOf("Español", "Inglés", "Francés", "Alemán", "Italiano")
    DropdownMenu(
        modifier = Modifier.fillMaxWidth(),
        expanded = expandedDropdownState,
        onDismissRequest = { onExpandedChange(false) },
    ) {
        optionList.forEach { language ->
            MyExposedDropDownItem(
                text = language,
            ) {
                onItemClick(language)
            }
        }
    }
}

@Composable
fun MyExposedDropDownItem(
    text: String,
    onItemClick: () -> Unit,
) {
    DropdownMenuItem(
        modifier = Modifier.fillMaxWidth(),
        text = {
            Text(text = text)
        },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_personita),
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
