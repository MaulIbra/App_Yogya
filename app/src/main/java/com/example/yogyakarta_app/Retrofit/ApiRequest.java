package com.example.yogyakarta_app.Retrofit;

import com.example.yogyakarta_app.Data.Response.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("everything")
    Call<NewsResponse> getNews(
            @Query("q") String region,
            @Query("from") String startDate,
            @Query("to") String endDate,
            @Query("sortBy") String sort,
            @Query("apiKey") String key);

}
