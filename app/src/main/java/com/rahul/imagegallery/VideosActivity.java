package com.rahul.imagegallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class VideosActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewVid;
    private List<String> vidList;
    private VideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        mRecyclerViewVid = findViewById(R.id.rvRecyclerViewVid);
        showImages();
    }

    private void showImages() {
        mRecyclerViewVid.setHasFixedSize(true);
        mRecyclerViewVid.setLayoutManager(new GridLayoutManager(this, 3));
        vidList = Videos.vidList(this);
        videoAdapter = new VideoAdapter(this, vidList);
        mRecyclerViewVid.setAdapter(videoAdapter);

    }
}