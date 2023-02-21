package com.zoneproduction.library.DodatniProgrami;

import android.view.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class QuoteTAXD {

    public static Map<Integer, Quote> quotes = new HashMap();

    static {

        Scanner scanner = null;

        System.out.println("______________________________");

        // Čitanje pitanja
        try {
            scanner = new Scanner(new FileReader("quotes.txt"));
            scanner.useDelimiter("!");
            while (scanner.hasNextLine()) {
                int id = scanner.nextInt();
                System.out.println(id);
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println(description);
                quotes.put(id, new Quote(id, description));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("loše");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
