package com.zoneproduction.manageme;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class WorkingScheduleActivity extends AppCompatActivity {

    ConstraintLayout radnoVrijeme;
    Button day1, day2;
    boolean isOpen = false;
    OpenClose op = new OpenClose();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_schedule);

        radnoVrijeme = findViewById(R.id.clRadnoVrijemeWS);
        day1 = findViewById(R.id.buttonDay1Calendar);
        day2 = findViewById(R.id.buttonDay2Calendar);

        day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isOpen) {
                    radnoVrijeme.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.SlideInRight).duration(500).repeat(0).playOn(radnoVrijeme);
                    isOpen = true;
                } else {
                    {
                        isOpen = false;
                        op.closeRoomFast(getApplicationContext(), radnoVrijeme);
                    }
                }
            }
        });

    }
}