package com.rahul.imagegallery;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

public class Videos {
    public static ArrayList<String> vidList(Context context){
        Uri uri;
        Cursor cursor;
        int column_idx;
        int column_folder_idx;
        ArrayList<String> vidList = new ArrayList<>();
        String absPath;
        uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

        String[] showcase = {MediaStore.MediaColumns.DATA,MediaStore.Video.Media.BUCKET_DISPLAY_NAME};

        String order = MediaStore.Images.Media.DEFAULT_SORT_ORDER;

        cursor = context.getContentResolver().query( uri, showcase, null,null,order);
        column_idx = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        column_folder_idx = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.BUCKET_DISPLAY_NAME);

        while (cursor.moveToNext()){
            absPath = cursor.getString(column_idx);
            vidList.add(absPath);
        }

        return vidList;
    }

}
