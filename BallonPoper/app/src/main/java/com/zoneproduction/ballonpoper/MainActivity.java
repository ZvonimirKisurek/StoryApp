package com.zoneproduction.ballonpoper;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTime, textViewCountDown, textViewScore;

    private ImageView balloon1, balloon2, balloon3, balloon4, balloon5, balloon6, balloon7, balloon8, balloon9;
    private GridLayout gridLayout;
    int score = 0;

    Runnable runnable;
    Handler handler;

    ImageView[] balloonArray;

    MediaPlayer mediaPlayer;
    MediaPlayer mamic1;
    MediaPlayer mamic2;

    CountDownTimer mCountDownTimer;
    long countdownPeriod;

    boolean status = false;
    int which;
    long time = 30000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTime = findViewById(R.id.textViewTime);
        textViewCountDown = findViewById(R.id.textViewCountDown);
        textViewScore = findViewById(R.id.textViewScore);
        balloon1 = findViewById(R.id.balloon1);
        balloon2 = findViewById(R.id.balloon2);
        balloon3 = findViewById(R.id.balloon3);
        balloon4 = findViewById(R.id.balloon4);
        balloon5 = findViewById(R.id.balloon5);
        balloon6 = findViewById(R.id.balloon6);
        balloon7 = findViewById(R.id.balloon7);
        balloon8 = findViewById(R.id.balloon8);
        balloon9 = findViewById(R.id.balloon9);
        gridLayout = findViewById(R.id.gridLayout);


        mamic1 = MediaPlayer.create(this, R.raw.mamic1);
        mamic2 = MediaPlayer.create(this, R.raw.mamic2);
        mediaPlayer = MediaPlayer.create(this, R.raw.nesjecamse);


        balloonArray = new ImageView[]{balloon1, balloon2, balloon3, balloon4, balloon5, balloon6, balloon7, balloon8, balloon9};

        countdownPeriod = 30000;
        time = countdownPeriod;

        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                textViewCountDown.setText(String.valueOf(millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {

                balloonsControl();
                createCountDownTimer();

//                new CountDownTimer(time, 1000) {
//                    @Override
//                    public void onTick(long millisUntilFinished) {
//
//                        textViewTime.setText("Remaining time : " + millisUntilFinished/1000);
//
//                    }
//
//                    @Override
//                    public void onFinish() {
//
//                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
//                        intent.putExtra("score",score);
//                        startActivity(intent);
//                        finish();
//
//                    }
//                }.start();

            }
        }.start();

    }


    public void increaseScoreByOne(View view) {

        score++;
        if(score > 999){
            textViewScore.setText("Trenutna utaja poreza : " + (score / 1000) + " milijuna");
        }else{
            textViewScore.setText("Trenutna utaja poreza : " + score + " tisuća");
        }
        if (which == 0) {
            if (mamic1.isPlaying()) {
                mamic1.seekTo(0);
                mamic1.start();
            }
            if (mamic2.isPlaying()) {
                mamic2.pause();
                mamic2.seekTo(0);
            }
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
            if (mCountDownTimer != null)
                mCountDownTimer.cancel();
            createCountDownTimer();

            mamic1.start();
        } else if (which == 1) {
            if (mamic1.isPlaying()) {
                mamic1.pause();
                mamic1.seekTo(0);
            }
            if (mamic2.isPlaying()) {
                mamic2.seekTo(0);
                mamic2.start();
            }
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
            mamic2.start();
            if (mCountDownTimer != null)
                mCountDownTimer.cancel();
            createCountDownTimer();
        } else {
            if (mamic1.isPlaying()) {
                mamic1.pause();
                mamic1.seekTo(0);
            }
            if (mamic2.isPlaying()) {
                mamic2.pause();
                mamic2.seekTo(0);
            }
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            }
            mediaPlayer.start();
        }

        if (view.getId() == balloon1.getId()) {
            if (which != 2) {
                balloon1.setImageResource(R.drawable.ludimamic);
            } else {
                balloon1.setImageResource(R.drawable.modri);
            }
        }
        if (view.getId() == balloon2.getId()) {
            if (which != 2) {
                balloon2.setImageResource(R.drawable.ludimamic);
            } else {
                balloon2.setImageResource(R.drawable.modri);
            }
        }
        if (view.getId() == balloon3.getId()) {
            if (which != 2) {
                balloon3.setImageResource(R.drawable.ludimamic);
            } else {
                balloon3.setImageResource(R.drawable.modri);
            }
        }
        if (view.getId() == balloon4.getId()) {
            if (which != 2) {
                balloon4.setImageResource(R.drawable.ludimamic);
            } else {
                balloon4.setImageResource(R.drawable.modri);
            }
        }
        if (view.getId() == balloon5.getId()) {
            if (which != 2) {
                balloon5.setImageResource(R.drawable.ludimamic);
            } else {
                balloon5.setImageResource(R.drawable.modri);
            }
        }
        if (view.getId() == balloon6.getId()) {
            if (which != 2) {
                balloon6.setImageResource(R.drawable.ludimamic);
            } else {
                balloon6.setImageResource(R.drawable.modri);
            }
        }
        if (view.getId() == balloon7.getId()) {
            if (which != 2) {
                balloon7.setImageResource(R.drawable.ludimamic);
            } else {
                balloon7.setImageResource(R.drawable.modri);
            }
        }
        if (view.getId() == balloon8.getId()) {
            if (which != 2) {
                balloon8.setImageResource(R.drawable.ludimamic);
            } else {
                balloon8.setImageResource(R.drawable.modri);
            }
        }
        if (view.getId() == balloon9.getId()) {
            if (which != 2) {
                balloon9.setImageResource(R.drawable.ludimamic);
            } else {
                balloon9.setImageResource(R.drawable.modri);
            }
        }
    }


    public void balloonsControl() {

        textViewCountDown.setVisibility(View.INVISIBLE);
        textViewTime.setVisibility(View.VISIBLE);
        textViewScore.setVisibility(View.VISIBLE);
        gridLayout.setVisibility(View.VISIBLE);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                for (ImageView balloon : balloonArray) {

                    balloon.setVisibility(View.INVISIBLE);
                    balloon.setImageResource(R.drawable.baloon);
                }

                gridLayout.setVisibility(View.VISIBLE);

                Random random = new Random();
                int i = random.nextInt(balloonArray.length);
                int orOr = random.nextInt(4);
                if (orOr == 1) {
                    balloonArray[i].setImageResource(R.drawable.miranmamic);
                    balloonArray[i].setVisibility(View.VISIBLE);
                    Random randomM = new Random();
                    which = randomM.nextInt(2);
                } else {
                    balloonArray[i].setImageResource(R.drawable.baloon);
                    balloonArray[i].setVisibility(View.VISIBLE);
                    which = 2;
                }
//                if (score <= 5) {
//                    handler.postDelayed(runnable, 2000);
//                } else if (score > 5 && score <= 10) {
//                    handler.postDelayed(runnable, 1500);
//                } else if (score > 10 && score <= 15) {
//                    handler.postDelayed(runnable, 1000);
//                } else {
//                    handler.postDelayed(runnable, 500);
//                }
                int delay = 2000 - score * 10;
                handler.postDelayed(runnable,delay);
            }
        };

        handler.post(runnable);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.volume) {

            if (!status) {
                mediaPlayer.setVolume(0, 0);
                item.setIcon(R.drawable.ic_baseline_volume_off_24);
                status = true;
            } else {
                mediaPlayer.setVolume(1, 1);
                item.setIcon(R.drawable.ic_baseline_volume_up_24);
                status = false;
            }

        }

        return super.onOptionsItemSelected(item);
    }

    private void createCountDownTimer() {
        mCountDownTimer = new CountDownTimer(time + 5000, 1) {

            @Override
            public void onTick(long millisUntilFinished) {

                textViewTime.setText("Preostalo vrijeme : " + millisUntilFinished / 1000);
                time = millisUntilFinished;

            }

            @Override
            public void onFinish() {

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("score", score);
                startActivity(intent);
                finish();

            }
        }.start();
    }
}
