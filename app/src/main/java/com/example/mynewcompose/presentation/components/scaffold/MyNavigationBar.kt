package com.example.mynewcompose.presentation.components.scaffold

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.presentation.components.model.NavItem
import com.example.mynewcompose.ui.theme.Pink100
import com.example.mynewcompose.ui.theme.Pink40
import com.example.mynewcompose.ui.theme.Pink60
import com.example.mynewcompose.ui.theme.Purple100

@Preview
@Composable
fun MyNavigationBar() {
    val itemList =
        listOf(
            NavItem("Home", Icons.Outlined.Home),
            NavItem("Favoritos", Icons.Outlined.Favorite),
            NavItem("Mi perfil", Icons.Outlined.PersonOutline),
        )
    var selectedIndex by remember { mutableIntStateOf(0) }
    NavigationBar(
        containerColor = Pink100,
        tonalElevation = 10.dp,
    ) {
        itemList.forEachIndexed { index, navItem ->
            ArantxaItem(navItem, isSelected = index == selectedIndex) {
                selectedIndex = index
            }
        }
    }
}

@Composable
fun RowScope.ArantxaItem(
    navItem: NavItem,
    isSelected: Boolean,
    onItemClick: () -> Unit,
) {
    NavigationBarItem(
        selected = isSelected,
        onClick = { onItemClick() },
        icon = { Icon(imageVector = navItem.icon, contentDescription = null) },
        label = { Text(text = navItem.name) },
        alwaysShowLabel = false,
        colors =
            NavigationBarItemDefaults.colors(
                selectedIconColor = Pink60,
                selectedTextColor = Pink60,
                indicatorColor = Purple100,
                unselectedIconColor = Pink40,
                unselectedTextColor = Pink40,
                disabledIconColor = Color.LightGray,
                disabledTextColor = Color.LightGray,
            ),
    )
}
