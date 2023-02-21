package com.zoneproduction.manageme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class KitchenPlanActivityPO extends AppCompatActivity {

    private ProgressBar pbStanje1, pbStanje2, pbStanje3, pbStanje4, pbStanje5;
    private LinearLayout natrag, layoutIzborProstora;
    private ImageView error1, error2, error3, error4, error5;
    private ImageButton dropDownRoom;
    private TextView storage, planSobe, currentTime, stanje1, stanje2, stanje3, stanje4, stanje5;
    private boolean isAlreadyOpenProstor = false;
    private OpenClose op = new OpenClose();
    private ConstraintLayout kitchenActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_plan_po);

        pbStanje1 = findViewById(R.id.progressBar1KP);
        pbStanje2 = findViewById(R.id.progressBar2KP);
        pbStanje3 = findViewById(R.id.progressBar3KP);
        pbStanje4 = findViewById(R.id.progressBar4KP);
        pbStanje5 = findViewById(R.id.progressBar5KP);
        natrag = findViewById(R.id.llNatragWS);
        error1 = findViewById(R.id.imageWarning1KP);
        error2 = findViewById(R.id.imageWarning2KP);
        error3 = findViewById(R.id.imageWarning3KP);
        error4 = findViewById(R.id.imageWarning4KP);
        error5 = findViewById(R.id.imageWarning5KP);
        planSobe = findViewById(R.id.textProstor1KPPO);
        storage = findViewById(R.id.textProstor2KPPO);
        layoutIzborProstora = findViewById(R.id.clOdabirProstorijeKPPO);
        dropDownRoom = findViewById(R.id.imageDropNameStageKPPO);
        currentTime = findViewById(R.id.textCurrentTimeKPPO);
        kitchenActivity = findViewById(R.id.clKPPO);
        stanje1 = findViewById(R.id.textCurrentProgress1KPPO);
        stanje2 = findViewById(R.id.textCurrentProgress2KPPO);
        stanje3 = findViewById(R.id.textCurrentProgress3KPPO);
        stanje4 = findViewById(R.id.textCurrentProgress4KPPO);
        stanje5 = findViewById(R.id.textCurrentProgress5KPPO);

        Animation animationIntro = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_faster);
        kitchenActivity.startAnimation(animationIntro);

        op.setTime(currentTime);
        pbStanje1.setProgress(100);
        pbStanje2.setProgress(100);
        pbStanje3.setProgress(100);
        pbStanje4.setProgress(100);
        pbStanje5.setProgress(100);

        planSobe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KitchenPlanActivityPO.this, RoomPlanActivityPO.class);
                startActivity(i);
                finish();
            }
        });

        storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KitchenPlanActivityPO.this, StorageActivityPO.class);
                startActivity(i);
                finish();
            }
        });

        dropDownRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                if (isAlreadyOpenProstor) {
                    YoYo.with(Techniques.BounceInUp).duration(500).repeat(0).playOn(layoutIzborProstora);
                    layoutIzborProstora.setVisibility(View.INVISIBLE);
                    isAlreadyOpenProstor = false;
                } else {
                    layoutIzborProstora.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.BounceInDown).duration(500).repeat(0).playOn(layoutIzborProstora);
                    isAlreadyOpenProstor = true;
                }
            }
        });

        //Handleri za errore
        Animation connectingAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.error_anim);
        if (pbStanje1.getProgress() == 25) {
            error1.setVisibility(View.VISIBLE);
            error1.startAnimation(connectingAnimation);
        } else {
            error1.setVisibility(View.INVISIBLE);
            error1.clearAnimation();
        }
        if (pbStanje2.getProgress() == 25) {
            error2.setVisibility(View.VISIBLE);
            error2.startAnimation(connectingAnimation);
        } else {
            error2.setVisibility(View.INVISIBLE);
            error2.clearAnimation();
        }
        if (pbStanje3.getProgress() == 25) {
            error3.setVisibility(View.VISIBLE);
            error3.startAnimation(connectingAnimation);
        } else {
            error3.clearAnimation();
            error3.setVisibility(View.INVISIBLE);
        }
        if (pbStanje4.getProgress() == 25) {
            error4.setVisibility(View.VISIBLE);
            error4.startAnimation(connectingAnimation);
        } else {
            error4.clearAnimation();
            error4.setVisibility(View.INVISIBLE);
        }
        if (pbStanje5.getProgress() == 25) {
            error5.setVisibility(View.VISIBLE);
            error5.startAnimation(connectingAnimation);
        } else {
            error5.clearAnimation();
            error5.setVisibility(View.INVISIBLE);
        }

        natrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KitchenPlanActivityPO.this, RoomPlanActivityPO.class);
                startActivity(intent);
                finish();
            }
        });

    }
}