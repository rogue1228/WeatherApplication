package com.junhwa.data

import com.junhwa.data.remote.RemoteDataSourceImpl
import com.junhwa.data.repository.WeatherRepoImpl
import com.junhwa.domain.data_source.RemoteDataSource
import com.junhwa.domain.repository.WeatherRepository
import org.junit.Test

class RepositoryTest {
    private val remoteDataSource: RemoteDataSource = RemoteDataSourceImpl("https://www.metaweather.com/api/")

    private val weatherRepo: WeatherRepository = WeatherRepoImpl(remoteDataSource)

    @Test
    fun repositoryTest() {
        println("=== test start ===")
        weatherRepo.loadWeatherData()
            .blockingForEach {
                println("Current City ${it.title}")
                println("Today Weather is ${it.todayWeather()}")
                println("Tomorrow Weather is ${it.tomorrowWeather()}")
                println("------")
            }
        println("=== test end ===")
    }
}