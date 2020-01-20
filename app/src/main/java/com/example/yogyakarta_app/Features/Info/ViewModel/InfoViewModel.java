package com.example.yogyakarta_app.Features.Info.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.yogyakarta_app.Data.Db.Entity.Info;
import com.example.yogyakarta_app.Features.Info.Model.InfoRepository;

import java.util.List;

public class InfoViewModel extends AndroidViewModel {

    private InfoRepository infoRepository;

    private LiveData<List<Info>> info;

    public InfoViewModel(@NonNull Application application) {
        super(application);
        infoRepository = new InfoRepository(application);
        info = infoRepository.getAllInfo();
    }

    public void insert(Info info){
        infoRepository.insert(info);
    }

    public LiveData<List<Info>> getAllInfo(){
        return info;
    }
}
