package com.example.weather.data.network

import com.example.weather.data.network.dto.current_weather.WeatherResponse
import com.example.weather.data.network.dto.five_days_weather.FiveDaysWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {

    @GET("{path}")
    suspend fun getFiveDaysWeather(
        @Path("path") path:String = "forecast",
        @Query("q") cityName: String = "Санкт-Петербург,ru",
        @Query("appid") appId: String = "d9e6fe2ca9bd114df14262b014663852",
        @Query("units") units: String = "metric",
        @Query("lang") language: String = "ru"
    ): FiveDaysWeatherResponse

    @GET("{path}")
    suspend fun getCurrentWeather(
        @Path("path") path:String = "weather",
        @Query("q") cityName: String = "Санкт-Петербург,ru",
        @Query("appid") appId: String = "d9e6fe2ca9bd114df14262b014663852",
        @Query("units") units: String = "metric",
        @Query("lang") language: String = "ru"
    ): WeatherResponse
}