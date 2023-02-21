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

public class FragmentDamir extends Fragment {

    public static FragmentDamir newInstance() {

       return new FragmentDamir();
    }

    private ImageView imageViewDamir;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_damir, container, false);

        imageViewDamir = view.findViewById(R.id.imageViewDamir);


        return view;
    }
}
