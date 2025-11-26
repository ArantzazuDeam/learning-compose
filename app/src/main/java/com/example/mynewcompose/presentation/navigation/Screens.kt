package com.example.mynewcompose.presentation.navigation

import com.example.mynewcompose.presentation.model.SettingModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(
    val id: String,
    val darkMode: Boolean,
)

@Serializable
data class Settings(
    val settingModel: SettingModel,
)
