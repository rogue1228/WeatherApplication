package com.junhwa.weatherapplication.application

import android.app.Application
import com.junhwa.weatherapplication.BuildConfig
import com.junhwa.weatherapplication.application.di.dataSourceModule
import com.junhwa.weatherapplication.application.di.repositoryModule
import com.junhwa.weatherapplication.application.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatheApplicion: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            properties(mapOf("base_url" to BuildConfig.BASE_API_URL))

            androidContext(this@WeatheApplicion)
            modules(dataSourceModule, repositoryModule, viewModelModule)
        }
    }
}