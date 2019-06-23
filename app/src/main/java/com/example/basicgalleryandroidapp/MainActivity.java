package com.example.basicgalleryandroidapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.basicgalleryandroidapp.adapter.GalleryRecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewImages;
    ArrayList<String> arrayListImageURIs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        recyclerViewImages = (RecyclerView) findViewById(R.id.idREcyclerView);

        arrayListImageURIs = new ArrayList<>();

        //recycler view initialized, adapter and layout provided >>>>

        GalleryRecyclerViewAdapter galleryRecyclerViewAdapter = new GalleryRecyclerViewAdapter(getApplicationContext(), arrayListImageURIs);
        recyclerViewImages.setAdapter(galleryRecyclerViewAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3, GridLayoutManager.HORIZONTAL, false);

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
