package com.example.weather.util

import java.util.*

fun getDate(): String {
    val calendar = Calendar.getInstance()
    val month = calendar.get(Calendar.MONTH) + 1
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val weekDayName = when (calendar.get(Calendar.DAY_OF_WEEK)) {
        1 -> "Вс"
        2 -> "Пн"
        3 -> "Вт"
        4 -> "Ср"
        5 -> "Чт"
        6 -> "Пт"
        7 -> "Сб"
        else -> ""
    }
    val monthName = when (month) {
        1 -> "января"
        2 -> "февраля"
        3 -> "марта"
        4 -> "апреля"
        5 -> "мая"
        6 -> "июня"
        7 -> "июля"
        8 -> "августа"
        9 -> "сентября"
        10 -> "октября"
        11 -> "ноября"
        12 -> "декабря"
        else -> "неизвестный месяц"
    }
    return "$weekDayName, $day $monthName"
}

fun getTime(): String {
    val calendar = Calendar.getInstance()
    val hour = (calendar.get(Calendar.HOUR_OF_DAY) + 3) % 24
    val minute = calendar.get(Calendar.MINUTE)
    return String.format("%1d:%02d", hour, minute)
}