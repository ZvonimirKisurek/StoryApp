package com.zoneproduction.manageme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class RoomPlanActivityVO extends AppCompatActivity {

    private TextView infoSoba1, infoSoba2, infoSoba3, infoSoba4, infoSoba5, infoSoba6, infoSoba7, infoSoba8, infoSoba9, infoSoba10,
            addClean1, addClean2, addClean3, addClean4, addClean5, addClean6, addClean7, addClean8, addClean9, addClean10, ostalo1, ostalo2, ostalo3, ostalo4, ostalo5, ostalo6,
            ostalo7, ostalo8, ostalo9, ostalo10, brojKata, imeProstorije, brojSobe1, brojSobe2, brojSobe3, brojSobe4, brojSobe5, brojSobe6, brojSobe7, brojSobe8,
            brojSobe9, brojSobe10, terminUsluge, hint, odabranaUsluga, prvaOpcijaKat, drugaOpcijaKat, trecaOpcijaKat, prostor1, prostor2, currentTime, vrijemeUsluge1,
            vrijemeUsluge2, vrijemeUsluge3, vrijemeUsluge4, vrijemeUsluge5, vrijemeUsluge6, vrijemeUsluge7, vrijemeUsluge8, opcijaUsluge1, opcijaUsluge2, opcijaUsluge3;
    ImageButton izborKat, izborProstor, izborUsluge, izborVremenaUsluge, potvrdi;
    LinearLayout soba1, soba2, soba3, soba4, soba5, soba6, soba7, soba8, soba9, soba10;
    ImageView error1, error2, error3, error4, error5, error6, error7, error8, error9, error10, profile1, profile2,
            profile3, profile4, profile5, profile6, profile7, profile8, profile9, profile10, clean1, clean2, clean3, clean4, clean5, clean6, clean7, clean8, clean9,
            clean10, food1, food2, food3, food4, food5, food6, food7, food8, food9, food10, dodanaUsluga, bedMake1, bedMake2, bedMake3, bedMake4, bedMake5, bedMake6,
            bedMake7, bedMake8, bedMake9, bedMake10;
    OpenClose op = new OpenClose();
    int openedRoom = 0;
    ConstraintLayout clUsluga, roomPlanActivity;
    LinearLayout clIzborKata, clIzborProstorije, backToMain, llIzborUsluge, llIzborVremenaUsluge;
    int[] floors = {2, 3, 4};
    int openedRoomActivity = 0;
    boolean isAlreadyOpenKat = false, isAlreadyOpenProstor = false, isAlreadyOpenUsluge = false, isAlreadyOpenVrijeme = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_plan_vo);

        Animation connectingAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.error_anim);
        currentTime = findViewById(R.id.textCurrentTimeRP);
        opcijaUsluge1 = findViewById(R.id.textPrvaOpcijaUslugeRP);
        opcijaUsluge2 = findViewById(R.id.textDrugaOpcijaUslugeRP);
        opcijaUsluge3 = findViewById(R.id.textTrecaOpcijaUslugeRP);
        llIzborUsluge = findViewById(R.id.llIzborUslugeRP);
        izborUsluge = findViewById(R.id.imageUslugePullUpRP);
        izborVremenaUsluge = findViewById(R.id.imageTerminiPullUpRP);
        llIzborVremenaUsluge = findViewById(R.id.llIzborVremenaUslugeRP);
        roomPlanActivity = findViewById(R.id.clRoomPlanActivityVO);
        terminUsluge = findViewById(R.id.textTerminUslugeRP);
        prvaOpcijaKat = findViewById(R.id.textPrvaOpcijaKatRP);
        drugaOpcijaKat = findViewById(R.id.textDrugaOpcijaKatRP);
        trecaOpcijaKat = findViewById(R.id.textTrecaOpcijaKatRP);
        clIzborKata = findViewById(R.id.clOdabirKataRP);
        clIzborProstorije = findViewById(R.id.clOdabirProstorijeRP);
        clUsluga = findViewById(R.id.clUslugeRP);
        brojKata = findViewById(R.id.textBrojEtapeRP);
        imeProstorije = findViewById(R.id.textImeEtapeRP);
        odabranaUsluga = findViewById(R.id.textUslugaZaDodatiRP);
        dodanaUsluga = findViewById(R.id.imageDogađajikonaRP);
        potvrdi = findViewById(R.id.buttonPotvrdiUsluguRP);
        brojKata = findViewById(R.id.textBrojEtapeRP);
        imeProstorije = findViewById(R.id.textImeEtapeRP);
        izborKat = findViewById(R.id.imageDropStageRP);
        izborProstor = findViewById(R.id.imageDropNameStageRP);
        backToMain = findViewById(R.id.llNatragRP);
        infoSoba1 = findViewById(R.id.textInfoSoba1RP);
        infoSoba2 = findViewById(R.id.textInfoSoba2RP);
        infoSoba3 = findViewById(R.id.textInfoSoba3RP);
        infoSoba4 = findViewById(R.id.textInfoSoba4RP);
        infoSoba5 = findViewById(R.id.textInfoSoba5RP);
        infoSoba6 = findViewById(R.id.textInfoSoba6RP);
        infoSoba7 = findViewById(R.id.textInfoSoba7RP);
        infoSoba8 = findViewById(R.id.textInfoSoba8RP);
        infoSoba9 = findViewById(R.id.textInfoSoba9RP);
        infoSoba10 = findViewById(R.id.textInfoSoba10RP);
        addClean1 = findViewById(R.id.textDodajClean1RP);
        addClean2 = findViewById(R.id.textDodajClean2RP);
        addClean3 = findViewById(R.id.textDodajClean3RP);
        addClean4 = findViewById(R.id.textDodajClean4RP);
        addClean5 = findViewById(R.id.textDodajClean5RP);
        addClean6 = findViewById(R.id.textDodajClean6RP);
        addClean7 = findViewById(R.id.textDodajClean7RP);
        addClean8 = findViewById(R.id.textDodajClean8RP);
        addClean9 = findViewById(R.id.textDodajClean9RP);
        addClean10 = findViewById(R.id.textDodajClean10RP);
        ostalo1 = findViewById(R.id.textOstalo1RP);
        ostalo2 = findViewById(R.id.textOstalo2RP);
        ostalo3 = findViewById(R.id.textOstalo3RP);
        ostalo4 = findViewById(R.id.textOstalo4RP);
        ostalo5 = findViewById(R.id.textOstalo5RP);
        ostalo6 = findViewById(R.id.textOstalo6RP);
        ostalo7 = findViewById(R.id.textOstalo7RP);
        ostalo8 = findViewById(R.id.textOstalo8RP);
        ostalo9 = findViewById(R.id.textOstalo9RP);
        ostalo10 = findViewById(R.id.textOstalo10RP);
        brojSobe1 = findViewById(R.id.textBrojSobe1RP);
        brojSobe2 = findViewById(R.id.textBrojSobe2RP);
        brojSobe3 = findViewById(R.id.textBrojSobe3RP);
        brojSobe4 = findViewById(R.id.textBrojSobe4RP);
        brojSobe5 = findViewById(R.id.textBrojSobe5RP);
        brojSobe6 = findViewById(R.id.textBrojSobe6RP);
        brojSobe7 = findViewById(R.id.textBrojSobe7RP);
        brojSobe8 = findViewById(R.id.textBrojSobe8RP);
        brojSobe9 = findViewById(R.id.textBrojSobe9RP);
        brojSobe10 = findViewById(R.id.textBrojSobe10RP);
        profile1 = findViewById(R.id.imageProfil1RP);
        profile2 = findViewById(R.id.imageProfil2RP);
        profile3 = findViewById(R.id.imageProfil3RP);
        profile4 = findViewById(R.id.imageProfil4RP);
        profile5 = findViewById(R.id.imageProfil5RP);
        profile6 = findViewById(R.id.imageProfil6RP);
        profile7 = findViewById(R.id.imageProfil7RP);
        profile8 = findViewById(R.id.imageProfil8RP);
        profile9 = findViewById(R.id.imageProfil9RP);
        profile10 = findViewById(R.id.imageProfil10RP);
        clean1 = findViewById(R.id.imageClean1RP);
        clean2 = findViewById(R.id.imageClean2RP);
        clean3 = findViewById(R.id.imageClean3RP);
        clean4 = findViewById(R.id.imageClean4RP);
        clean5 = findViewById(R.id.imageClean5RP);
        clean6 = findViewById(R.id.imageClean6RP);
        clean7 = findViewById(R.id.imageClean7RP);
        clean8 = findViewById(R.id.imageClean8RP);
        clean9 = findViewById(R.id.imageClean9RP);
        clean10 = findViewById(R.id.imageClean10RP);
        food1 = findViewById(R.id.imageFood1RP);
        food2 = findViewById(R.id.imageFood2RP);
        food3 = findViewById(R.id.imageFood3RP);
        food4 = findViewById(R.id.imageFood4RP);
        food5 = findViewById(R.id.imageFood5RP);
        food6 = findViewById(R.id.imageFood6RP);
        food7 = findViewById(R.id.imageFood7RP);
        food8 = findViewById(R.id.imageFood8RP);
        food9 = findViewById(R.id.imageFood9RP);
        food10 = findViewById(R.id.imageFood10RP);
        bedMake1 = findViewById(R.id.imageBedMake1RP);
        bedMake2 = findViewById(R.id.imageBedMake2RP);
        bedMake3 = findViewById(R.id.imageBedMake3RP);
        bedMake4 = findViewById(R.id.imageBedMake4RP);
        bedMake5 = findViewById(R.id.imageBedMake5RP);
        bedMake6 = findViewById(R.id.imageBedMake6RP);
        bedMake7 = findViewById(R.id.imageBedMake7RP);
        bedMake8 = findViewById(R.id.imageBedMake8RP);
        bedMake9 = findViewById(R.id.imageBedMake9RP);
        bedMake10 = findViewById(R.id.imageBedMake10RP);
        error1 = findViewById(R.id.imageWarning1RP);
        error2 = findViewById(R.id.imageWarning2RP);
        error3 = findViewById(R.id.imageWarning3RP);
        error4 = findViewById(R.id.imageWarning4RP);
        error5 = findViewById(R.id.imageWarning5RP);
        error6 = findViewById(R.id.imageWarning6RP);
        error7 = findViewById(R.id.imageWarning7RP);
        error8 = findViewById(R.id.imageWarning8RP);
        error9 = findViewById(R.id.imageWarning9RP);
        error10 = findViewById(R.id.imageWarning10RP);
        soba1 = findViewById(R.id.vlSoba1RP);
        soba2 = findViewById(R.id.vlSoba2RP);
        soba3 = findViewById(R.id.vlSoba3RP);
        soba4 = findViewById(R.id.vlSoba4RP);
        soba5 = findViewById(R.id.vlSoba5RP);
        soba6 = findViewById(R.id.vlSoba6RP);
        soba7 = findViewById(R.id.vlSoba7RP);
        soba8 = findViewById(R.id.vlSoba8RP);
        soba9 = findViewById(R.id.vlSoba9RP);
        soba10 = findViewById(R.id.vlSoba10RP);
        prostor1 = findViewById(R.id.textProstor1RP);
        prostor2 = findViewById(R.id.textProstor2RP);
        vrijemeUsluge1 = findViewById(R.id.textVrijemeUsluge1RP);
        vrijemeUsluge2 = findViewById(R.id.textVrijemeUsluge2RP);
        vrijemeUsluge3 = findViewById(R.id.textVrijemeUsluge3RP);
        vrijemeUsluge4 = findViewById(R.id.textVrijemeUsluge4RP);
        vrijemeUsluge5 = findViewById(R.id.textVrijemeUsluge5RP);
        vrijemeUsluge6 = findViewById(R.id.textVrijemeUsluge6RP);
        vrijemeUsluge7 = findViewById(R.id.textVrijemeUsluge7RP);
        vrijemeUsluge8 = findViewById(R.id.textVrijemeUsluge8RP);

        Animation animationIntro = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_faster);
        roomPlanActivity.startAnimation(animationIntro);

        error1.startAnimation(connectingAnimation);
        error10.startAnimation(connectingAnimation);

        /*
        error3.startAnimation(connectingAnimation);
        error4.startAnimation(connectingAnimation);
        error5.startAnimation(connectingAnimation);
        error6.startAnimation(connectingAnimation);
        error7.startAnimation(connectingAnimation);
        error8.startAnimation(connectingAnimation);
        error9.startAnimation(connectingAnimation);
        error2.startAnimation(connectingAnimation);
        */

        //kako ugasiti istu animaciju
        /*
        myView.clearAnimation();
        connectingAnimation.cancel();
        connectingAnimation.reset();
         */
        setTime();

        roomPlanActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.closeRoomFast(getApplicationContext(), clIzborKata, clIzborProstorije, llIzborUsluge, llIzborVremenaUsluge);
                if (openedRoom != 0) {
                    op.closeRoomFast(getApplicationContext(), currRoomInfo(openedRoom), currRoomAddClean(openedRoom), currRoomAddOther(openedRoom), clUsluga);
                    openedRoom = 0;
                }
            }
        });

        //Odabrati vrijeme usluge
        vrijemeUsluge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terminUsluge.setText(vrijemeUsluge1.getText().toString());
                op.checkIfAddJobIsEmpty(odabranaUsluga, terminUsluge, potvrdi);
                llIzborVremenaUsluge.setVisibility(View.INVISIBLE);
            }
        });
        vrijemeUsluge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terminUsluge.setText(vrijemeUsluge2.getText().toString());
                op.checkIfAddJobIsEmpty(odabranaUsluga, terminUsluge, potvrdi);
                llIzborVremenaUsluge.setVisibility(View.INVISIBLE);
            }
        });
        vrijemeUsluge3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terminUsluge.setText(vrijemeUsluge3.getText().toString());
                op.checkIfAddJobIsEmpty(odabranaUsluga, terminUsluge, potvrdi);
                llIzborVremenaUsluge.setVisibility(View.INVISIBLE);
            }
        });
        vrijemeUsluge4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terminUsluge.setText(vrijemeUsluge4.getText().toString());
                op.checkIfAddJobIsEmpty(odabranaUsluga, terminUsluge, potvrdi);
                llIzborVremenaUsluge.setVisibility(View.INVISIBLE);
            }
        });
        vrijemeUsluge5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terminUsluge.setText(vrijemeUsluge5.getText().toString());
                op.checkIfAddJobIsEmpty(odabranaUsluga, terminUsluge, potvrdi);
                llIzborVremenaUsluge.setVisibility(View.INVISIBLE);
            }
        });
        vrijemeUsluge6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terminUsluge.setText(vrijemeUsluge6.getText().toString());
                op.checkIfAddJobIsEmpty(odabranaUsluga, terminUsluge, potvrdi);
                llIzborVremenaUsluge.setVisibility(View.INVISIBLE);
            }
        });
        vrijemeUsluge7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terminUsluge.setText(vrijemeUsluge7.getText().toString());
                op.checkIfAddJobIsEmpty(odabranaUsluga, terminUsluge, potvrdi);
                llIzborVremenaUsluge.setVisibility(View.INVISIBLE);
            }
        });
        vrijemeUsluge8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terminUsluge.setText(vrijemeUsluge8.getText().toString());
                op.checkIfAddJobIsEmpty(odabranaUsluga, terminUsluge, potvrdi);
                llIzborVremenaUsluge.setVisibility(View.INVISIBLE);
            }
        });


        //Odabrati uslugu u layoutu

        opcijaUsluge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                odabranaUsluga.setText(opcijaUsluge1.getText().toString());
                dodanaUsluga.setImageDrawable(getDrawable(R.drawable.foodicon));
                dodanaUsluga.setVisibility(View.VISIBLE);
                op.checkIfAddJobIsEmpty(odabranaUsluga, terminUsluge, potvrdi);
                llIzborUsluge.setVisibility(View.INVISIBLE);
            }
        });

        opcijaUsluge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                odabranaUsluga.setText(opcijaUsluge2.getText().toString());
                dodanaUsluga.setImageDrawable(getDrawable(R.drawable.bedmaking));
                dodanaUsluga.setVisibility(View.VISIBLE);
                op.checkIfAddJobIsEmpty(odabranaUsluga, terminUsluge, potvrdi);
                llIzborUsluge.setVisibility(View.INVISIBLE);
            }
        });

        opcijaUsluge3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                odabranaUsluga.setText(opcijaUsluge3.getText().toString());
                dodanaUsluga.setImageDrawable(getDrawable(R.drawable.cleaningicon));
                dodanaUsluga.setVisibility(View.VISIBLE);
                op.checkIfAddJobIsEmpty(odabranaUsluga, terminUsluge, potvrdi);
                llIzborUsluge.setVisibility(View.INVISIBLE);
            }
        });

        //nazad na MainActivity
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivityVO.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        prostor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivityVO.this, StorageActivityVO.class);
                startActivity(intent);
                finish();
            }
        });

        prostor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivityVO.this, KitchenPlanActivityVO.class);
                startActivity(intent);
            }
        });

        //set on Click za sobe
        soba1.setOnClickListener(view -> {
            openRoom(1);
            setTime();
        });
        soba2.setOnClickListener(view -> {
            setTime();
            openRoom(2);
        });
        soba3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(3);
                setTime();
            }
        });
        soba4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(4);
                setTime();
            }
        });
        soba5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(5);
                setTime();
            }
        });
        soba6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(6);
                setTime();
            }
        });
        soba7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(7);
                setTime();
            }
        });
        soba8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(8);
                setTime();
            }
        });
        soba9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(9);
                setTime();
            }
        });
        soba10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(10);
                setTime();
            }
        });

        //set on Click za usluge
        addClean1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba1, addClean1, ostalo1};
                op.addClean(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, clUsluga);
                odabranaUsluga.setText("Čišćenje sobe");
                dodanaUsluga.setImageDrawable(getDrawable(R.drawable.cleaningicon));
                openedRoom = 0;
                openedRoomActivity = 1;
            }
        });
        addClean2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba2, addClean2, ostalo2};
                op.addClean(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, clUsluga);
                odabranaUsluga.setText("Čišćenje sobe");
                dodanaUsluga.setImageDrawable(getDrawable(R.drawable.cleaningicon));
                openedRoom = 0;
                openedRoomActivity = 2;
            }
        });
        addClean3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba3, addClean3, ostalo3};
                op.addClean(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, clUsluga);
                odabranaUsluga.setText("Čišćenje sobe");
                dodanaUsluga.setImageDrawable(getDrawable(R.drawable.cleaningicon));
                openedRoom = 0;
                openedRoomActivity = 3;
            }
        });
        addClean4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba4, addClean4, ostalo4};
                op.addClean(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, clUsluga);
                odabranaUsluga.setText("Čišćenje sobe");
                dodanaUsluga.setImageDrawable(getDrawable(R.drawable.cleaningicon));
                openedRoom = 0;
                openedRoomActivity = 4;
            }
        });
        addClean5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba5, addClean5, ostalo5};
                op.addClean(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, clUsluga);
                odabranaUsluga.setText("Čišćenje sobe");
                dodanaUsluga.setImageDrawable(getDrawable(R.drawable.cleaningicon));
                openedRoom = 0;
                openedRoomActivity = 5;
            }
        });
        addClean6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba6, addClean6, ostalo6};
                op.addClean(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, clUsluga);
                odabranaUsluga.setText("Čišćenje sobe");
                dodanaUsluga.setImageDrawable(getDrawable(R.drawable.cleaningicon));
                openedRoom = 0;
                openedRoomActivity = 6;
            }
        });
        addClean7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba7, addClean7, ostalo7};
                op.addClean(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, clUsluga);
                odabranaUsluga.setText("Čišćenje sobe");
                dodanaUsluga.setImageDrawable(getDrawable(R.drawable.cleaningicon));
                openedRoom = 0;
                openedRoomActivity = 7;
            }
        });
        addClean8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba8, addClean8, ostalo8};
                op.addClean(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, clUsluga);
                odabranaUsluga.setText("Čišćenje sobe");
                dodanaUsluga.setImageDrawable(getDrawable(R.drawable.cleaningicon));
                openedRoom = 0;
                openedRoomActivity = 8;
            }
        });
        addClean9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba9, addClean9, ostalo9};
                op.addClean(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, clUsluga);
                odabranaUsluga.setText("Čišćenje sobe");
                dodanaUsluga.setImageDrawable(getDrawable(R.drawable.cleaningicon));
                openedRoom = 0;
                openedRoomActivity = 9;
            }
        });
        addClean10.setOnClickListener(view -> {
            TextView[] tvs = {infoSoba10, addClean10, ostalo10};
            op.addClean(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, clUsluga);
            odabranaUsluga.setText("Čišćenje sobe");
            dodanaUsluga.setImageDrawable(getDrawable(R.drawable.cleaningicon));
            openedRoom = 0;
            openedRoomActivity = 10;
        });


        ostalo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba1, addClean1, ostalo1};
                op.addOstalo(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, izborUsluge, clUsluga);
                odabranaUsluga.setText("Izaberite uslugu");
                terminUsluge.setText("Termin");
                openedRoom = 0;
                openedRoomActivity = 1;
            }
        });
        ostalo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba2, addClean2, ostalo2};
                op.addOstalo(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, izborUsluge, clUsluga);
                odabranaUsluga.setText("Izaberite uslugu");
                terminUsluge.setText("Termin");
                openedRoom = 0;
                openedRoomActivity = 2;
            }
        });
        ostalo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba3, addClean3, ostalo3};
                op.addOstalo(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, izborUsluge, clUsluga);
                odabranaUsluga.setText("Izaberite uslugu");
                terminUsluge.setText("Termin");
                openedRoom = 0;
                openedRoomActivity = 3;
            }
        });
        ostalo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba4, addClean4, ostalo4};
                op.addOstalo(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, izborUsluge, clUsluga);
                odabranaUsluga.setText("Izaberite uslugu");
                terminUsluge.setText("Termin");
                openedRoom = 0;
                openedRoomActivity = 4;
            }
        });
        ostalo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba5, addClean5, ostalo5};
                op.addOstalo(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, izborUsluge, clUsluga);
                odabranaUsluga.setText("Izaberite uslugu");
                terminUsluge.setText("Termin");
                openedRoom = 0;
                openedRoomActivity = 5;
            }
        });
        ostalo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba6, addClean6, ostalo6};
                op.addOstalo(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, izborUsluge, clUsluga);
                odabranaUsluga.setText("Izaberite uslugu");
                terminUsluge.setText("Termin");
                openedRoom = 0;
                openedRoomActivity = 6;
            }
        });
        ostalo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba7, addClean7, ostalo7};
                op.addOstalo(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, izborUsluge, clUsluga);
                odabranaUsluga.setText("Izaberite uslugu");
                terminUsluge.setText("Termin");
                openedRoom = 0;
                openedRoomActivity = 7;
            }
        });
        ostalo8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba8, addClean8, ostalo8};
                op.addOstalo(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, izborUsluge, clUsluga);
                odabranaUsluga.setText("Izaberite uslugu");
                terminUsluge.setText("Termin");
                openedRoom = 0;
                openedRoomActivity = 8;
            }
        });
        ostalo9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba9, addClean9, ostalo9};
                op.addOstalo(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, izborUsluge, clUsluga);
                odabranaUsluga.setText("Izaberite uslugu");
                terminUsluge.setText("Termin");
                openedRoom = 0;
                openedRoomActivity = 9;
            }
        });
        ostalo10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView[] tvs = {infoSoba10, addClean10, ostalo10};
                op.addOstalo(getApplicationContext(), izborUsluge, tvs, dodanaUsluga, izborUsluge, clUsluga);
                odabranaUsluga.setText("Izaberite uslugu");
                terminUsluge.setText("Termin");
                openedRoom = 0;
                openedRoomActivity = 10;
            }
        });

        //DROP DOWN ZA KAT , SOBE, USLUGE, VRIJEME USLUGE
        izborKat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAlreadyOpenKat) {
                    op.closeDropDowns(getApplicationContext(), clIzborProstorije, llIzborUsluge, llIzborVremenaUsluge, clIzborKata);
                    isAlreadyOpenKat = false;
                } else {
                    op.closeDropDowns(getApplicationContext(), clIzborProstorije, llIzborUsluge, llIzborVremenaUsluge);
                    clIzborKata.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.BounceInDown).duration(500).repeat(0).playOn(clIzborKata);
                    isAlreadyOpenKat = true;
                    isAlreadyOpenProstor = false;
                    isAlreadyOpenUsluge = false;
                    isAlreadyOpenVrijeme = false;
                }
            }
        });
        izborProstor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAlreadyOpenProstor) {
                    op.closeDropDowns(getApplicationContext(), clIzborProstorije, llIzborUsluge, llIzborVremenaUsluge, clIzborKata);
                    isAlreadyOpenProstor = false;
                } else {
                    op.closeDropDowns(getApplicationContext(), llIzborUsluge, clIzborKata, llIzborVremenaUsluge);
                    clIzborProstorije.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.BounceInDown).duration(500).repeat(0).playOn(clIzborProstorije);
                    isAlreadyOpenKat = false;
                    isAlreadyOpenProstor = true;
                    isAlreadyOpenUsluge = false;
                    isAlreadyOpenVrijeme = false;
                }
            }
        });
        izborUsluge.setOnClickListener(view -> {
            if (isAlreadyOpenUsluge) {
                op.closeDropDowns(getApplicationContext(), clIzborProstorije, llIzborUsluge, llIzborVremenaUsluge, clIzborKata);
                isAlreadyOpenUsluge = false;
            } else {
                op.closeDropDowns(getApplicationContext(), clIzborProstorije, clIzborKata, llIzborVremenaUsluge);
                llIzborUsluge.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceInDown).duration(500).repeat(0).playOn(llIzborUsluge);
                isAlreadyOpenKat = false;
                isAlreadyOpenProstor = false;
                isAlreadyOpenUsluge = true;
                isAlreadyOpenVrijeme = false;
            }
        });
        izborVremenaUsluge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generirajVrijeme();
                if (isAlreadyOpenVrijeme) {
                    op.closeDropDowns(getApplicationContext(), clIzborProstorije, llIzborUsluge, llIzborVremenaUsluge, clIzborKata);
                    isAlreadyOpenVrijeme = false;
                } else {
                    op.closeDropDowns(getApplicationContext(), clIzborProstorije, clIzborKata, llIzborUsluge);
                    llIzborVremenaUsluge.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.BounceInDown).duration(500).repeat(0).playOn(llIzborVremenaUsluge);
                    isAlreadyOpenKat = false;
                    isAlreadyOpenProstor = false;
                    isAlreadyOpenUsluge = false;
                    isAlreadyOpenVrijeme = true;
                }
            }
        });

        //IZBOR KATA
        prvaOpcijaKat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floors[0] = Integer.parseInt(brojKata.getText().charAt(0) + "");
                Arrays.sort(floors);
                brojKata.setText(prvaOpcijaKat.getText().toString());
                setRoomNumbers();
            }
        });
        drugaOpcijaKat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floors[1] = Integer.parseInt(brojKata.getText().charAt(0) + "");
                Arrays.sort(floors);
                brojKata.setText(drugaOpcijaKat.getText().toString());
                setRoomNumbers();
            }
        });
        trecaOpcijaKat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floors[2] = Integer.parseInt(brojKata.getText().charAt(0) + "");
                Arrays.sort(floors);
                brojKata.setText(trecaOpcijaKat.getText().toString());
                setRoomNumbers();

            }
        });

        infoSoba1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivityVO.this, InfoRoomActivityVO.class);
                intent.putExtra("roomNumber", "1");
                startActivity(intent);
            }
        });

        infoSoba2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivityVO.this, InfoRoomActivityVO.class);
                intent.putExtra("roomNumber", "2");
                startActivity(intent);
            }
        });

        infoSoba3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivityVO.this, InfoRoomActivityVO.class);
                intent.putExtra("roomNumber", "3");
                startActivity(intent);
            }
        });

        infoSoba4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivityVO.this, InfoRoomActivityVO.class);
                intent.putExtra("roomNumber", "4");
                startActivity(intent);
            }
        });

        infoSoba5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivityVO.this, InfoRoomActivityVO.class);
                startActivity(intent);
            }
        });

        infoSoba6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivityVO.this, InfoRoomActivityVO.class);
                startActivity(intent);
            }
        });

        infoSoba7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivityVO.this, InfoRoomActivityVO.class);
                startActivity(intent);
            }
        });

        infoSoba8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivityVO.this, InfoRoomActivityVO.class);
                startActivity(intent);
            }
        });

        infoSoba9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivityVO.this, InfoRoomActivityVO.class);
                startActivity(intent);
            }
        });

        infoSoba10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivityVO.this, InfoRoomActivityVO.class);
                startActivity(intent);
            }
        });

        potvrdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (odabranaUsluga.getText().toString().equals("Izaberite uslugu") || terminUsluge.getText().toString().equals("Termin")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Molim vas izaberite uslugu i njen termin", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (odabranaUsluga.getText().toString().equals("Izaberite uslugu")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Molim vas izaberite uslugu", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (terminUsluge.getText().toString().equals("Termin")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Molim vas izaberite termin usluge", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Object[] assets = findAssets(openedRoomActivity);
                    ImageView clean = (ImageView) assets[0];
                    ImageView food = (ImageView) assets[1];
                    ImageView bedMake = (ImageView) assets[2];
                    String odabranaAktivnost = odabranaUsluga.getText().toString();
                    switch (odabranaAktivnost) {
                        case "Posluga u sobu":
                            food.setVisibility(View.VISIBLE);
                            break;
                        case "Promijena posteljine":
                            bedMake.setVisibility(View.VISIBLE);
                            break;
                        case "Nadopuna materijala u sobi":
                            clean.setVisibility(View.VISIBLE);
                            break;
                    }
                    op.closeRoomFast(getApplicationContext(), clUsluga);
                }
            }
        });
    }

    public Object[] findAssets(int openedRoom) {
        int trenutnoVrijeme;
        int vrijemeAktivnost;
        Animation connectingAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.error_anim);
        switch (openedRoom) {
            case 1:
                trenutnoVrijeme = Integer.parseInt(currentTime.getText().toString().replace(":", ""));
                vrijemeAktivnost = Integer.parseInt(terminUsluge.getText().toString().replace(":", ""));
                if ((vrijemeAktivnost - trenutnoVrijeme) < 30) {
                    error1.setImageDrawable(getDrawable(R.drawable.exclamationred));
                    error1.startAnimation(connectingAnimation);
                } else if ((vrijemeAktivnost - trenutnoVrijeme) < 60) {
                    error1.setImageDrawable(getDrawable(R.drawable.exclamation));
                    error1.startAnimation(connectingAnimation);
                }
                return new Object[]{clean1, food1, bedMake1, profile1};
            case 2:
                trenutnoVrijeme = Integer.parseInt(currentTime.getText().toString().replace(":", ""));
                vrijemeAktivnost = Integer.parseInt(terminUsluge.getText().toString().replace(":", ""));
                if ((vrijemeAktivnost - trenutnoVrijeme) < 30) {
                    error2.setImageDrawable(getDrawable(R.drawable.exclamationred));
                    error2.startAnimation(connectingAnimation);
                } else if ((vrijemeAktivnost - trenutnoVrijeme) < 60) {
                    error2.setImageDrawable(getDrawable(R.drawable.exclamation));
                    error2.startAnimation(connectingAnimation);
                }
                return new Object[]{clean2, food2, bedMake2, profile2};
            case 3:
                trenutnoVrijeme = Integer.parseInt(currentTime.getText().toString().replace(":", ""));
                vrijemeAktivnost = Integer.parseInt(terminUsluge.getText().toString().replace(":", ""));
                if ((vrijemeAktivnost - trenutnoVrijeme) < 30) {
                    error3.setImageDrawable(getDrawable(R.drawable.exclamationred));
                    error3.startAnimation(connectingAnimation);
                } else if ((vrijemeAktivnost - trenutnoVrijeme) < 60) {
                    error3.setImageDrawable(getDrawable(R.drawable.exclamation));
                    error3.startAnimation(connectingAnimation);
                }
                return new Object[]{clean3, food3, bedMake3, profile3};
            case 4:
                trenutnoVrijeme = Integer.parseInt(currentTime.getText().toString().replace(":", ""));
                vrijemeAktivnost = Integer.parseInt(terminUsluge.getText().toString().replace(":", ""));
                if ((vrijemeAktivnost - trenutnoVrijeme) < 30) {
                    error4.setImageDrawable(getDrawable(R.drawable.exclamationred));
                    error4.startAnimation(connectingAnimation);
                } else if ((vrijemeAktivnost - trenutnoVrijeme) < 60) {
                    error4.setImageDrawable(getDrawable(R.drawable.exclamation));
                    error4.startAnimation(connectingAnimation);
                }
                return new Object[]{clean4, food4, bedMake4, profile4};
            case 5:
                trenutnoVrijeme = Integer.parseInt(currentTime.getText().toString().replace(":", ""));
                vrijemeAktivnost = Integer.parseInt(terminUsluge.getText().toString().replace(":", ""));
                if ((vrijemeAktivnost - trenutnoVrijeme) < 30) {
                    error5.setImageDrawable(getDrawable(R.drawable.exclamationred));
                    error5.startAnimation(connectingAnimation);
                } else if ((vrijemeAktivnost - trenutnoVrijeme) < 60) {
                    error5.setImageDrawable(getDrawable(R.drawable.exclamation));
                    error5.startAnimation(connectingAnimation);
                }
                return new Object[]{clean5, food5, bedMake5, profile5};
            case 6:
                trenutnoVrijeme = Integer.parseInt(currentTime.getText().toString().replace(":", ""));
                vrijemeAktivnost = Integer.parseInt(terminUsluge.getText().toString().replace(":", ""));
                if ((vrijemeAktivnost - trenutnoVrijeme) < 30) {
                    error6.setImageDrawable(getDrawable(R.drawable.exclamationred));
                    error6.startAnimation(connectingAnimation);
                } else if ((vrijemeAktivnost - trenutnoVrijeme) < 60) {
                    error6.setImageDrawable(getDrawable(R.drawable.exclamation));
                    error6.startAnimation(connectingAnimation);
                }
                return new Object[]{clean6, food6, bedMake6, profile6};
            case 7:
                trenutnoVrijeme = Integer.parseInt(currentTime.getText().toString().replace(":", ""));
                vrijemeAktivnost = Integer.parseInt(terminUsluge.getText().toString().replace(":", ""));
                if ((vrijemeAktivnost - trenutnoVrijeme) < 30) {
                    error7.setImageDrawable(getDrawable(R.drawable.exclamationred));
                    error7.startAnimation(connectingAnimation);
                } else if ((vrijemeAktivnost - trenutnoVrijeme) < 60) {
                    error7.setImageDrawable(getDrawable(R.drawable.exclamation));
                    error7.startAnimation(connectingAnimation);
                }
                return new Object[]{clean7, food7, bedMake7, profile7};
            case 8:
                trenutnoVrijeme = Integer.parseInt(currentTime.getText().toString().replace(":", ""));
                vrijemeAktivnost = Integer.parseInt(terminUsluge.getText().toString().replace(":", ""));
                if ((vrijemeAktivnost - trenutnoVrijeme) < 30) {
                    error8.setImageDrawable(getDrawable(R.drawable.exclamationred));
                    error8.startAnimation(connectingAnimation);
                } else if ((vrijemeAktivnost - trenutnoVrijeme) < 60) {
                    error8.setImageDrawable(getDrawable(R.drawable.exclamation));
                    error8.startAnimation(connectingAnimation);
                }
                return new Object[]{clean8, food8, bedMake8, profile8};
            case 9:
                trenutnoVrijeme = Integer.parseInt(currentTime.getText().toString().replace(":", ""));
                vrijemeAktivnost = Integer.parseInt(terminUsluge.getText().toString().replace(":", ""));
                if ((vrijemeAktivnost - trenutnoVrijeme) < 30) {
                    error9.setImageDrawable(getDrawable(R.drawable.exclamationred));
                    error9.startAnimation(connectingAnimation);
                } else if ((vrijemeAktivnost - trenutnoVrijeme) < 60) {
                    error9.setImageDrawable(getDrawable(R.drawable.exclamation));
                    error9.startAnimation(connectingAnimation);
                }
                return new Object[]{clean9, food9, bedMake9, profile9};
            default:
                trenutnoVrijeme = Integer.parseInt(currentTime.getText().toString().replace(":", ""));
                vrijemeAktivnost = Integer.parseInt(terminUsluge.getText().toString().replace(":", ""));
                if ((vrijemeAktivnost - trenutnoVrijeme) < 30) {
                    error10.setImageDrawable(getDrawable(R.drawable.exclamationred));
                    error10.startAnimation(connectingAnimation);
                } else if ((vrijemeAktivnost - trenutnoVrijeme) < 60) {
                    error10.setImageDrawable(getDrawable(R.drawable.exclamation));
                    error10.startAnimation(connectingAnimation);
                }
                return new Object[]{clean10, food10, bedMake10, profile10};
        }
    }

    public void generirajVrijeme() {
        String currTime = currentTime.getText().toString();
        int baseTime = Integer.parseInt(currTime.replace(":", ""));
        int minutes = (baseTime / 30) % 2 == 1 ? 30 : 0;
        baseTime = baseTime / 100;
        System.out.println(baseTime);
        baseTime = baseTime * 60 + minutes;
        baseTime += 30;
        String rest = baseTime % 60 == 0 ? "00" : String.valueOf(baseTime % 60);
        if ((baseTime / 60) < 10) {
            vrijemeUsluge1.setText("0" + (baseTime / 60) + ":" + (rest));
        } else {

            vrijemeUsluge1.setText((baseTime / 60) + ":" + (rest));
        }
        baseTime += 30;
        rest = baseTime % 60 == 0 ? "00" : String.valueOf(baseTime % 60);
        if (baseTime < 10) {
            vrijemeUsluge2.setText("0" + (baseTime / 60) + ":" + (rest));
        } else {
            vrijemeUsluge2.setText((baseTime / 60) + ":" + (rest));
        }
        baseTime += 30;
        rest = baseTime % 60 == 0 ? "00" : String.valueOf(baseTime % 60);
        if (baseTime < 10) {
            vrijemeUsluge3.setText("0" + (baseTime / 60) + ":" + (rest));
        } else {
            vrijemeUsluge3.setText((baseTime / 60) + ":" + (rest));
        }
        baseTime += 30;
        rest = baseTime % 60 == 0 ? "00" : String.valueOf(baseTime % 60);
        if (baseTime < 10) {
            vrijemeUsluge4.setText("0" + (baseTime / 60) + ":" + (rest));
        } else {
            vrijemeUsluge4.setText((baseTime / 60) + ":" + (rest));
        }
        baseTime += 30;
        rest = baseTime % 60 == 0 ? "00" : String.valueOf(baseTime % 60);
        if (baseTime < 10) {
            vrijemeUsluge5.setText("0" + (baseTime / 60) + ":" + (rest));
        } else {
            vrijemeUsluge5.setText((baseTime / 60) + ":" + (rest));
        }
        baseTime += 30;
        rest = baseTime % 60 == 0 ? "00" : String.valueOf(baseTime % 60);
        if (baseTime < 10) {
            vrijemeUsluge6.setText("0" + (baseTime / 60) + ":" + (rest));
        } else {
            vrijemeUsluge6.setText((baseTime / 60) + ":" + (rest));
        }
        baseTime += 30;
        rest = baseTime % 60 == 0 ? "00" : String.valueOf(baseTime % 60);
        if (baseTime < 10) {
            vrijemeUsluge7.setText("0" + (baseTime / 60) + ":" + (rest));
        } else {
            vrijemeUsluge7.setText((baseTime / 60) + ":" + (rest));
        }
        baseTime += 30;
        rest = baseTime % 60 == 0 ? "00" : String.valueOf(baseTime % 60);
        if (baseTime < 10) {
            vrijemeUsluge8.setText("0" + (baseTime / 60) + ":" + (rest));
        } else {
            vrijemeUsluge8.setText((baseTime / 60) + ":" + (rest));
        }
    }

    public TextView currRoomInfo(int number) {
        switch (number) {
            case 1:
                return infoSoba1;
            case 2:
                return infoSoba2;
            case 3:
                return infoSoba3;
            case 4:
                return infoSoba4;
            case 5:
                return infoSoba5;
            case 6:
                return infoSoba6;
            case 7:
                return infoSoba7;
            case 8:
                return infoSoba8;
            case 9:
                return infoSoba9;
            default:
                return infoSoba10;
        }
    }

    public TextView currRoomAddClean(int number) {
        switch (number) {
            case 1:
                return addClean1;
            case 2:
                return addClean2;
            case 3:
                return addClean3;
            case 4:
                return addClean4;
            case 5:
                return addClean5;
            case 6:
                return addClean6;
            case 7:
                return addClean7;
            case 8:
                return addClean8;
            case 9:
                return addClean9;
            default:
                return addClean10;
        }
    }

    public TextView currRoomAddOther(int number) {
        switch (number) {
            case 1:
                return ostalo1;
            case 2:
                return ostalo2;
            case 3:
                return ostalo3;
            case 4:
                return ostalo4;
            case 5:
                return ostalo5;
            case 6:
                return ostalo6;
            case 7:
                return ostalo7;
            case 8:
                return ostalo8;
            case 9:
                return ostalo9;
            default:
                return ostalo10;
        }
    }

    public void setRoomNumbers() {
        prvaOpcijaKat.setText(String.valueOf(floors[0] + ".kat"));
        drugaOpcijaKat.setText(String.valueOf(floors[1] + ".kat"));
        trecaOpcijaKat.setText(String.valueOf(floors[2] + ".kat"));
        brojSobe1.setText(String.valueOf(brojKata.getText().charAt(0) + "" + brojSobe1.getText().charAt(1)));
        brojSobe2.setText(String.valueOf(brojKata.getText().charAt(0) + "" + brojSobe2.getText().charAt(1)));
        brojSobe3.setText(String.valueOf(brojKata.getText().charAt(0) + "" + brojSobe3.getText().charAt(1)));
        brojSobe4.setText(String.valueOf(brojKata.getText().charAt(0) + "" + brojSobe4.getText().charAt(1)));
        brojSobe5.setText(String.valueOf(brojKata.getText().charAt(0) + "" + brojSobe5.getText().charAt(1)));
        brojSobe6.setText(String.valueOf(brojKata.getText().charAt(0) + "" + brojSobe6.getText().charAt(1)));
        brojSobe7.setText(String.valueOf(brojKata.getText().charAt(0) + "" + brojSobe7.getText().charAt(1)));
        brojSobe8.setText(String.valueOf(brojKata.getText().charAt(0) + "" + brojSobe8.getText().charAt(1)));
        brojSobe9.setText(String.valueOf(brojKata.getText().charAt(0) + "" + brojSobe9.getText().charAt(1)));
        brojSobe10.setText(String.valueOf(brojKata.getText().charAt(0) + "" + brojSobe10.getText().charAt(1)));
    }

    public void openRoom(int roomNumber) {
        clIzborKata.setVisibility(View.INVISIBLE);
        clIzborProstorije.setVisibility(View.INVISIBLE);
        clUsluga.setVisibility(View.INVISIBLE);
        llIzborUsluge.setVisibility(View.INVISIBLE);
        llIzborVremenaUsluge.setVisibility(View.INVISIBLE);
        boolean same = roomNumber == openedRoom;

        /*if(openedRoom != 0){
            System.out.println("AKTIVIRANO 1");
            op.closeRoom(currRoomInfo(openedRoom), currRoomAddClean(openedRoom), currRoomAddOther(openedRoom), getApplicationContext());
        }*/
        if (openedRoom != 0) {
            System.out.println("AKTIVIRANO 2");
            op.closeRoom(currRoomInfo(openedRoom), currRoomAddClean(openedRoom), currRoomAddOther(openedRoom), getApplicationContext());
            openedRoom = 0;
        }
        if (openedRoom != roomNumber && !same) {
            System.out.println("AKTIVIRANO 3");
            switch (roomNumber) {
                case 1:
                    op.openRoom(infoSoba1, addClean1, ostalo1);
                    break;
                case 2:
                    op.openRoom(infoSoba2, addClean2, ostalo2);
                    break;
                case 3:
                    op.openRoom(infoSoba3, addClean3, ostalo3);
                    break;
                case 4:
                    op.openRoom(infoSoba4, addClean4, ostalo4);
                    break;
                case 5:
                    op.openRoom(infoSoba5, addClean5, ostalo5);
                    break;
                case 6:
                    op.openRoom(infoSoba6, addClean6, ostalo6);
                    break;
                case 7:
                    op.openRoom(infoSoba7, addClean7, ostalo7);
                    break;
                case 8:
                    op.openRoom(infoSoba8, addClean8, ostalo8);
                    break;
                case 9:
                    op.openRoom(infoSoba9, addClean9, ostalo9);
                    break;
                default:
                    op.openRoom(infoSoba10, addClean10, ostalo10);
                    break;
            }
            openedRoom = roomNumber;
        }
    }

    //time management
    public void setTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        currentTime.setText(now.format(dtf));
    }

}