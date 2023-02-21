package com.zoneproduction.library.Knjige;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zoneproduction.library.GlavniScreenovi.HomeScreenReader;
import com.zoneproduction.library.GlavniScreenovi.HomeScreenWriter;
import com.zoneproduction.library.R;

public class MysteryCategory extends AppCompatActivity {

    ImageView knjiga1, knjiga2, knjiga3, knjiga4, knjiga5, back, forward,backToCategory;
    TextView naslov1, naslov2, naslov3, naslov4, naslov5, pisac1, pisac2, pisac3, pisac4, pisac5, currentPage;
    int totalPages = 0;
    HomeScreenReader hsr = new HomeScreenReader();
    String type = hsr.getType();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mystery_category);

        knjiga1 = findViewById(R.id.imageKnjigeMystery1);
        knjiga2 = findViewById(R.id.imageKnjigaMystery2);
        knjiga3 = findViewById(R.id.imageKnjigaMystery3);
        knjiga4 = findViewById(R.id.imageKnjigaMystery4);
        knjiga5 = findViewById(R.id.imageKnjigaMystery5);
        naslov1 = findViewById(R.id.textNaslovMystery1);
        naslov2 = findViewById(R.id.textNaslovMystery2);
        naslov3 = findViewById(R.id.textNaslovMystery3);
        naslov4 = findViewById(R.id.textNaslovMystery4);
        naslov5 = findViewById(R.id.textNaslovMystery5);
        pisac1 = findViewById(R.id.textImePiscaMystery1);
        pisac2 = findViewById(R.id.textImePiscaMystery2);
        pisac3 = findViewById(R.id.textImePiscaMystery3);
        pisac4 = findViewById(R.id.textImePiscaMystery4);
        pisac5 = findViewById(R.id.textImePiscaMystery5);
        back = findViewById(R.id.backArrowMystery);
        forward = findViewById(R.id.forwardArrowMystery);
        currentPage = findViewById(R.id.textCurrentPageMystery);
        backToCategory = findViewById(R.id.backMystery);

        if(currentPage.getText().toString().equals("1")){
            back.setVisibility(View.INVISIBLE);
        }else if(Integer.parseInt((String) currentPage.getText()) < totalPages){
            back.setVisibility(View.VISIBLE);
            forward.setVisibility(View.VISIBLE);
        }else{
            forward.setVisibility(View.INVISIBLE);
        }

        backToCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                if(type.equals("reader")){
                    i = new Intent(MysteryCategory.this, HomeScreenReader.class);
                }else{
                    i = new Intent(MysteryCategory.this, HomeScreenWriter.class);
                }
                startActivity(i);
                finish();
            }
        });

    }
}