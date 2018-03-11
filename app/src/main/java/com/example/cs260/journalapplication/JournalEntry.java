package com.example.cs260.journalapplication;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by matthewruben on 3/5/18.
 */

public class JournalEntry {
    private LocalDateTime dateTime;
    private String text;
    private ArrayList<Tag> tags;

    /**
     * Constructor
     */
    public JournalEntry(LocalDateTime dateTime, String text){
        this.dateTime = dateTime;
        this.text = text;
        tags = new ArrayList<>();
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

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    @Override
    public String toString()
    {
        return dateTime.format(Journal.dateTimeFormatter) + " " + text;
    }

}
