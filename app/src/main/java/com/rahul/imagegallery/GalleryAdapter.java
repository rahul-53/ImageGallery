package com.rahul.imagegallery;

import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

     private Context context;
     private List<String>  imageList;
    public ClickListener clickListener;

    public GalleryAdapter(Context context, List<String> imageList) {
        this.imageList=imageList;
        this.clickListener = clickListener;
        this.context=context;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GalleryViewHolder(
                LayoutInflater.from(context).inflate(R.layout.image_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        String image =  imageList.get(position);

        Glide.with(context).load(image).into(holder.imageView);
 /* holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(context,DisplayImageActivity.class);


            }

        });*/

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivImages);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onClick(getAdapterPosition());
                }
            });
        }
    }
}
