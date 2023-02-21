package com.zoneproduction.library.GlavniScreenovi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zoneproduction.library.R;

public class BookBuyer extends AppCompatActivity {

    ImageView imageKnjiga, back;
    TextView imePisca, imeKnjige, opis, price;
    Button buyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_buyer);

        imageKnjiga = findViewById(R.id.imageKnjigaBuyer);
        back = findViewById(R.id.backBuyer);
        imePisca = findViewById(R.id.textImePiscaBuyer);
        imeKnjige = findViewById(R.id.textImeKnjigeBuyer);
        opis = findViewById(R.id.textOpisKnjigeBuyer);
        price = findViewById(R.id.textPriceBuyer);
        buyButton = findViewById(R.id.buttonBuyBuyer);

    }
}