package com.example.yogyakarta_app.Features.Info.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.yogyakarta_app.Data.Db.Entity.Info;

import java.util.List;

@Dao
public interface InfoDao {

    @Insert
    void insert(Info info);

    @Update
    void update(Info info);

    @Delete
    void delete(Info info);

    @Query("SELECT * FROM info_table ORDER BY id DESC")
    LiveData<List<Info>> getAllInfo();


}
