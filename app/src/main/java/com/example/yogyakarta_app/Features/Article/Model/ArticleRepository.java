package com.example.yogyakarta_app.Features.Article.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.yogyakarta_app.Data.Db.LocalDatabase;
import com.example.yogyakarta_app.Data.Db.Entity.Article;

import java.util.List;

public class ArticleRepository {

    private ArticleDao articleDao;

    private LiveData<List<Article>> allArticles;

    public ArticleRepository(Application application){
        LocalDatabase database = LocalDatabase.getInstance(application);
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
        new deleteArticleAsyncTask(articleDao).execute(article);

    }

    public void deleteAllArticles(){
        new deleteAllArticleAsyncTask(articleDao).execute();
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

    private static class deleteArticleAsyncTask extends AsyncTask<Article, Void, Void>{

        private ArticleDao articleDao;

        public deleteArticleAsyncTask(ArticleDao articleDao) {
            this.articleDao = articleDao;
        }

        @Override
        protected Void doInBackground(Article... articles) {
            articleDao.delete(articles[0]);
            return null;
        }
    }

    private static class deleteAllArticleAsyncTask extends AsyncTask<Void, Void, Void>{

        private ArticleDao articleDao;

        public deleteAllArticleAsyncTask(ArticleDao articleDao) {
            this.articleDao = articleDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            articleDao.deleteAllArticles();
            return null;
        }
    }
}
