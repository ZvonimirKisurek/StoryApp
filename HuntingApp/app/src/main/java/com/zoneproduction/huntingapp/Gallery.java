package com.zoneproduction.huntingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class Gallery extends AppCompatActivity {

    TextView opis;
    GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        opis = findViewById(R.id.galleryOpis);
        gifImageView = findViewById(R.id.gifImageView);

    }
}