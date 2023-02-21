package com.example.todolist;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText item;
    Button add;
    ListView listView;
    ArrayList<String> itemList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item = findViewById(R.id.editText);
        add = findViewById(R.id.button);
        listView = findViewById(R.id.list);

        itemList = FileHelper.readData(this);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, itemList);

        listView.setAdapter(arrayAdapter);

        add.setOnClickListener(v -> {
            String itemName = item.getText().toString();
            itemList.add(itemName);
            item.setText("");
            FileHelper.writeData(itemList, getApplicationContext());
            arrayAdapter.notifyDataSetChanged();
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder((MainActivity.this));
                alert.setTitle("Obriši");
                alert.setMessage("Želiš li obrisati odabranu stavku?");
                alert.setCancelable(false);
                alert.setNegativeButton("Ne", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alert.setPositiveButton("Da", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        itemList.remove(position);
                        arrayAdapter.notifyDataSetChanged();
                        FileHelper.writeData(itemList,getApplicationContext());
                    }
                });
                AlertDialog alertDialog = alert.create();
                alertDialog.show();
            }
        });

    }
}