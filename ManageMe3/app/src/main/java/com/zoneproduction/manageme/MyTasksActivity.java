package com.zoneproduction.manageme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MyTasksActivity extends AppCompatActivity {

    TextView currentTime;
    LinearLayout nazad;
    OpenClose op = new OpenClose();
    ConstraintLayout zadatak1, zadatak2, zadatak3, zadatak4, zadatak5, zadatak6, zadatak7, zadatak8, zadatak9, zadatak10, zadatak11, zadatak12, zadatak13;
    TextView detalji1, detalji2, detalji3, detalji4, detalji5, detalji6, detalji7, detalji8, detalji9, detalji10, detalji11, detalji12, detalji13;
    ImageView error1, error2, error3, error4, error5, error6, error7, error8, error9, error10, error11, error12, error13, done1, done2, done3, done4, done5,
            done6, done7, done8, done9, done10, done11, done12, done13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tasks);

        currentTime = findViewById(R.id.textCurrentTimeMT);
        nazad = findViewById(R.id.llNatragWS);
        zadatak1 = findViewById(R.id.clAktivnost1MT);
        zadatak2 = findViewById(R.id.clAktivnost2MT);
        zadatak3 = findViewById(R.id.clAktivnost3MT);
        zadatak4 = findViewById(R.id.clAktivnost4MT);
        zadatak5 = findViewById(R.id.clAktivnost5MT);
        zadatak6 = findViewById(R.id.clAktivnost6MT);
        zadatak7 = findViewById(R.id.clAktivnost7MT);
        zadatak8 = findViewById(R.id.clAktivnost8MT);
        zadatak9 = findViewById(R.id.clAktivnost9MT);
        zadatak10 = findViewById(R.id.clAktivnost10MT);
        zadatak11 = findViewById(R.id.clAktivnost11MT);
        zadatak12 = findViewById(R.id.clAktivnost12MT);
        zadatak13 = findViewById(R.id.clAktivnost13MT);
        detalji1 = findViewById(R.id.textInfoAktivnosti1MT);
        detalji2 = findViewById(R.id.textInfoAktivnosti2MT);
        detalji3 = findViewById(R.id.textInfoAktivnosti3MT);
        detalji4 = findViewById(R.id.textInfoAktivnosti4MT);
        detalji5 = findViewById(R.id.textInfoAktivnosti5MT);
        detalji6 = findViewById(R.id.textInfoAktivnosti6MT);
        detalji7 = findViewById(R.id.textInfoAktivnosti7MT);
        detalji8 = findViewById(R.id.textInfoAktivnosti8MT);
        detalji9 = findViewById(R.id.textInfoAktivnosti9MT);
        detalji10 = findViewById(R.id.textInfoAktivnosti10MT);
        detalji11 = findViewById(R.id.textInfoAktivnosti11MT);
        detalji12 = findViewById(R.id.textInfoAktivnosti12MT);
        detalji13 = findViewById(R.id.textInfoAktivnosti13MT);
        error1 = findViewById(R.id.imageErrorAktivnost1MT);
        error2 = findViewById(R.id.imageErrorAktivnost2MT);
        error3 = findViewById(R.id.imageErrorAktivnost3MT);
        error4 = findViewById(R.id.imageErrorAktivnost4MT);
        error5 = findViewById(R.id.imageErrorAktivnost5MT);
        error6 = findViewById(R.id.imageErrorAktivnost6MT);
        error7 = findViewById(R.id.imageErrorAktivnost7MT);
        error8 = findViewById(R.id.imageErrorAktivnost8MT);
        error9 = findViewById(R.id.imageErrorAktivnost9MT);
        error10 = findViewById(R.id.imageErrorAktivnost10MT);
        error11 = findViewById(R.id.imageErrorAktivnost11MT);
        error12 = findViewById(R.id.imageErrorAktivnost12MT);
        error13 = findViewById(R.id.imageErrorAktivnost13MT);
        done1 = findViewById(R.id.imageObradaAktivnosti1MT);
        done2 = findViewById(R.id.imageObradaAktivnosti2MT);
        done3 = findViewById(R.id.imageObradaAktivnosti3MT);
        done4 = findViewById(R.id.imageObradaAktivnosti4MT);
        done5 = findViewById(R.id.imageObradaAktivnosti5MT);
        done6 = findViewById(R.id.imageObradaAktivnosti6MT);
        done7 = findViewById(R.id.imageObradaAktivnosti7MT);
        done8 = findViewById(R.id.imageObradaAktivnosti8MT);
        done9 = findViewById(R.id.imageObradaAktivnosti9MT);
        done10 = findViewById(R.id.imageObradaAktivnosti10MT);
        done11 = findViewById(R.id.imageObradaAktivnosti11MT);
        done12 = findViewById(R.id.imageObradaAktivnosti12MT);
        done13 = findViewById(R.id.imageObradaAktivnosti13MT);

        op.setTime(currentTime);

        nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyTasksActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        detalji1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyTasksActivity.this, InfoRoomActivityPO.class);
                startActivity(intent);
            }
        });

        detalji2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyTasksActivity.this, InfoRoomActivityPO.class);
                startActivity(intent);
            }
        });

        detalji3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyTasksActivity.this, InfoRoomActivityPO.class);
                startActivity(intent);
            }
        });
    }
}