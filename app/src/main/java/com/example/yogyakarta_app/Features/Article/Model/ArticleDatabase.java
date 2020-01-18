package com.example.yogyakarta_app.Features.Article.Model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Article.class}, version = 1)
public abstract class ArticleDatabase extends RoomDatabase {

    private static ArticleDatabase instance;

    public abstract ArticleDao articleDao();

    public static synchronized ArticleDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ArticleDatabase.class, "article_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();

        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback =new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{

        private ArticleDao articleDao;

        public PopulateDbAsyncTask(ArticleDatabase db) {
            this.articleDao = db.articleDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            articleDao.insert(new Article("Maulana 1","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 2","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 3","Lagi Cari Kerja","Bimbang buat resign"));
            return null;
        }
    }
}
