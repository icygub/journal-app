package com.example.cs260.journalapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class PickAudioActivity extends Activity {

    static final int PICK_AUDIO_REQUEST = 1;

    public void SelectAnAudio(){
        startActivityForResult(
                new Intent(Intent.ACTION_PICK,
                        Uri.parse("audio/*")),
                PICK_AUDIO_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == PICK_AUDIO_REQUEST) {
            if (resultCode == RESULT_OK) {
            }
        }
    }
}
