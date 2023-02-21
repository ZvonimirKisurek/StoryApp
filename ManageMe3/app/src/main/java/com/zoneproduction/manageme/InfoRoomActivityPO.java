package com.zoneproduction.manageme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class InfoRoomActivityPO extends AppCompatActivity {

    private TextView brojSobe, imeUsluge, vrijemeAktivnosti, napomena, vrijeme1, vrijeme2, vrijeme3, vrijeme4, vrijeme5, vrijeme6, vrijeme7, vrijeme8, vrijeme9, vrijeme10, vrijeme11,
            vrijeme12, currentTime;
    private ImageView slikaUsluge, profilDjelatnika, urediNapomenu, iducaAktivnost, proslaAktivnost;
    private CircleImageView profil1, profil2, profil3, profil4, profil5;
    private Button odabir1, odabir2, odabir3, odabir4, odabir5, promijenaTermina, promijenaDjelatnika;
    private ConstraintLayout aktivnost, djelatnik1, djelatnik2, djelatnik3, djelatnik4, djelatnik5, infoRoomActivity;
    private LinearLayout djelatnici, vrijeme, natrag;
    OpenClose op = new OpenClose();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_room_po);

        infoRoomActivity = findViewById(R.id.clInfoRoomActivityPO);
        brojSobe = findViewById(R.id.textRoomNumberIR);
        imeUsluge = findViewById(R.id.textAktivnostIR);
        vrijemeAktivnosti = findViewById(R.id.textVrijemeAktivnostiIR);
        napomena = findViewById(R.id.textNapomenaIR);
        slikaUsluge = findViewById(R.id.imageAktivnostIR);
        profilDjelatnika = findViewById(R.id.imageProfilDjelatnikaIR);
        urediNapomenu = findViewById(R.id.imageUrediNapomenuIR);
        iducaAktivnost = findViewById(R.id.imageIducaAktivnostIR);
        proslaAktivnost = findViewById(R.id.imageProslaAktivnostIR);
        vrijeme1 = findViewById(R.id.textTime1IR);
        vrijeme2 = findViewById(R.id.textTime2IR);
        vrijeme3 = findViewById(R.id.textTime3IR);
        vrijeme4 = findViewById(R.id.textTime4IR);
        vrijeme5 = findViewById(R.id.textTime5IR);
        vrijeme6 = findViewById(R.id.textTime6IR);
        vrijeme7 = findViewById(R.id.textTime7IR);
        vrijeme8 = findViewById(R.id.textTime8IR);
        vrijeme9 = findViewById(R.id.textTime9IR);
        vrijeme10 = findViewById(R.id.textTime10IR);
        vrijeme11 = findViewById(R.id.textTime11IR);
        vrijeme12 = findViewById(R.id.textTime12IR);
        profil1 = findViewById(R.id.imageDjelatnika1IR);
        profil2 = findViewById(R.id.imageDjelatnika2IR);
        profil3 = findViewById(R.id.imageDjelatnika3IR);
        profil4 = findViewById(R.id.imageDjelatnika4IR);
        profil5 = findViewById(R.id.imageDjelatnika5IR);
        odabir1 = findViewById(R.id.buttonOdabirDjelatnika1IR);
        odabir2 = findViewById(R.id.buttonOdabirDjelatnika2IR);
        odabir3 = findViewById(R.id.buttonOdabirDjelatnika3IR);
        odabir4 = findViewById(R.id.buttonOdabirDjelatnika4IR);
        odabir5 = findViewById(R.id.buttonOdabirDjelatnika5IR);
        natrag = findViewById(R.id.llNatragIRPO);
        aktivnost = findViewById(R.id.clAktivnostIR);
        djelatnik1 = findViewById(R.id.clDjelatnik1IR);
        djelatnik2 = findViewById(R.id.clDjelatnik2IR);
        djelatnik3 = findViewById(R.id.clDjelatnik3IR);
        djelatnik4 = findViewById(R.id.clDjelatnik4IR);
        djelatnik5 = findViewById(R.id.clDjelatnik5IR);
        djelatnici = findViewById(R.id.llIzborDjelatnikaIR);
        vrijeme = findViewById(R.id.llIzborVremenaIR);
        currentTime = findViewById(R.id.textCurrentTimeIRPO);

        Animation animationIntro = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_faster);
        infoRoomActivity.startAnimation(animationIntro);

        op.setTime(currentTime);

        natrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoRoomActivityPO.this, RoomPlanActivityPO.class);
                startActivity(intent);
                finish();
            }
        });

    }
}