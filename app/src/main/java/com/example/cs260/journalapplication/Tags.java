package com.example.cs260.journalapplication;

import java.util.ArrayList;

/**
 * Created by icyhot on 3/4/2018.
 */

public class Tags {

    private ArrayList<Tag> tags;

    public Tags() {
        tags = new ArrayList<>();
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
    }


}
