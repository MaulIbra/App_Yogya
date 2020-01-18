package com.example.yogyakarta_app.Features.Article.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.yogyakarta_app.Features.Article.Model.Article;
import com.example.yogyakarta_app.Features.Article.ViewModel.ArticleViewModel;
import com.example.yogyakarta_app.R;

import java.util.List;

public class ArticleView extends AppCompatActivity {

    private ArticleViewModel articleViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);
        articleViewModel.getAllArticle().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(@Nullable List<Article> articles) {
                Toast.makeText(ArticleView.this,"on changed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
