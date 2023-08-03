package com.example.weather.presentation.navigation

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object DetailsScreen: Screen("details_screen/weather={weather}")
    object FiveDaysScreen: Screen("five_days_screen")
}
