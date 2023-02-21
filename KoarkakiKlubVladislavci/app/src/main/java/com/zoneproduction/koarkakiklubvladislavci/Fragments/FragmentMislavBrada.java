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

public class FragmentMislavBrada extends Fragment {

    public static FragmentMislavBrada newInstance() {

       return new FragmentMislavBrada();
    }

    private ImageView imageViewMislavBrada;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mislav_bradaric, container, false);

        imageViewMislavBrada = view.findViewById(R.id.imageViewMislavBrada);


        return view;
    }
}
