package com.example.weather.presentation.main_screen.composables

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.weather.presentation.common_composables.InfoBox
import com.example.weather.ui.theme.AppTheme
import com.example.weather.ui.theme.Orientation

@Composable
fun MainScreenInformationCards(
    humidity: Int,
    windSpeed: Int,
    pressure: Int,
    orientation: Orientation,
    modifier: Modifier = Modifier
) {
    when (orientation) {
        Orientation.Portrait -> {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max)
                    .padding(AppTheme.dimens.smallMedium),
                horizontalArrangement = Arrangement.spacedBy(AppTheme.dimens.smallMedium),
                verticalAlignment = Alignment.CenterVertically
            ) {
                InfoBox(title = "Влажность", info = "$humidity%", modifier = Modifier.weight(1f))
                InfoBox(
                    title = "Скорость ветра",
                    info = "$windSpeed м/с",
                    modifier = Modifier.weight(1f)
                )
                InfoBox(
                    title = "Давление",
                    info = "$pressure мм рт. ст.",
                    modifier = Modifier.weight(1f)
                )
            }
        }
        Orientation.Landscape -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.smallMedium),
                modifier = modifier
            ) {
                InfoBox(title = "Влажность", info = "$humidity%", modifier = Modifier.weight(1f))
                InfoBox(
                    title = "Скорость ветра",
                    info = "$windSpeed м/с",
                    modifier = Modifier.weight(1f)
                )
                InfoBox(
                    title = "Давление",
                    info = "$pressure мм рт. ст.",
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}