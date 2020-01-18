package com.example.yogyakarta_app.Data.Db.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.w3c.dom.Text;

@Entity(tableName = "article_table")
public class Article {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String author;

    private String title;

    private String content;

    public Article(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
