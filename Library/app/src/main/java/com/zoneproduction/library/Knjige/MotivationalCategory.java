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

public class MotivationalCategory extends AppCompatActivity {

    ImageView knjiga1, knjiga2, knjiga3, knjiga4, knjiga5, back, forward, backToCategory;
    TextView naslov1, naslov2, naslov3, naslov4, naslov5, pisac1, pisac2, pisac3, pisac4, pisac5, currentPage;
    int totalPages = 0;
    HomeScreenReader hsr = new HomeScreenReader();
    String type = hsr.getType();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivational_category);

        knjiga1 = findViewById(R.id.imageKnjigeMotivational1);
        knjiga2 = findViewById(R.id.imageKnjigaMotivational2);
        knjiga3 = findViewById(R.id.imageKnjigaMotivational3);
        knjiga4 = findViewById(R.id.imageKnjigaMotivational4);
        knjiga5 = findViewById(R.id.imageKnjigaMotivational5);
        naslov1 = findViewById(R.id.textNaslovMotivational1);
        naslov2 = findViewById(R.id.textNaslovMotivational2);
        naslov3 = findViewById(R.id.textNaslovMotivational3);
        naslov4 = findViewById(R.id.textNaslovMotivational4);
        naslov5 = findViewById(R.id.textNaslovMotivational5);
        pisac1 = findViewById(R.id.textImePiscaMotivational1);
        pisac2 = findViewById(R.id.textImePiscaMotivational2);
        pisac3 = findViewById(R.id.textImePiscaMotivational3);
        pisac4 = findViewById(R.id.textImePiscaMotivational4);
        pisac5 = findViewById(R.id.textImePiscaMotivational5);
        back = findViewById(R.id.backArrowMotivational);
        forward = findViewById(R.id.forwardArrowMotivational);
        currentPage = findViewById(R.id.textCurrentPageMotivational);
        backToCategory = findViewById(R.id.backMotivational);

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
                    i = new Intent(MotivationalCategory.this, HomeScreenReader.class);
                }else{
                    i = new Intent(MotivationalCategory.this, HomeScreenWriter.class);
                }
                startActivity(i);
                finish();
            }
        });

    }
}