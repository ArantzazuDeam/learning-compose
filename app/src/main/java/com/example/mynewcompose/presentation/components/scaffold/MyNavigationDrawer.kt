package com.example.mynewcompose.presentation.components.scaffold

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mynewcompose.presentation.components.model.DrawerItem
import com.example.mynewcompose.ui.theme.Green100
import com.example.mynewcompose.ui.theme.Green40
import com.example.mynewcompose.ui.theme.Green60
import com.example.mynewcompose.ui.theme.Green80
import com.example.mynewcompose.ui.theme.Pink100
import com.example.mynewcompose.ui.theme.Pink40
import com.example.mynewcompose.ui.theme.Pink80

@Composable
fun MyModalDrawer(
    drawerState: DrawerState,
    onCloseNavigation: () -> Unit,
    content: @Composable () -> Unit,
) {
    val itemList =
        listOf(
            DrawerItem("Home", Icons.Outlined.Home, 2),
            DrawerItem("Favoritos", Icons.Outlined.Favorite, 3),
            DrawerItem("Mi perfil", Icons.Outlined.PersonOutline, 0),
            DrawerItem("Configuración", Icons.Outlined.Settings, 0),
        )
    var selectedIndex by remember { mutableIntStateOf(0) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape =
                    RoundedCornerShape(
                        topEnd = 50.dp,
                        bottomEnd = 50.dp,
                    ),
                drawerContentColor = Green40,
                drawerContainerColor = Green100,
                drawerTonalElevation = 10.dp,
            ) {
                Spacer(Modifier.height(44.dp))
                itemList.forEachIndexed { index, drawerItem ->
                    MyDrawerItem(
                        drawerItem = drawerItem,
                        isSelected = index == selectedIndex,
                    ) {
                        selectedIndex = index
                    }
                }
                Text(
                    "Si pulsas en este texto se cierra el drawer",
                    modifier =
                        Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .clickable { onCloseNavigation() },
                )
            }
        },
        scrimColor = Green60.copy(alpha = 0.8f),
    ) {
        content()
    }
}

@Composable
fun ColumnScope.MyDrawerItem(
    drawerItem: DrawerItem,
    isSelected: Boolean,
    onItemClick: () -> Unit,
) {
    NavigationDrawerItem(
        label = { Text(drawerItem.name) },
        selected = isSelected,
        onClick = { onItemClick() },
        icon = {
            Icon(
                imageVector = drawerItem.icon,
                contentDescription = null,
            )
        },
        badge = {
            if (drawerItem.notification > 0) {
                Badge(
                    containerColor = if (isSelected) Pink80 else Pink40,
                    contentColor = if (isSelected) Pink40 else Pink100,
                ) { Text("${drawerItem.notification}") }
            }
        },
        shape = RoundedCornerShape(50.dp),
        colors =
            NavigationDrawerItemDefaults.colors(
                selectedContainerColor = Green40,
                unselectedContainerColor = Green80,
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White,
                selectedBadgeColor = Color.White,
                unselectedBadgeColor = Green100,
            ),
    )
}
