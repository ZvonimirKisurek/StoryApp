package com.zoneproduction.library.DodatniProgrami;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.zoneproduction.library.GlavniScreenovi.HomeScreenReader;
import com.zoneproduction.library.R;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class BookReaderActivity extends AppCompatActivity {

    BookTAXD bookTAXD = new BookTAXD();

    private TextView nameOfBook, nameOfChapter, bookContent;

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageReference = storage.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_reader);

        nameOfBook = findViewById(R.id.textTitleOfBook);
        nameOfChapter = findViewById(R.id.textCurrentChapter);
        bookContent = findViewById(R.id.textContentOfTheBook);

        bookContent.setMovementMethod(new ScrollingMovementMethod());

        Intent intent = getIntent();
        String titleOfTheBook = intent.getStringExtra("NameBook");
        File pass = (File) intent.getExtras().get("TextKnjige");

        System.out.println("Što je prošlo");
        System.out.println(pass);
        System.out.println("kraj !!!");

        bookTAXD.put(pass);

        List<List<String>> paragraphs = BookTAXD.getParagraphs();
        String titleOfChapter = paragraphs.get(0).get(0);
        String paragraph = paragraphs.get(0).get(1);

        nameOfChapter.setText(titleOfChapter);
        bookContent.setText(paragraph);

        nameOfBook.setText(titleOfTheBook);

    }
}
