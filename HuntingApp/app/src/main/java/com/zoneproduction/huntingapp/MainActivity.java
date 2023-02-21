package com.zoneproduction.huntingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    ImageView mainPozadina;
    Button buttonPrijava, buttonRegistracija;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);

        mainPozadina = findViewById(R.id.imageView);
        buttonPrijava = findViewById(R.id.buttonPrijava);
        buttonRegistracija = findViewById(R.id.buttonRegistracija);

        buttonPrijava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, Gallery.class);
                startActivity(i);
                finish();

            }
        });

        buttonRegistracija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, Gallery.class);
                startActivity(i);
                finish();

            }
        });

    }
}