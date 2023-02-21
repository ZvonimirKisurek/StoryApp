package com.zoneproduction.firebaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

   EditText mail, password;
   Button signIn, signUp, forgotPassword, phoneSign;

   FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        signIn = findViewById(R.id.buttonSignIn);
        signUp = findViewById(R.id.buttonSignUp);
        forgotPassword = findViewById(R.id.buttonForgot);
        phoneSign = findViewById(R.id.buttonPhoneSign);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userMail = mail.getText().toString();
                String userPassword = password.getText().toString();

                signInFirebase(userMail, userPassword);

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, SignUp.class);
                startActivity(i);

            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, ForgetActivity.class);
                startActivity(i);

            }
        });

        phoneSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, PhoneSignActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void signInFirebase(String userName, String userPassword){

        auth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent i = new Intent(MainActivity.this, main_menu.class);
                            startActivity(i);
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Mail or password is not correct", Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = auth.getCurrentUser();
        if(user != null){
            Intent i = new Intent(MainActivity.this, main_menu.class);
            startActivity(i);
            finish();
        }
    }
}