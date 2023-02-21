package com.zoneproduction.koarkakiklubvladislavci.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.zoneproduction.koarkakiklubvladislavci.Adapters.ViewPagerAdapterEkipa;
import com.zoneproduction.koarkakiklubvladislavci.R;

public class EkipaActivity extends AppCompatActivity {

    private TabLayout tabLayoutEkipa;
    private ViewPager2 viewPagerEkipa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekipa);

        tabLayoutEkipa = findViewById(R.id.tabLayoutEkipa);
        viewPagerEkipa = findViewById(R.id.viewPagerEkipa);

        ViewPagerAdapterEkipa adapter = new ViewPagerAdapterEkipa(getSupportFragmentManager(), getLifecycle());

        viewPagerEkipa.setAdapter(adapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayoutEkipa, viewPagerEkipa, true, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position) {
                    case 0:
                        tab.setText("Zvonimir Kišurek");
                        break;
                    case 1:
                        tab.setText("Mihael Mamić");
                        break;
                    case 2:
                        tab.setText("Nino Gradinjan");
                        break;
                    case 3:
                        tab.setText("Toni Gradinjan");
                        break;
                    case 4:
                        tab.setText("Gabrijel Puhalo");
                        break;
                    case 5:
                        tab.setText("Filip Jelenić");
                        break;
                    case 6:
                        tab.setText("Mihael Štefičar");
                        break;
                    case 7:
                        tab.setText("Nikola Radmilović");
                        break;
                    case 8:
                        tab.setText("Mislav Bradarić");
                        break;
                    case 9:
                        tab.setText("Damir Duvnjak");
                        break;
                    case 10:
                        tab.setText("Tomislav Šilješ");
                        break;
                    case 11:
                        tab.setText("Luka Brezničar");
                        break;
                    case 12:
                        tab.setText("Mislav Grbeša");
                        break;
                }
            }
        });
        tabLayoutMediator.attach();
    }
}