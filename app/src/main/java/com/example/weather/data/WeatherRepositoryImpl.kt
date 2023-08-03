package com.example.weather.data

import com.example.weather.data.network.WeatherService
import com.example.weather.data.network.dto.current_weather.WeatherResponse
import com.example.weather.data.network.dto.five_days_weather.FiveDaysWeatherResponse
import com.example.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherService: WeatherService): WeatherRepository {
    override suspend fun getCurrentWeather(): WeatherResponse {
        return weatherService.getCurrentWeather()
    }

    override suspend fun getFiveDaysWeather(): FiveDaysWeatherResponse {
        return weatherService.getFiveDaysWeather()
    }
}