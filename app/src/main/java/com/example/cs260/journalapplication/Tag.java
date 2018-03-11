package com.example.cs260.journalapplication;

/**
 * Created by icyhot on 3/10/2018.
 */

public class Tag {

    private String text;
    //private JournalEntry journalEntry;

    public Tag(String text) {
        this.text = text;
        //this.journalEntry = journalEntry;
    }

    @Override
    public String toString() {
        return text;
    }
}
