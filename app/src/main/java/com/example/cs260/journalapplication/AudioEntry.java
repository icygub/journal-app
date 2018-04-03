package com.example.cs260.journalapplication;

import android.media.MediaPlayer;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import static java.lang.System.in;

public class AudioEntry {

    public JournalEntry entry;
    public List<String> AudioList;

    public AudioEntry(List<String> audioList){
        AudioList = audioList;
    }

    public void addAudio(String path, String fileName){
        File f = new File(path + File.separator + fileName);
        if(f.isDirectory()){
            AudioList.add(path);
        }
    }

   public void deleteAudio(String path, String fileName){
        for(int i = 0; i < AudioList.size(); i++){
            if(AudioList.get(i) == path + File.separator + fileName){
                AudioList.remove(i);
            }
       }
   }

   public void playAudio(String path, String fileName){
       MediaPlayer mp = new MediaPlayer();
       try {
           mp.setDataSource(path + File.separator + fileName);
           mp.prepare();
           mp.start();
       } catch (Exception e ){
           e.printStackTrace();
       }
   }
}
