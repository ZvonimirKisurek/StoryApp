package com.zoneproduction.dialogfragment;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class MyDialogFragment extends DialogFragment {

    Button ok, cancel;
    EditText enter;

    public MyDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_dialog, container, false);
        enter = view.findViewById(R.id.editTextEnter);
        ok = view.findViewById(R.id.buttonOkay);
        cancel = view.findViewById(R.id.buttonCancel);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userEnter = enter.getText().toString();
                ((MainActivity) getActivity()).result.setText(userEnter);
                getDialog().dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getDialog().dismiss();

            }
        });

        return view;
    }
}