package com.example.mynewcompose.presentation.components.scaffold

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.mynewcompose.R
import com.example.mynewcompose.ui.theme.Green100
import com.example.mynewcompose.ui.theme.Pink100
import com.example.mynewcompose.ui.theme.Pink60
import com.example.mynewcompose.ui.theme.Purple100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onNavSelected: () -> Unit) {
    TopAppBar(
        title = {
            Text("Componentes de Compose")
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = null,
                modifier =
                    Modifier.clickable {
                        onNavSelected()
                    },
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.ic_quaso),
                contentDescription = null,
            )
            Icon(
                painter = painterResource(R.drawable.ic_badminton),
                contentDescription = null,
                tint = Color.Yellow,
            )
            Icon(
                painter = painterResource(R.drawable.ic_foot),
                contentDescription = null,
            )
        },
        colors =
            TopAppBarDefaults.topAppBarColors(
                containerColor = Pink60,
                titleContentColor = Purple100,
                navigationIconContentColor = Pink100,
                actionIconContentColor = Green100,
                scrolledContainerColor = Color.Black,
            ),
    )
}
