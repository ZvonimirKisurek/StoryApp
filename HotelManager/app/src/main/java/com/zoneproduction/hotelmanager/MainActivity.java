package com.zoneproduction.hotelmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView plan, voditelji, klijenti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plan = findViewById(R.id.imageButtonPlanMain);
        voditelji = findViewById(R.id.imageButtonMenagerMain);
        klijenti = findViewById(R.id.imageButtonWorkerMain);

        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, RoomPlanActivity.class);
                startActivity(i);
                finish();

            }
        });



    }


}