package com.example.basicgalleryandroidapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;

@Dao
public interface ImageDAO {
    @Insert
    public void insertImage(Image image);

    @Query("SELECT * from image_table ORDER BY image_uid ASC")
    public LiveData<ArrayList<Image>> getImages();
}
