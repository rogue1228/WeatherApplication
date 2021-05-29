package com.junhwa.data.remote

import com.junhwa.domain.data_source.RemoteDataSource
import com.junhwa.domain.model.Location
import com.junhwa.domain.model.LocationWeather
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.Interceptor

class RemoteDataSourceImpl(baseUrl: String, interceptors: List<Interceptor>): BaseApiManger(interceptors), RemoteDataSource {
    private val service: WeatherApiService = create(baseUrl, WeatherApiService::class.java)

    override fun loadLocation(keyword: String): Single<List<Location>> {
        return service.searchLocation(keyword)
            .subscribeOn(Schedulers.io())
    }

    override fun loadLocationWeather(woeid: Int): Single<LocationWeather> {
        return service.getLocalWeather(woeid)
            .subscribeOn(Schedulers.io())
    }

}