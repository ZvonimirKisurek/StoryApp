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

public class FragmentMislavGrb extends Fragment {

    public static FragmentMislavGrb newInstance() {

       return new FragmentMislavGrb();
    }

    private ImageView imageViewMislavGrb;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mislav_gbresa, container, false);

        imageViewMislavGrb = view.findViewById(R.id.imageViewMislavGrb);


        return view;
    }
}
