package com.example.basicgalleryandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViwerActivity extends AppCompatActivity {

    String urlPath;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viwer);

        urlPath = getIntent().getExtras().getString("image_path");
        imageView = findViewById(R.id.idImageViewer);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = width;

        imageView.setLayoutParams(layoutParams);
        Glide.with(this).load(urlPath).into(imageView);
    }
}
