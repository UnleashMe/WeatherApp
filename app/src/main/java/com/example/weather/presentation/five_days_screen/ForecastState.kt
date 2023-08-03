package com.example.weather.presentation.five_days_screen

import com.example.weather.domain.model.FiveDaysWeather

class ForecastState(
    val isLoading: Boolean = false,
    val error: String = "",
    val weather: FiveDaysWeather? = null
)