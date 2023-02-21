package com.zoneproduction.hotelmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import de.hdodenhof.circleimageview.CircleImageView;

public class InfoRoomActivity extends AppCompatActivity {

    private TextView brojSobe, imeUsluge, vrijemeAktivnosti, napomena, vrijeme1, vrijeme2, vrijeme3, vrijeme4, vrijeme5, vrijeme6, vrijeme7, vrijeme8, vrijeme9, vrijeme10, vrijeme11,
                    vrijeme12;
    private ImageView slikaUsluge, profilDjelatnika, urediNapomenu, iducaAktivnost, proslaAktivnost;
    private CircleImageView profil1, profil2, profil3, profil4, profil5;
    private Button odabir1, odabir2, odabir3, odabir4, odabir5, nazadNaPlan, promijenaTermina, promijenaDjelatnika;
    private ConstraintLayout aktivnost, djelatnik1, djelatnik2, djelatnik3, djelatnik4, djelatnik5, infoRoomActivity;
    private LinearLayout djelatnici, vrijeme;
    OpenClose op = new OpenClose();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_room);

        infoRoomActivity = findViewById(R.id.clInfoRoomActivity);
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
        nazadNaPlan = findViewById(R.id.buttonBackToPlanIR);
        promijenaTermina = findViewById(R.id.buttonPromijenaVremenaIR);
        promijenaDjelatnika = findViewById(R.id.buttonPromjeniDjelatnikaIR);
        aktivnost = findViewById(R.id.clAktivnostIR);
        djelatnik1 = findViewById(R.id.clDjelatnik1IR);
        djelatnik2 = findViewById(R.id.clDjelatnik2IR);
        djelatnik3 = findViewById(R.id.clDjelatnik3IR);
        djelatnik4 = findViewById(R.id.clDjelatnik4IR);
        djelatnik5 = findViewById(R.id.clDjelatnik5IR);
        djelatnici = findViewById(R.id.llIzborDjelatnikaIR);
        vrijeme = findViewById(R.id.llIzborVremenaIR);

        Animation animationIntro = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_faster);
        infoRoomActivity.startAnimation(animationIntro);

        nazadNaPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(InfoRoomActivity.this, RoomPlanActivity.class);
                startActivity(intent);
                finish();

            }
        });

        promijenaTermina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                op.closeRoomFast(getApplicationContext(), djelatnici);
                vrijeme.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(vrijeme);

            }
        });

        promijenaDjelatnika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                op.closeRoomFast(getApplicationContext(), vrijeme);
                djelatnici.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(djelatnici);

            }
        });

    }
}