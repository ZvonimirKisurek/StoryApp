package com.zoneproduction.library.GlavniScreenovi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.zoneproduction.library.DodatniProgrami.BookReaderActivity;
import com.zoneproduction.library.R;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static android.content.ContentValues.TAG;

public class Fragment_myLibrary extends Fragment {

    public static Fragment_myLibrary newInstance() {

        return new Fragment_myLibrary();
    }

    private ImageView knjiga1, knjiga2, knjiga3, knjiga4, knjiga5, back, forward;
    private TextView naslov1, naslov2, naslov3, naslov4, naslov5, pisac1, pisac2, pisac3, pisac4, pisac5, currentPage,dummy;
    private ConstraintLayout layout1, layout2, layout3, layout4, layout5;

    FirebaseStorage storage = FirebaseStorage.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    // Create a storage reference from our app
    StorageReference storageRef = storage.getReference();

    StorageReference primjerRef = storageRef.child("Knjige/Primjer/primjerSlike.jpg");
    StorageReference primjerTxt = storageRef.child("Knjige/Primjer/primjerKnjige.txt");

    StorageReference gsReference = storage.getReferenceFromUrl("gs://library-80ae5.appspot.com/Knjige/Primjer/primjerSlike.jpg");

    StorageReference httpsReference = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/library-80ae5.appspot.com/o/Knjige%2FPrimjer%2FprimjerSlike.jpg?alt=media&token=75efbb6c-48c0-4dec-a2ca-7df6c8cfa0c4");

    String[] books = {"Primjer","Primjer", "Primjer","Primjer","Primjer","Primjer"};
    String[] bookPictures = {"primjerSlike","primjerSlike", "primjerSlike", "primjerSlike", "primjerSlike","primjerSlike"};
    int totalPages = books.length / 5;
    int indexOfBooks = 0;
    Map<String, String> resultOfDatabase = new HashMap<>();
    Map<String, String> resultOfBook = new HashMap<>();

    File localFile = null;

    String nameOfTheBook;

    List<StorageReference> storageReferenceList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        testMolim();

        View view = inflater.inflate(R.layout.fragment_my_library, container, false);

        if(books.length % 5 != 0){
            totalPages++;
        }

        layout1 = view.findViewById(R.id.layoutKnjigeMyLibrary1);
        layout2 = view.findViewById(R.id.layoutKnjigeMyLibrary2);
        layout3 = view.findViewById(R.id.layoutKnjigeMyLibrary3);
        layout4 = view.findViewById(R.id.layoutKnjigeMyLibrary4);
        layout5 = view.findViewById(R.id.layoutKnjigeMyLibrary5);
        knjiga1 = view.findViewById(R.id.imageKnjigaMyLibrary1);
        knjiga2 = view.findViewById(R.id.imageKnjigaMyLibrary2);
        knjiga3 = view.findViewById(R.id.imageKnjigaMyLibrary3);
        knjiga4 = view.findViewById(R.id.imageKnjigaMyLibrary4);
        knjiga5 = view.findViewById(R.id.imageKnjigaMyLibrary5);
        naslov1 = view.findViewById(R.id.textNaslovMyLibrary1);
        naslov2 = view.findViewById(R.id.textNaslovMyLibrary2);
        naslov3 = view.findViewById(R.id.textNaslovMyLibrary3);
        naslov4 = view.findViewById(R.id.textNaslovMyLibrary4);
        naslov5 = view.findViewById(R.id.textNaslovMyLibrary5);
        pisac1 = view.findViewById(R.id.textImePiscaMyLibrary1);
        pisac2 = view.findViewById(R.id.textImePiscaMyLibrary2);
        pisac3 = view.findViewById(R.id.textImePiscaMyLibrary3);
        pisac4 = view.findViewById(R.id.textImePiscaMyLibrary4);
        pisac5 = view.findViewById(R.id.textImePiscaMyLibrary5);
        back = view.findViewById(R.id.backArrowMyLibrary);
        forward = view.findViewById(R.id.forwardArrowMyLibrary);
        currentPage = view.findViewById(R.id.textCurrentPageMyLibrary);
        dummy = view.findViewById(R.id.passingTextMyLibrary);

