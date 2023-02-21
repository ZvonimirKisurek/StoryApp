package com.zoneproduction.informationbook.adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zoneproduction.informationbook.fragments.FragmentFrance;
import com.zoneproduction.informationbook.fragments.FragmentItaly;
import com.zoneproduction.informationbook.fragments.FragmentPetra;
import com.zoneproduction.informationbook.fragments.FragmentTajMahal;
import com.zoneproduction.informationbook.fragments.FragmentUnitedKingdom;

public class ViewPagerAdapterWonders extends FragmentStateAdapter {

    public ViewPagerAdapterWonders(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment;

        switch (position){
            case 0:
                fragment = FragmentTajMahal.newInstance();
                break;
            case 1:
                fragment = FragmentPetra.newInstance();
                break;
            default:
                return null;
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
