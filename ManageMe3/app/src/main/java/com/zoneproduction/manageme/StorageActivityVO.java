package com.zoneproduction.manageme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageActivityVO extends AppCompatActivity {

    private LinearLayout backToMain, layoutIzborProstora;
    private TextView dodavanjeStavke, currentTime;
    private List<String> listNamesOfProducts = new ArrayList<>();
    private Map<String, Integer> proizvodi = new HashMap<>();
    private LinearLayout proizvod1, proizvod2, proizvod3, proizvod4, proizvod5, proizvod6, proizvod7, proizvod8, proizvod9, proizvod10, proizvod11, proizvod12, proizvod13;
    private TextView imeProizvoda1, imeProizvoda2, imeProizvoda3, imeProizvoda4, imeProizvoda5, imeProizvoda6, imeProizvoda7, imeProizvoda8, imeProizvoda9, imeProizvoda10,
            imeProizvoda11, imeProizvoda12, imeProizvoda13, komadiProizvoda1, komadiProizvoda2, komadiProizvoda3, komadiProizvoda4, komadiProizvoda5, komadiProizvoda6,
            komadiProizvoda7, komadiProizvoda8, komadiProizvoda9, komadiProizvoda10, komadiProizvoda11, komadiProizvoda12, komadiProizvoda13, minus1, minus2,
            minus3, minus4, minus5, minus6, minus7, minus8, minus9, minus10, minus11, minus12, minus13, plus1, plus2, plus3, plus4, plus5, plus6, plus7, plus8,
            plus9, plus10, plus11, plus12, plus13, detail1, detail2, detail3, detail4, detail5, detail6, detail7, detail8, detail9, detail10, detail11, detail12,
            detail13, restoran, planSobe;
    private EditText imeDodanogProizvoda, kolicinaDodanogProizvoda;
    private Button dodajProizvod;
    private ConstraintLayout noviProizvod, storageActivity;
    private ImageView close;
    private ImageButton izborProstora;
    private int currentEmpty = proizvodi.size() + 1;
    private boolean isAlreadyOpenProstor = false;
    private OpenClose op = new OpenClose();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_vo);
        Map<String, Integer> add = new HashMap<>();
        proizvodi.put("Sapun", 100);
        proizvodi.put("Coca-Cola 330ml", 100);
        proizvodi.put("Brašno oštro 1kg", 100);
        listNamesOfProducts.add("Sapun");
        listNamesOfProducts.add("Coca-Cola 330ml");
        listNamesOfProducts.add("Brašno oštro 1kg");

        planSobe = findViewById(R.id.textProstor1SA);
        storageActivity = findViewById(R.id.clSAVO);
        restoran = findViewById(R.id.textProstor2SA);
        imeDodanogProizvoda = findViewById(R.id.editTextNazivDodanogProizvodaSA);
        kolicinaDodanogProizvoda = findViewById(R.id.editTextKolicinaProizvodaSAID);
        dodajProizvod = findViewById(R.id.buttonDodajNoviProizvodSA);
        noviProizvod = findViewById(R.id.clDodatiProizvodSA);
        close = findViewById(R.id.imageCloseDodatiProizvodSA);
        backToMain = findViewById(R.id.llNatragSAID);
        dodavanjeStavke = findViewById(R.id.textDodatiStavkuSA);
        proizvod1 = findViewById(R.id.proizvod1SA);
        proizvod2 = findViewById(R.id.proizvod2SA);
        proizvod3 = findViewById(R.id.proizvod3SA);
        proizvod4 = findViewById(R.id.proizvod4SA);
        proizvod5 = findViewById(R.id.proizvod5SA);
        proizvod6 = findViewById(R.id.proizvod6SA);
        proizvod7 = findViewById(R.id.proizvod7SA);
        proizvod8 = findViewById(R.id.proizvod8SA);
        proizvod9 = findViewById(R.id.proizvod9SA);
        proizvod10 = findViewById(R.id.proizvod10SA);
        proizvod11 = findViewById(R.id.proizvod11SA);
        proizvod12 = findViewById(R.id.proizvod12SA);
        proizvod13 = findViewById(R.id.proizvod13SA);
        imeProizvoda1 = findViewById(R.id.textNazivProizvoda1SA);
        imeProizvoda2 = findViewById(R.id.textNazivProizvoda2SA);
        imeProizvoda3 = findViewById(R.id.textNazivProizvoda3SA);
        imeProizvoda4 = findViewById(R.id.textNazivProizvoda4SA);
        imeProizvoda5 = findViewById(R.id.textNazivProizvoda5SA);
        imeProizvoda6 = findViewById(R.id.textNazivProizvoda6SA);
        imeProizvoda7 = findViewById(R.id.textNazivProizvoda7SA);
        imeProizvoda8 = findViewById(R.id.textNazivProizvoda8SA);
        imeProizvoda9 = findViewById(R.id.textNazivProizvoda9SA);
        imeProizvoda10 = findViewById(R.id.textNazivProizvoda10SA);
        imeProizvoda11 = findViewById(R.id.textNazivProizvoda11SA);
        imeProizvoda12 = findViewById(R.id.textNazivProizvoda12SA);
        imeProizvoda13 = findViewById(R.id.textNazivProizvoda13SA);
        komadiProizvoda1 = findViewById(R.id.textBrojKomada1SA);
        komadiProizvoda2 = findViewById(R.id.textBrojKomada2SA);
        komadiProizvoda3 = findViewById(R.id.textBrojKomada3SA);
        komadiProizvoda4 = findViewById(R.id.textBrojKomada4SA);
        komadiProizvoda5 = findViewById(R.id.textBrojKomada5SA);
        komadiProizvoda6 = findViewById(R.id.textBrojKomada6SA);
        komadiProizvoda7 = findViewById(R.id.textBrojKomada7SA);
        komadiProizvoda8 = findViewById(R.id.textBrojKomada8SA);
        komadiProizvoda9 = findViewById(R.id.textBrojKomada9SA);
        komadiProizvoda10 = findViewById(R.id.textBrojKomada10SA);
        komadiProizvoda11 = findViewById(R.id.textBrojKomada11SA);
        komadiProizvoda12 = findViewById(R.id.textBrojKomada12SA);
        komadiProizvoda13 = findViewById(R.id.textBrojKomada13SA);
        minus1 = findViewById(R.id.textMinusKom1SA);
        minus2 = findViewById(R.id.textMinusKom2SA);
        minus3 = findViewById(R.id.textMinusKom3SA);
        minus4 = findViewById(R.id.textMinusKom4SA);
        minus5 = findViewById(R.id.textMinusKom5SA);
        minus6 = findViewById(R.id.textMinusKom6SA);
        minus7 = findViewById(R.id.textMinusKom7SA);
        minus8 = findViewById(R.id.textMinusKom8SA);
        minus9 = findViewById(R.id.textMinusKom9SA);
        minus10 = findViewById(R.id.textMinusKom10SA);
        minus11 = findViewById(R.id.textMinusKom11SA);
        minus12 = findViewById(R.id.textMinusKom12SA);
        minus13 = findViewById(R.id.textMinusKom13SA);
        plus1 = findViewById(R.id.textPlusKom1SA);
        plus2 = findViewById(R.id.textPlusKom2SA);
        plus3 = findViewById(R.id.textPlusKom3SA);
        plus4 = findViewById(R.id.textPlusKom4SA);
        plus5 = findViewById(R.id.textPlusKom5SA);
        plus6 = findViewById(R.id.textPlusKom6SA);
        plus7 = findViewById(R.id.textPLusKom7SA);
        plus8 = findViewById(R.id.textPlusKom8SA);
        plus9 = findViewById(R.id.textPlusKom9SA);
        plus10 = findViewById(R.id.textPlusKom10SA);
        plus11 = findViewById(R.id.textPlusKom11SA);
        plus12 = findViewById(R.id.textPlusKom12SA);
        plus13 = findViewById(R.id.textPlusKom13SA);
        detail1 = findViewById(R.id.textDetailProizvoda1SAVO);
        detail2 = findViewById(R.id.textDetailProizvoda2SAVO);
        detail3 = findViewById(R.id.textDetailProizvoda3SAVO);
        detail4 = findViewById(R.id.textDetailProizvoda4SAVO);
        detail5 = findViewById(R.id.textDetailProizvoda5SAVO);
        detail6 = findViewById(R.id.textDetailProizvoda6SAVO);
        detail7 = findViewById(R.id.textDetailProizvoda7SAVO);
        detail8 = findViewById(R.id.textDetailProizvoda8SAVO);
        detail9 = findViewById(R.id.textDetailProizvoda9SAVO);
        detail10 = findViewById(R.id.textDetailProizvoda10SAVO);
        detail11 = findViewById(R.id.textDetailProizvoda11SAVO);
        detail12 = findViewById(R.id.textDetailProizvoda12SAVO);
        detail13 = findViewById(R.id.textDetailProizvoda13SAVO);
        izborProstora = findViewById(R.id.imageDropNameStageSA);
        layoutIzborProstora = findViewById(R.id.clOdabirProstorijeKPVO);
        currentTime = findViewById(R.id.textCurrentTimeSAVO);

        Animation animationIntro = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_faster);
        storageActivity.startAnimation(animationIntro);

        fillItems();
        op.setTime(currentTime);

        planSobe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StorageActivityVO.this, RoomPlanActivityVO.class);
                startActivity(i);
                finish();
            }
        });

        restoran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StorageActivityVO.this, KitchenPlanActivityVO.class);
                startActivity(i);
                finish();
            }
        });

        izborProstora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                if (isAlreadyOpenProstor) {
                    YoYo.with(Techniques.BounceInUp).duration(500).repeat(0).playOn(layoutIzborProstora);
                    layoutIzborProstora.setVisibility(View.INVISIBLE);
                    isAlreadyOpenProstor = false;
                } else {
                    layoutIzborProstora.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.BounceInDown).duration(500).repeat(0).playOn(layoutIzborProstora);
                    isAlreadyOpenProstor = true;
                }
            }
        });

        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StorageActivityVO.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        dodajProizvod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                proizvodi.put(imeDodanogProizvoda.getText().toString(), Integer.parseInt(kolicinaDodanogProizvoda.getText().toString()));
                fillItems();
                currentEmpty++;
                Animation outro = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.outro_anim);
                noviProizvod.startAnimation(outro);
                noviProizvod.setVisibility(View.INVISIBLE);
            }
        });

        dodavanjeStavke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                noviProizvod.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceInDown).duration(500).repeat(0).playOn(noviProizvod);
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                Animation outro = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.outro_anim);
                noviProizvod.startAnimation(outro);
                noviProizvod.setVisibility(View.INVISIBLE);
            }
        });

        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(1);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ--;
                quantity.setText(String.valueOf(currQ));
            }
        });
        minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(2);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ--;
                quantity.setText(String.valueOf(currQ));
            }
        });
        minus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(3);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ--;
                quantity.setText(String.valueOf(currQ));
            }
        });
        minus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(4);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ--;
                quantity.setText(String.valueOf(currQ));
            }
        });
        minus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(5);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ--;
                quantity.setText(String.valueOf(currQ));
            }
        });
        minus6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(6);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ--;
                quantity.setText(String.valueOf(currQ));
            }
        });
        minus7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(7);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ--;
                quantity.setText(String.valueOf(currQ));
            }
        });
        minus8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(8);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ--;
                quantity.setText(String.valueOf(currQ));
            }
        });
        minus9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(9);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ--;
                quantity.setText(String.valueOf(currQ));
            }
        });
        minus10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(10);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ--;
                quantity.setText(String.valueOf(currQ));
            }
        });
        minus11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(11);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ--;
                quantity.setText(String.valueOf(currQ));
            }
        });
        minus12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(12);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ--;
                quantity.setText(String.valueOf(currQ));
            }
        });
        minus13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(13);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ--;
                quantity.setText(String.valueOf(currQ));
            }
        });

        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(1);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ++;
                quantity.setText(String.valueOf(currQ));
            }
        });
        plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(2);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ++;
                quantity.setText(String.valueOf(currQ));
            }
        });
        plus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(3);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ++;
                quantity.setText(String.valueOf(currQ));
            }
        });
        plus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(4);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ++;
                quantity.setText(String.valueOf(currQ));
            }
        });
        plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(5);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ++;
                quantity.setText(String.valueOf(currQ));
            }
        });
        plus6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(6);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ++;
                quantity.setText(String.valueOf(currQ));
            }
        });
        plus7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(7);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ++;
                quantity.setText(String.valueOf(currQ));
            }
        });
        plus8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(8);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ++;
                quantity.setText(String.valueOf(currQ));
            }
        });
        plus9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(9);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ++;
                quantity.setText(String.valueOf(currQ));
            }
        });
        plus10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(10);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ++;
                quantity.setText(String.valueOf(currQ));
            }
        });
        plus11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(11);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ++;
                quantity.setText(String.valueOf(currQ));
            }
        });
        plus12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(12);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ++;
                quantity.setText(String.valueOf(currQ));
            }
        });
        plus13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTime(currentTime);
                TextView quantity = getQuantityOfProduct(13);
                int currQ = Integer.parseInt(quantity.getText().toString());
                currQ++;
                quantity.setText(String.valueOf(currQ));
            }
        });

        detail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StorageActivityVO.this, StorageItemDetailActivity.class);
                intent.putExtra("kolicina", komadiProizvoda1.getText().toString());
                intent.putExtra("Nastavak", "VO");
                startActivity(intent);
            }
        });
        detail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StorageActivityVO.this, StorageItemDetailActivity.class);
                intent.putExtra("kolicina", komadiProizvoda2.getText().toString());
                intent.putExtra("Nastavak", "VO");
                startActivity(intent);
            }
        });
        detail3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StorageActivityVO.this, StorageItemDetailActivity.class);
                intent.putExtra("kolicina", komadiProizvoda3.getText().toString());
                intent.putExtra("Nastavak", "VO");
                startActivity(intent);
            }
        });
        detail4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StorageActivityVO.this, StorageItemDetailActivity.class);
                intent.putExtra("kolicina", komadiProizvoda4.getText().toString());
                intent.putExtra("Nastavak", "VO");
                startActivity(intent);
            }
        });
        detail5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StorageActivityVO.this, StorageItemDetailActivity.class);
                intent.putExtra("kolicina", komadiProizvoda5.getText().toString());
                intent.putExtra("Nastavak", "VO");
                startActivity(intent);
            }
        });
        detail6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StorageActivityVO.this, StorageItemDetailActivity.class);
                intent.putExtra("kolicina", komadiProizvoda6.getText().toString());
                intent.putExtra("Nastavak", "VO");
                startActivity(intent);
            }
        });
        detail7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StorageActivityVO.this, StorageItemDetailActivity.class);
                intent.putExtra("kolicina", komadiProizvoda7.getText().toString());
                intent.putExtra("Nastavak", "VO");
                startActivity(intent);
            }
        });
        detail8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StorageActivityVO.this, StorageItemDetailActivity.class);
                intent.putExtra("kolicina", komadiProizvoda8.getText().toString());
                intent.putExtra("Nastavak", "VO");
                startActivity(intent);
            }
        });
        detail9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StorageActivityVO.this, StorageItemDetailActivity.class);
                intent.putExtra("kolicina", komadiProizvoda9.getText().toString());
                intent.putExtra("Nastavak", "VO");
                startActivity(intent);
            }
        });
        detail10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StorageActivityVO.this, StorageItemDetailActivity.class);
                intent.putExtra("kolicina", komadiProizvoda10.getText().toString());
                intent.putExtra("Nastavak", "VO");
                startActivity(intent);
            }
        });
        detail11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StorageActivityVO.this, StorageItemDetailActivity.class);
                intent.putExtra("kolicina", komadiProizvoda11.getText().toString());
                intent.putExtra("Nastavak", "VO");
                startActivity(intent);
            }
        });
        detail12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StorageActivityVO.this, StorageItemDetailActivity.class);
                intent.putExtra("kolicina", komadiProizvoda12.getText().toString());
                intent.putExtra("Nastavak", "VO");
                startActivity(intent);
            }
        });
        detail13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StorageActivityVO.this, StorageItemDetailActivity.class);
                intent.putExtra("kolicina", komadiProizvoda13.getText().toString());
                intent.putExtra("Nastavak", "VO");
                startActivity(intent);
            }
        });
    }

    public void fillItems() {
        int index = 1;
        for (Map.Entry entry : proizvodi.entrySet()) {
            System.out.print(entry.getKey() + " : " + entry.getValue());
            TextView ime = getNameOfProduct(index), quantity = getQuantityOfProduct(index);
            ime.setText(entry.getKey().toString());
            quantity.setText(entry.getValue().toString());
            LinearLayout ll = getProductLayout(index);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) ll.getLayoutParams();
            params.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            params.width = LinearLayout.LayoutParams.MATCH_PARENT;
            ll.setLayoutParams(params);
            index++;
        }
    }

    public TextView getNameOfProduct(int room) {
        switch (room) {
            case 1:
                return imeProizvoda1;
            case 2:
                return imeProizvoda2;
            case 3:
                return imeProizvoda3;
            case 4:
                return imeProizvoda4;
            case 5:
                return imeProizvoda5;
            case 6:
                return imeProizvoda6;
            case 7:
                return imeProizvoda7;
            case 8:
                return imeProizvoda8;
            case 9:
                return imeProizvoda9;
            case 10:
                return imeProizvoda10;
            case 11:
                return imeProizvoda11;
            case 12:
                return imeProizvoda12;
            default:
                return imeProizvoda13;
        }
    }

    public TextView getQuantityOfProduct(int room) {
        switch (room) {
            case 1:
                return komadiProizvoda1;
            case 2:
                return komadiProizvoda2;
            case 3:
                return komadiProizvoda3;
            case 4:
                return komadiProizvoda4;
            case 5:
                return komadiProizvoda5;
            case 6:
                return komadiProizvoda6;
            case 7:
                return komadiProizvoda7;
            case 8:
                return komadiProizvoda8;
            case 9:
                return komadiProizvoda9;
            case 10:
                return komadiProizvoda10;
            case 11:
                return komadiProizvoda11;
            case 12:
                return komadiProizvoda12;
            default:
                return komadiProizvoda13;
        }
    }

    public LinearLayout getProductLayout(int room) {
        switch (room) {
            case 1:
                return proizvod1;
            case 2:
                return proizvod2;
            case 3:
                return proizvod3;
            case 4:
                return proizvod4;
            case 5:
                return proizvod5;
            case 6:
                return proizvod6;
            case 7:
                return proizvod7;
            case 8:
                return proizvod8;
            case 9:
                return proizvod9;
            case 10:
                return proizvod10;
            case 11:
                return proizvod11;
            case 12:
                return proizvod12;
            default:
                return proizvod13;
        }
    }

}