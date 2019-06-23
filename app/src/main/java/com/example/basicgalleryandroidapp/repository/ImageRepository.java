package com.example.basicgalleryandroidapp.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.example.basicgalleryandroidapp.database.GalleryRoomDatabase;
import com.example.basicgalleryandroidapp.database.Image;
import com.example.basicgalleryandroidapp.database.ImageDAO;

import java.util.ArrayList;

public class ImageRepository {
    private LiveData<ArrayList<Image>> arrayListLiveDataImages;
    private ImageDAO imageDAO;

    public ImageRepository(Context context) {
        GalleryRoomDatabase galleryRoomDatabase = GalleryRoomDatabase.getInstance(context);
        imageDAO = galleryRoomDatabase.imageDAO();
        arrayListLiveDataImages = imageDAO.getImages();
    }

    public LiveData<ArrayList<Image>> getImagesFromRoomDatabase() {
        LiveData<ArrayList<Image>> arrayListLiveData = imageDAO.getImages();
        return arrayListLiveData;
    }

    public void insertImagesToDatabase() {

    }
}
