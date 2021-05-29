package com.junhwa.data.repository

import com.junhwa.domain.data_source.RemoteDataSource
import com.junhwa.domain.repository.WeatherRepository
import com.junhwa.domain.model.LocationWeather
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class WeatherRepoImpl(private val remoteDataSource: RemoteDataSource): WeatherRepository {
    override fun loadWeatherData(): Single<List<LocationWeather>> {
        return remoteDataSource.loadLocation("se")
            .map { list ->
                list.map {
                    remoteDataSource.loadLocationWeather(it.woeid).blockingGet()
                }
            }
    }
}