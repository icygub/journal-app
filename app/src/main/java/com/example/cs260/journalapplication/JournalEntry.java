package com.example.cs260.journalapplication;

import java.time.LocalDateTime;

/**
 * Created by matthewruben on 3/5/18.
 */

public class JournalEntry {
    private LocalDateTime dateTime;
    private String text;

    /**
     * Constructor
     */
    public JournalEntry(LocalDateTime dateTime, String text){
        this.dateTime = dateTime;
        this.text = text;
    }

    public LocalDateTime getDateTime() { return dateTime;}

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return dateTime.format(Journal.dateTimeFormatter) + " " + text;
    }

}
