package com.example.weather.presentation.main_screen.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weather.ui.theme.AppTheme

@Composable
fun MainScreenButtons(
    onDetailsClick: () -> Unit,
    onForecastClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(AppTheme.dimens.medium),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {
                onDetailsClick()
            },
            shape = RoundedCornerShape(AppTheme.dimens.medium),
            modifier = Modifier
                .weight(1f),
            border = BorderStroke(AppTheme.dimens.tiny, MaterialTheme.colors.secondary),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
        ) {
            Text(text = "Details", style = MaterialTheme.typography.body2)
        }
        Spacer(modifier = Modifier.weight(0.2f))
        Button(
            onClick = { onForecastClick() },
            modifier = Modifier
                .weight(1f),
            border = BorderStroke(AppTheme.dimens.tiny, MaterialTheme.colors.secondary),
            shape = RoundedCornerShape(AppTheme.dimens.medium),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
        ) {
            Text(text = "Forecast", style = MaterialTheme.typography.body2)
        }
    }
}