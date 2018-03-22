package com.example.cs260.journalapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private VideoView videoView;
    private static final int SELECT_VIDEO = 1;
    private static final int READ_REQUEST_CODE = 1;
    private static final int REQUEST_TAKE_GALLERY_VIDEO = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.video_view);
    }

    public void getVideoButtonClicked(View v) {
        //Toast.makeText(this, "HELLO JORDAN", Toast.LENGTH_SHORT).show();

//        intent = new Intent();
//        intent.setType("video/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent,"Select Video"),REQUEST_TAKE_GALLERY_VIDEO);

//        intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(intent, SELECT_VIDEO);

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("video/*");
        startActivityForResult(intent, READ_REQUEST_CODE);

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
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                videoView.setVideoURI(uri);
                videoView.requestFocus();
                videoView.start();
                //Log.i(TAG, "Uri: " + uri.toString());
                //showImage(uri);
            }
        }
    }


//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode == RESULT_OK) {
//            if (requestCode == REQUEST_TAKE_GALLERY_VIDEO) {
//                Uri selectedImageUri = data.getData();
//
//                // OI FILE Manager
//                filemanagerstring = selectedImageUri.getPath();
//
//                // MEDIA GALLERY
//                selectedImagePath = getPath(selectedImageUri);
//                if (selectedImagePath != null) {
//
//                    Intent intent = new Intent(HomeActivity.this,
//                            VideoplayAvtivity.class);
//                    intent.putExtra("path", selectedImagePath);
//                    startActivity(intent);
//                }
//            }
//        }
//    }
//
//    // UPDATED!
//    public String getPath(Uri uri) {
//        String[] projection = { MediaStore.Video.Media.DATA };
//        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
//        if (cursor != null) {
//            // HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
//            // THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
//            int column_index = cursor
//                    .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
//            cursor.moveToFirst();
//            return cursor.getString(column_index);
//        } else
//            return null;
//    }

    /**
     * This main method is for testing in the counsel all code needs to be placed within the MainActivity and attached to the UI
     * @param args contains the command line arguments
     */
    public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);
    // diary instance
    Journal diary = new Journal();
    String choice = "0";
    // main loop
        while(!choice.equals("4"))

    {
        diary.printHomeScreen();
        System.out.println();
        System.out.println("Choose an action:");
        System.out.println("0 - Show all tags");
        System.out.println("1 - Add an entry");
        System.out.println("2 - Search for entries");
        System.out.println("3 - Delete entries");
        System.out.println("4 - End");
        choice = scanner.nextLine();
        System.out.println();
        // reaction to the choice
        switch (choice) {
            case "0":
                diary.showAllTags();
                break;
            case "1":
                diary.addEntry();
                break;
            case "2":
                diary.searchEntries();
                break;
            case "3":
                diary.deleteEntries();
                break;
            case "4":
                System.out.println("Press any key to quit the program...");
                break;
            default:
                System.out.println("Error. Press any key to choose another action.");
                break;
        }
    }
}



}
