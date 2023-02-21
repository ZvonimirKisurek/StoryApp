package com.zoneproduction.manageme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    ImageView plan, voditelji, djelatnici;
    TextView error, errorText;
    ConstraintLayout mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plan = findViewById(R.id.imageButtonPlanMain);
        voditelji = findViewById(R.id.imageButtonMenagerMain);
        djelatnici = findViewById(R.id.imageButtonWorkerMain);
        error = findViewById(R.id.textPrijaviErrorMain);
        errorText = findViewById(R.id.textErrorTextMain);
        mainActivity = findViewById(R.id.clMainActivity);

        Animation animationIntro = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_faster);
        mainActivity.startAnimation(animationIntro);

        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (errorText.getVisibility() == View.INVISIBLE) {
                    errorText.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.RollIn).duration(250).repeat(0).playOn(errorText);
                } else {
                    errorText.setVisibility(View.INVISIBLE);
                }
            }
        });

        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RoomPlanActivityPO.class);
                startActivity(i);
                finish();
            }
        });

        voditelji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, WorkerCategoryChoiceActivity.class);
                startActivity(i);
                finish();
            }
        });

        djelatnici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, WorkerCategoryActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}