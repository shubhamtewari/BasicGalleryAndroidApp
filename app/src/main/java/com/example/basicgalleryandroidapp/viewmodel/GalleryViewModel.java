package com.example.basicgalleryandroidapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.basicgalleryandroidapp.database.Image;
import com.example.basicgalleryandroidapp.repository.ImageRepository;

import java.util.ArrayList;

public class GalleryViewModel extends AndroidViewModel {

    ImageRepository imageRepository;
    MutableLiveData<ArrayList<Image>> mutableLiveDataImagesList;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
        imageRepository = new ImageRepository(application.getApplicationContext());
        mutableLiveDataImagesList = (MutableLiveData<ArrayList<Image>>) imageRepository.getImagesFromRoomDatabase();
    }

    public MutableLiveData<ArrayList<Image>> getMutableLiveDataImagesList() {
        return mutableLiveDataImagesList;
    }
}
