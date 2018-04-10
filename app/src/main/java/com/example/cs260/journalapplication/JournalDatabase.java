package com.example.cs260.journalapplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * Created by matthewruben on 3/5/18.
 */

public class JournalDatabase {

    private ArrayList<JournalEntry> journalEntries = new ArrayList<>();

    public void addEntry(LocalDateTime dateTime, String text) {
        journalEntries.add(new JournalEntry(dateTime, text));
    }

    /**
     * Finding entries saved in the Arraylist by parameters
     * @param dateTime the entered date and time to be searched
     * @param byTime a boolean flag
     * @return entries that have the given dateTime
     */
    public ArrayList<JournalEntry> findEntries(LocalDateTime dateTime, boolean byTime) {
        ArrayList<JournalEntry> found = new ArrayList<>();
        for (JournalEntry entry : journalEntries) {
            if ((byTime && (entry.getDateTime().equals(dateTime))) // filtered by time and date
                    ||
                    ((!byTime) && (entry.getDateTime().toLocalDate().equals(dateTime.toLocalDate())))) { // filtered by date only
                found.add(entry);
            }
        }
        return found;
    }

    public void deleteEntries(LocalDateTime dateTime) {
        ArrayList<JournalEntry> found = findEntries(dateTime, true);
        for (JournalEntry entry : found) {
            journalEntries.remove(entry);
        }
    }

    public void saveAllEntriesIntoPhone()throws IOException {
        for(int i = 0; i < journalEntries.size(); i++){
            String fileName= "Entry" + i + ".txt";
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(journalEntries.get(i));
            oos.close();
        }
    }

    public JournalEntry readEntrySavedonPhone(String savedFile)throws IOException,
    ClassNotFoundException{
        String fileName = savedFile;
        FileInputStream fin = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fin);
        JournalEntry entry = (JournalEntry)ois.readObject();
        ois.close();
        return entry;
    }
}
