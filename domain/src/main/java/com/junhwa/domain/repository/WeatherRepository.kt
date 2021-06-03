package com.junhwa.domain.repository

import com.junhwa.domain.model.LocationWeather
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface WeatherRepository {
    fun loadWeatherData(keyword: String): Observable<LocationWeather>
}