package com.example.weather.domain.model

import androidx.annotation.DrawableRes

data class FiveDaysWeather(
    val cityName: String,
    val dailyWeather: Map<String, List<Weather>>
) {
    data class Weather(
        val temperature: Int,
        val time: String,
        @DrawableRes
        val iconPath: Int
    )
}