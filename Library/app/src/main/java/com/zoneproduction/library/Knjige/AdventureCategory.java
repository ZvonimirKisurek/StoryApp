package com.zoneproduction.library.Knjige;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zoneproduction.library.GlavniScreenovi.BookBuyer;
import com.zoneproduction.library.GlavniScreenovi.HomeScreenGuest;
import com.zoneproduction.library.GlavniScreenovi.HomeScreenReader;
import com.zoneproduction.library.GlavniScreenovi.HomeScreenWriter;
import com.zoneproduction.library.R;

public class AdventureCategory extends AppCompatActivity {

    ImageView knjiga1, knjiga2, knjiga3, knjiga4, knjiga5, back, forward, backToCategory;
    TextView naslov1, naslov2, naslov3, naslov4, naslov5, pisac1, pisac2, pisac3, pisac4, pisac5, currentPage;
    int totalPages = 0;
    ConstraintLayout layout1, layout2, layout3, layout4, layout5;
    HomeScreenReader hsr = new HomeScreenReader();
    String type = hsr.getType();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_category);

        knjiga1 = findViewById(R.id.imageKnjigaAdventure1);
        knjiga2 = findViewById(R.id.imageKnjigaAdventure2);
        knjiga3 = findViewById(R.id.imageKnjigaAdventure3);
        knjiga4 = findViewById(R.id.imageKnjigaAdventure4);
        knjiga5 = findViewById(R.id.imageKnjigaAdventure5);
        naslov1 = findViewById(R.id.textNaslovBiograph1);
        naslov2 = findViewById(R.id.textNaslovAdventure2);
        naslov3 = findViewById(R.id.textNaslovAdventure3);
        naslov4 = findViewById(R.id.textNaslovAdventure4);
        naslov5 = findViewById(R.id.textNaslovAdventure5);
        pisac1 = findViewById(R.id.textImePiscaArt1);
        pisac2 = findViewById(R.id.textImePiscaAdventure2);
        pisac3 = findViewById(R.id.textImePiscaAdventure3);
        pisac4 = findViewById(R.id.textImePiscaAdventure4);
        pisac5 = findViewById(R.id.textImePiscaAdventure5);
        back = findViewById(R.id.backArrowAdventure);
        forward = findViewById(R.id.forwardArrowAdventure);
        currentPage = findViewById(R.id.textCurrentPageAdventure);
        layout1 = findViewById(R.id.knjigaAdventure1);
        layout2 = findViewById(R.id.knjigaAdventure2);
        layout3 = findViewById(R.id.knjigaAdventure3);
        layout4 = findViewById(R.id.knjigaAdventure4);
        layout5 = findViewById(R.id.knjigaAdventure5);
        backToCategory = findViewById(R.id.backAdventure);

            //logika s kojom će de micati strijelice ako sam došao do kraja ili ako sam na početku liste s knjigama
        if(currentPage.getText().toString().equals("1")){
            back.setVisibility(View.INVISIBLE);
        }else if(Integer.parseInt((String) currentPage.getText()) < totalPages){
            back.setVisibility(View.VISIBLE);
            forward.setVisibility(View.VISIBLE);
        }else{
            forward.setVisibility(View.INVISIBLE);
        }

        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdventureCategory.this, BookBuyer.class);
                startActivity(i);
                finish();
            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdventureCategory.this, BookBuyer.class);
                startActivity(i);
                finish();
            }
        });
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdventureCategory.this, BookBuyer.class);
                startActivity(i);
                finish();
            }
        });
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdventureCategory.this, BookBuyer.class);
                startActivity(i);
                finish();
            }
        });
        layout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdventureCategory.this, BookBuyer.class);
                startActivity(i);
                finish();
            }
        });

        backToCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                if(type.equals("reader")){
                    i = new Intent(AdventureCategory.this, HomeScreenReader.class);
                }else{
                    i = new Intent(AdventureCategory.this, HomeScreenWriter.class);
                }
                startActivity(i);
                finish();
            }
        });

    }
}