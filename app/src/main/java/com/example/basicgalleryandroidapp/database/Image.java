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
    private String imageUid;

    @ColumnInfo(name = "image_uri")
    private String imageURI;

    public Image(String imageUid, String imageURI) {
        this.imageUid = imageUid;
        this.imageURI = imageURI;
    }

    public String getImageUid() {
        return imageUid;
    }

    public void setImageUid(String imageUid) {
        this.imageUid = imageUid;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }
}
