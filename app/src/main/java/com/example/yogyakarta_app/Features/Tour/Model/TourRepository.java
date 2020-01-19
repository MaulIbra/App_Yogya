package com.example.yogyakarta_app.Features.Tour.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.yogyakarta_app.Data.Db.Entity.Tour;
import com.example.yogyakarta_app.Data.Db.LocalDatabase;

import java.util.List;

public class TourRepository {

    private TourDao tourDao;

    private LiveData<List<Tour>> allTours;

    public TourRepository(Application application) {
        LocalDatabase database = LocalDatabase.getInstance(application);
        tourDao = database.tourDao();
        allTours = tourDao.getAllTour();
    }

    public LiveData<List<Tour>> getAllTours(){
        return allTours;
    }
}
