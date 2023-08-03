package com.example.weather.data.network.dto.five_days_weather

import com.example.weather.domain.model.FiveDaysWeather
import com.example.weather.util.getWeatherImage
import kotlin.math.roundToInt

data class FiveDaysWeatherResponse(
    val city: City = City(),
    val cnt: Int = 0,
    val cod: String = "",
    val list: List<Data> = listOf(),
    val message: Int = 0
)

fun FiveDaysWeatherResponse.toFiveDaysWeather(): FiveDaysWeather {
    return FiveDaysWeather(
        cityName = city.name,
        dailyWeather = this.list.groupBy { data -> data.dt_txt.takeWhile { it != ' ' } }.mapValues { entry ->
            entry.value.map { data ->
                FiveDaysWeather.Weather(
                    temperature = data.main.temp.roundToInt(),
                    time = data.dt_txt.takeLastWhile { it != ' ' }.dropLast(3),
                    iconPath = getWeatherImage(data.weather[0].id)
                )
            }
        }
    )
}