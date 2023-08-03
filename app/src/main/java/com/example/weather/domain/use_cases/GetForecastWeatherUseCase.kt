package com.example.weather.domain.use_cases

import com.example.weather.data.network.dto.five_days_weather.toFiveDaysWeather
import com.example.weather.domain.model.FiveDaysWeather
import com.example.weather.domain.repository.WeatherRepository
import com.example.weather.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetForecastWeatherUseCase @Inject constructor(private val repository: WeatherRepository) {

    operator fun invoke(): Flow<Resource<FiveDaysWeather>> = flow {
        try {
            emit(Resource.Loading())
            val weather = repository.getFiveDaysWeather()
            emit(Resource.Success(weather.toFiveDaysWeather()))
        } catch (e: HttpException) {
            emit(Resource.Error("HttpException"))
        } catch (e: IOException) {
            emit(Resource.Error("Check your connection"))
        }
    }
}