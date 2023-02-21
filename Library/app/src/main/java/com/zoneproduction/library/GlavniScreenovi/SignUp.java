package com.zoneproduction.library.GlavniScreenovi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.zoneproduction.library.R;

public class SignUp extends AppCompatActivity {

    EditText mail;
    EditText password;
    Button signUp;
    ProgressBar progressBar;
    TextView errorMail, errorPassword;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mail = findViewById(R.id.emailSignUp);
        password = findViewById(R.id.passwordSignUp);
        signUp = findViewById(R.id.buttonSignUp);
        errorMail = findViewById(R.id.textViewEmailSignUp);
        errorPassword = findViewById(R.id.textViewPasswordSignUp);
        progressBar = findViewById(R.id.progressBarSignUp);
        progressBar.setVisibility(View.INVISIBLE);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean good = true;
                String email = mail.getText().toString();
                String userPassword = password.getText().toString();
                if(userPassword.equals("")){
                    errorPassword.setVisibility(View.VISIBLE);
                    good = false;
                }else{
                    errorPassword.setVisibility(View.INVISIBLE);
                }
                if(email.equals("")){
                    errorMail.setVisibility(View.VISIBLE);
                    good = false;
                }else{
                    errorMail.setVisibility(View.INVISIBLE);
                }
                if(good) {
                    signUp.setClickable(false);
                    email = mail.getText().toString();
                    userPassword = password.getText().toString();
                    signUpFirebase(email, userPassword);
                }
            }
        });
    }

    public void signUpFirebase(String email, String userPassword){

        progressBar.setVisibility(View.VISIBLE);
        auth.createUserWithEmailAndPassword(email,userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(SignUp.this, "Your account is created", Toast.LENGTH_LONG).show();
                    finish();
                    progressBar.setVisibility(View.INVISIBLE);
                    Intent i = new Intent(SignUp.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(SignUp.this, "Something went wrong!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}