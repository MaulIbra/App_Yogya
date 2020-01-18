package com.example.yogyakarta_app.Features.News.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.yogyakarta_app.Data.Db.Entity.News;
import com.example.yogyakarta_app.Data.Response.NewsResponse;
import com.example.yogyakarta_app.Features.News.ViewModel.NewsViewModel;
import com.example.yogyakarta_app.R;

import java.util.ArrayList;
import java.util.List;

public class NewsView extends AppCompatActivity {

    private NewsViewModel newsViewModel;
    private List<News> news = new ArrayList<>();
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_list_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerView_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        newsAdapter = new NewsAdapter(this,news);
        recyclerView.setAdapter(newsAdapter);

        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);

        getNews();

    }

    private void getNews(){
        newsViewModel.getNewsResponseLiveData().observe(this, new Observer<NewsResponse>() {
            @Override
            public void onChanged(@Nullable NewsResponse newsResponse) {
                if (newsResponse != null) {
                    List<News> n = newsResponse.getNews();
                    news.addAll(n);
                    newsAdapter.notifyDataSetChanged();
                }
            }
        });
    }

}
