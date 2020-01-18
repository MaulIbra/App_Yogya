package com.example.yogyakarta_app.Features.News.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.yogyakarta_app.Data.Response.NewsResponse;
import com.example.yogyakarta_app.Features.News.Model.NewsRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsViewModel extends AndroidViewModel {

    private NewsRepository newsRepository;
    private LiveData<NewsResponse> newsResponseLiveData;


    public NewsViewModel(@NonNull Application application) {
        super(application);
        newsRepository = new NewsRepository();
        this.newsRepository.getNews("yogyakarta","2019-12-12",currentDate(),"popularity");
    }

    public String currentDate(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dateobj = new Date();
        return String.valueOf(dateobj);
    }


    public LiveData<NewsResponse> getNewsResponseLiveData(){
        return newsResponseLiveData;
    }
}
