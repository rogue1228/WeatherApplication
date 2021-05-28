package com.junhwa.domain.model

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("title")
    val title: String,
    @SerializedName("woeid")
    val woeid: Int
)
