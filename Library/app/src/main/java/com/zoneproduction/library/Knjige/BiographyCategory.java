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

public class BiographyCategory extends AppCompatActivity {

    ImageView knjiga1, knjiga2, knjiga3, knjiga4, knjiga5, back, forward, backToCategory;
    TextView naslov1, naslov2, naslov3, naslov4, naslov5, pisac1, pisac2, pisac3, pisac4, pisac5, currentPage;
    int totalPages = 0;
    HomeScreenReader hsr = new HomeScreenReader();
    String type = hsr.getType();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biography_category);

        knjiga1 = findViewById(R.id.imageKnjigeBiograph1);
        knjiga2 = findViewById(R.id.imageKnjigaBiograph2);
        knjiga3 = findViewById(R.id.imageKnjigaBiograph3);
        knjiga4 = findViewById(R.id.imageKnjigaBiograph4);
        knjiga5 = findViewById(R.id.imageKnjigaBiograph5);
        naslov1 = findViewById(R.id.textNaslovBiograph1);
        naslov2 = findViewById(R.id.textNaslovBiograph2);
        naslov3 = findViewById(R.id.textNaslovBiograph3);
        naslov4 = findViewById(R.id.textNaslovBiograph4);
        naslov5 = findViewById(R.id.textNaslovBiograph5);
        pisac1 = findViewById(R.id.textImePiscaBiograph1);
        pisac2 = findViewById(R.id.textImePiscaBiograph2);
        pisac3 = findViewById(R.id.textImePiscaBiograph3);
        pisac4 = findViewById(R.id.textImePiscaBiograph4);
        pisac5 = findViewById(R.id.textImePiscaBiograph5);
        back = findViewById(R.id.backArrowBiograph);
        forward = findViewById(R.id.forwardArrowBiograph);
        currentPage = findViewById(R.id.textCurrentPageBiograph);
        backToCategory = findViewById(R.id.backBiograph);

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
                    i = new Intent(BiographyCategory.this, HomeScreenReader.class);
                }else{
                    i = new Intent(BiographyCategory.this, HomeScreenWriter.class);
                }
                startActivity(i);
                finish();
            }
        });

    }
}