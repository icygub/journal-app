package com.example.cs260.journalapplication;

/**
 * Created by 1237jwells on 3/9/2018.
 */

public class Tag_Model {
// Find Journal Entry by Tag
    private String tag;

    public Tag_Model(String tag){
        this.tag = tag;
    }

    public String getTag(){
        return tag;
    }
    public void setTag(String tag){
        this.tag = tag;
    }


    @Override
    public String toString(){
        return tag;
    }


}
//JOrdan's AMAZING CODEEEEEE
