package com.rahul.imagegallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class GalleryActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> imageList;
    private GalleryAdapter galleryAdapter;

    private static final int  PERMISSION_CODE = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mRecyclerView = findViewById(R.id.rvRecyclerViewImg);

        if (ContextCompat.checkSelfPermission(GalleryActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}
                    ,PERMISSION_CODE);
        }
        else{
            showImages();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_CODE){
            if (grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "permission granted",Toast.LENGTH_SHORT).show();
                showImages();
            }
            else {
                Toast.makeText(this,"permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showImages() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        imageList = Gallery.imageList(this);
        galleryAdapter = new GalleryAdapter(this, imageList,new ClickListener(){

            @Override
            public void onClick(String path) {

            }
        });
        mRecyclerView.setAdapter(galleryAdapter);
        
    }

}