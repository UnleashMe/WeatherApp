package com.example.weather.presentation.five_days_screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.weather.domain.model.FiveDaysWeather
import com.example.weather.presentation.common_composables.CustomCard
import com.example.weather.ui.theme.AppTheme

@Composable
fun ForecastItem(weather: FiveDaysWeather.Weather) {
    CustomCard(modifier = Modifier.fillMaxWidth(0.95f)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = AppTheme.dimens.smallMedium),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = weather.time, style = MaterialTheme.typography.h5)
            Text(text = "${weather.temperature}°С", style = MaterialTheme.typography.h5)
            Image(
                painter = painterResource(id = weather.iconPath),
                contentDescription = "weatherIcon",
                modifier = Modifier.size(AppTheme.dimens.large)
            )
        }
    }
}