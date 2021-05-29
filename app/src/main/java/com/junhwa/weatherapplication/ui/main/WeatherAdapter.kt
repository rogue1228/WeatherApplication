package com.junhwa.weatherapplication.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.junhwa.domain.model.LocationWeather
import com.junhwa.weatherapplication.R
import com.junhwa.weatherapplication.databinding.ItemWeatherBinding

class WeatherAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val typeHeader = 0
    private val typeItem = 1

    private val list: MutableList<LocationWeather> = mutableListOf()

    fun addItems(locWeatherList: List<LocationWeather>) {
        list.addAll(locWeatherList)
        notifyDataSetChanged()
    }

    fun clear() {
        list.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (typeHeader == viewType) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
            HeaderViewHolder(view)
        } else {
            val binding: ItemWeatherBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_weather,
                parent,
                false
            )
            WeatherVIewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is WeatherVIewHolder) {
            holder.bind(list[position - 1])
        }
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            typeHeader
        } else {
            typeItem
        }
    }

}