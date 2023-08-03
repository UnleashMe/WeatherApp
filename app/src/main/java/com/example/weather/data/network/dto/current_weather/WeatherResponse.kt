package com.example.weather.data.network.dto.current_weather

import com.example.weather.domain.model.CurrentWeather
import com.example.weather.util.getWeatherImage
import kotlin.math.roundToInt

data class WeatherResponse(
    val base: String = "",
    val clouds: Clouds = Clouds(),
    val cod: Int = 0,
    val coord: Coord = Coord(),
    val dt: Int = 0,
    val id: Int = 0,
    val main: Main = Main(),
    val name: String = "",
    val rain: Rain = Rain(),
    val sys: Sys = Sys(),
    val timezone: Int = 0,
    val visibility: Int = 0,
    val weather: List<Weather> = listOf(),
    val wind: Wind = Wind()
)

fun WeatherResponse.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        cityName = this.name,
        temperature = if (this.main.temp > 0) {
            "+${this.main.temp.roundToInt()}°С"
        } else "${this.main.temp.roundToInt()}°С",
        humidity = this.main.humidity,
        windSpeed = this.wind.speed,
        pressure = this.main.pressure,
        description = this.weather[0].description,
        feelsLike = if (this.main.feels_like > 0) {
            "По ощущению: +${this.main.feels_like.roundToInt()}°С"
        } else "По ощущению: ${this.main.feels_like.roundToInt()}°С",
        cloudiness = this.clouds.all,
        iconPath = getWeatherImage(this.weather[0].id)
    )
}