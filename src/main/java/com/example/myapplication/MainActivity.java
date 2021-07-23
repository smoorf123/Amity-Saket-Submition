package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    ImageView mImageView;
    TextView mResultTv;
    View mColorView;

    Bitmap bitmap;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageView);
        mResultTv = findViewById(R.id.resultTv);
        mColorView = findViewById(R.id.colorView);

        mImageView.setDrawingCacheEnabled(true);
        mImageView.buildDrawingCache(true);



        mImageView.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                bitmap = mImageView.getDrawingCache();

                int pixel = bitmap.getPixel((int) event.getX(), (int) event.getY());

                int r = Color.red(pixel);
                int g = Color.green(pixel);
                int b = Color.blue(pixel);

                String hex = "#" + Integer.toHexString(pixel);

                mColorView.setBackgroundColor(Color.rgb(r, g, b));

                mResultTv.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + hex);
                Log.d("SOMIL KEY", String.valueOf(r));

                }
                return true;
            });

    }
}
