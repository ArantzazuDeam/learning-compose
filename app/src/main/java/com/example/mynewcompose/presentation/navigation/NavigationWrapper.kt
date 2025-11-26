package com.example.mynewcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.mynewcompose.presentation.model.SettingModel
import com.example.mynewcompose.presentation.navigation.type.createNavType
import com.example.mynewcompose.presentation.screen.detail.DetailScreen
import com.example.mynewcompose.presentation.screen.home.HomeScreen
import com.example.mynewcompose.presentation.screen.login.LoginScreen
import com.example.mynewcompose.presentation.screen.setting.SettingScreen
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Login,
    ) {
        composable<Login> {
            LoginScreen(
                navigateToDetail = { navController.navigate(Home) },
            )
        }
        composable<Home> {
            HomeScreen(
                navigateBack = { navController.popBackStack() },
                navigateToDetail = { id, isValid ->
                    navController.navigate(Detail(id = id, darkMode = isValid))
                },
            )
        }
        composable<Detail> { navBackStackEntry ->
            val detail: Detail = navBackStackEntry.toRoute<Detail>()
            DetailScreen(
                id = detail.id,
                navigateToSettings = { settingModel ->
                    navController.navigate(
                        Settings(settingModel),
                    )
                },
                navigateBack = { navController.popBackStack() },
            )
        }

        composable<Settings>(typeMap = mapOf(typeOf<SettingModel>() to createNavType<SettingModel>())) { navBackStackEntry ->
            val settings: Settings = navBackStackEntry.toRoute<Settings>()
            SettingScreen(
                settingModel = settings.settingModel,
                navigateToLogin = {
                    navController.navigate(Login) {
                        popUpTo<Login> {
                            inclusive =
                                true // true navega a una nueva pantalla de login y elimina la anterior instancia del login
                            // inclusive = false, deja en la pila la anterior instancia de login y la nueva. Una mierda.
                        }
                    }
                },
            )
        }
    }
}
