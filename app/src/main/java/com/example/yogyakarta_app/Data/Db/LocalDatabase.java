package com.example.yogyakarta_app.Data.Db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.yogyakarta_app.Data.Db.Entity.Article;
import com.example.yogyakarta_app.Data.Db.Entity.Tour;
import com.example.yogyakarta_app.Features.Article.Model.ArticleDao;
import com.example.yogyakarta_app.Features.Tour.Model.TourDao;

@Database(entities = {Article.class}, version = 1)
public abstract class LocalDatabase extends RoomDatabase {

    private static LocalDatabase instance;

    public abstract ArticleDao articleDao();

    public abstract TourDao tourDao();

    public static synchronized LocalDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    LocalDatabase.class, "app_db")
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
        private TourDao tourDao;

        public PopulateDbAsyncTask(LocalDatabase db) {
            articleDao = db.articleDao();
            tourDao = db.tourDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            articleDao.insert(new Article("Maulana 1","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 2","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 3","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 1","Lagi Cari Kerja","Bimbang buat resign"));
            articleDao.insert(new Article("Maulana 2","Lagi Cari Kerja","Bimbang buat resign"));
            tourDao.insert(new Tour("Candi Prambanan","Jl. Raya Solo - Yogyakarta No.16, Kranggan, Bokoharjo, Kec. Prambanan, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55571","http://bob.kemenpar.go.id/wp-content/uploads/2019/10/candi-prambanan-1.jpg",-7.7520206,110.4892787));
            return null;
        }
    }
}
