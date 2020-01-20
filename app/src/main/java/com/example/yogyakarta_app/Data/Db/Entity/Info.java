package com.example.yogyakarta_app.Data.Db.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.w3c.dom.Text;

@Entity(tableName = "info_table")
public class Info {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String contentInfo;

    private String timeInfo;

    private String name;

    public Info(String contentInfo, String timeInfo, String name) {
        this.contentInfo = contentInfo;
        this.timeInfo = timeInfo;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getContentInfo() {
        return contentInfo;
    }

    public String getTimeInfo() {
        return timeInfo;
    }

    public String getName() {
        return name;
    }
}
