package com.zoneproduction.library.GlavniScreenovi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.zoneproduction.library.R;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;


public class Fragment_Profile extends Fragment {

    public static Fragment_Profile newInstance() {

        return new Fragment_Profile();
    }

    private EditText userName,firstName, lastName, date;
    private TextView missingFirst, missingLast, missingDate, missingUser, passer;
    private ImageView profileImage;
    private Button update;
    String getUser, getFirst, getLast, getDate;
    LogInReader logInReader = new LogInReader();
    String mail = logInReader.getEmail();

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Map<String, Object> user = new HashMap<>();
    //user id
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    CollectionReference users = db.collection("Users");


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment__profile, container, false);

        userName = view.findViewById(R.id.UsernameProfile);
        firstName = view.findViewById(R.id.FirstNameProfile);
        lastName = view.findViewById(R.id.LastNameProfile);
        profileImage = view.findViewById(R.id.imageViewProfile);
        missingUser = view.findViewById(R.id.textUsernameMissing);
        missingFirst = view.findViewById(R.id.textFirstNameMissing);
        missingLast = view.findViewById(R.id.textViewLastNameMissing);
        missingDate = view.findViewById(R.id.textViewEmailMissing);
        update = view.findViewById(R.id.buttonUpdateProfile);
        date = view.findViewById(R.id.textDateProfile);
        passer = view.findViewById(R.id.randomtxt);

        //metoda kojom ćemo vidjeti jel postoji user
        DocumentReference docRef = db.collection("Users").document(mail);
        getInfoAboutProfile();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean bad = false;
                if(userName.getText().toString().equals("") || userName == null){
                    bad = true;
                    missingUser.setVisibility(View.VISIBLE);
                }else{
                    missingUser.setVisibility(View.INVISIBLE);
                }
                if(firstName.getText().toString().equals("") || firstName == null){
                    bad = true;
                    missingFirst.setVisibility(View.VISIBLE);
                }else{
                    missingFirst.setVisibility(View.INVISIBLE);
                }
                if (lastName.getText().toString().equals("") || lastName == null){
                    bad = true;
                    missingLast.setVisibility(View.VISIBLE);
                }else{
                    missingLast.setVisibility(View.INVISIBLE);
                }
                if(date.getText().toString().equals("") || date == null){
                    bad = true;
                    missingDate.setVisibility(View.VISIBLE);
                }else{
                    missingDate.setVisibility(View.INVISIBLE);
                }
                if(!bad){
                    user.put("User name", userName.getText().toString());
                    user.put("First name", firstName.getText().toString());
                    user.put("Last name", lastName.getText().toString());
                    user.put("Date of birth", date.getText().toString());
                    user.put("UserId", "User" + userName.getText().toString());
                    LogInReader log = new LogInReader();
                    user.put("Email", log.getEmail());
                    users.document(log.getEmail()).set(user);
                }
                Toast toast = Toast.makeText(view.getContext(), "Profile updated", Toast.LENGTH_LONG);
                getInfoAboutProfile();
                toast.show();
            }
        });


        return view;
    }

    public void getInfoAboutProfile(){
        DocumentReference docRef = db.collection("Users").document(mail);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Map<String, String> resultOfDatabase = new HashMap<String , String>();
                        resultOfDatabase.put("User name",document.getData().get("User name").toString());
                        resultOfDatabase.put("First name",document.getData().get("First name").toString());
                        resultOfDatabase.put("Last name",document.getData().get("Last name").toString());
                        resultOfDatabase.put("Date of birth",document.getData().get("Date of birth").toString());
                        getUser = resultOfDatabase.get("User name").toString();
                        getFirst = resultOfDatabase.get("First name").toString();
                        getLast = resultOfDatabase.get("Last name").toString();
                        getDate = resultOfDatabase.get("Date of birth").toString();
                        userName.setText(getUser);
                        firstName.setText(getFirst);
                        lastName.setText(getLast);
                        date.setText(getDate);
                        passer.setText(getUser);
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

}