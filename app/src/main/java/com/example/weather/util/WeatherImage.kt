package com.example.weather.util

import com.example.weather.R

fun getWeatherImage(code: Int): Int {
    return when (code) {
        in 200 until 300 -> {
            R.drawable.storm
        }
        in 300 until 400 -> {
            R.drawable.drizzle
        }
        in 500 until 600 -> {
            R.drawable.rain
        }
        in 600 until 700 -> {
            R.drawable.snow
        }
        800 -> {
            R.drawable.clear
        }
        741 -> {
            R.drawable.fog
        }
        721 -> {
            R.drawable.haze
        }
        else -> R.drawable.clouds
    }
}