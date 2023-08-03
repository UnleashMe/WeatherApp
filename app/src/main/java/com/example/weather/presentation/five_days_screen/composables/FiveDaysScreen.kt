package com.example.weather.presentation.five_days_screen.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weather.presentation.common_composables.ErrorScreen
import com.example.weather.presentation.common_composables.LoadingScreen
import com.example.weather.presentation.five_days_screen.ForecastViewModel
import com.example.weather.ui.theme.AppTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FiveDaysScreen(
    viewModel: ForecastViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = state.isLoading)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
    ) {
        state.weather?.let { weather ->
            SwipeRefresh(state = swipeRefreshState, onRefresh = { viewModel.getForecast() }) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = AppTheme.dimens.smallMedium),
                    verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.smallMedium),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    weather.dailyWeather.forEach { entry ->
                        stickyHeader {
                            DateHeader(date = entry.key)
                        }
                        items(entry.value) {
                            ForecastItem(weather = it)
                            if (it == entry.value.last() && entry.key == weather.dailyWeather.keys.last()) {
                                Spacer(
                                    modifier = Modifier
                                        .height(AppTheme.dimens.mediumLarge)
                                        .background(MaterialTheme.colors.secondary)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
    if (state.error.isNotEmpty()) {
        ErrorScreen(errorMessage = state.error) {
            viewModel.getForecast()
        }
    }
    if (state.isLoading) {
        LoadingScreen()
    }
}