package com.junhwa.weatherapplication.ui.main

import androidx.lifecycle.LiveData
import com.junhwa.domain.model.LocationWeather

interface MainDataBinder {
    val weatherData: LiveData<LocationWeather>
    val isLoading: LiveData<Boolean>
    fun loadData()
}