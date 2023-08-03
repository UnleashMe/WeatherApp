package com.example.weather.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weather.domain.model.CurrentWeather
import com.example.weather.presentation.details_screen.DetailsScreen
import com.example.weather.presentation.five_days_screen.composables.FiveDaysScreen
import com.example.weather.presentation.main_screen.composables.MainScreen
import com.example.weather.ui.theme.Orientation
import com.example.weather.util.fromJson

@Composable
fun Navigation(orientation: Orientation) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController, orientation = orientation)
        }
        composable(route = Screen.DetailsScreen.route) {
            val weatherJson = it.arguments?.getString("weather")
            val currentWeather = fromJson<CurrentWeather>(weatherJson)
            DetailsScreen(currentWeather = currentWeather, orientation = orientation)
        }
        composable(route = Screen.FiveDaysScreen.route) {
            FiveDaysScreen()
        }
    }
}