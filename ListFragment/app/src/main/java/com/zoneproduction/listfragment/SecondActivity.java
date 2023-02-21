package com.zoneproduction.listfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        SecondFragment secondFragment = new SecondFragment();
        fragmentTransaction.add(R.id.frame, secondFragment);

        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        secondFragment.setArguments(bundle);

        fragmentTransaction.commit();
    }
}