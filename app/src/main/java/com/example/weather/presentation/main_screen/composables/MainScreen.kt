package com.example.weather.presentation.main_screen.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weather.presentation.common_composables.ErrorScreen
import com.example.weather.presentation.common_composables.LoadingScreen
import com.example.weather.presentation.main_screen.MainScreenViewModel
import com.example.weather.presentation.navigation.Screen
import com.example.weather.ui.theme.AppTheme
import com.example.weather.ui.theme.Orientation
import com.example.weather.util.toJson

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel(),
    navController: NavController,
    orientation: Orientation
) {

    val state = viewModel.state.value

    state.weather?.let { weather ->
        when (orientation) {
            Orientation.Portrait -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.smallMedium),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MainCard(
                            cityName = weather.cityName,
                            iconPath = weather.iconPath,
                            temperature = weather.temperature,
                            modifier = Modifier
                                .fillMaxWidth(0.95f)
                                .padding(vertical = AppTheme.dimens.medium),
                            imageSize = AppTheme.dimens.humongous,
                            orientation = orientation
                        )
                        MainScreenInformationCards(
                            humidity = weather.humidity,
                            windSpeed = weather.windSpeed,
                            pressure = weather.pressure,
                            orientation = orientation
                        )
                    }
                    MainScreenButtons(onDetailsClick = {
                        val weatherJson = toJson(weather)
                        navController.navigate(
                            Screen.DetailsScreen.route.replace(
                                "{weather}",
                                weatherJson
                            )
                        )
                    }, onForecastClick = {
                        navController.navigate(Screen.FiveDaysScreen.route)
                    })
                }
            }
            Orientation.Landscape -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .weight(4f)
                            .padding(AppTheme.dimens.smallMedium),
                        horizontalArrangement = Arrangement.spacedBy(AppTheme.dimens.smallMedium)
                    ) {
                        MainCard(
                            cityName = weather.cityName,
                            iconPath = weather.iconPath,
                            temperature = weather.temperature,
                            imageSize = AppTheme.dimens.large,
                            orientation = orientation,
                            modifier = Modifier
                                .weight(3f)
                                .fillMaxHeight()
                                .padding(end = AppTheme.dimens.smallMedium)
                        )
                        MainScreenInformationCards(
                            humidity = weather.humidity,
                            windSpeed = weather.windSpeed,
                            pressure = weather.pressure,
                            orientation = orientation,
                            modifier = Modifier.weight(2f)
                        )
                    }
                    MainScreenButtons(onDetailsClick = {
                        val weatherJson = toJson(weather)
                        navController.navigate(
                            Screen.DetailsScreen.route.replace(
                                "{weather}",
                                weatherJson
                            ),

                            )
                    }, onForecastClick = {
                        navController.navigate(Screen.FiveDaysScreen.route)
                    },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

    }
    if (state.isLoading) {
        LoadingScreen()
    }
    if (state.error.isNotEmpty()) {
        ErrorScreen(errorMessage = state.error) {
            viewModel.getWeather()
        }
    }
}