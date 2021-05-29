package com.junhwa.weatherapplication.ui

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.junhwa.domain.model.LocationWeather
import com.junhwa.weatherapplication.BuildConfig
import com.junhwa.weatherapplication.ui.main.WeatherAdapter

@BindingAdapter("app:load_image")
fun loadImage(imageView: ImageView, imageUrl: String?) {
    val url = Uri.parse(BuildConfig.BASE_API_URL).buildUpon()
        .appendEncodedPath(imageUrl)
        .build()

    Glide.with(imageView)
        .load(url)
        .into(imageView)
}