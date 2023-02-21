package com.zoneproduction.library.GlavniScreenovi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.zoneproduction.library.Adapteri.ViewPagerAdapter;
import com.zoneproduction.library.Adapteri.ViewPagerAdapterWriter;
import com.zoneproduction.library.R;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class HomeScreenWriter extends AppCompatActivity {

    private TabLayout tabLayoutCategory;
    private ViewPager2 viewPagerCategory;
    private Button signOut;
    private TextView greeting;
    String user = "";

    LogInWriter liw = new LogInWriter();
    String type = liw.getType();

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser userID = auth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_writer);
        tabLayoutCategory = findViewById(R.id.tablLayoutWriter);
        viewPagerCategory = findViewById(R.id.viewPagerWriter);
        signOut = findViewById(R.id.buttonSignOutHomeWriter);
        greeting = findViewById(R.id.textGreetingWriter);

        ViewPagerAdapterWriter adapter = new ViewPagerAdapterWriter(getSupportFragmentManager(), getLifecycle());

        viewPagerCategory.setAdapter(adapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayoutCategory, viewPagerCategory, true, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("My Books");
                        break;
                    case 1:
                        tab.setText("Store");
                        break;
                    case 2:
                        tab.setText("Profile");
                        break;
                }
            }
        });
        System.out.println(userID.getEmail().toString());
        DocumentReference docRef = db.collection("Writers").document(userID.getEmail());
        Map<String, String> resultOfDatabase = new HashMap<String, String>();
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        resultOfDatabase.put("User name", document.getData().get("User name").toString());
                        user = "Hi " + resultOfDatabase.get("User name");
                        greeting.setText(user);
                    } else {
                        Log.d(TAG, "No such document Writer");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

        tabLayoutMediator.attach();

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(HomeScreenWriter.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public String getType(){
        return type;
    }
}