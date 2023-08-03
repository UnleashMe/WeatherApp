package com.example.weather.presentation.details_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.weather.domain.model.CurrentWeather
import com.example.weather.presentation.common_composables.InfoBox
import com.example.weather.ui.theme.AppTheme
import com.example.weather.ui.theme.Orientation

@Composable
fun DetailsScreen(
    currentWeather: CurrentWeather?,
    orientation: Orientation
) {
    currentWeather?.let { weather ->
        when (orientation) {
            Orientation.Portrait -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background),
                    verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.medium),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(AppTheme.dimens.medium),
                        backgroundColor = MaterialTheme.colors.primary,
                        shape = RoundedCornerShape(AppTheme.dimens.medium),
                        border = BorderStroke(AppTheme.dimens.tiny, color = MaterialTheme.colors.secondary)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(AppTheme.dimens.medium),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = weather.iconPath),
                                contentDescription = "weatherIcon",
                                modifier = Modifier.size(AppTheme.dimens.humongous)
                            )
                            Text(text = weather.description, style = MaterialTheme.typography.h4, textAlign = TextAlign.Center)
                            Text(
                                text = weather.temperature,
                                style = MaterialTheme.typography.h1,
                                textAlign = TextAlign.Center
                            )
                            Text(text = weather.feelsLike, style = MaterialTheme.typography.h4, textAlign = TextAlign.Center)
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.smallMedium),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Max)
                                .padding(AppTheme.dimens.smallMedium),
                            horizontalArrangement = Arrangement.spacedBy(AppTheme.dimens.smallMedium),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            InfoBox(
                                title = "Влажность",
                                info = weather.humidity.toString() + "%",
                                modifier = Modifier.weight(1f)
                            )
                            InfoBox(
                                title = "Скорость ветра",
                                info = weather.windSpeed.toString() + " м/с",
                                modifier = Modifier.weight(1f)
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Max)
                                .padding(AppTheme.dimens.smallMedium),
                            horizontalArrangement = Arrangement.spacedBy(AppTheme.dimens.smallMedium),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            InfoBox(
                                title = "Давление",
                                info = weather.pressure.toString() + " мм рт. ст.",
                                modifier = Modifier.weight(1f)
                            )
                            InfoBox(
                                title = "Облачность",
                                info = weather.cloudiness.toString() + "%",
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
            Orientation.Landscape -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(AppTheme.dimens.smallMedium).fillMaxHeight(0.95f),
                    horizontalArrangement = Arrangement.spacedBy(AppTheme.dimens.medium)
                ) {

                    Card(
                        modifier = Modifier
                            .weight(2f)
                            .fillMaxHeight()
                            .padding(AppTheme.dimens.medium),
                        backgroundColor = MaterialTheme.colors.primary,
                        shape = RoundedCornerShape(AppTheme.dimens.medium),
                        border = BorderStroke(AppTheme.dimens.tiny, color = MaterialTheme.colors.secondary)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(AppTheme.dimens.medium),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(AppTheme.dimens.medium)
                            ) {
                                Image(
                                    painter = painterResource(id = weather.iconPath),
                                    contentDescription = "weatherIcon",
                                    modifier = Modifier.size(AppTheme.dimens.large)
                                )
                                Text(
                                    text = weather.temperature,
                                    style = MaterialTheme.typography.h1
                                )
                            }
                            Text(text = weather.description, style = MaterialTheme.typography.h4)
                            Text(text = weather.feelsLike, style = MaterialTheme.typography.h4)
                        }
                    }
                    Column(
                        modifier = Modifier.weight(2f).fillMaxHeight(),
                        verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.large),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Max)
                                .padding(AppTheme.dimens.smallMedium),
                            horizontalArrangement = Arrangement.spacedBy(AppTheme.dimens.smallMedium),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            InfoBox(
                                title = "Влажность",
                                info = weather.humidity.toString() + "%",
                                modifier = Modifier.weight(1f)
                            )
                            InfoBox(
                                title = "Скорость ветра",
                                info = weather.windSpeed.toString() + " м/с",
                                modifier = Modifier.weight(1f)
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Max)
                                .padding(AppTheme.dimens.smallMedium),
                            horizontalArrangement = Arrangement.spacedBy(AppTheme.dimens.smallMedium),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            InfoBox(
                                title = "Давление",
                                info = weather.pressure.toString() + " мм рт. ст.",
                                modifier = Modifier.weight(1f)
                            )
                            InfoBox(
                                title = "Облачность",
                                info = weather.cloudiness.toString() + "%",
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}