package com.example.yogyakarta_app.Features.Article.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ArticleDao {

    void insert(Article article);

    void update(Article article);

    void delete(Article article);

    @Query("DELETE FROM article_table")
    void deleteAllArticles();

    @Query("SELECT * FROM article_table ORDER BY id DESC")
    LiveData<List<Article>> getAllArticles();

}
