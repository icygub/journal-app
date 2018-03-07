package com.example.cs260.journalapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void deleteTags() throws Exception {
        Tags tags = new Tags();
        for(int i = 0; i < 10; i++) {
            tags.addTag(new Tag(Integer.toString(i)));
        }

    }

}