package com.zoneproduction.manageme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

public class LogInActivity extends AppCompatActivity {

    TextView wrongEmail, wrongPass, forgotPassword;
    Button logIn, signUp;
    EditText mail, password;
    ProgressBar progressBar;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        wrongEmail = findViewById(R.id.textForgotMailLA);
        wrongPass = findViewById(R.id.textWrongPasswordLA);
        forgotPassword = findViewById(R.id.textForgotPasswordLA);
        logIn = findViewById(R.id.buttonPrijavaLogInLA);
        signUp = findViewById(R.id.buttonRegisterLogInLA);
        mail = findViewById(R.id.editTextEmailLogInLA);
        password = findViewById(R.id.editTextPasswordLogInLA);
        progressBar = findViewById(R.id.progressBarLogInLA);
        constraintLayout = findViewById(R.id.clLogIn);

        Animation animationIntro = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_anim);
        constraintLayout.startAnimation(animationIntro);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LogInActivity.this, CreateAccountActivity.class);
                startActivity(i);
            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mail.getText().toString();
                String userPassword = password.getText().toString();
                boolean good = true;
                if (email == null || email.equals("")) {
                    wrongEmail.setVisibility(View.VISIBLE);
                    good = false;
                }
                if (userPassword == null || userPassword.equals("")) {
                    wrongPass.setVisibility(View.VISIBLE);
                    good = false;
                }
                signInWithFirebase(email, userPassword);
            }
        });
    }

    public void signInWithFirebase(String userEmail, String userPassword) {

        progressBar.setVisibility(View.VISIBLE);
        logIn.setClickable(false);
        auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Intent i = new Intent(LogInActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(LogInActivity.this, "Uspješno ste prijavljeni", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LogInActivity.this, "Molim Vas kreirajte račun", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    logIn.setClickable(true);
                }
            }
        });
    }
}