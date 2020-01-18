package com.example.yogyakarta_app.Data.Response;

import com.example.yogyakarta_app.Data.Db.Entity.News;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponse {

    @SerializedName("articles")
    @Expose
    private List<News> news = null;

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
