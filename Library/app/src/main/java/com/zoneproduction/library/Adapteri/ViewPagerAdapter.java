package com.zoneproduction.library.Adapteri;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zoneproduction.library.GlavniScreenovi.Fragment_Library;
import com.zoneproduction.library.GlavniScreenovi.Fragment_Profile;
import com.zoneproduction.library.GlavniScreenovi.Fragment_myLibrary;


public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment;

        switch (position){
            case 0:
                fragment = Fragment_myLibrary.newInstance();
                break;
            case 1:
                fragment = Fragment_Library.newInstance();
                break;
            case 2:
                fragment = Fragment_Profile.newInstance();
                break;
            default:
                return null;
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
