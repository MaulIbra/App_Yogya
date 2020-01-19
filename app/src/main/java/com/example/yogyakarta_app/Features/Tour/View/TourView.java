package com.example.yogyakarta_app.Features.Tour.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yogyakarta_app.Data.Db.Entity.Tour;
import com.example.yogyakarta_app.Features.News.View.NewsAdapter;
import com.example.yogyakarta_app.Features.News.ViewModel.NewsViewModel;
import com.example.yogyakarta_app.Features.Tour.ViewModel.TourViewModel;
import com.example.yogyakarta_app.R;

import java.util.ArrayList;
import java.util.List;

public class TourView extends AppCompatActivity {

    private TourViewModel tourViewModel;
    private List<Tour> tourList = new ArrayList<>();
    private TourAdapter tourAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour_list_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerView_tour);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        tourAdapter = new TourAdapter(this,tourList);
        recyclerView.setAdapter(tourAdapter);

        tourViewModel = ViewModelProviders.of(this).get(TourViewModel.class);

        getTour();
    }


    private void getTour(){
        tourViewModel.getAllTours().observe(this, new Observer<List<Tour>>() {
            @Override
            public void onChanged(@Nullable List<Tour> tours) {
                tourAdapter.setTour(tours);
            }
        });
    }
}
