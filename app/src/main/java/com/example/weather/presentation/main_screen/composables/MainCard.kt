package com.example.weather.presentation.main_screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.example.weather.presentation.common_composables.CustomCard
import com.example.weather.ui.theme.AppTheme
import com.example.weather.ui.theme.Orientation
import com.example.weather.util.getDate
import com.example.weather.util.getTime

@Composable
fun MainCard(
    cityName: String,
    iconPath: Int,
    temperature: String,
    modifier: Modifier = Modifier,
    imageSize: Dp,
    orientation: Orientation
) {
    CustomCard(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(AppTheme.dimens.medium),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(bottom = AppTheme.dimens.smallMedium),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = cityName,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h3
                )
                Spacer(modifier = Modifier.width(AppTheme.dimens.smallMedium))
                Text(
                    text = getTime(),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h3
                )
            }
            Row(
                modifier = Modifier
                    .padding(bottom = AppTheme.dimens.medium)
            ) {
                Text(
                    text = getDate(),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h2
                )
            }
            when (orientation) {
                Orientation.Portrait -> {
                    Image(
                        painter = painterResource(id = iconPath),
                        contentDescription = "weatherIcon",
                        modifier = Modifier.size(imageSize)
                    )
                    Text(
                        text = temperature,
                        style = MaterialTheme.typography.h1
                    )
                }
                Orientation.Landscape -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(AppTheme.dimens.mediumLarge)
                    ) {
                        Image(
                            painter = painterResource(id = iconPath),
                            contentDescription = "weatherIcon",
                            modifier = Modifier.size(imageSize)
                        )
                        Text(
                            text = temperature,
                            style = MaterialTheme.typography.h1
                        )
                    }
                }
            }

        }
    }
}