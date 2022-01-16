package com.rahul.imagegallery;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnImage, mBtnVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mBtnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imgIntent = new Intent(MainActivity.this,GalleryActivity.class);
                startActivity(imgIntent);
            }
        });

        mBtnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vidIntent = new Intent(MainActivity.this,VideosActivity.class);
                startActivity(vidIntent);
            }
        });
    }

    private void initView(){
        mBtnImage = findViewById(R.id.buttonImg);
        mBtnVideo = findViewById(R.id.buttonVid);

    }

}