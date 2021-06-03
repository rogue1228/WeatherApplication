package com.junhwa.weatherapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.junhwa.domain.model.LocationWeather
import com.junhwa.domain.repository.WeatherRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable

class MainViewModel(private val weatherRepo: WeatherRepository) : ViewModel() {
    private val _weatherData: MutableLiveData<LocationWeather> = MutableLiveData()
    val weatherData: LiveData<LocationWeather> = _weatherData

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _isLoading

    private var weatherDisposable: Disposable? = null

    fun loadData() {
        _isLoading.value = true
        weatherDisposable = weatherRepo.loadWeatherData("se")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                _isLoading.postValue(false)
                _weatherData.postValue(it)
            }
    }

    override fun onCleared() {
        super.onCleared()
        weatherDisposable?.dispose()
    }
}