package com.junhwa.weatherapplication.ui

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.junhwa.domain.model.LocationWeather
import com.junhwa.weatherapplication.BuildConfig
import com.junhwa.weatherapplication.ui.main.WeatherAdapter

@BindingAdapter("add_item")
fun addItem(recyclerView: RecyclerView, locWeather: LocationWeather?) {
    locWeather?.let {
        (recyclerView.adapter as? WeatherAdapter)?.addItem(it)
    }
}

@BindingAdapter("item_clear")
fun clearItem(recyclerView: RecyclerView, refreshing: Boolean?) {
    if (refreshing == true) {
        (recyclerView.adapter as? WeatherAdapter)?.clear()
    }
}

@BindingAdapter("load_image")
fun loadImage(imageView: ImageView, imageUrl: String?) {
    val url = Uri.Builder()
        .authority(BuildConfig.BASE_API_URL)
        .appendPath(imageUrl)
        .build()

    Glide.with(imageView)
        .load(url)
        .into(imageView)
}