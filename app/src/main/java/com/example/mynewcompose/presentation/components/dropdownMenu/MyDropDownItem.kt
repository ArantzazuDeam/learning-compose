package com.example.mynewcompose.presentation.components.dropdownMenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.R
import com.example.mynewcompose.ui.theme.Orange50
import com.example.mynewcompose.ui.theme.PurpleGrey80

//@Preview(showSystemUi = true)
@Composable
fun MyDropDownItemPreview() {
    Scaffold { innerPadding ->
        MyDropDownItemParent(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MyDropDownItemParent(modifier: Modifier) {
    Column(
        modifier =
            modifier
                .padding(horizontal = 30.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MyDropDownItem()
        MyDisableDropDownItem()
    }
}

@Composable
fun MyDropDownItem() {
    DropdownMenuItem(
        modifier = Modifier
            .fillMaxWidth()
            .background(PurpleGrey80),
        text = {
            Text(text = "Ejemplo 1")
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
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        colors =
            MenuItemColors(
                textColor = Color.Black,
                leadingIconColor = Color.Blue,
                trailingIconColor = Orange50,
                disabledTextColor = Color.DarkGray,
                disabledLeadingIconColor = Color.DarkGray,
                disabledTrailingIconColor = Color.DarkGray,
            ),
        onClick = {},
    )
}

@Composable
fun MyDisableDropDownItem() {
    DropdownMenuItem(
        modifier = Modifier
            .fillMaxWidth()
            .background(PurpleGrey80),
        text = {
            Text(text = "Ejemplo 1")
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
        enabled = false,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        colors =
            MenuItemColors(
                textColor = Color.Black,
                leadingIconColor = Color.Blue,
                trailingIconColor = Orange50,
                disabledTextColor = Color.DarkGray,
                disabledLeadingIconColor = Color.DarkGray,
                disabledTrailingIconColor = Color.DarkGray,
            ),
        onClick = {},
    )
}
