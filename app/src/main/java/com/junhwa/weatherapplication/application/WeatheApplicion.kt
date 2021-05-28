package com.junhwa.weatherapplication.application

import android.app.Application
import com.junhwa.weatherapplication.application.di.dataSourceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatheApplicion: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WeatheApplicion)
            modules(dataSourceModule)
        }
    }
}