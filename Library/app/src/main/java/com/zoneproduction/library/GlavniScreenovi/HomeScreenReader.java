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
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.zoneproduction.library.R;
import com.zoneproduction.library.Adapteri.ViewPagerAdapter;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class HomeScreenReader extends AppCompatActivity {

    private TabLayout tabLayoutCategory;
    private ViewPager2 viewPagerCategory;
    private TextView greeting;
    String user = "";

    LogInReader lir = new LogInReader();
    String type = lir.getType();

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference users = db.collection("Users");
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser userID = auth.getCurrentUser();
    private Button signOut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_reader);

        tabLayoutCategory = findViewById(R.id.tabLayoutHomeReader);
        viewPagerCategory = findViewById(R.id.viewPagerHomeReader);
        greeting = findViewById(R.id.textGreetingReader);
        signOut = findViewById(R.id.buttonSignOutHomeReader);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());

        viewPagerCategory.setAdapter(adapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayoutCategory, viewPagerCategory, true, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("My Library");
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
        tabLayoutMediator.attach();

        //metoda kojom ćemo naći da li postoji user
//                    users.whereEqualTo("Email", mail)
//                            .get()
//                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                    if (task.isSuccessful()) {
//                                       Log.d(TAG, "Pass");
//                                    } else {
//                                        Log.d(TAG, "Error getting documents: ", task.getException());
//                                    }
//                                }
//                            });

        DocumentReference docRef = db.collection("Users").document(userID.getEmail());
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
                        Log.d(TAG, "No such document Reader");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(HomeScreenReader.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
    public String getType(){
        return type;
    }

    //updateanje profila od korisnika
//    public void editProfile(String newName){
//        newName = "Hi " + newName;
//        greeting.setText(newName);
//    }
}
