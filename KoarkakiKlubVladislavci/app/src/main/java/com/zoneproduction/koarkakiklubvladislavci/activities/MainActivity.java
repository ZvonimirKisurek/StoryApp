package com.zoneproduction.koarkakiklubvladislavci.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zoneproduction.koarkakiklubvladislavci.R;

public class MainActivity extends AppCompatActivity {

    ImageView grb;
    Button buttonEkipa, buttonOKlubu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grb = findViewById(R.id.imageViewGrb);
        buttonEkipa = findViewById(R.id.buttonEkipa);
        buttonOKlubu = findViewById(R.id.buttonOKlubu);

        buttonEkipa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EkipaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonOKlubu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OKlubuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}