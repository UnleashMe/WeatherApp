package com.example.weather.presentation.common_composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.weather.ui.theme.AppTheme

@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = AppTheme.dimens.medium,
    backgroundColor: Color = MaterialTheme.colors.primary,
    borderWidth: Dp = AppTheme.dimens.tiny,
    borderColor: Color = MaterialTheme.colors.secondary,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(cornerRadius),
        backgroundColor = backgroundColor,
        border = BorderStroke(borderWidth, borderColor)
    ) {
        content()
    }
}