package com.zoneproduction.library.GlavniScreenovi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.zoneproduction.library.R;

public class Forgot_password extends AppCompatActivity {

    EditText email;
    Button button;
    ProgressBar progressBar;
    ImageView back;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.editTextPasswordEmail);
        button = findViewById(R.id.buttonPasswordContinue);
        progressBar = findViewById(R.id.progressBarPassword);
        back = findViewById(R.id.backForgotPassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userMail = email.getText().toString();
                resetPassword(userMail);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Forgot_password.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });
    }

    public void resetPassword(String userMail){

        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(userMail).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()){
                    Toast.makeText(Forgot_password.this, "Your password reset mail is send to your email", Toast.LENGTH_LONG).show();
                    finish();
                    button.setClickable(false);
                    progressBar.setVisibility(View.INVISIBLE);
                    finish();
                }else{
                    Toast.makeText(Forgot_password.this, "We are sorry it seems there is a problem, please try later", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}