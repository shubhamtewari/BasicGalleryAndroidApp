package com.example.basicgalleryandroidapp.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import com.example.basicgalleryandroidapp.database.GalleryRoomDatabase;
import com.example.basicgalleryandroidapp.database.Image;
import com.example.basicgalleryandroidapp.database.ImageDAO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageRepository {
    private MutableLiveData<List<Image>> arrayListLiveDataImages;
    private ImageDAO imageDAO;

    public ImageRepository(Context context, MutableLiveData<List<Image>> arrayListLiveDataImages) {
        GalleryRoomDatabase galleryRoomDatabase = GalleryRoomDatabase.getInstance(context);
        imageDAO = galleryRoomDatabase.imageDAO();
        this.arrayListLiveDataImages = arrayListLiveDataImages;
    }

    public void initImagesRoomDatabase() {
        new getImagesTask(imageDAO).execute(arrayListLiveDataImages);
    }

    private static class getImagesTask extends AsyncTask<MutableLiveData<List<Image>>, Void, Void> {

        private ImageDAO imageDAO;

        getImagesTask(ImageDAO imageDAO){
            this.imageDAO = imageDAO;
        }

        @Override
        protected Void doInBackground(MutableLiveData<List<Image>>... mutableLiveData) {
            //load images from database
            List<Image> imageList = imageDAO.getImages();
            mutableLiveData[0].postValue(imageList);

            //clear image_table
            imageDAO.deleteAll();

            //add images to database
            File CameraDirectory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString()+"/Camera");
            //Log.d("TEST", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString());
            File[] files = CameraDirectory.listFiles();
            //Log.d("TEST", "No. of files: "+files.length);
            for (File currentFile : files) {
                if (currentFile.isDirectory()) {
                    //Log.d("TEST", "File: "+currentFile.getAbsolutePath());
                }
                else {
                    if(currentFile.getAbsolutePath().endsWith(".png")||currentFile.getAbsolutePath().endsWith(".jpg")||currentFile.getAbsolutePath().endsWith(".jpeg"))
                    //Log.d("TEST", "doInBackground: "+currentFile.getAbsolutePath());
                    imageDAO.insertImage(new Image(currentFile.getAbsolutePath(), currentFile.getAbsolutePath()));
                }
            }

            imageList.clear();
            imageList = imageDAO.getImages();
            mutableLiveData[0].postValue(imageList);

            return null;
        }
    }

}
