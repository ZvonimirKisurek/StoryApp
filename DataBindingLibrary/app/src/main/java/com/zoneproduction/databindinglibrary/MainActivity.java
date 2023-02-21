package com.zoneproduction.databindinglibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.widget.TextView;

import com.zoneproduction.databindinglibrary.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Info info = new Info("David", "Michael", "david@gmail.com");

        activityMainBinding.setData(info);

    }
}