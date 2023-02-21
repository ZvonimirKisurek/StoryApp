package com.zoneproduction.eventbus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {

    EditText message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.editTextMessage);
        send = findViewById(R.id.buttonSend);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fragment fr = new fragment();
        ft.add(R.id.frameLayout,fr);
        ft.commit();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userMessage = message.getText().toString();

                EventBus.getDefault().post(new Message(userMessage));

            }
        });
    }
}