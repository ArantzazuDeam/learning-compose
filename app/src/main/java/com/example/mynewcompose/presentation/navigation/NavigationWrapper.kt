package com.example.mynewcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.mynewcompose.presentation.screen.detail.DetailScreen
import com.example.mynewcompose.presentation.screen.home.HomeScreen
import com.example.mynewcompose.presentation.screen.login.LoginScreen

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
                    navController.navigate(Detail(id = id, check = isValid))
                },
            )
        }
        composable<Detail> { navBackStackEntry ->
            val detail: Detail = navBackStackEntry.toRoute<Detail>()
            val elementoBooleano = detail.check
            DetailScreen(detail.id, navigateBack = { navController.popBackStack() })
        }
    }
}
