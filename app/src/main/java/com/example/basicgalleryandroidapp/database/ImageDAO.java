package com.example.basicgalleryandroidapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ImageDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertImage(Image image);

    @Query("SELECT * from image_table")
    public List<Image> getImages();

    @Query("DELETE from image_table")
    public void deleteAll();
}
