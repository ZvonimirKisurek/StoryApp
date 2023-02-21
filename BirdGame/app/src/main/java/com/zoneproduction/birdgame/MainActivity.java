package com.zoneproduction.birdgame;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView bird, enemy1, enemy2, enemy3, coin, volume;
    private Button buttonStart;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bird = findViewById(R.id.bird);
        enemy1 = findViewById(R.id.enemy1);
        enemy2 = findViewById(R.id.enemy2);
        enemy3 = findViewById(R.id.enemy3);
        coin = findViewById(R.id.coin1);
        volume = findViewById(R.id.volume);
        buttonStart = findViewById(R.id.buttonStart);

        animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_animation);
        bird.setAnimation(animation);
        enemy1.setAnimation(animation);
        enemy2.setAnimation(animation);
        enemy3.setAnimation(animation);
        coin.setAnimation(animation);
    }
}