package com.zoneproduction.koarkakiklubvladislavci.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zoneproduction.koarkakiklubvladislavci.R;

public class FragmentNikolaRad extends Fragment {

    public static FragmentNikolaRad newInstance() {

       return new FragmentNikolaRad();
    }

    private ImageView imageViewNikolaRad;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nikola_rad, container, false);

        imageViewNikolaRad = view.findViewById(R.id.imageViewNikolaRad);


        return view;
    }
}
