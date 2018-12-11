package com.example.frans.listapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class PictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        Intent in = getIntent();
        int index = in.getIntExtra("item_index", -1);

        if (index > -1) {
            ImageView img = findViewById(R.id.imageView);
            scaleImg(img, getImg(index));
        }

    }

    private int getImg(int index) {
        switch (index) {
            case 0: return R.drawable.ransuli;
            case 1: return R.drawable.mic;
            case 2: return R.drawable.bottle;
            default: return -1;
        }
    }

    private void scaleImg(ImageView img, int pic) {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imageWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imageWidth > screenWidth) {
            int ratio = Math.round( (float)imageWidth / (float)screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);
    }

}
