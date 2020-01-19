package com.example.yogyakarta_app.Features.Tour.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.yogyakarta_app.Data.Db.Entity.Tour;
import com.example.yogyakarta_app.Features.Tour.Model.TourRepository;

import java.util.List;

public class TourViewModel extends AndroidViewModel {

    private TourRepository tourRepository;

    private LiveData<List<Tour>> allTours;

    public TourViewModel(@NonNull Application application) {
        super(application);
        tourRepository = new TourRepository(application);
        allTours = tourRepository.getAllTours();
    }

    public LiveData<List<Tour>> getAllTours(){
        return allTours;
    }
}
