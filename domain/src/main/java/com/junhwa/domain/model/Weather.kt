package com.junhwa.domain.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class Weather(
    @SerializedName("weather_state_name")
    val weatherState: String,
    @SerializedName("weather_state_abbr")
    private val iconImage: String,
    @SerializedName("the_temp")
    val temp: Float,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("applicable_date")
    val date: LocalDate
) {
    fun iconImageURL() : String {
        return "static/img/weather/png/$iconImage.png"
    }
}