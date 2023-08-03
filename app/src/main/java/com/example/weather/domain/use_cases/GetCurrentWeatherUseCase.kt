package com.example.weather.domain.use_cases

import com.example.weather.data.network.dto.current_weather.toCurrentWeather
import com.example.weather.domain.model.CurrentWeather
import com.example.weather.domain.repository.WeatherRepository
import com.example.weather.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(private val repository: WeatherRepository) {

    operator fun invoke(): Flow<Resource<CurrentWeather>> = flow {
        try {
            emit(Resource.Loading())
            val weather = repository.getCurrentWeather().toCurrentWeather()
            emit(Resource.Success(weather))
        } catch (e: HttpException) {
            emit(Resource.Error("HttpException"))
        } catch (e: IOException) {
            emit(Resource.Error("Check your connection"))
        }
    }
}