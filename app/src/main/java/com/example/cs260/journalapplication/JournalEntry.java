package com.example.cs260.journalapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.time.LocalDateTime;
import java.util.List;

import static android.content.ContentValues.TAG;
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

        final int PICK_AUDIO_REQUEST = 1;

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("audio/*");

        startActivityForResult(intent, PICK_AUDIO_REQUEST);
    }

    @Override
    public String onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                Log.i(TAG, "Uri: " + uri.toString());
                return uri.toString();
            }
        }

        return null;
    }

    @Override
    public String toString()
    {
        return dateTime.format(Journal.dateTimeFormatter) + " " + text;
    }

}
