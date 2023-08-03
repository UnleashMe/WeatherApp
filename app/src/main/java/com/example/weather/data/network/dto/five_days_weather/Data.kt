package com.example.weather.data.network.dto.five_days_weather

data class Data(
    val clouds: Clouds = Clouds(),
    val dt: Int = 0,
    val dt_txt: String = "",
    val main: Main = Main(),
    val pop: Double = 0.0,
    val rain: Rain = Rain(),
    val sys: Sys = Sys(),
    val visibility: Int = 0,
    val weather: List<Weather> = listOf(),
    val wind: Wind = Wind()
)