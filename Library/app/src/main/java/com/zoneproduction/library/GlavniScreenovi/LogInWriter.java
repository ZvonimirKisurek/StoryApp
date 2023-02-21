package com.zoneproduction.library.GlavniScreenovi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.zoneproduction.library.R;

public class LogInWriter extends AppCompatActivity {



    Button logInWriter;
    EditText editTextEmailWriter;
    EditText editTextPasswordWriter;
    TextView forgotPassWriter, forgotToEnterUser, forgotToEnterPass;
    ImageView backLogInWriter;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    ProgressBar progressBarWriter;

    String type = "Writer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_writer);

        logInWriter = findViewById(R.id.logInButtonWriter);
        editTextEmailWriter = findViewById(R.id.editTextEmailWriter);
        editTextPasswordWriter = findViewById(R.id.editTextPasswordWriter);
        forgotPassWriter = findViewById(R.id.forgotPasswordWriter);
        backLogInWriter = findViewById(R.id.backLogInWriter);
        forgotToEnterPass = findViewById(R.id.textForgotToEnterPassWriter);
        forgotToEnterUser = findViewById(R.id.textForgotToEnterUserWriter);
        progressBarWriter = findViewById(R.id.progressBarLogInWriter);

        logInWriter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = editTextEmailWriter.getText().toString();
                String userPassword = editTextPasswordWriter.getText().toString();
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

        backLogInWriter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LogInWriter.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });
    }

    public void signInWithFirebase(String userEmail, String userPassword) {
        progressBarWriter.setVisibility(View.VISIBLE);
        logInWriter.setClickable(false);
        auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    String typeOfUser = "Writer";
                    Intent i = new Intent(LogInWriter.this, HomeScreenWriter.class);
                    startActivity(i);
                    finish();
                    progressBarWriter.setVisibility(View.INVISIBLE);
                    Toast toast = Toast.makeText(LogInWriter.this, "You're successfully logged in", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(LogInWriter.this, "Create Writer account first", Toast.LENGTH_LONG);
                    toast.show();
                    progressBarWriter.setVisibility(View.INVISIBLE);
                    logInWriter.setClickable(true);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            Intent i = new Intent(LogInWriter.this, HomeScreenWriter.class);
            startActivity(i);
            finish();
        }
    }
    public String getType(){
        return type;
    }
}