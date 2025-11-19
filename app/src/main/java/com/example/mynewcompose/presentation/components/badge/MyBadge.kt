package com.example.mynewcompose.presentation.components.badge

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.R
import com.example.mynewcompose.ui.theme.Orange40
import com.example.mynewcompose.ui.theme.Orange50

@Composable
fun MyBadge() {
    Badge(
        containerColor = Color.Blue,
        contentColor = Orange50,
    ) {
        Text("3")
    }
}

@Composable
fun MyWeirdBadge() {
    Badge(
        containerColor = Color.Blue,
        contentColor = Orange50,
    ) {
        Text("3")
        Button(
            onClick = {},
        ) {
            Text("5")
        }
    }
}

@Preview
@Composable
fun MyBadgeBox() {
    BadgedBox(
        modifier = Modifier.padding(start = 8.dp),
        badge = { MyBadge() },
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_quaso),
            contentDescription = null,
            tint = Orange40,
        )
    }
}
