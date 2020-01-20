package com.example.yogyakarta_app.Features.Info.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.yogyakarta_app.Data.Db.Entity.Info;
import com.example.yogyakarta_app.Data.Db.Entity.Tour;
import com.example.yogyakarta_app.Data.Db.LocalDatabase;

import java.util.List;

public class InfoRepository {

    private InfoDao infoDao;

    private LiveData<List<Info>> infos;

    public InfoRepository(Application application) {
        LocalDatabase localDatabase = LocalDatabase.getInstance(application);
        infoDao = localDatabase.infoDao();
        infos = infoDao.getAllInfo();
    }

    public void insert(Info info){
        new insertInfoAsyncTask(infoDao).execute(info);
    }

    public LiveData<List<Info>> getAllInfo(){
        return infos;
    }

    private static class insertInfoAsyncTask extends AsyncTask<Info, Void, Void>{

        private InfoDao infoDao;

        public insertInfoAsyncTask(InfoDao infoDao) {
            this.infoDao = infoDao;
        }

        @Override
        protected Void doInBackground(Info... infos) {
            infoDao.insert(infos[0]);
            return null;
        }
    }
}
