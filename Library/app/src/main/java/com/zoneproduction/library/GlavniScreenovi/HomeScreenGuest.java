package com.zoneproduction.library.GlavniScreenovi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;
import com.zoneproduction.library.Adapteri.ViewPagerAdapter;
import com.zoneproduction.library.R;

public class HomeScreenGuest extends AppCompatActivity {

    private TabLayout tabLayoutCategory;
    private ViewPager2 viewPagerCategory;
    private Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_guest);

        tabLayoutCategory = findViewById(R.id.tabLayoutHomeReader);
        viewPagerCategory = findViewById(R.id.viewPagerHomeReader);
        signOut = findViewById(R.id.buttonSignOutHomeGuest);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());

        viewPagerCategory.setAdapter(adapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayoutCategory, viewPagerCategory, true, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("My Library");
                        break;
                    case 1:
                        tab.setText("Store");
                        break;
                    case 2:
                        tab.setText("Profile");
                        break;
                }
            }
        });
        tabLayoutMediator.attach();

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(HomeScreenGuest.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}