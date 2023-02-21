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

public class HorrorCategory extends AppCompatActivity {

    ImageView knjiga1, knjiga2, knjiga3, knjiga4, knjiga5, back, forward, backToCategory;
    TextView naslov1, naslov2, naslov3, naslov4, naslov5, pisac1, pisac2, pisac3, pisac4, pisac5, currentPage;
    int totalPages = 0;
    HomeScreenReader hsr = new HomeScreenReader();
    String type = hsr.getType();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horror_category);

        knjiga1 = findViewById(R.id.imageKnjigeHorror1);
        knjiga2 = findViewById(R.id.imageKnjigaHorror2);
        knjiga3 = findViewById(R.id.imageKnjigaHorror3);
        knjiga4 = findViewById(R.id.imageKnjigaHorror4);
        knjiga5 = findViewById(R.id.imageKnjigaHorror5);
        naslov1 = findViewById(R.id.textNaslovHorror1);
        naslov2 = findViewById(R.id.textNaslovHorror2);
        naslov3 = findViewById(R.id.textNaslovHorror3);
        naslov4 = findViewById(R.id.textNaslovHorror4);
        naslov5 = findViewById(R.id.textNaslovHorror5);
        pisac1 = findViewById(R.id.textImePiscaHorror1);
        pisac2 = findViewById(R.id.textImePiscaHorror2);
        pisac3 = findViewById(R.id.textImePiscaHorror3);
        pisac4 = findViewById(R.id.textImePiscaHorror4);
        pisac5 = findViewById(R.id.textImePiscaHorror5);
        back = findViewById(R.id.backArrowHorror);
        forward = findViewById(R.id.forwardArrowHorror);
        currentPage = findViewById(R.id.textCurrentPageHorror);
        backToCategory = findViewById(R.id.backHorror);

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
                    i = new Intent(HorrorCategory.this, HomeScreenReader.class);
                }else{
                    i = new Intent(HorrorCategory.this, HomeScreenWriter.class);
                }
                startActivity(i);
                finish();
            }
        });

    }
}