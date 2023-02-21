package com.zoneproduction.library.DodatniProgrami;

import java.util.HashMap;
import java.util.Map;

public class Quote {

    private final int quoteId;
    private final String quote;
    private final Map<String, Integer> quotes;

    public Quote(int quoteId, String quote) {
        this.quoteId = quoteId;
        this.quote = quote;
        this.quotes = new HashMap();
    }

    public int getQuoteId() {
        return quoteId;
    }

    public String getQuote() {
        return quote;
    }

    public Map<String, Integer> getQuotes() {
        return new HashMap(quotes);
    }

    protected void addExit(String num, int desc) {
        quotes.put(num, desc);
    }

}
