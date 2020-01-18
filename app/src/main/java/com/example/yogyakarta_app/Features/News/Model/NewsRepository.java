package com.example.yogyakarta_app.Features.News.Model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.yogyakarta_app.Data.Response.NewsResponse;
import com.example.yogyakarta_app.Retrofit.ApiRequest;
import com.example.yogyakarta_app.Retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsRepository {

    private static final String TAG = NewsRepository.class.getSimpleName();
    private static final String BASE_URL = "https://newsapi.org/v2/";
    private static final String KEY = "b45ce1e14aed45e696631791f757ae8b";
    private ApiRequest apiRequest;

    public NewsRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance(BASE_URL).create(ApiRequest.class);
    }

    public LiveData<NewsResponse> getNews(String region, String startDate, String endDate, String sortBy) {
        final MutableLiveData<NewsResponse> data = new MutableLiveData<>();
        apiRequest.getNews(region,startDate,endDate,sortBy, KEY)
                .enqueue(new Callback<NewsResponse>() {

                    @Override
                    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                        Log.d(TAG, "onResponse response: " + response);
                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }
                    @Override
                    public void onFailure(Call<NewsResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
