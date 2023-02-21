package com.zoneproduction.hotelmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class RoomPlanActivity extends AppCompatActivity {

    private TextView infoSoba1, infoSoba2, infoSoba3, infoSoba4, infoSoba5, infoSoba6, infoSoba7, infoSoba8, infoSoba9, infoSoba10,
                addClean1, addClean2, addClean3, addClean4, addClean5, addClean6, addClean7, addClean8, addClean9, addClean10, ostalo1, ostalo2, ostalo3, ostalo4, ostalo5, ostalo6,
                ostalo7, ostalo8, ostalo9, ostalo10, brojKata, imeProstorije, brojSobe1, brojSobe2, brojSobe3, brojSobe4, brojSobe5, brojSobe6, brojSobe7, brojSobe8, brojSobe9, brojSobe10,
                terminUsluge, hint, odabranaUsluga, prvaOpcijaKat, drugaOpcijaKat, trecaOpcijaKat;
    ImageButton izborKat, izborProstor, dropUpUsluge;
    ImageView soba1, soba2, soba3, soba4, soba5, soba6, soba7, soba8, soba9, soba10,error1, error2, error3, error4, error5, error6, error7, error8, error9, error10, profile1, profile2,
                profile3, profile4, profile5, profile6, profile7, profile8, profile9, profile10;
    CircleImageView clean1, clean2, clean3, clean4, clean5, clean6, clean7, clean8, clean9, clean10, food1, food2, food3, food4, food5, food6, food7, food8, food9, food10, dodanaUsluga;
    OpenClose op = new OpenClose();
    Button potvrdi;
    int openedRoom = 0;
    ConstraintLayout clUsluga, roomPlanActivity;
    LinearLayout clIzborKata, clIzborProstorije, backToMain;
    int[] floors = {2,3,4};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_plan);

        roomPlanActivity = findViewById(R.id.clRoomPlanActivity);
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
        dropUpUsluge = findViewById(R.id.imageUslugePullUpRP);
        dodanaUsluga = findViewById(R.id.imageDogađajikonaRP);
        potvrdi = findViewById(R.id.buttonPotvrdiUsluguRP);
        brojKata = findViewById(R.id.textBrojEtapeRP);
        imeProstorije = findViewById(R.id.textImeEtapeRP);
        izborKat = findViewById(R.id.imageDropStageRP);
        izborProstor = findViewById(R.id.imageDropNameStageRP);
        backToMain = findViewById(R.id.llNatragRP);

        Animation animationIntro = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_faster);
        roomPlanActivity.startAnimation(animationIntro);

        Animation connectingAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.error_anim);
        error1.startAnimation(connectingAnimation);
        error2.startAnimation(connectingAnimation);
        error3.startAnimation(connectingAnimation);
        error4.startAnimation(connectingAnimation);
        error5.startAnimation(connectingAnimation);
        error6.startAnimation(connectingAnimation);
        error7.startAnimation(connectingAnimation);
        error8.startAnimation(connectingAnimation);
        error9.startAnimation(connectingAnimation);
        error10.startAnimation(connectingAnimation);
        //kako ugasiti istu animaciju
        /*
        myView.clearAnimation();
        connectingAnimation.cancel();
        connectingAnimation.reset();
         */

        //nazad na MainActivity
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //set on Click za sobe
        soba1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(1);
            }
        });
        soba2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(2);
            }
        });
        soba3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(3);
            }
        });
        soba4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(4);
            }
        });
        soba5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(5);
            }
        });
        soba6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(6);
            }
        });
        soba7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(7);
            }
        });
        soba8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(8);
            }
        });
        soba9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(9);
            }
        });
        soba10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(10);
            }
        });

        //set on Click za usluge
        addClean1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                odabranaUsluga.setText("Čišćenje sobe");
                dropUpUsluge.setClickable(false);
                dropUpUsluge.setVisibility(View.INVISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        addClean2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                odabranaUsluga.setText("Čišćenje sobe");
                dropUpUsluge.setClickable(false);
                dropUpUsluge.setVisibility(View.INVISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        addClean3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                odabranaUsluga.setText("Čišćenje sobe");
                dropUpUsluge.setClickable(false);
                dropUpUsluge.setVisibility(View.INVISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        addClean4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                odabranaUsluga.setText("Čišćenje sobe");
                dropUpUsluge.setClickable(false);
                dropUpUsluge.setVisibility(View.INVISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        addClean5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                odabranaUsluga.setText("Čišćenje sobe");
                dropUpUsluge.setClickable(false);
                dropUpUsluge.setVisibility(View.INVISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        addClean6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                odabranaUsluga.setText("Čišćenje sobe");
                dropUpUsluge.setClickable(false);
                dropUpUsluge.setVisibility(View.INVISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        addClean7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                odabranaUsluga.setText("Čišćenje sobe");
                dropUpUsluge.setClickable(false);
                dropUpUsluge.setVisibility(View.INVISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        addClean8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                odabranaUsluga.setText("Čišćenje sobe");
                dropUpUsluge.setClickable(false);
                dropUpUsluge.setVisibility(View.INVISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        addClean9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                odabranaUsluga.setText("Čišćenje sobe");
                dropUpUsluge.setClickable(false);
                dropUpUsluge.setVisibility(View.INVISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        addClean10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                odabranaUsluga.setText("Čišćenje sobe");
                dropUpUsluge.setClickable(false);
                dropUpUsluge.setVisibility(View.INVISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });


        ostalo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        ostalo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        ostalo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        ostalo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        ostalo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        ostalo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        ostalo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        ostalo8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        ostalo9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });
        ostalo10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clUsluga.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(clUsluga);
            }
        });

        //DROP DOWN ZA KAT I SOBE
        izborKat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clIzborProstorije.setVisibility(View.INVISIBLE);
                clIzborProstorije.setClickable(false);
                clIzborKata.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceInDown).duration(500).repeat(0).playOn(clIzborKata);
            }
        });
        izborProstor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clIzborKata.setVisibility(View.INVISIBLE);
                clIzborKata.setClickable(false);
                clIzborProstorije.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceInDown).duration(500).repeat(0).playOn(clIzborProstorije);
            }
        });

        //IZBOR KATA
        prvaOpcijaKat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floors[0] = Integer.parseInt(brojKata.getText().charAt(0)+"");
                Arrays.sort(floors);
                brojKata.setText(prvaOpcijaKat.getText().toString());
                setRoomNumbers();
            }
        });
        drugaOpcijaKat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floors[1] = Integer.parseInt(brojKata.getText().charAt(0)+"");
                Arrays.sort(floors);
                brojKata.setText(drugaOpcijaKat.getText().toString());
                setRoomNumbers();
            }
        });
        trecaOpcijaKat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floors[2] = Integer.parseInt(brojKata.getText().charAt(0)+"");
                Arrays.sort(floors);
                brojKata.setText(trecaOpcijaKat.getText().toString());
                setRoomNumbers();

            }
        });

        infoSoba1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivity.this, InfoRoomActivity.class);
                startActivity(intent);
            }
        });

    }

    public TextView currRoomInfo(int number){
        switch(number){
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

    public TextView currRoomAddClean(int number){
        switch(number){
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

    public TextView currRoomAddOther(int number){
        switch(number){
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

    public void setRoomNumbers(){
        prvaOpcijaKat.setText(String.valueOf(floors[0] + ".kat"));
        drugaOpcijaKat.setText(String.valueOf(floors[1] + ".kat"));
        trecaOpcijaKat.setText(String.valueOf(floors[2] + ".kat"));
        brojSobe1.setText(String.valueOf(brojKata.getText().charAt(0)+""+brojSobe1.getText().charAt(1)));
        brojSobe2.setText(String.valueOf(brojKata.getText().charAt(0)+""+brojSobe2.getText().charAt(1)));
        brojSobe3.setText(String.valueOf(brojKata.getText().charAt(0)+""+brojSobe3.getText().charAt(1)));
        brojSobe4.setText(String.valueOf(brojKata.getText().charAt(0)+""+brojSobe4.getText().charAt(1)));
        brojSobe5.setText(String.valueOf(brojKata.getText().charAt(0)+""+brojSobe5.getText().charAt(1)));
        brojSobe6.setText(String.valueOf(brojKata.getText().charAt(0)+""+brojSobe6.getText().charAt(1)));
        brojSobe7.setText(String.valueOf(brojKata.getText().charAt(0)+""+brojSobe7.getText().charAt(1)));
        brojSobe8.setText(String.valueOf(brojKata.getText().charAt(0)+""+brojSobe8.getText().charAt(1)));
        brojSobe9.setText(String.valueOf(brojKata.getText().charAt(0)+""+brojSobe9.getText().charAt(1)));
        brojSobe10.setText(String.valueOf(brojKata.getText().charAt(0)+""+brojSobe10.getText().charAt(1)));
    }

    public void openRoom(int roomNumber){
        clIzborKata.setVisibility(View.INVISIBLE);
        clIzborProstorije.setVisibility(View.INVISIBLE);
        clUsluga.setVisibility(View.INVISIBLE);
        boolean same = roomNumber == openedRoom;
        boolean closedSame = false;

        /*if(openedRoom != 0){
            System.out.println("AKTIVIRANO 1");
            op.closeRoom(currRoomInfo(openedRoom), currRoomAddClean(openedRoom), currRoomAddOther(openedRoom), getApplicationContext());
        }*/
        if(openedRoom != 0){
            System.out.println("AKTIVIRANO 2");
            op.closeRoom(currRoomInfo(openedRoom), currRoomAddClean(openedRoom), currRoomAddOther(openedRoom), getApplicationContext());
            openedRoom = 0;
        }
        if(openedRoom != roomNumber && !same){
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

}