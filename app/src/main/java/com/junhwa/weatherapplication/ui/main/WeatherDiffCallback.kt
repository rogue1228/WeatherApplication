package com.junhwa.weatherapplication.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.junhwa.domain.model.LocationWeather

fun weatherDiffCallback(
    oldWeatherList: List<LocationWeather>,
    newWeatherList: List<LocationWeather>
) = object: DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldWeatherList.size
    }

    override fun getNewListSize(): Int {
        return newWeatherList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldWeatherList[oldItemPosition].woeid == newWeatherList[newItemPosition].woeid
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldWeatherList[oldItemPosition].hashCode() == newWeatherList[newItemPosition].hashCode()
    }
}