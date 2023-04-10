package com.example.weather4.db;

import androidx.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.weather4.model.SavedDailyForecast;
import com.example.weather4.model.UviDb;

import java.util.List;

@Dao
public interface ForecastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertForecastList(List<SavedDailyForecast> savedDailyForecasts);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUvi(UviDb uviDb);

    @Query("SELECT * FROM saveddailyforecast ORDER BY mdate ASC")
    LiveData<List<SavedDailyForecast>> loadForecast();

    @Query("SELECT * FROM uvidb ")
    LiveData<UviDb> loadUvi();

    @Query("DELETE FROM saveddailyforecast")
    void deleteNewsTable();

    @Query("DELETE FROM uvidb")
    void deleteUvi();
}
