package com.zoneproduction.manageme;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class KitchenPlanActivityVO extends AppCompatActivity {

    private ProgressBar pbStanje1, pbStanje2, pbStanje3, pbStanje4, pbStanje5;
    private Button percCetvrtina1, percPola1, perc3Cetvrtine1, percFull1, percCetvrtina2, percPola2, perc3Cetvrtine2, percFull2, percCetvrtina3, percPola3, perc3Cetvrtine3, percFull3,
            percCetvrtina4, percPola4, perc3Cetvrtine4, percFull4, percCetvrtina5, percPola5, perc3Cetvrtine5, percFull5;
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
        setContentView(R.layout.activity_kitchen_plan_vo);

        pbStanje1 = findViewById(R.id.progressBar1KP);
        percCetvrtina1 = findViewById(R.id.buttonCetvrtina1KP);
        percPola1 = findViewById(R.id.buttonPola1KP);
        perc3Cetvrtine1 = findViewById(R.id.buttonTriCetvrtine1KP);
        percFull1 = findViewById(R.id.buttonFull1KP);
        pbStanje2 = findViewById(R.id.progressBar2KP);
        percCetvrtina2 = findViewById(R.id.buttonCetvrtina2KP);
        percPola2 = findViewById(R.id.buttonPola2KP);
        perc3Cetvrtine2 = findViewById(R.id.buttonTriCetvrtine2KP);
        percFull2 = findViewById(R.id.buttonFull2KP);
        pbStanje3 = findViewById(R.id.progressBar3KP);
        percCetvrtina3 = findViewById(R.id.buttonCetvrtina3KP);
        percPola3 = findViewById(R.id.buttonPola3KP);
        perc3Cetvrtine3 = findViewById(R.id.buttonTriCetvrtine3KP);
        percFull3 = findViewById(R.id.buttonFull3KP);
        pbStanje4 = findViewById(R.id.progressBar4KP);
        percCetvrtina4 = findViewById(R.id.buttonCetvrtina4KP);
        percPola4 = findViewById(R.id.buttonPola4KP);
        perc3Cetvrtine4 = findViewById(R.id.buttonTriCetvrtine4KP);
        percFull4 = findViewById(R.id.buttonFull4KP);
        pbStanje5 = findViewById(R.id.progressBar5KP);
        percCetvrtina5 = findViewById(R.id.buttonCetvrtina5KP);
        percPola5 = findViewById(R.id.buttonPola5KP);
        perc3Cetvrtine5 = findViewById(R.id.buttonTriCetvrtine5KP);
        percFull5 = findViewById(R.id.buttonFull5KP);
        natrag = findViewById(R.id.llNatragWS);
        error1 = findViewById(R.id.imageWarning1KP);
        error2 = findViewById(R.id.imageWarning2KP);
        error3 = findViewById(R.id.imageWarning3KP);
        error4 = findViewById(R.id.imageWarning4KP);
        error5 = findViewById(R.id.imageWarning5KP);
        planSobe = findViewById(R.id.textProstor1KPVO);
        storage = findViewById(R.id.textProstor2KPVO);
        layoutIzborProstora = findViewById(R.id.clOdabirProstorijeKPVO);
        dropDownRoom = findViewById(R.id.imageDropNameStageKPVO);
        currentTime = findViewById(R.id.textCurrentTimeKPVO);
        kitchenActivity = findViewById(R.id.clKPVO);
        stanje1 = findViewById(R.id.textCurrentProgress1KPVO);
        stanje2 = findViewById(R.id.textCurrentProgress2KPVO);
        stanje3 = findViewById(R.id.textCurrentProgress3KPVO);
        stanje4 = findViewById(R.id.textCurrentProgress4KPVO);
        stanje5 = findViewById(R.id.textCurrentProgress5KPVO);

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
                Intent i = new Intent(KitchenPlanActivityVO.this, RoomPlanActivityVO.class);
                startActivity(i);
                finish();
            }
        });

        storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KitchenPlanActivityVO.this, StorageActivityVO.class);
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
                Intent intent = new Intent(KitchenPlanActivityVO.this, RoomPlanActivityVO.class);
                startActivity(intent);
                finish();
            }
        });

        //Buttoni za setanje progress-a
        percCetvrtina1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje1.setProgress(25);
                error1.startAnimation(connectingAnimation);
                error1.setVisibility(View.VISIBLE);
                stanje1.setText(" 25%");
            }
        });
        percPola1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje1.setProgress(50);
                error1.clearAnimation();
                error1.setVisibility(View.INVISIBLE);
                stanje1.setText(" 50%");
            }
        });
        perc3Cetvrtine1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje1.setProgress(75);
                error1.clearAnimation();
                error1.setVisibility(View.INVISIBLE);
                stanje1.setText(" 75%");
            }
        });
        percFull1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje1.setProgress(100);
                error1.clearAnimation();
                error1.setVisibility(View.INVISIBLE);
                stanje1.setText(" 100%");
            }
        });
        percCetvrtina2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje2.setProgress(25);
                error2.startAnimation(connectingAnimation);
                error2.setVisibility(View.VISIBLE);
                stanje2.setText(" 25%");
            }
        });
        percPola2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje2.setProgress(50);
                error2.clearAnimation();
                error2.setVisibility(View.INVISIBLE);
                stanje2.setText(" 50%");
            }
        });
        perc3Cetvrtine2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje2.setProgress(75);
                error2.clearAnimation();
                error2.setVisibility(View.INVISIBLE);
                stanje2.setText(" 75%");
            }
        });
        percFull2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje2.setProgress(100);
                error2.clearAnimation();
                error2.setVisibility(View.INVISIBLE);
                stanje2.setText(" 100%");
            }
        });
        percCetvrtina3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje3.setProgress(25);
                error3.startAnimation(connectingAnimation);
                error3.setVisibility(View.VISIBLE);
                stanje3.setText(" 25%");
            }
        });
        percPola3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje3.setProgress(50);
                error3.clearAnimation();
                error3.setVisibility(View.INVISIBLE);
                stanje3.setText(" 50%");

            }
        });
        perc3Cetvrtine3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje3.setProgress(75);
                error3.clearAnimation();
                error3.setVisibility(View.INVISIBLE);
                stanje3.setText(" 75%");

            }
        });
        percFull3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje3.setProgress(100);
                error3.clearAnimation();
                error3.setVisibility(View.INVISIBLE);
                stanje3.setText(" 100%");

            }
        });
        percCetvrtina4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje4.setProgress(25);
                error4.startAnimation(connectingAnimation);
                error4.setVisibility(View.VISIBLE);
                stanje4.setText(" 25%");

            }
        });
        percPola4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje4.setProgress(50);
                error4.clearAnimation();
                error4.setVisibility(View.INVISIBLE);
                stanje4.setText(" 25%");

            }
        });
        perc3Cetvrtine4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje4.setProgress(75);
                error4.clearAnimation();
                error4.setVisibility(View.INVISIBLE);
                stanje4.setText(" 75%");
            }
        });
        percFull4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje4.setProgress(100);
                error4.clearAnimation();
                error4.setVisibility(View.INVISIBLE);
                stanje4.setText(" 100%");
            }
        });
        percCetvrtina5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje5.setProgress(25);
                error5.startAnimation(connectingAnimation);
                error5.setVisibility(View.VISIBLE);
                stanje5.setText(" 25%");
            }
        });
        percPola5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje5.setProgress(50);
                error5.clearAnimation();
                error5.setVisibility(View.INVISIBLE);
                stanje5.setText(" 50%");
            }
        });
        perc3Cetvrtine5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje5.setProgress(75);
                error5.clearAnimation();
                error5.setVisibility(View.INVISIBLE);
                stanje5.setText(" 75%");
            }
        });
        percFull5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                pbStanje5.setProgress(100);
                error5.clearAnimation();
                error5.setVisibility(View.INVISIBLE);
                stanje5.setText(" 100%");
            }
        });

    }
}