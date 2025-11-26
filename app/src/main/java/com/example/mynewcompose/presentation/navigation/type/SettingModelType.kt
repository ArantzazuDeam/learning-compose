package com.example.mynewcompose.presentation.navigation.type

import android.net.Uri
import android.os.Build
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import com.example.mynewcompose.presentation.model.SettingModel
import kotlinx.serialization.json.Json

val settingModelType =
    object : NavType<SettingModel>(isNullableAllowed = true) {
        override fun put(
            bundle: SavedState,
            key: String,
            value: SettingModel,
        ) {
            bundle.putParcelable(key, value)
        }

        override fun get(
            bundle: SavedState,
            key: String,
        ): SettingModel? =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable(key, SettingModel::class.java)
            } else {
                bundle.getParcelable(key)
            }

        override fun parseValue(value: String): SettingModel = Json.decodeFromString<SettingModel>(value)

        override fun serializeAsValue(value: SettingModel): String = Uri.encode(Json.encodeToString(value))
    }
