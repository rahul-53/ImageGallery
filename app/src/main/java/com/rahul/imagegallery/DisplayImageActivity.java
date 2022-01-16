package com.rahul.imagegallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class DisplayImageActivity extends AppCompatActivity {
    ImageView mIvImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);
        mIvImage= findViewById(R.id.fullImageView);

      /*  if (getIntent().hasExtra("byteArray")) {

            Bitmap b = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("byteArray"), 0,
                    getIntent().getByteArrayExtra("byteArray").length);
            mIvImage.setImageBitmap(b);

        }*/
    }
}