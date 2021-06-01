package com.junhwa.weatherapplication.ui

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.junhwa.domain.model.LocationWeather
import com.junhwa.weatherapplication.BuildConfig
import com.junhwa.weatherapplication.ui.main.WeatherAdapter

@BindingAdapter("bind:add_item")
fun addItem(recyclerView: RecyclerView, locWeather: List<LocationWeather>?) {
    locWeather?.let {
        (recyclerView.adapter as? WeatherAdapter)?.addItems(it)
    }
}

@BindingAdapter("bind:item_clear")
fun itemClear(recyclerView: RecyclerView, refreshing: Boolean?) {
    if (refreshing == true) {
        (recyclerView.adapter as? WeatherAdapter)?.clear()
    }
}

@BindingAdapter("app:load_image")
fun loadImage(imageView: ImageView, imageUrl: String?) {
    val url = Uri.parse(BuildConfig.BASE_API_URL).buildUpon()
        .appendEncodedPath(imageUrl)
        .build()

    Glide.with(imageView)
        .load(url)
        .into(imageView)
}