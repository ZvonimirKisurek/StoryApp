package com.zoneproduction.manageme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class WorkerCategoryChoiceActivity extends AppCompatActivity {

    ImageButton restoran, plan, storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_category_choice);

        restoran = findViewById(R.id.imageButtonRestoranCC);
        plan = findViewById(R.id.imageButtonRoomPlanCC);
        storage = findViewById(R.id.imageButtonStorageCC);

        restoran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkerCategoryChoiceActivity.this, KitchenPlanActivityVO.class);
                startActivity(intent);
                finish();
            }
        });
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkerCategoryChoiceActivity.this, RoomPlanActivityVO.class);
                startActivity(intent);
                finish();
            }
        });
        storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkerCategoryChoiceActivity.this, StorageActivityVO.class);
                startActivity(intent);
                finish();
            }
        });
    }
}