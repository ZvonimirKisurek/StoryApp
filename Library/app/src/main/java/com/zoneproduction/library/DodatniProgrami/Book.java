package com.zoneproduction.library.DodatniProgrami;

import java.util.HashMap;
import java.util.Map;

public class Book {
    private final int paragraphID;
    private final String paragraph;
    private final Map<String, Integer> paragraphs;

    public Book(int locationID, String description) {
        this.paragraphID = locationID;
        this.paragraph = description;
        this.paragraphs = new HashMap();
    }

    public int getParagraphID() {
        return paragraphID;
    }

    public String getDescription() {
        return paragraph;
    }

    public Map<String, Integer> getParagraphs() {
        return new HashMap(paragraphs);
    }
}
