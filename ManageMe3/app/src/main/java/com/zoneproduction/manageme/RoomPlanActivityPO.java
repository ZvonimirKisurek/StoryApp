package com.zoneproduction.manageme;

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

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Arrays;

public class RoomPlanActivityPO extends AppCompatActivity {

    private TextView infoSoba1, infoSoba2, infoSoba3, infoSoba4, infoSoba5, infoSoba6, infoSoba7, infoSoba8, infoSoba9, infoSoba10,
            brojKata, imeProstorije, brojSobe1, brojSobe2, brojSobe3, brojSobe4, brojSobe5, brojSobe6, brojSobe7, brojSobe8,
            brojSobe9, brojSobe10, terminUsluge, hint, odabranaUsluga, prvaOpcijaKat, drugaOpcijaKat, trecaOpcijaKat, prostor1, prostor2, currentTime, vrijemeUsluge1,
            vrijemeUsluge2, vrijemeUsluge3, vrijemeUsluge4, vrijemeUsluge5, vrijemeUsluge6, vrijemeUsluge7, vrijemeUsluge8, opcijaUsluge1, opcijaUsluge2, opcijaUsluge3;
    ImageButton izborKat, izborProstor, izborUsluge, izborVremenaUsluge;
    LinearLayout soba1, soba2, soba3, soba4, soba5, soba6, soba7, soba8, soba9, soba10;
    ImageView error1, error2, error3, error4, error5, error6, error7, error8, error9, error10, profile1, profile2,
            profile3, profile4, profile5, profile6, profile7, profile8, profile9, profile10, clean1, clean2, clean3, clean4, clean5, clean6, clean7, clean8, clean9,
            clean10, food1, food2, food3, food4, food5, food6, food7, food8, food9, food10, dodanaUsluga, bedMake1, bedMake2, bedMake3, bedMake4, bedMake5, bedMake6,
            bedMake7, bedMake8, bedMake9, bedMake10;
    OpenClose op = new OpenClose();
    Button potvrdi;
    int openedRoom = 0;
    ConstraintLayout clUsluga, roomPlanActivity;
    LinearLayout clIzborKata, clIzborProstorije, backToMain, llIzborUsluge, llIzborVremenaUsluge;
    int[] floors = {2, 3, 4};
    int openedRoomActivity = 0;
    boolean isAlreadyOpenKat = false, isAlreadyOpenProstor = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_plan_po);

        Animation connectingAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.error_anim);
        currentTime = findViewById(R.id.textCurrentTimeRP);
        opcijaUsluge1 = findViewById(R.id.textPrvaOpcijaUslugeRP);
        opcijaUsluge2 = findViewById(R.id.textDrugaOpcijaUslugeRP);
        opcijaUsluge3 = findViewById(R.id.textTrecaOpcijaUslugeRP);
        llIzborUsluge = findViewById(R.id.llIzborUslugeRP);
        izborUsluge = findViewById(R.id.imageUslugePullUpRP);
        izborVremenaUsluge = findViewById(R.id.imageTerminiPullUpRP);
        llIzborVremenaUsluge = findViewById(R.id.llIzborVremenaUslugeRP);
        roomPlanActivity = findViewById(R.id.clRoomPlanActivityPO);
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
        op.setTime(currentTime);

        roomPlanActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                op.closeRoomFast(getApplicationContext(), clIzborKata, clIzborProstorije, llIzborUsluge, llIzborVremenaUsluge);
                if (openedRoom != 0) {
                    op.closeRoomFast(getApplicationContext(), currRoomInfo(openedRoom), clUsluga);
                    openedRoom = 0;
                }
            }
        });

        //Odabrati vrijeme usluge
        vrijemeUsluge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                terminUsluge.setText(vrijemeUsluge1.getText().toString());
            }
        });
        vrijemeUsluge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                terminUsluge.setText(vrijemeUsluge2.getText().toString());
            }
        });
        vrijemeUsluge3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                terminUsluge.setText(vrijemeUsluge3.getText().toString());
            }
        });
        vrijemeUsluge4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                terminUsluge.setText(vrijemeUsluge4.getText().toString());
            }
        });
        vrijemeUsluge5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                terminUsluge.setText(vrijemeUsluge5.getText().toString());
            }
        });
        vrijemeUsluge6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                terminUsluge.setText(vrijemeUsluge6.getText().toString());
            }
        });
        vrijemeUsluge7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                terminUsluge.setText(vrijemeUsluge7.getText().toString());
            }
        });
        vrijemeUsluge8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                terminUsluge.setText(vrijemeUsluge8.getText().toString());
            }
        });


        //nazad na MainActivity
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoomPlanActivityPO.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        prostor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                Intent intent = new Intent(RoomPlanActivityPO.this, StorageActivityPO.class);
                startActivity(intent);
                finish();
            }
        });

        prostor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                Intent intent = new Intent(RoomPlanActivityPO.this, KitchenPlanActivityPO.class);
                startActivity(intent);
            }
        });

        //set on Click za sobe
        soba1.setOnClickListener(view -> {
            openRoom(1);
            op.setTime(currentTime);
        });
        soba2.setOnClickListener(view -> {
            op.setTime(currentTime);
            openRoom(2);
        });
        soba3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(3);
                op.setTime(currentTime);
            }
        });
        soba4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(4);
                op.setTime(currentTime);
            }
        });
        soba5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(5);
                op.setTime(currentTime);
            }
        });
        soba6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(6);
                op.setTime(currentTime);
            }
        });
        soba7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(7);
                op.setTime(currentTime);
            }
        });
        soba8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(8);
                op.setTime(currentTime);
            }
        });
        soba9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(9);
                op.setTime(currentTime);
            }
        });
        soba10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRoom(10);
                op.setTime(currentTime);
            }
        });

        //set on Click za usluge

        //DROP DOWN ZA KAT , SOBE, USLUGE, VRIJEME USLUGE
        izborKat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                if (isAlreadyOpenKat) {
                    op.closeDropDowns(getApplicationContext(), clIzborProstorije, llIzborUsluge, llIzborVremenaUsluge, clIzborKata, currRoomInfo(openedRoom));
                    openedRoom = 0;
                    isAlreadyOpenKat = false;
                } else {
                    op.closeDropDowns(getApplicationContext(), clIzborProstorije, llIzborUsluge, llIzborVremenaUsluge, currRoomInfo(openedRoom));
                    clIzborKata.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.BounceInDown).duration(500).repeat(0).playOn(clIzborKata);
                    isAlreadyOpenKat = true;
                    openedRoom = 0;
                    isAlreadyOpenProstor = false;
                }
            }
        });
        izborProstor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                if (isAlreadyOpenProstor) {
                    op.closeDropDowns(getApplicationContext(), clIzborProstorije, llIzborUsluge, llIzborVremenaUsluge, clIzborKata, currRoomInfo(openedRoom));
                    openedRoom = 0;
                    isAlreadyOpenProstor = false;
                } else {
                    op.closeDropDowns(getApplicationContext(), llIzborUsluge, clIzborKata, llIzborVremenaUsluge, currRoomInfo(openedRoom));
                    clIzborProstorije.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.BounceInDown).duration(500).repeat(0).playOn(clIzborProstorije);
                    isAlreadyOpenKat = false;
                    openedRoom = 0;
                    isAlreadyOpenProstor = true;
                }
            }
        });

        //IZBOR KATA
        prvaOpcijaKat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                floors[0] = Integer.parseInt(brojKata.getText().charAt(0) + "");
                Arrays.sort(floors);
                brojKata.setText(prvaOpcijaKat.getText().toString());
                setRoomNumbers();
            }
        });
        drugaOpcijaKat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                floors[1] = Integer.parseInt(brojKata.getText().charAt(0) + "");
                Arrays.sort(floors);
                brojKata.setText(drugaOpcijaKat.getText().toString());
                setRoomNumbers();
            }
        });
        trecaOpcijaKat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                floors[2] = Integer.parseInt(brojKata.getText().charAt(0) + "");
                Arrays.sort(floors);
                brojKata.setText(trecaOpcijaKat.getText().toString());
                setRoomNumbers();

            }
        });

        infoSoba1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                Intent intent = new Intent(RoomPlanActivityPO.this, InfoRoomActivityPO.class);
                intent.putExtra("roomNumber", "1");
                startActivity(intent);
            }
        });

        infoSoba2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                Intent intent = new Intent(RoomPlanActivityPO.this, InfoRoomActivityPO.class);
                intent.putExtra("roomNumber", "2");
                startActivity(intent);
            }
        });

        infoSoba3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                Intent intent = new Intent(RoomPlanActivityPO.this, InfoRoomActivityPO.class);
                intent.putExtra("roomNumber", "3");
                startActivity(intent);
            }
        });

        infoSoba4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                Intent intent = new Intent(RoomPlanActivityPO.this, InfoRoomActivityPO.class);
                intent.putExtra("roomNumber", "4");
                startActivity(intent);
            }
        });

        infoSoba5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                Intent intent = new Intent(RoomPlanActivityPO.this, InfoRoomActivityPO.class);
                startActivity(intent);
            }
        });

        infoSoba6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                Intent intent = new Intent(RoomPlanActivityPO.this, InfoRoomActivityPO.class);
                startActivity(intent);
            }
        });

        infoSoba7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                Intent intent = new Intent(RoomPlanActivityPO.this, InfoRoomActivityPO.class);
                startActivity(intent);
            }
        });

        infoSoba8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                Intent intent = new Intent(RoomPlanActivityPO.this, InfoRoomActivityPO.class);
                startActivity(intent);
            }
        });

        infoSoba9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                Intent intent = new Intent(RoomPlanActivityPO.this, InfoRoomActivityPO.class);
                startActivity(intent);
            }
        });

        infoSoba10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                Intent intent = new Intent(RoomPlanActivityPO.this, InfoRoomActivityPO.class);
                startActivity(intent);
            }
        });
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
            case 10:
                return infoSoba10;
            default:
                return null;
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
            op.closeRoomFast(getApplicationContext(), currRoomInfo(openedRoom));
            openedRoom = 0;
        }
        if (openedRoom != roomNumber && !same) {
            System.out.println("AKTIVIRANO 3");
            switch (roomNumber) {
                case 1:
                    op.openRoomFast(getApplicationContext(), infoSoba1);
                    break;
                case 2:
                    op.openRoomFast(getApplicationContext(), infoSoba2);
                    break;
                case 3:
                    op.openRoomFast(getApplicationContext(), infoSoba3);
                    break;
                case 4:
                    op.openRoomFast(getApplicationContext(), infoSoba4);
                    break;
                case 5:
                    op.openRoomFast(getApplicationContext(), infoSoba5);
                    break;
                case 6:
                    op.openRoomFast(getApplicationContext(), infoSoba6);
                    break;
                case 7:
                    op.openRoomFast(getApplicationContext(), infoSoba7);
                    break;
                case 8:
                    op.openRoomFast(getApplicationContext(), infoSoba8);
                    break;
                case 9:
                    op.openRoomFast(getApplicationContext(), infoSoba9);
                    break;
                default:
                    op.openRoomFast(getApplicationContext(), infoSoba10);
                    break;
            }
            openedRoom = roomNumber;
        }
    }

    //time management


}