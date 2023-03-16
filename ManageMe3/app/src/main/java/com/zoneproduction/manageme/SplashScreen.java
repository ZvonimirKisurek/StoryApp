package com.zoneproduction.manageme;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import de.hdodenhof.circleimageview.CircleImageView;

public class SplashScreen extends AppCompatActivity {

    ConstraintLayout wallPaper;
    CircleImageView splash;
    TextView title, subtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        wallPaper = findViewById(R.id.clSplash);
        splash = findViewById(R.id.imageSplashScreen);
        title = findViewById(R.id.textSplashTitle);
        subtitle = findViewById(R.id.textSplashSubtitle);

        Animation animationIntro = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_anim);
        wallPaper.startAnimation(animationIntro);
        YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        }, 2500);

    }
}