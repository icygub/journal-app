package com.example.cs260.journalapplication;

/**
 * Created by matthewruben on 3/7/18.
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Journal {
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/y HH:mm");
    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/y");

    private JournalDatabase journalDatabase;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructor
     */
    public Journal() {
        journalDatabase = new JournalDatabase();
    }

    /**
     * Takes the input from the keyboard and attempts to parse it into the dateTimeFormatter
     * @return a date and time in the correct format
     */
    private LocalDateTime readDateTime() {
        System.out.println("Enter date and time as mm/dd/yyyy hh:mm");
        LocalDateTime dateTime;
        try {
            dateTime = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);
        }
        catch (DateTimeParseException e) {
            System.out.println("Error. Please try again.");
            return readDateTime();
        }
        return dateTime;
    }

    /**
     * Takes input from the keyboard and attempts to parse the date
     * @return a date in the correct format
     */
    private LocalDate readDate() {
        System.out.println("Enter date as mm/dd/yyyy");
        LocalDate date;
        try {
            date = LocalDate.parse(scanner.nextLine(), dateFormatter);
        }
        catch (DateTimeParseException e) {
            System.out.println("Error. Please try again.");
            return readDate();
        }
        return date;
    }

    public void printEntries(LocalDate day) {
        ArrayList<JournalEntry> entries = journalDatabase.findEntries(day.atStartOfDay(), false);
        for (JournalEntry entry : entries) {
            System.out.println(entry);
        }
    }

    //created by John
    public void printAllEntries() {
        for (JournalEntry entry : journalDatabase.getAllEntries()) {
            System.out.println(entry);
        }
    }

    public void addEntry() {
        LocalDateTime dateTime = readDateTime();
        System.out.println("Enter the entry text:");
        String text = scanner.nextLine();
        journalDatabase.addEntry(dateTime, text);
        locateTags(text);
    }

    /**
     * Any characters immediately after a # will be considered a tag
     * #thisisatag
     * # thisisnotatag
     * @param text
     */
    public void locateTags(String text) {
        Pattern pattern = Pattern.compile("(#\\w+)\\b");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()) {
            addTag(matcher.group(1));
        }
    }

    //created by John
    public void addTag(String tagText) {
        JournalEntry lastEntry = journalDatabase.getLastEntry();
        lastEntry.addTag(new Tag(tagText));
    }

    /**
     * Searches the ArrayList by date
     */
    public void searchEntries() {
        Scanner scanner = new Scanner(System.in);
        // Entering the date
        LocalDateTime dateTime = readDate().atStartOfDay();
        // Searching for entries
        ArrayList<JournalEntry> entries = journalDatabase.findEntries(dateTime, false);
        // Printing entries
        if (entries.size() > 0) {
            System.out.println("Entries found! Include tags? (y/n)");
            if(scanner.nextLine().equalsIgnoreCase("y")) {
                for (JournalEntry entry : entries) {
                    System.out.println(entry);
                    StringBuilder sb = new StringBuilder();
                    for (Tag tag : entry.getTags()) {
                        sb.append(tag);
                        sb.append(" ");
                    }
                    System.out.println("Tags: " + sb.toString());
                }
            }
            else {
                for (JournalEntry entry : entries) {
                    System.out.println(entry);
                }
            }
        } else {
            // Nothing found
            System.out.println("No entries were found.");
        }
        scanner.nextLine(); // wait for enter
    }

    public void deleteEntries() {
        System.out.println("Entries with the same exact date and time will be deleted");
        LocalDateTime dateTime = readDateTime();
        journalDatabase.deleteEntries(dateTime);
    }
    public void printHomeScreen() {
        System.out.println();
        System.out.println();
        System.out.println("Welcome to your virtual diary!");
        System.out.println("Today is: " + LocalDateTime.now().format(dateTimeFormatter));
        System.out.println();
        // printing the home screen
//        System.out.println("Today:\n------");
//        printEntries(LocalDate.now());
//        System.out.println();
//        System.out.println("Tomorrow:\n---------");
        System.out.println("All:\n------");
        printAllEntries();
        printEntries(LocalDate.now().plusDays(1));
        System.out.println();
    }

}
