package com.example.cs260.journalapplication;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static java.lang.System.in;

/**
 * Created by cerqu on 8/03/2018.
 */

public class Tag {

    private static List<String> TagList = new ArrayList<String>();

    public Tag(List<String> tagList){
        TagList = tagList;
    }

    public static void AddTag(String tagToAdd){
        TagList.add(tagToAdd);
    }

    public static List<String> GetTagList(){
        return TagList;
    }

    public static int FindTag(String tagToFind){
        for(int i = 0; i < TagList.size(); i++){
            if(TagList.get(i) == tagToFind)
                return i;
        }

        return 404;
    }

    public static void DeleteTag(String tagToDelete){
        int index = FindTag(tagToDelete);
        if(index != 404){
            TagList.remove(index);
        }
    }

    public static void EditTag(String oldTag, String newTag){
        int index = FindTag(oldTag);
        if(index != 404){
            TagList.remove(index);
            TagList.add(index, newTag);
        }
    }

    public static List<String> GetHashtags(String text) {
        String[] words = text.split(" ");
        List<String> hashtags = new ArrayList<String>();
        for (String word : words) {
            if (word.startsWith("#")) {
                hashtags.add(word);
            }
        }
        return hashtags;
    }
}
