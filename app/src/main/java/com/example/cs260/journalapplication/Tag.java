package com.example.cs260.journalapplication;

/**
 * Created by icyhot on 3/10/2018.
 */

public class Tag {

    private String text;
    private JournalEntry journalEntry;

    public Tag(String text, JournalEntry journalEntry) {
        this.text = text;
        this.journalEntry = journalEntry;
    }
}
