package com.example.weather4.di;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import com.example.weather4.viewmodel.ForecastViewModel;
import com.example.weather4.viewmodel.WeatherViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ForecastViewModel.class)
    abstract ViewModel bindForecastViewModel(ForecastViewModel forecastViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(WeatherViewModelFactory factory);
}
