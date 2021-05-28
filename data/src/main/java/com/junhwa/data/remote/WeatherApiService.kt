package com.junhwa.data.remote

import com.junhwa.domain.model.Location
import com.junhwa.domain.model.LocationWeather
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApiService {

    @GET("location/search")
    fun searchLocation(@Query("query") keyword: String): Single<List<Location>>

    @GET("location/{woeid}")
    fun getLocalWeather(@Path("woeid") woeid: Int): Single<LocationWeather>
}