package com.junhwa.data.repository

import com.junhwa.domain.data_source.RemoteDataSource
import com.junhwa.domain.repository.WeatherRepository
import com.junhwa.domain.model.LocationWeather
import io.reactivex.rxjava3.core.Observable

class WeatherRepoImpl(private val remoteDataSource: RemoteDataSource): WeatherRepository {
    override fun loadWeatherData(): Observable<LocationWeather> {
        return remoteDataSource.loadLocation("se")
            .flatMapObservable {
                Observable.fromIterable(it)
            }
            .flatMapSingle {
                remoteDataSource.loadLocationWeather(it.woeid)
            }
    }
}