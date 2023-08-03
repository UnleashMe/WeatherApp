package com.example.weather.presentation.five_days_screen.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weather.presentation.common_composables.CustomCard
import com.example.weather.ui.theme.AppTheme

@Composable
fun DateHeader(
    date: String
) {
    CustomCard(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = Modifier.fillMaxWidth(0.95f)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.dimens.smallMedium)
        ) {
            Text(text = date, style = MaterialTheme.typography.h5)
        }
    }
}