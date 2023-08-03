package com.example.weather.util

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

inline fun <reified T> toJson(obj: T): String {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val jsonAdapter = moshi.adapter(T::class.java).lenient()
    return jsonAdapter.toJson(obj)
}

inline fun <reified T> fromJson(str: String?): T? {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val jsonAdapter = moshi.adapter(T::class.java).lenient()
    return str?.let { jsonAdapter.fromJson(it) }
}