package com.zoneproduction.informationbook.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.zoneproduction.informationbook.R;
import com.zoneproduction.informationbook.adapters.ViewPagerAdapterWonders;

public class WondersActivity extends AppCompatActivity {

    private TabLayout tabLayoutWonders;
    private ViewPager2 viewPagerWonders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wonders);

        tabLayoutWonders = findViewById(R.id.tabLayoutWonders);
        viewPagerWonders = findViewById(R.id.viewPagerWonders);

        ViewPagerAdapterWonders adapterWonders = new ViewPagerAdapterWonders(getSupportFragmentManager(), getLifecycle());

        viewPagerWonders.setAdapter(adapterWonders);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayoutWonders, viewPagerWonders, true, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){
                    case 0:
                        tab.setText("TajMahal");
                        break;
                    case 1:
                        tab.setText("Petra");
                        break;
                }

            }
        });
        tabLayoutMediator.attach();
    }
}