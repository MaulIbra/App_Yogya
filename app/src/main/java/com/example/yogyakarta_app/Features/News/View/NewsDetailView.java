package com.example.yogyakarta_app.Features.News.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yogyakarta_app.R;

public class NewsDetailView extends AppCompatActivity {

    private TextView titleDetailNews;
    private TextView publishedDetailNews;
    private TextView contentDetailNews;
    private ImageView imageDetailNews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_view);

        titleDetailNews = findViewById(R.id.text_view_news_detail_title);
        publishedDetailNews = findViewById(R.id.text_view_news_detail_published);
        imageDetailNews = findViewById(R.id.image_view_news_detail_image);
        contentDetailNews = findViewById(R.id.text_view_news_detail_content);

        Intent i = getIntent();

        String image = i.getStringExtra("image");
        System.out.println(image);
        Glide.with(NewsDetailView.this)
                .load(image)
                .apply(new RequestOptions().centerCrop())
                .into(imageDetailNews);

        publishedDetailNews.setText(i.getStringExtra("publishedAt"));
        titleDetailNews.setText(i.getStringExtra("title"));
        contentDetailNews.setText(i.getStringExtra("content"));
    }
}
