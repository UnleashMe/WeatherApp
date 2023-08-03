package com.example.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.weather.presentation.common_composables.SplashScreen
import com.example.weather.presentation.navigation.Navigation
import com.example.weather.ui.theme.AppTheme
import com.example.weather.ui.theme.WeatherTheme
import com.example.weather.ui.theme.rememberWindowSizeClass
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val window = rememberWindowSizeClass()
            WeatherTheme(window) {
                var splash by rememberSaveable {
                    mutableStateOf(true)
                }
                LaunchedEffect(key1 = Unit) {
                    delay(1000)
                    splash = false
                }
                if (splash) {
                    SplashScreen()
                } else {
                    Navigation(AppTheme.orientation)
                }
            }
        }
    }
}