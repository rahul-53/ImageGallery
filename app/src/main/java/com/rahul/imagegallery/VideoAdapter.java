package com.rahul.imagegallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private Context context;
    private List<String>  vidList;
    public ClickListener clickListener;

    public VideoAdapter(Context context, List<String> vidList) {
        this.vidList=vidList;

        this.context=context;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(context).inflate(R.layout.vid_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        String image =  vidList.get(position);

        Glide.with(context).load(image).into(holder.imageView);

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onClick(image);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return vidList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivImages);
        }
    }
}

