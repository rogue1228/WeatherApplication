package com.junhwa.domain.repository

import com.junhwa.domain.model.LocationWeather
import io.reactivex.rxjava3.core.Observable

interface WeatherRepository {
    fun loadWeatherData(): Observable<LocationWeather>
}