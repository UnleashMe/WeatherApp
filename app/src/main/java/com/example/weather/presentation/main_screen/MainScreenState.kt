package com.example.weather.presentation.main_screen

import com.example.weather.domain.model.CurrentWeather

data class MainScreenState(
    val isLoading: Boolean = false,
    val error: String = "",
    val weather: CurrentWeather? = null
)
