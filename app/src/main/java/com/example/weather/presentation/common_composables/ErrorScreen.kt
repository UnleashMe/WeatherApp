package com.example.weather.presentation.common_composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.weather.ui.theme.AppTheme

@Composable
fun ErrorScreen(
    errorMessage: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Ой, что-то пошло не так!",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(bottom = AppTheme.dimens.medium)
            )
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(bottom = AppTheme.dimens.medium)
            )
            Button(
                onClick = { onClick() },
                shape = RoundedCornerShape(AppTheme.dimens.medium),
                border = BorderStroke(AppTheme.dimens.tiny, MaterialTheme.colors.secondary),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
            ) {
                Text(text = "Попробовать снова", style = MaterialTheme.typography.h5)
            }
        }
    }
}