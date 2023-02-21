package com.zoneproduction.library.DodatniProgrami;

public class QuoteGenerator {

    String[] quotes;

    public QuoteGenerator(String[] quotes) {
        this.quotes = quotes;
    }

    public String getQuote(int position){
        return quotes[position-1];
    }
}


