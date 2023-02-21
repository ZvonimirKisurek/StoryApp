package com.zoneproduction.informationbook.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.zoneproduction.informationbook.adapters.AdapterClass;
import com.zoneproduction.informationbook.ModelClass;
import com.zoneproduction.informationbook.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ModelClass> arrayList;
    private AdapterClass adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        arrayList = new ArrayList<>();

        ModelClass modelClass = new ModelClass("countries", "The Countries");
        ModelClass modelClass2 = new ModelClass("museum", "The Museums");
        ModelClass modelClass3 = new ModelClass("leaders", "The Leaders");
        ModelClass modelClass4 = new ModelClass("wonders", "Seven Wonders of the World");


        arrayList.add(modelClass);
        arrayList.add(modelClass2);
        arrayList.add(modelClass3);
        arrayList.add(modelClass4);

        adapter = new AdapterClass(arrayList, this);
        recyclerView.setAdapter(adapter);

    }
}