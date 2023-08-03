package com.example.weather.domain.model

import androidx.annotation.DrawableRes

data class CurrentWeather(
  val cityName: String,
  val temperature: String,
  val humidity: Int,
  val windSpeed: Int,
  val pressure: Int,
  val description: String,
  val feelsLike: String,
  val cloudiness: Int,
  @DrawableRes
  val iconPath: Int,
)