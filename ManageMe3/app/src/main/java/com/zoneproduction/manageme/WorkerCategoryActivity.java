package com.zoneproduction.manageme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class WorkerCategoryActivity extends AppCompatActivity {

    ImageButton schedule, tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_category);

        schedule = findViewById(R.id.imageButtonScheduleCW);
        tasks = findViewById(R.id.imageButtonTasksCW);

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkerCategoryActivity.this, WorkingScheduleActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkerCategoryActivity.this, MyTasksActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}