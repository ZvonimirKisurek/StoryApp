package com.zoneproduction.manageme;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccountActivity extends AppCompatActivity {

    TextView emptyMail, emptyPassword, voditelj, djelatnik;
    Button signUp;
    EditText mail, password;
    ProgressBar progressBar;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    ConstraintLayout layoutVoditelj, layoutDjelatnik;
    boolean vodi = false, djel = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        emptyMail = findViewById(R.id.textForgotMailCA);
        emptyPassword = findViewById(R.id.textWrongPasswordCA);
        signUp = findViewById(R.id.buttonRegisterSignUpCA);
        mail = findViewById(R.id.editTextEmailSignUpCA);
        password = findViewById(R.id.editTextPasswordSignUpCA);
        progressBar = findViewById(R.id.progressBarSignUpCA);
        layoutDjelatnik = findViewById(R.id.clDjelatnikCA);
        layoutVoditelj = findViewById(R.id.clVoditeljCA);
        voditelj = findViewById(R.id.textVoditeljCA);
        djelatnik = findViewById(R.id.textDjelatnikCA);

        voditelj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (djel) {
                    djelatnik.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.appBlue));
                    djelatnik.setBackground(getDrawable(R.drawable.circleblue));
                }
                voditelj.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.green));
                voditelj.setBackground(getDrawable(R.drawable.circlegreen));
                vodi = true;
            }
        });
        djelatnik.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if (vodi) {
                    voditelj.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.appBlue));
                    voditelj.setBackground(getDrawable(R.drawable.circleblue));
                }
                //djelatnik.setBackgroundResource(R.color.green);
                //djelatnik.setBackgroundColor(Color.GREEN);
                djelatnik.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.green));
                djelatnik.setBackground(getDrawable(R.drawable.circlegreen));
                djel = true;
            }
        });

        //E67AFD63

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean good = true;
                String email = mail.getText().toString();
                String userPassword = password.getText().toString();
                if (userPassword.equals("")) {
                    emptyPassword.setVisibility(View.VISIBLE);
                    good = false;
                } else {
                    emptyPassword.setVisibility(View.INVISIBLE);
                }
                if (email.equals("")) {
                    emptyMail.setVisibility(View.VISIBLE);
                    good = false;
                } else {
                    emptyMail.setVisibility(View.INVISIBLE);
                }
                if (good) {
                    signUp.setClickable(false);
                    email = mail.getText().toString();
                    userPassword = password.getText().toString();
                    signUpFirebase(email, userPassword);
                }
            }
        });
    }

    public void signUpFirebase(String email, String userPassword) {

        progressBar.setVisibility(View.VISIBLE);
        auth.createUserWithEmailAndPassword(email, userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(CreateAccountActivity.this, "Vaš račun je kreiran", Toast.LENGTH_LONG).show();
                    finish();
                    progressBar.setVisibility(View.INVISIBLE);
                    Intent i = new Intent(CreateAccountActivity.this, LogInActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(CreateAccountActivity.this, "Nešto je pošlo po krivu!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}