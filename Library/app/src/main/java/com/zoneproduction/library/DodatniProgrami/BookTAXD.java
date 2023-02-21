package com.zoneproduction.library.DodatniProgrami;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;
import com.zoneproduction.library.DodatniProgrami.Book;
import com.zoneproduction.library.GlavniScreenovi.Fragment_Library;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookTAXD {

    public static List<List<String>> paragraphs = new ArrayList<>();

    public void put(File file) {

        Scanner scanner = null;

        // Read locations
        try {
            scanner = new Scanner(new FileReader(file));
            scanner.useDelimiter("!");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                System.out.println("Location " + loc);
                scanner.skip(scanner.delimiter());
                String[] rest = scanner.nextLine().split("!");
                String chapter = rest[0];
                System.out.println("Chapter " + chapter);
                String paragraph = rest[1];
                System.out.println("Paragraph " + paragraph);
                List<String> list = new ArrayList<>();
                list.add(chapter);
                list.add(paragraph);
                paragraphs.add(list);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static  List<List<String>> getParagraphs() {
        return paragraphs;
    }
}
