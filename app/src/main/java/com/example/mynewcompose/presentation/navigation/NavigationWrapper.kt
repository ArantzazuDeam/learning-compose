package com.example.mynewcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
            )
        }
    }
}
