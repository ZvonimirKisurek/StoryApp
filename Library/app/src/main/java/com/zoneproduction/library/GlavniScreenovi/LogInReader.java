package com.zoneproduction.library.GlavniScreenovi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.zoneproduction.library.R;

import static android.content.ContentValues.TAG;

public class LogInReader extends AppCompatActivity {

    Button logInReader;
    EditText editTextEmailReader;
    EditText editTextPasswordReader;
    TextView forgotPassReader, forgotToEnterUser, forgotToEnterPass;
    ImageView backLogInReader;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    ProgressBar progressBarReader;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference users = db.collection("Users");
    FirebaseUser user = auth.getCurrentUser();

    String type = "Reader";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_reader);

        logInReader = findViewById(R.id.logInButtonReader);
        editTextEmailReader = findViewById(R.id.editTextEmailReader);
        editTextPasswordReader = findViewById(R.id.editTextPasswordReader);
        forgotPassReader = findViewById(R.id.forgotPasswordReader);
        backLogInReader = findViewById(R.id.backLogInReader);
        progressBarReader = findViewById(R.id.progressBarLogInReader);
        forgotToEnterUser = findViewById(R.id.textForgotToEnterUserReader);
        forgotToEnterPass = findViewById(R.id.textForgotToEnterPassReader);

        logInReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String username = editTextEmailReader.getText().toString();
                String userPassword = editTextPasswordReader.getText().toString();
                boolean good = true;
                if (username == null || username.equals("")) {
                    forgotToEnterUser.setVisibility(View.VISIBLE);
                    good = false;
                }
                if (userPassword == null || userPassword.equals("")) {
                    forgotToEnterPass.setVisibility(View.VISIBLE);
                    good = false;
                }
                if(good){
                    signInWithFirebase(username, userPassword);
                }

            }
        });

        backLogInReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LogInReader.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });
    }

    public void signInWithFirebase(String userEmail, String userPassword) {

        progressBarReader.setVisibility(View.VISIBLE);
        logInReader.setClickable(false);
        auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Intent i = new Intent(LogInReader.this, HomeScreenReader.class);
                    startActivity(i);
                    finish();
                    progressBarReader.setVisibility(View.INVISIBLE);
                    Toast.makeText(LogInReader.this, "You're successfully logged in", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LogInReader.this, "Create Reader account first", Toast.LENGTH_LONG).show();
                    progressBarReader.setVisibility(View.INVISIBLE);
                    logInReader.setClickable(true);

                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            Intent i = new Intent(LogInReader.this, HomeScreenReader.class);
            startActivity(i);
            finish();
        }
    }

    public String getEmail() {
        return user.getEmail();
    }

    public String getType(){return type;}
}

