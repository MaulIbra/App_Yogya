package com.example.yogyakarta_app.Data.Db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.yogyakarta_app.Data.Db.Entity.Article;
import com.example.yogyakarta_app.Features.Article.Model.ArticleDao;

@Database(entities = {Article.class}, version = 1)
public abstract class LocalDatabase extends RoomDatabase {

    private static LocalDatabase instance;

    public abstract ArticleDao articleDao();

    public static synchronized LocalDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    LocalDatabase.class, "article_database")
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
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{

        private ArticleDao articleDao;

        public PopulateDbAsyncTask(LocalDatabase db) {
            articleDao = db.articleDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            articleDao.insert(new Article("Maulana 1","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 2","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 3","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 1","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 2","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 3","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 1","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 2","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 3","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 1","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 2","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 3","Lagi Cari Kerja","Bimbang buat resign"));
            return null;
        }
    }
}
