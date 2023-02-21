package com.zoneproduction.koarkakiklubvladislavci.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.zoneproduction.koarkakiklubvladislavci.Adapters.ViewPagerAdapterEkipa;
import com.zoneproduction.koarkakiklubvladislavci.R;

public class OKlubuActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_klubu);

    }
}