package com.example.weather.presentation.common_composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.weather.R
import com.example.weather.ui.theme.AppTheme

@Composable
fun SplashScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.weather_icon),
                contentDescription = "app_icon",
                modifier = Modifier
                    .size(AppTheme.dimens.humongous)
                    .padding(bottom = AppTheme.dimens.mediumLarge)
            )
            CircularProgressIndicator(
                modifier = Modifier.size(AppTheme.dimens.big),
                color = MaterialTheme.colors.primary,
                strokeWidth = AppTheme.dimens.smallMedium
            )
        }
    }
}