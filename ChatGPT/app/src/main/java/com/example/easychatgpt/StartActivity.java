package com.example.easychatgpt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class StartActivity extends AppCompatActivity {

    String inputs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button activity = (Button) findViewById(R.id.activity);
        TextView username =(EditText) findViewById(R.id.username);
        TextView password =(EditText) findViewById(R.id.password);
        TextView signin =(TextView) findViewById(R.id.signin);
        EditText place =(EditText) findViewById(R.id.passwor32d);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);



        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {


            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String text =  username.getText().toString();
                String text2 =  password.getText().toString();
                String text3 =  place.getText().toString();
                    inputs = "Please tell me a long " + text + " Story. I am " + text2 + "years old from " + text3;
                    signin.setText(inputs);
                //Toast.makeText(MainActivity.this, "letsgo", Toast.LENGTH_SHORT).show();
            }
        });

        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

    }

    private void openActivity2() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("input", inputs);
        Log.d("halo", inputs);
        startActivity(intent);
    }
}