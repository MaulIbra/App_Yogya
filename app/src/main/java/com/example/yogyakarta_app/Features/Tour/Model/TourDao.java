package com.example.yogyakarta_app.Features.Tour.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.yogyakarta_app.Data.Db.Entity.Tour;

import java.util.List;

@Dao
public interface TourDao {

    @Insert
    void insert(Tour tour);

    @Update
    void update(Tour tour);

    @Delete
    void delete(Tour tour);

    @Query("DELETE FROM tour_table")
    void deleteAllTour();

    @Query("SELECT * FROM tour_table ORDER BY id DESC")
    LiveData<List<Tour>> getAllTour();
}
