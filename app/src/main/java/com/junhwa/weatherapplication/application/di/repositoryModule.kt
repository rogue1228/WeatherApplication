package com.junhwa.weatherapplication.application.di

import com.junhwa.data.repository.WeatherRepoImpl
import com.junhwa.domain.repository.WeatherRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<WeatherRepository> {
        WeatherRepoImpl(get())
    }
}