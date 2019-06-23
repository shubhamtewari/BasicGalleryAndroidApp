package com.example.basicgalleryandroidapp.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity (tableName = "image_table")
public class Image {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "image_uid")
    private int imageUid;

    @ColumnInfo(name = "image_uri")
    private String imageURI;

    public Image(int uid, String uri) {
        this.imageUid = uid;
        this.imageURI = uri;
    }

    public int getImageUid() {
        return imageUid;
    }

    public void setImageUid(int imageUid) {
        this.imageUid = imageUid;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }
}
