package com.zoneproduction.library.GlavniScreenovi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zoneproduction.library.R;

public class Fragment_MyBooks extends Fragment {

    public static Fragment_MyBooks newInstance() {

        return new Fragment_MyBooks();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment__my_books, container, false);

        return view;
    }
}