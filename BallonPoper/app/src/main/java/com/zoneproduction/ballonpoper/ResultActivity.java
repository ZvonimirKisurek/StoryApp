package com.zoneproduction.ballonpoper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewInfo, textViewMyScore, textViewHighestScore;
    private Button buttonPlayAgain, buttonQuitGame;

    int myScore;

    MediaPlayer mediaPlayer;

    //for recording the score
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewHighestScore = findViewById(R.id.textViewHighest);
        textViewMyScore = findViewById(R.id.textViewMyScore);
        textViewInfo = findViewById(R.id.textViewInfo);
        buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
        buttonQuitGame = findViewById(R.id.buttonQuit);

        myScore = getIntent().getIntExtra("score",0);
        textViewMyScore.setText("Your Score : " + myScore);

        sharedPreferences = this.getSharedPreferences("Score", Context.MODE_PRIVATE);
        int highest = sharedPreferences.getInt("highestScore", 0);

        mediaPlayer = MediaPlayer.create(this,R.raw.kraj);

        if(myScore >= highest){

            //saveanje high score-a
            sharedPreferences.edit().putInt("highestScore",myScore).apply();
            textViewHighestScore.setText("Najbolji rezultat : " + myScore);
            textViewInfo.setText("Čestitam utajio si dosad najviše poreza. Želiš li pokušati postat Todorić, igraj opet?");

        }else{

            textViewHighestScore.setText("Najveća utaja poreza : " + highest);
            if((highest-myScore) > 10){
                textViewInfo.setText("Moraš brže potpisati za veći klub");
                mediaPlayer.start();
            }
            if((highest-myScore) > 3){
                textViewInfo.setText("Dobro je blizu si ali Dinamo je Dinamo, a Real je Real.");
                mediaPlayer.start();
            }
            if((highest-myScore) <= 3){
                textViewInfo.setText("Super još malo pa ćeš i ti moći imati vilu u Međimurju");
            }
        }

        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        buttonQuitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);

            }
        });

    }
}