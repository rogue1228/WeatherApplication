package com.junhwa.weatherapplication.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.junhwa.domain.model.LocationWeather
import com.junhwa.weatherapplication.databinding.ItemWeatherBinding

class WeatherVIewHolder(private val binding: ItemWeatherBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(locWeather: LocationWeather) {
        binding.locWeather = locWeather
    }
}