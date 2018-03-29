package com.example.cs260.journalapplication;

import android.content.Intent;

/**
 * Created by turng on 3/28/2018.
 */

public class GetMedia {

    private static final int READ_REQUEST_CODE = 42;

    /**
     * Fires an intent to spin up the "file chooser" UI and select an image.
     */
    public void performFileSearch(String mediaType) {

        // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file
        // browser.
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones)
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        // Filter to show only images, using the image MIME data type.
        // If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
        // To search for all documents available via installed storage providers,
        // it would be "*/*".
       // intent.setType("image/*");
        intent.setType(mediaType);

        startActivityForResult(intent, READ_REQUEST_CODE);
    }

    private void startActivityForResult(Intent intent, int readRequestCode) {
    }
}
