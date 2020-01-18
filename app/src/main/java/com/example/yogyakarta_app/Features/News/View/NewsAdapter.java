package com.example.yogyakarta_app.Features.News.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yogyakarta_app.Data.Db.Entity.News;
import com.example.yogyakarta_app.R;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private List<News> news = new ArrayList<>();

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.news_item,viewGroup,false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, int i) {
        News Currentnews = news.get(i);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class NewsHolder extends RecyclerView.ViewHolder{
        private ImageView imageNews;
        private TextView titleNews;
        private TextView descriptionNews;
        private TextView publishedNews;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            imageNews = itemView.findViewById(R.id.image_view_news_image);
            titleNews = itemView.findViewById(R.id.text_view_news_title);
            descriptionNews = itemView.findViewById(R.id.text_view_news_description);
            publishedNews = itemView.findViewById(R.id.text_view_news_published);
        }
    }
}
