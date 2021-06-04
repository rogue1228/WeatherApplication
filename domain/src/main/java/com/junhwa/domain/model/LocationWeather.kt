package com.junhwa.domain.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class LocationWeather(
    @SerializedName("consolidated_weather")
    val weatherList: List<Weather>,
    @SerializedName("title")
    val title: String,
    @SerializedName("woeid")
    val woeid: Int
) {
    fun todayWeather(): Weather? {
        return weatherList.find { it.date == LocalDate.now() }
    }

    fun tomorrowWeather(): Weather? {
        return weatherList.find { it.date == LocalDate.now().plusDays(1) }
    }
}