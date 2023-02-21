package com.zoneproduction.flappybirdzasirotinju;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {

    private ImageView bird, enemyRed, enemyGreen, enemyGray, coin1, coin2, right1, right2, right3;
    private TextView textViewScore, textViewStartInfo;
    private ConstraintLayout constraintLayout;

    private boolean touchControl = false;
    private boolean beginControl = false;

    private Runnable runnable;
    private Handler handler;

    //Positions
    int birdX, enemy1X, enemy2X, enemy3X, coin1X, coin2X;
    int birdY, enemy1Y, enemy2Y, enemy3Y, coin1Y, coin2Y;

    //Dimensions of screen
    int screenWidth;
    int screenHeight;

    //remaining right
    int right = 3;

    //points
    int score = 0;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        bird = findViewById(R.id.birdPlayer);
        enemyGray = findViewById(R.id.enemyGrey);
        enemyGreen = findViewById(R.id.enemyGreen);
        enemyRed = findViewById(R.id.enemyRed);
        coin1 = findViewById(R.id.coin1);
        coin2 = findViewById(R.id.coin2);
        right1 = findViewById(R.id.right1);
        right2 = findViewById(R.id.right2);
        right3 = findViewById(R.id.right3);
        textViewScore = findViewById(R.id.textViewScore);
        textViewStartInfo = findViewById(R.id.textViewStartInfo);
        constraintLayout = findViewById(R.id.constraintLayout);

        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                textViewStartInfo.setVisibility(View.INVISIBLE);

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    touchControl = true;
                }

                if(event.getAction() == MotionEvent.ACTION_UP){
                    touchControl = false;
                }

                if(!beginControl){
                    beginControl = true;

                    screenWidth = (int) constraintLayout.getWidth();
                    screenHeight = (int) constraintLayout.getHeight();

                    birdX = (int) bird.getX();
                    birdY = (int) bird.getY();

                    handler = new Handler();
                    runnable = () -> {

                        moveToBird();
                        enemyControl();
                        collisionControl();

                    };
                    handler.post(runnable);
                }else{
                    if(event.getAction() == MotionEvent.ACTION_DOWN){
                        touchControl = true;
                    }

                    if(event.getAction() == MotionEvent.ACTION_UP){
                        touchControl = false;
                    }
                }

                return true;
            }
        });
    }

    public void moveToBird(){

        if(touchControl){
            birdY = birdY - (screenHeight / 50);
        }else{
            birdY = birdY + (screenHeight / 50);
        }

        if(birdY <= 0){
            birdY = 0;
        }

        if(birdY >= (screenHeight - bird.getHeight())-50){
            birdY = (screenHeight - bird.getHeight())-50;
        }

        bird.setY(birdY);

    }

    public void enemyControl(){

        enemyRed.setVisibility(View.VISIBLE);
        enemyGreen.setVisibility(View.VISIBLE);
        enemyGray.setVisibility(View.VISIBLE);
        coin1.setVisibility(View.VISIBLE);
        coin2.setVisibility(View.VISIBLE);

        enemy1X = enemy1X - (screenWidth / 150);

        if(enemy1X < 0){
            enemy1X = screenWidth + 200;
            enemy1Y = (int) Math.floor(Math.random() * screenHeight);

            if(enemy1Y <= 0){
                enemy1Y = 0;
            }

            if(enemy1Y >= (screenHeight - enemyRed.getHeight())){
                enemy1Y = (screenHeight - enemyRed.getHeight());
            }
        }

        enemyRed.setX(enemy1X);
        enemyRed.setY(enemy1Y);

        enemy2X = enemy2X - (screenWidth / 150);

        if(enemy2X < 0){
            enemy2X = screenWidth + 200;
            enemy2Y = (int) Math.floor(Math.random() * screenHeight);

            if(enemy2Y <= 0){
                enemy2Y = 0;
            }

            if(enemy2Y >= (screenHeight - enemyGray.getHeight())){
                enemy2Y = (screenHeight - enemyGray.getHeight());
            }
        }

        enemyGray.setX(enemy2X);
        enemyGray.setY(enemy2Y);

        enemy3X = enemy3X - (screenWidth / 150);

        if(enemy3X < 0){
            enemy3X = screenWidth + 200;
            enemy3Y = (int) Math.floor(Math.random() * screenHeight);

            if(enemy3Y <= 0){
                enemy3Y = 0;
            }

            if(enemy3Y >= (screenHeight - enemyGreen.getHeight())){
                enemy3Y = (screenHeight - enemyGreen.getHeight());
            }
        }

        enemyGreen.setX(enemy3X);
        enemyGreen.setY(enemy3Y);

        coin1X = coin1X - (screenWidth / 150);

        if(coin1X < 0){
            coin1X = screenWidth + 200;
            coin1Y = (int) Math.floor(Math.random() * screenHeight);

            if(coin1Y <= 0){
                coin1Y = 0;
            }

            if(coin1Y >= (screenHeight - coin1.getHeight())){
                coin1Y = (screenHeight - coin1.getHeight());
            }
        }

        coin1.setX(coin1X);
        coin1.setY(coin1Y);

        coin2X = coin2X - (screenWidth / 150);

        if(coin2X < 0){
            coin2X = screenWidth + 200;
            coin2Y = (int) Math.floor(Math.random() * screenHeight);

            if(coin2Y <= 0){
                coin2Y = 0;
            }

            if(coin2Y >= (screenHeight - coin2.getHeight())){
                coin2Y = (screenHeight - coin2.getHeight());
            }
        }

        coin2.setX(coin2X);
        coin2.setY(coin2Y);
        
    }

    public void collisionControl(){

        int centerEnemy1x = enemy1X + enemyRed.getWidth() / 2;
        int centerEnemy1y = enemy1Y + enemyRed.getHeight() / 2;

        if(centerEnemy1x >= birdX && centerEnemy1x <= (birdX + bird.getWidth()) && centerEnemy1y >= birdY && centerEnemy1y <= (birdY + bird.getHeight())){

            enemy1X = screenWidth + 200;
            right--;

        }

        int centerEnemy2x = enemy2X + enemyGray.getWidth() / 2;
        int centerEnemy2y = enemy2Y + enemyGray.getHeight() / 2;

        if(centerEnemy2x >= birdX && centerEnemy2x <= (birdX + bird.getWidth()) && centerEnemy2y >= birdY && centerEnemy2y <= (birdY + bird.getHeight())){

            enemy2X = screenWidth + 200;
            right--;

        }

        int centerEnemy3x = enemy1X + enemyRed.getWidth() / 2;
        int centerEnemy3y = enemy1Y + enemyRed.getHeight() / 2;

        if(centerEnemy3x >= birdX && centerEnemy3x <= (birdX + bird.getWidth()) && centerEnemy3y >= birdY && centerEnemy3y <= (birdY + bird.getHeight())){

            enemy3X = screenWidth + 200;
            right--;

        }

        int coin1x = coin1X + coin1.getWidth() / 2;
        int coin1y = coin1Y + coin1.getHeight() / 2;

        if(coin1x >= birdX && coin1x <= (birdX + bird.getWidth()) && coin1y >= birdY && coin1y <= (birdY + bird.getHeight())){

            coin1x = screenWidth + 200;
            score = score + 10;
            textViewScore.setText("" + score);

        }

        int coin2x = coin2X + coin2.getWidth() / 2;
        int coin2y = coin2Y + coin2.getHeight() / 2;

        if(coin2x >= birdX && coin2x <= (birdX + bird.getWidth()) && coin2y >= birdY && coin2y <= (birdY + bird.getHeight())){

            coin2X = screenWidth + 200;
            score += 10;
            textViewScore.setText("" + score);

        }

        if(right > 0 && score < 200){

            if(right == 2){
                right1.setImageResource(R.drawable.grey_h);
            }
            if(right == 1){
                right2.setImageResource(R.drawable.grey_h);
            }
            handler.postDelayed(runnable, 20);
        }else if(score >= 200){
            handler.removeCallbacks(runnable);
        }else if(right == 0){
            handler.removeCallbacks(runnable);
            right3.setImageResource(R.drawable.grey_h);
            Intent intent = new Intent(GameActivity.this, ResultActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }

}