package com.zoneproduction.library.Adapteri;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zoneproduction.library.GlavniScreenovi.FragmentLibraryWriter;
import com.zoneproduction.library.GlavniScreenovi.FragmentProfileWriter;
import com.zoneproduction.library.GlavniScreenovi.Fragment_MyBooks;

public class ViewPagerAdapterWriter extends FragmentStateAdapter {

    public ViewPagerAdapterWriter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment;

        switch (position){
            case 0:
                fragment = Fragment_MyBooks.newInstance();
                break;
            case 1:
                fragment = FragmentLibraryWriter.newInstance();
                break;
            case 2:
                fragment = FragmentProfileWriter.newInstance();
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
