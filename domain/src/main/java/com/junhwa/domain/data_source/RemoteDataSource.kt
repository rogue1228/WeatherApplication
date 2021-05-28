package com.junhwa.domain.data_source

import com.junhwa.domain.model.Location
import com.junhwa.domain.model.LocationWeather
import io.reactivex.rxjava3.core.Single

interface RemoteDataSource {
    fun loadLocation(keyword: String): Single<List<Location>>
    fun loadLocationWeather(woeid: Int): Single<LocationWeather>
}