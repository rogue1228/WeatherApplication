package com.junhwa.weatherapplication.application.di

import com.junhwa.data.remote.RemoteDataSourceImpl
import com.junhwa.domain.data_source.RemoteDataSource
import com.junhwa.weatherapplication.BuildConfig
import org.koin.dsl.module

val dataSourceModule = module {
    single<RemoteDataSource> {
        RemoteDataSourceImpl(BuildConfig.BASE_API_URL)
    }
}