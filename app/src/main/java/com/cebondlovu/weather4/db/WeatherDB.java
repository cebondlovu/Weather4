package com.cebondlovu.weather4.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cebondlovu.weather4.model.SavedDailyForecast;
import com.cebondlovu.weather4.model.UviDb;


@Database(entities = {SavedDailyForecast.class, UviDb.class},
        version = 1,
        exportSchema = false)

public abstract class WeatherDB extends RoomDatabase {
    abstract public ForecastDao forecastDao();
}
