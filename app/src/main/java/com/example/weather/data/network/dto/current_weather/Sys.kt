package com.example.weather.data.network.dto.current_weather

data class Sys(
    val country: String = "",
    val id: Int = 0,
    val sunrise: Int = 0,
    val sunset: Int = 0,
    val type: Int = 0
)