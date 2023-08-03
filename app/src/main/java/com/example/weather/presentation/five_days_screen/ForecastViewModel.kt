package com.example.weather.presentation.five_days_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.domain.use_cases.GetForecastWeatherUseCase
import com.example.weather.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(val getForecastWeatherUseCase: GetForecastWeatherUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(ForecastState())
    val state: State<ForecastState> = _state

    init {
        getForecast()
    }

    fun getForecast() {
        getForecastWeatherUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _state.value = ForecastState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = ForecastState(error = it.message ?: "unknown error")
                }
                is Resource.Success -> {
                    _state.value = ForecastState(weather = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}