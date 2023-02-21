package com.zoneproduction.manageme;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StorageItemDetailActivity extends AppCompatActivity {

    private TextView nazivProizvoda, kategorijaProizvoda, vrijeme;
    EditText količinaProizvoda;
    Button potvrdi, minus1, minus10, plus1, plus10;
    LinearLayout nazad;
    OpenClose op;
    int startState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_item_detail);

        Intent intent = getIntent();
        String numberOfProduct = intent.getExtras().getString("kolicina") == null ? "0" : intent.getExtras().getString("kolicina");
        String extension = intent.getExtras().getString("Nastavak");

        nazivProizvoda = findViewById(R.id.textNazivProizvodaSAID);
        kategorijaProizvoda = findViewById(R.id.textKategorijaProizvodaSAID);
        vrijeme = findViewById(R.id.textCurrentTimeSAID);
        količinaProizvoda = findViewById(R.id.editTextKolicinaProizvodaSAID);
        potvrdi = findViewById(R.id.buttonDodajNoviProizvodSAID);
        nazad = findViewById(R.id.llNatragSAID);
        minus1 = findViewById(R.id.buttonMinusOneSAID);
        minus10 = findViewById(R.id.buttonMinusTenSAID);
        plus1 = findViewById(R.id.buttonPlusOneSAID);
        plus10 = findViewById(R.id.buttonPlusTenSAID);

        setTime(vrijeme);
        količinaProizvoda.setText(numberOfProduct);
        startState = Integer.parseInt(količinaProizvoda.getText().toString());

        nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if (extension.equals("VO")) {
                    intent = new Intent(StorageItemDetailActivity.this, StorageActivityVO.class);
                } else {
                    intent = new Intent(StorageItemDetailActivity.this, StorageActivityPO.class);
                }
                startActivity(intent);
                finish();
            }
        });

        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currState = Integer.parseInt(količinaProizvoda.getText().toString());
                currState--;
                setTime(vrijeme);
                količinaProizvoda.setText(String.valueOf(currState));
                checkState(startState, currState);
            }
        });

        minus10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currState = Integer.parseInt(količinaProizvoda.getText().toString());
                currState -= 10;
                setTime(vrijeme);
                količinaProizvoda.setText(String.valueOf(currState));
                checkState(startState, currState);
            }
        });

        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currState = Integer.parseInt(količinaProizvoda.getText().toString());
                currState++;
                setTime(vrijeme);
                količinaProizvoda.setText(String.valueOf(currState));
                checkState(startState, currState);
            }
        });

        plus10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currState = Integer.parseInt(količinaProizvoda.getText().toString());
                currState += 10;
                setTime(vrijeme);
                količinaProizvoda.setText(String.valueOf(currState));
                checkState(startState, currState);
            }
        });

        potvrdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime(vrijeme);
                startState = Integer.parseInt(količinaProizvoda.getText().toString());
                checkState(startState, startState);
            }
        });

    }

    public void checkState(int start, int curr) {
        if (start < curr) {
            količinaProizvoda.setTextColor(Color.GREEN);
            if (potvrdi.getVisibility() == View.INVISIBLE) {
                potvrdi.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(potvrdi);
            }
        } else if (start > curr) {
            količinaProizvoda.setTextColor(Color.RED);
            if (potvrdi.getVisibility() == View.INVISIBLE) {
                potvrdi.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(potvrdi);
            }
        } else {
            količinaProizvoda.setTextColor(Color.WHITE);
            potvrdi.setVisibility(View.INVISIBLE);
        }
    }

    public void setTime(TextView tv) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        tv.setText(now.format(dtf));
    }
}