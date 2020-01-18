package com.example.yogyakarta_app.Features.Article.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ArticleRepository {

    private ArticleDao articleDao;

    private LiveData<List<Article>> allArticles;

    public ArticleRepository(Application application){
        ArticleDatabase database =ArticleDatabase.getInstance(application);
        articleDao = database.articleDao();
        allArticles =articleDao.getAllArticles();
    }

    public void insert(Article article){
        new insertArticleAsyncTask(articleDao).execute(article);
    }

    public void update(Article article){
        new updateArticleAsyncTask(articleDao).execute(article);
    }

    public void delete(Article article){

    }

    public void deleteAllArticles(){

    }

    public LiveData<List<Article>> getAllArticles(){
        return allArticles;
    }

    private static class insertArticleAsyncTask extends AsyncTask<Article, Void, Void>{

        private ArticleDao articleDao;

        public insertArticleAsyncTask(ArticleDao articleDao) {
            this.articleDao = articleDao;
        }

        @Override
        protected Void doInBackground(Article... articles){
            articleDao.insert(articles[0]);
            return null;
        }
    }

    private static class updateArticleAsyncTask extends AsyncTask<Article, Void, Void>{

        private ArticleDao articleDao;

        public updateArticleAsyncTask(ArticleDao articleDao) {
            this.articleDao = articleDao;
        }

        @Override
        protected Void doInBackground(Article... articles) {
            articleDao.update(articles[0]);
            return null;
        }
    }
}
