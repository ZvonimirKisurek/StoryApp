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

public class FragmentZvonimir extends Fragment {

    public static FragmentZvonimir newInstance() {

       return new FragmentZvonimir();
    }

    private ImageView imageViewZvonimir;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_zvonimir, container, false);

        imageViewZvonimir = view.findViewById(R.id.imageViewMihaelStef);


        return view;
    }
}
