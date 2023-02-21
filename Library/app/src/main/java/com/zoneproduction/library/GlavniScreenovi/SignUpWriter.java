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

public class SignUpWriter extends AppCompatActivity {

    EditText mail;
    EditText password;
    Button signUp;
    ProgressBar progressBar;
    TextView errorMail, errorPassword;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_writer);

        mail = findViewById(R.id.emailSignUpWriter);
        password = findViewById(R.id.passwordSignUpWriter);
        signUp = findViewById(R.id.buttonSignUpWriter);
        errorMail = findViewById(R.id.textViewEmailSignUpWriter);
        errorPassword = findViewById(R.id.textViewPasswordSignUpWriter);
        progressBar = findViewById(R.id.progressBarSignUpWriter);
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
                    Toast.makeText(SignUpWriter.this, "Your account is created", Toast.LENGTH_LONG).show();
                    finish();
                    progressBar.setVisibility(View.INVISIBLE);
                    Intent i = new Intent(SignUpWriter.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(SignUpWriter.this, "Something went wrong!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}