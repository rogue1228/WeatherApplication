package com.junhwa.data.remote

import com.junhwa.domain.data_source.RemoteDataSource
import com.junhwa.domain.model.Location
import com.junhwa.domain.model.LocationWeather
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RemoteDataSourceImpl(baseUrl: String): BaseApiManger(), RemoteDataSource {
    private val service: WeatherApiService = create(baseUrl, WeatherApiService::class.java)

    override fun loadLocation(keyword: String): Single<List<Location>> {
        return service.searchLocation(keyword)
            .observeOn(Schedulers.io())
    }

    override fun loadLocationWeather(woeid: Int): Single<LocationWeather> {
        return service.getLocalWeather(woeid)
            .observeOn(Schedulers.io())
    }

}