package com.example.mynewcompose.presentation.components.model

import androidx.compose.ui.graphics.vector.ImageVector

data class DrawerItem(
    val name: String,
    val icon: ImageVector,
    val notification: Int,
)
