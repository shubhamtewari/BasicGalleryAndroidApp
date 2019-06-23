package com.example.basicgalleryandroidapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.basicgalleryandroidapp.database.Image;
import com.example.basicgalleryandroidapp.repository.ImageRepository;

import java.util.ArrayList;
import java.util.List;

public class GalleryViewModel extends AndroidViewModel {

    ImageRepository imageRepository;
    MutableLiveData<List<Image>> mutableLiveDataImagesList;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
        if(mutableLiveDataImagesList==null) {
            mutableLiveDataImagesList = new MutableLiveData<>();
            mutableLiveDataImagesList.setValue(new ArrayList<Image>());
            imageRepository = new ImageRepository(application.getApplicationContext(), mutableLiveDataImagesList);

        }
    }

    public void initDatabase() {
        imageRepository.initImagesRoomDatabase();
    }

    public MutableLiveData<List<Image>> getMutableLiveDataImagesList() {
        return mutableLiveDataImagesList;
    }

    public ImageRepository getImageRepository() {
        return imageRepository;
    }
}
