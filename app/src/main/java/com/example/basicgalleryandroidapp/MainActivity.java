package com.example.basicgalleryandroidapp;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.basicgalleryandroidapp.adapter.GalleryRecyclerViewAdapter;
import com.example.basicgalleryandroidapp.viewmodel.GalleryViewModel;

import java.util.ArrayList;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        recyclerViewImages = findViewById(R.id.idREcyclerView);

        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);

        //recycler view initialized, adapter and layout provided >>>>
        GalleryRecyclerViewAdapter galleryRecyclerViewAdapter = new GalleryRecyclerViewAdapter(getApplicationContext(), galleryViewModel.getMutableLiveDataImagesList().getValue());
        recyclerViewImages.setAdapter(galleryRecyclerViewAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3, GridLayoutManager.HORIZONTAL, false);
        recyclerViewImages.setLayoutManager(gridLayoutManager);

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
}
