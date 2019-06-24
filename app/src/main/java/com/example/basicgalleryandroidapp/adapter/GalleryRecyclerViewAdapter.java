package com.example.basicgalleryandroidapp.adapter;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.basicgalleryandroidapp.R;
import com.example.basicgalleryandroidapp.database.Image;
import com.example.basicgalleryandroidapp.viewmodel.GalleryViewModel;

import java.io.File;
import java.net.URI;
import java.util.List;

public class GalleryRecyclerViewAdapter extends RecyclerView.Adapter<GalleryRecyclerViewAdapter.ImageViewHolder>{

    private MutableLiveData<List<Image>> mutableListImageURIs;
    private Context context;

    private GalleryViewModel galleryViewModel;

    public GalleryRecyclerViewAdapter(@NonNull Context context, MutableLiveData<List<Image>> mutableListImageURIs) {
        this.context = context;
        this.mutableListImageURIs = mutableListImageURIs;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.gallery_image_layout, viewGroup, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        imageViewHolder.textView.setText(mutableListImageURIs.getValue().get(i).getImageUid()+"");
        //Picasso.get().load(mutableListImageURIs.getValue().get(i).getImageURI()).into(imageViewHolder.imageView);
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.idImageView);
            textView = itemView.findViewById(R.id.idTextView);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mutableListImageURIs.getValue().size();
    }
}
