package com.rahul.imagegallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class GalleryActivity extends AppCompatActivity implements ClickListener {
    private RecyclerView mRecyclerView;
    private ConstraintLayout mLayoutConstraint;
    private List<String> imgList;
    private GalleryAdapter galleryAdapter ;

    private static final int  PERMISSION_CODE = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mRecyclerView = findViewById(R.id.rvRecyclerViewImg);
        mLayoutConstraint = findViewById(R.id.galleryLayout);

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
        imgList = Gallery.imageList(this);
         galleryAdapter = new GalleryAdapter(this, imgList);
        mRecyclerView.setAdapter(galleryAdapter);

    }

    @Override
    public void onClick(int position) {
/*     mLayoutConstraint.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

         }
     });*/

    }
    /*public void loadNextActivity(){
        Intent confirmBMP = new Intent(this,DisplayImageActivity.class);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Bitmap bmp = returnScaledBMP();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);

        confirmBMP.putExtra("Bitmap",bmp);
        startActivity(confirmBMP);
        finish();

    }
    public Bitmap returnScaledBMP(){
        Bitmap bmp=null;
        bmp = tempBitmap;
        bmp = createScaledBitmapKeepingAspectRatio(bmp,400);
        return bmp;
    }*/



}