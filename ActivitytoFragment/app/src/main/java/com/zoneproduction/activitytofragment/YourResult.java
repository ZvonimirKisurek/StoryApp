package com.zoneproduction.activitytofragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;


public class YourResult extends Fragment {

    TextView result;

    public YourResult() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_your_result, container, false);
        result = view.findViewById(R.id.textViewResult);

        Bundle bundle = getArguments();
        int userWeight = bundle.getInt("weight");
        int userHeight = bundle.getInt("height");

        double userBmi = (double) (userWeight * 1000) / (userHeight * userHeight);

        result.setText(String.valueOf(userBmi));
        return  view;
    }
}