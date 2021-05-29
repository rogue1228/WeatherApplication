package com.junhwa.data.remote

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.time.LocalDate
import java.time.format.DateTimeFormatter

abstract class BaseApiManger(private val interceptors: List<Interceptor>) {

    open fun okHttpClientBuilder(): OkHttpClient.Builder {
        val httpClientBuilder = OkHttpClient.Builder()

        interceptors.forEach {
            httpClientBuilder.addInterceptor(it)
        }

        return httpClientBuilder
    }

    fun <T> create(baseUrl: String, service: Class<T>): T {
        val client = okHttpClientBuilder().build()

        val gson = GsonBuilder()
            .registerTypeAdapter(LocalDate::class.java, object : JsonDeserializer<LocalDate> {
                override fun deserialize(
                    json: JsonElement?,
                    typeOfT: Type?,
                    context: JsonDeserializationContext?
                ): LocalDate = LocalDate.parse(json?.asString, DateTimeFormatter.ISO_DATE)
            })
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create(service)
    }
}