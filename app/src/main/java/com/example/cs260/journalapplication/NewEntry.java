package com.example.cs260.journalapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;

public class NewEntry extends AppCompatActivity {

    private Button save;
    private Journal journal = new Journal();
    private EditText text;

    private static final int READ_REQUEST_CODE = 42;
    //private static final int PICKFILE_REQUEST_CODE = 53;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__new_entry);


        text = (EditText)findViewById(R.id.user_text);
        save = (Button)findViewById(R.id.Save_btn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = text.getText().toString();
            }
        });
    }

    public void addMedia(View view) {
        Log.i("add media method", "we are here");
        performFileSearch();
    }

    /**
     * Fires an intent to spin up the "file chooser" UI and select an image.
     */
    public void performFileSearch() {

        // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file
        // browser.
//        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//        intent.putExtra("Hello", 0);
//        intent.putExtra("Helloagain", 1);
//
//        // Filter to only show results that can be "opened", such as a
//        // file (as opposed to a list of contacts or timezones)
//        intent.addCategory(Intent.CATEGORY_OPENABLE);
//
//        // Filter to show only images, using the image MIME data type.
//        // If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
//        // To search for all documents available via installed storage providers,
//        // it would be "*/*".
//        intent.setType("image/*");
//
//        //startActivityForResult(intent, READ_REQUEST_CODE);
//        startActivityForResult(intent, PICKFILE_REQUEST_CODE);

        Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
        chooseFile.setType("*/*");
        chooseFile = Intent.createChooser(chooseFile, "Choose a file");
        startActivityForResult(chooseFile, READ_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {

        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // The document selected by the user won't be returned in the intent.
            // Instead, a URI to that document will be contained in the return intent
            // provided to this method as a parameter.
            // Pull that URI using resultData.getData().
            Uri uri;
            if (resultData != null) {
                Log.i("hello", "hello agaaaaaainnnnn");
                videoView = findViewById(R.id.videoview_video);
                uri = resultData.getData();
                videoView.setVideoURI(uri);
                videoView.requestFocus();
                videoView.start();
            }
        }
    }
}
