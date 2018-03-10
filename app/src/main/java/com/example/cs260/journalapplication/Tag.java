package com.example.cs260.journalapplication;

import java.util.ArrayList;

/**
 * Created by 1237jwells on 3/9/2018.
 */

public class Tag {

    public ArrayList<Tag_Model> Tag = new ArrayList<>();

    public void addTag(String tag){

        Tag.add(new Tag_Model(tag));

    }
//Find Tags by tag parameter


    public ArrayList<Tag> findTag;
}
