package com.example.cs260.journalapplication;

import android.app.Activity;
import android.content.Intent;

import java.time.LocalDateTime;
import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

/**
 * Created by matthewruben on 3/5/18.
 */

public class JournalEntry {
    private LocalDateTime dateTime;
    private String text;
    private List<String> audiosList;

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

    public void addAudioFile(){
        final int PICK_CONTACT_REQUEST = 1;

        Intent intent;
        intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("audio/*");
    }

    @Override
    public String toString()
    {
        return dateTime.format(Journal.dateTimeFormatter) + " " + text;
    }

}
