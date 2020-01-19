package com.example.yogyakarta_app.Data.Db.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tour_table")
public class Tour {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String address;

    private String imageUrl;

    private Double latitude;

    private Double longitude;


    public Tour(String title, String address, String imageUrl, Double latitude, Double longitude) {
        this.title = title;
        this.address = address;
        this.imageUrl = imageUrl;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getAddress() {
        return address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
