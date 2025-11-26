package com.example.mynewcompose.presentation.navigation.type

import android.net.Uri
import android.os.Build
import android.os.Parcelable
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import kotlinx.serialization.json.Json

/**
 * reified indica que la función se tiene que crear en tiempo de ejecución y no en el de compilación
 */

inline fun <reified T : Parcelable> createNavType(): NavType<T> =
    object : NavType<T>(isNullableAllowed = true) {
        override fun put(
            bundle: SavedState,
            key: String,
            value: T,
        ) {
            bundle.putParcelable(key, value)
        }

        override fun get(
            bundle: SavedState,
            key: String,
        ): T? =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable(key, T::class.java)
            } else {
                bundle.getParcelable(key)
            }

        override fun parseValue(value: String): T = Json.decodeFromString<T>(value)

        override fun serializeAsValue(value: T): String = Uri.encode(Json.encodeToString(value))
    }
