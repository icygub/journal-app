package com.example.cs260.journalapplication;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TagClassUnitTest {
    @Test
    public void TagClass_GivenTagName_TagCreated_ShouldPass() throws Exception {
        List<String> testList = new ArrayList<String>();
        Tag tClass = new Tag(testList);
        Tag.AddTag("tag 1");
        Tag.AddTag("tag 2");
        Tag.AddTag("Example Tag");
        Tag.AddTag("tag 3");
        Tag.AddTag("tag 4");
        String value = testList.get(0);
        assertEquals("tag 1", value);
        value = testList.get(1);
        assertEquals("tag 2", value);
        value = testList.get(2);
        assertEquals("Example Tag", value);
        value = testList.get(3);
        assertEquals("tag 3", value);
        value = testList.get(4);
        assertEquals("tag 4", value);
    }

    @Test
    public void TagClass_GivenTagName_FindIndex_ShouldPass() throws Exception {
        List<String> testList = new ArrayList<String>();
        Tag tClass = new Tag(testList);
        Tag.AddTag("tag 1");
        Tag.AddTag("tag 2");
        Tag.AddTag("Example Tag");
        Tag.AddTag("tag 3");
        Tag.AddTag("tag 4");
        int index = Tag.FindTag("Example Tag");
        assertEquals(2, index);
        index = Tag.FindTag("tag 1");
        assertEquals(0, index);
        index = Tag.FindTag("tag 2");
        assertEquals(1, index);
        index = Tag.FindTag("tag 3");
        assertEquals(3, index);
        index = Tag.FindTag("tag 4");
        assertEquals(4, index);
    }

    @Test
    public void TagClass_GivenTagName_DeleteTag_ShouldPass(){
        List<String> testList = new ArrayList<String>();
        Tag tClass = new Tag(testList);
        Tag.AddTag("tag 1");
        Tag.AddTag("tag 2");
        Tag.AddTag("Example Tag");
        Tag.AddTag("tag 3");
        Tag.AddTag("tag 4");
        Tag.DeleteTag("Example Tag");
        int index = Tag.FindTag("Example Tag");
        assertEquals(404, index);
        Tag.DeleteTag("tag 1");
        index = Tag.FindTag("tag 1");
        assertEquals(404, index);
        Tag.DeleteTag("tag 2");
        index = Tag.FindTag("tag 2");
        assertEquals(404, index);
        Tag.DeleteTag("tag 3");
        index = Tag.FindTag("tag 3");
        assertEquals(404, index);
        Tag.DeleteTag("tag 4");
        index = Tag.FindTag("tag 4");
        assertEquals(404, index);
    }

    @Test
    public void TagClass_GivenPrevTagandNewTag_EditTag_ShouldPass(){
        List<String> testList = new ArrayList<String>();
        Tag tClass = new Tag(testList);
        Tag.AddTag("tag 1");
        Tag.AddTag("tag 2");
        Tag.AddTag("Example Tag");
        Tag.AddTag("tag 3");
        Tag.AddTag("tag 4");
        Tag.EditTag("Example Tag","Example Tog");
        int index = Tag.FindTag("Example Tag");
        assertEquals(404, index);
        index = Tag.FindTag("Example Tog");
        assertEquals(2, index);
        Tag.EditTag("tag 1","tog 1");
        index = Tag.FindTag("tag 1");
        assertEquals(404, index);
        index = Tag.FindTag("tog 1");
        assertEquals(0, index);
        Tag.EditTag("tag 2","tog 2");
        index = Tag.FindTag("tag 2");
        assertEquals(404, index);
        index = Tag.FindTag("tog 2");
        assertEquals(1, index);
        Tag.EditTag("tag 3","tog 3");
        index = Tag.FindTag("tag 3");
        assertEquals(404, index);
        index = Tag.FindTag("tog 3");
        assertEquals(3, index);
        Tag.EditTag("tag 4","tog 4");
        index = Tag.FindTag("tag 4");
        assertEquals(404, index);
        index = Tag.FindTag("tog 4");
        assertEquals(4, index);
    }

    @Test
    public void TagClass_GivenText_FindTags_ShouldPass(){
        List<String> testList = new ArrayList<String>();
        Tag tClass = new Tag(testList);
        String testText = "Today I went to Universal Studio #MoviesFun with my family. It was a #SunnyDay and we had the opportunity to " +
                "enter many attractions. Nevertheless i was #Sick";
        List<String> hashtags = Tag.GetHashtags(testText);
        assertEquals(3, hashtags.size());
        assertEquals("#MoviesFun", hashtags.get(0));
        assertEquals("#SunnyDay", hashtags.get(1));
        assertEquals("#Sick", hashtags.get(2));
    }
}
