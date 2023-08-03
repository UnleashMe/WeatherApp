package com.example.weather.domain.repository

import com.example.weather.data.network.dto.current_weather.WeatherResponse
import com.example.weather.data.network.dto.five_days_weather.FiveDaysWeatherResponse

interface WeatherRepository {

    suspend fun getCurrentWeather(): WeatherResponse

    suspend fun getFiveDaysWeather(): FiveDaysWeatherResponse
}