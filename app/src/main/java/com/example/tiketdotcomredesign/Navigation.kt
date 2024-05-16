package com.example.tiketdotcomredesign

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

sealed class Route {
    data class LoginScreen(val name:String = "Login"):Route()
    data class HomeScreen(val name:String = "Home"):Route()
    data class SearchFlightResultScreen(val name:String = "SearchFlightResult"):Route()


}
@Composable
fun MyNavigation(navHostController: NavHostController){
    NavHost(
        navController = navHostController,
        startDestination = Route.LoginScreen().name,
    ){
        composable(route = Route.LoginScreen().name){
            LoginScreen(
                onLoginClick = {
                    navHostController.navigate(
                        Route.HomeScreen().name
                    )
                }
            )
        }
        composable(route = Route.HomeScreen().name){
            HomeScreen(
                onLogoutClick = {
                    navHostController.navigate(
                        Route.LoginScreen().name
                    )
                }
            )
        }
        composable(route = Route.SearchFlightResultScreen().name){
            SearchFlightResultScreen(
                onLogoutClick = {
                    navHostController.navigate(
                        Route.LoginScreen().name
                    )
                }
            )
        }
    }
}