package com.example.mynewcompose.presentation.components.button

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.R
import com.example.mynewcompose.ui.theme.Pink60
import com.example.mynewcompose.ui.theme.Purple100

@Preview
@Composable
fun MyFab() {
    FloatingActionButton(
        onClick = { },
        containerColor = Pink60,
        contentColor = Purple100,
        shape = CircleShape,
        elevation =
            FloatingActionButtonDefaults.elevation(
                defaultElevation = 12.dp,
            ),
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_quaso),
            contentDescription = null,
        )
    }
}
