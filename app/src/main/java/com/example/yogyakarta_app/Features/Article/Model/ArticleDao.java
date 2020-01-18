package com.example.yogyakarta_app.Features.Article.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.yogyakarta_app.Data.Db.Entity.Article;

import java.util.List;

@Dao
public interface ArticleDao {

    @Insert
    void insert(Article article);

    @Update
    void update(Article article);

    @Delete
    void delete(Article article);

    @Query("DELETE FROM article_table")
    void deleteAllArticles();

    @Query("SELECT * FROM article_table ORDER BY id DESC")
    LiveData<List<Article>> getAllArticles();

}
