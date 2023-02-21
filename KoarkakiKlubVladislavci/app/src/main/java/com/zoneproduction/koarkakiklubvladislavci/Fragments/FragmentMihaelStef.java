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

public class FragmentMihaelStef extends Fragment {

    public static FragmentMihaelStef newInstance() {

       return new FragmentMihaelStef();
    }

    private ImageView imageViewMihaelStef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mihael_steficar, container, false);

        imageViewMihaelStef = view.findViewById(R.id.imageViewMihaelStef);


        return view;
    }
}
