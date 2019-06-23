package com.example.basicgalleryandroidapp.adapter;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.basicgalleryandroidapp.database.Image;
import com.example.basicgalleryandroidapp.viewmodel.GalleryViewModel;

import java.util.ArrayList;

public class GalleryRecyclerViewAdapter extends RecyclerView.Adapter<GalleryRecyclerViewAdapter.ImageViewHolder>{

    private ArrayList<Image> arrayListImageURIs;
    private Context context;

    private GalleryViewModel galleryViewModel;

    public GalleryRecyclerViewAdapter(@NonNull Context context, ArrayList<Image> arrayListImageURIs) {
        this.context = context;
        this.arrayListImageURIs = arrayListImageURIs;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ImageView imageView = new ImageView(context);
        return new ImageViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {

    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView;
        }
    }

    @Override
    public int getItemCount() {
        return arrayListImageURIs.size();
    }
}
