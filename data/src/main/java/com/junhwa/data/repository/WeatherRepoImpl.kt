package com.junhwa.data.repository

import com.junhwa.domain.data_source.RemoteDataSource
import com.junhwa.domain.repository.WeatherRepository
import com.junhwa.domain.model.LocationWeather
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class WeatherRepoImpl(private val remoteDataSource: RemoteDataSource): WeatherRepository {
    override fun loadWeatherData(keyword: String): Observable<LocationWeather> {
        return remoteDataSource.loadLocation(keyword)
            .flatMapObservable {
                Observable.fromIterable(it)
            }
            .flatMapSingle {
                remoteDataSource.loadLocationWeather(it.woeid)
            }
    }
}