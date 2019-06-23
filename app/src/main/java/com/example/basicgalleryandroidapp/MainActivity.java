package com.example.basicgalleryandroidapp;

import android.Manifest;
import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.basicgalleryandroidapp.adapter.GalleryRecyclerViewAdapter;
import com.example.basicgalleryandroidapp.database.Image;
import com.example.basicgalleryandroidapp.viewmodel.GalleryViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * MainActivity.class
 * Will display the the images from the camera folder of a phone using recycler view.
 *
 * Data Members:
 * Recycler View for displaying images
 * View Model for storing and accessing the lifecycle persistent data
 *
 * @author shubhamtewari
 */
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewImages;
    GalleryViewModel galleryViewModel;

    public final int PERMISSION_EXTERNAL_STORAGE = 1331;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        recyclerViewImages = findViewById(R.id.idREcyclerView);

        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);

        //check read and request external storage permissions
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_EXTERNAL_STORAGE);
        } else {
            //permission granted
            galleryViewModel.initDatabase();
        }


        //recycler view initialized, adapter and layout provided >>>>
        GalleryRecyclerViewAdapter galleryRecyclerViewAdapter = new GalleryRecyclerViewAdapter(getApplicationContext(), galleryViewModel.getMutableLiveDataImagesList());
        recyclerViewImages.setAdapter(galleryRecyclerViewAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3, GridLayoutManager.VERTICAL, false);
        recyclerViewImages.setLayoutManager(gridLayoutManager);


        //observe for live data changes
        galleryViewModel.getMutableLiveDataImagesList().observe(this, new Observer<List<Image>>() {
            @Override
            public void onChanged(@Nullable List<Image> images) {
                recyclerViewImages.getAdapter().notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "No of images"+recyclerViewImages.getAdapter().getItemCount(), Toast.LENGTH_SHORT).show();
            }
        });

        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_EXTERNAL_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    galleryViewModel.initDatabase();
                } else {
                    Toast.makeText(getApplicationContext(), "Cannot access storage:(", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}