        //Testovi
        // Reference's path is: "images/space.jpg"
        // This is analogous to a file path on disk
        System.out.println(primjerRef.getPath());

        // Reference's name is the last segment of the full path: "space.jpg"
        // This is analogous to the file name
        System.out.println(primjerRef.getName());

        // Reference's bucket is the name of the storage bucket that the files are stored in
        System.out.println(primjerRef.getBucket());

        checkPages();
        showBooks(view);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int page = Integer.parseInt(currentPage.getText().toString()) - 1;
                currentPage.setText(String.valueOf(page));
                indexOfBooks -= 5;
                checkPages();
                showBooks(view);
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int page = Integer.parseInt(currentPage.getText().toString()) + 1;
                currentPage.setText(String.valueOf(page));
                indexOfBooks += 5;
                checkPages();
                showBooks(view);
            }
        });



        //implementirati metodu koja će prenijeti naziv knjige i pokrenuti intent od book-a
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BookReaderActivity.class);
                showText(primjerTxt);
                intent.putExtra("NameBook",naslov1.getText().toString());
                intent.putExtra("TextKnjige", localFile);
                startActivity(intent);
                //možda bude trebalo
                getActivity().finish();
            }
        });

        return view;
    }

    public static void setImageViewWithByteArray(ImageView view, byte[] data) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        view.setImageBitmap(bitmap);
    }

    public void checkPages(){
        if(currentPage.getText().toString().equals("1")){
            forward.setVisibility(View.VISIBLE);
            forward.setClickable(true);
            back.setVisibility(View.INVISIBLE);
            back.setClickable(false);
        }else if(Integer.parseInt((String) currentPage.getText()) < totalPages){
            back.setVisibility(View.VISIBLE);
            forward.setVisibility(View.VISIBLE);
            back.setClickable(true);
            forward.setClickable(true);
        }else{
            back.setVisibility(View.VISIBLE);
            back.setClickable(true);
            forward.setVisibility(View.INVISIBLE);
            forward.setClickable(false);
        }
    }

    public void showImage(ImageView img, StorageReference reference){
        final long ONE_MEGABYTE = 1024 * 1024;
        reference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Data for "images/island.jpg" is returns, use this as needed
                Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                img.setImageBitmap(Bitmap.createScaledBitmap(bmp, img.getWidth(), img.getHeight(), false));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
    }

    public void insertBookInfo(String book, TextView title, TextView author){
        DocumentReference docRef = db.collection("ListaKnjiga").document(book);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        resultOfDatabase.put("Naslov", Objects.requireNonNull(document.getData().get("Naslov")).toString());
                        resultOfDatabase.put("Ime Pisca", Objects.requireNonNull(document.getData().get("Ime Pisca")).toString());
                        title.setText(resultOfDatabase.get("Naslov"));
                        author.setText(resultOfDatabase.get("Ime Pisca"));
                    } else {
                        Log.d(TAG, "No such document Broj Knjiga");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    public String getNameOfTheBook(){
        return nameOfTheBook;
    }

    public void showBooks(View view){
        int dif = 5;
        if((books.length-indexOfBooks) < 5){
            dif = books.length - indexOfBooks;
        }
        //način kako povuči iz database-a podatke odnosno broj knjiga u bazi kako bi mi mogli vuči 5 po 5 knjiga
        StorageReference reference;
        storageReferenceList = new ArrayList<>();
        for(int i = 0; i < dif; i++) {
            switch (i){
                case 0:
                    //kreiranje naslova i pisca
                    layout1.setClickable(true);
                    layout1.setVisibility(View.VISIBLE);
                    insertBookInfo(books[indexOfBooks+i], naslov1, pisac1);
                    //prikazivanje slike
                    reference = storageRef.child("Knjige/Primjer/" + bookPictures[indexOfBooks+i] + ".jpg");
                    showImage(view.findViewById(R.id.imageKnjigaMyLibrary1),reference);
                    //saveanje referenci za BookReaderActivity
                    storageReferenceList.add(storageRef.child("Knjige/Primjer/" + bookPictures[indexOfBooks+i] + ".txt"));
                    break;
                case 1:
                    layout2.setClickable(true);
                    layout2.setVisibility(View.VISIBLE);
                    insertBookInfo(books[indexOfBooks+i], naslov2, pisac2);
                    reference = storageRef.child("Knjige/Primjer/" + bookPictures[indexOfBooks+i] + ".jpg");
                    showImage(view.findViewById(R.id.imageKnjigaMyLibrary2),reference);
                    //saveanje referenci za BookReaderActivity
                    storageReferenceList.add(storageRef.child("Knjige/Primjer/" + bookPictures[indexOfBooks+i] + ".txt"));
                    break;
                case 2:
                    layout3.setClickable(true);
                    layout3.setVisibility(View.VISIBLE);
                    insertBookInfo(books[indexOfBooks+i], naslov3, pisac3);
                    reference = storageRef.child("Knjige/Primjer/" + bookPictures[indexOfBooks+i] + ".jpg");
                    showImage(view.findViewById(R.id.imageKnjigaMyLibrary3),reference);
                    //saveanje referenci za BookReaderActivity
                    storageReferenceList.add(storageRef.child("Knjige/Primjer/" + bookPictures[indexOfBooks+i] + ".txt"));
                    break;
                case 3:
                    layout4.setClickable(true);
                    layout4.setVisibility(View.VISIBLE);
                    insertBookInfo(books[indexOfBooks+i], naslov4, pisac4);
                    reference = storageRef.child("Knjige/Primjer/" + bookPictures[indexOfBooks+i] + ".jpg");
                    showImage(view.findViewById(R.id.imageKnjigaMyLibrary4),reference);
                    //saveanje referenci za BookReaderActivity
                    storageReferenceList.add(storageRef.child("Knjige/Primjer/" + bookPictures[indexOfBooks+i] + ".txt"));
                    break;
                case 4:
                    layout5.setClickable(true);
                    layout5.setVisibility(View.VISIBLE);
                    insertBookInfo(books[indexOfBooks+i], naslov5, pisac5);
                    reference = storageRef.child("Knjige/Primjer/" + bookPictures[indexOfBooks+i] + ".jpg");
                    showImage(view.findViewById(R.id.imageKnjigaMyLibrary5),reference);
                    //saveanje referenci za BookReaderActivity
                    storageReferenceList.add(storageRef.child("Knjige/Primjer/" + bookPictures[indexOfBooks+i] + ".txt"));
                    break;
            }

        }

        int missing = 5 - dif;

        for(int i = 0; i < missing; i++) {
            switch (i){
                case 0:
                    layout5.setClickable(false);
                    layout5.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    layout4.setClickable(false);
                    layout4.setVisibility(View.INVISIBLE);
                    break;
                case 2:
                    layout3.setClickable(false);
                    layout3.setVisibility(View.INVISIBLE);
                    break;
                case 3:
                    layout2.setClickable(false);
                    layout2.setVisibility(View.INVISIBLE);
                    break;
                case 4:
                    layout1.setClickable(false);
                    layout1.setVisibility(View.INVISIBLE);
                    break;
            }

        }
    }

    public void showText(StorageReference reference){
        final long ONE_MEGABYTE = 1024 * 1024;
        reference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Data for "images/island.jpg" is returns, use this as needed
                // Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                final String s = new String(bytes, StandardCharsets.UTF_8);
                System.out.println("REZULTATI FRAGMENT MY LIBRARY SHOW TEXT METODE");
                System.out.println(s);
                resultOfBook.put("Tekst", s);
                dummy.setText(resultOfBook.get("Tekst"));
                System.out.println("!!!!!!!!!!!!");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                System.out.println("BIG BIG BIG FAIL");
            }
        });
    }

    public void testMolim(){
        try {
            localFile = File.createTempFile("image", ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        primjerTxt.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                // Local temp file has been created
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
        System.out.println("REZULTAT testMolim()");
        System.out.println(localFile);
        System.out.println("Kraj!!!");
    }
}