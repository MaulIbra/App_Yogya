package com.example.yogyakarta_app.Features.Article.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.yogyakarta_app.Features.Article.Model.Article;
import com.example.yogyakarta_app.Features.Article.Model.ArticleRepository;

import java.util.List;

public class ArticleViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;

    private LiveData<List<Article>> allArticle;

    public ArticleViewModel(@NonNull Application application) {
        super(application);
        articleRepository = new ArticleRepository(application);
        allArticle = articleRepository.getAllArticles();
    }

    public void insert(Article article){
        articleRepository.insert(article);
    }

    public void update(Article article){
        articleRepository.update(article);
    }

    public void delete(Article article){
        articleRepository.delete(article);
    }

    public void deleteAllArticles(){
        articleRepository.deleteAllArticles();
    }

    public LiveData<List<Article>> getAllArticle(){
        return allArticle;
    }
}
