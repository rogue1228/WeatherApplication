package com.junhwa.weatherapplication.application.di

import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.junhwa.data.remote.RemoteDataSourceImpl
import com.junhwa.domain.data_source.RemoteDataSource
import com.junhwa.weatherapplication.BuildConfig
import org.koin.dsl.module

val dataSourceModule = module {
    single {
        ChuckerCollector(
            context = get(),
            showNotification = BuildConfig.DEBUG,
            retentionPeriod = RetentionManager.Period.ONE_DAY
        )
    }

    single<RemoteDataSource> {
        RemoteDataSourceImpl(
            BuildConfig.BASE_API_URL,
            listOf(
                ChuckerInterceptor.Builder(get())
                    .maxContentLength(250_000L)
                    .collector(get())
                    .build()
            )
        )
    }
}