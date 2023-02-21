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

public class FinancialCategory extends AppCompatActivity {

    ImageView knjiga1, knjiga2, knjiga3, knjiga4, knjiga5, back, forward,backToCategory;
    TextView naslov1, naslov2, naslov3, naslov4, naslov5, pisac1, pisac2, pisac3, pisac4, pisac5, currentPage;
    int totalPages = 0;
    HomeScreenReader hsr = new HomeScreenReader();
    String type = hsr.getType();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_category);

        knjiga1 = findViewById(R.id.imageKnjigaFinancial1);
        knjiga2 = findViewById(R.id.imageKnjigaFinancial2);
        knjiga3 = findViewById(R.id.imageKnjigaFinancial3);
        knjiga4 = findViewById(R.id.imageKnjigaFinancial4);
        knjiga5 = findViewById(R.id.imageKnjigaFinancial5);
        naslov1 = findViewById(R.id.textNaslovFinancial1);
        naslov2 = findViewById(R.id.textNaslovFinancial2);
        naslov3 = findViewById(R.id.textNaslovFinancial3);
        naslov4 = findViewById(R.id.textNaslovFinancial4);
        naslov5 = findViewById(R.id.textNaslovFinancial5);
        pisac1 = findViewById(R.id.textImePiscaFinancial1);
        pisac2 = findViewById(R.id.textImePiscaFinancial2);
        pisac3 = findViewById(R.id.textImePiscaFinancial3);
        pisac4 = findViewById(R.id.textImePiscaFinancial4);
        pisac5 = findViewById(R.id.textImePiscaFinancial5);
        back = findViewById(R.id.backArrowFinancial);
        forward = findViewById(R.id.forwardArrowFinancial);
        currentPage = findViewById(R.id.textCurrentPageFinancial);
        backToCategory = findViewById(R.id.backFinancial);

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
                    i = new Intent(FinancialCategory.this, HomeScreenReader.class);
                }else{
                    i = new Intent(FinancialCategory.this, HomeScreenWriter.class);
                }
                startActivity(i);
                finish();
            }
        });

    }
}