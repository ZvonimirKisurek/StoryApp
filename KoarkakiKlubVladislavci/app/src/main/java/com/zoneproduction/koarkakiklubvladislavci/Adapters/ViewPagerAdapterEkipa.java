package com.zoneproduction.koarkakiklubvladislavci.Adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zoneproduction.koarkakiklubvladislavci.Fragments.FragmentDamir;
import com.zoneproduction.koarkakiklubvladislavci.Fragments.FragmentFilip;
import com.zoneproduction.koarkakiklubvladislavci.Fragments.FragmentGabrijel;
import com.zoneproduction.koarkakiklubvladislavci.Fragments.FragmentLuka;
import com.zoneproduction.koarkakiklubvladislavci.Fragments.FragmentMihaelMamic;
import com.zoneproduction.koarkakiklubvladislavci.Fragments.FragmentMihaelStef;
import com.zoneproduction.koarkakiklubvladislavci.Fragments.FragmentMislavBrada;
import com.zoneproduction.koarkakiklubvladislavci.Fragments.FragmentMislavGrb;
import com.zoneproduction.koarkakiklubvladislavci.Fragments.FragmentNikolaRad;
import com.zoneproduction.koarkakiklubvladislavci.Fragments.FragmentNino;
import com.zoneproduction.koarkakiklubvladislavci.Fragments.FragmentTomislav;
import com.zoneproduction.koarkakiklubvladislavci.Fragments.FragmentToni;
import com.zoneproduction.koarkakiklubvladislavci.Fragments.FragmentZvonimir;

public class ViewPagerAdapterEkipa extends FragmentStateAdapter {

    public ViewPagerAdapterEkipa(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment;

        switch (position){
            case 0:
                fragment = FragmentZvonimir.newInstance();
                break;
            case 1:
                fragment = FragmentMihaelMamic.newInstance();
                break;
            case 2:
                fragment = FragmentNino.newInstance();
                break;
            case 3:
                fragment = FragmentToni.newInstance();
                break;
            case 4:
                fragment = FragmentGabrijel.newInstance();
                break;
            case 5:
                fragment = FragmentFilip.newInstance();
                break;
            case 6:
                fragment = FragmentMihaelStef.newInstance();
                break;
            case 7:
                fragment = FragmentNikolaRad.newInstance();
                break;
            case 8:
                fragment = FragmentMislavBrada.newInstance();
                break;
            case 9:
                fragment = FragmentDamir.newInstance();
                break;
            case 10:
                fragment = FragmentTomislav.newInstance();
                break;
            case 11:
                fragment = FragmentLuka.newInstance();
                break;
            case 12:
                fragment = FragmentMislavGrb.newInstance();
                break;

            default:
                return null;
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 13;
    }
}
