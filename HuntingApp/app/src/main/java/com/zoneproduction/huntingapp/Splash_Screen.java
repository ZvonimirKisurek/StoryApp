package com.zoneproduction.huntingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        imageView = findViewById(R.id.splashImage);
        textView = findViewById(R.id.splashTitle);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_anim);
        textView.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(Splash_Screen.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        },3000);

    }
}