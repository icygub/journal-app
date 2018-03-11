package com.example.cs260.journalapplication;

/**
 * Created by matthewruben on 3/7/18.
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

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
    }

    /**
     * Searches the ArrayList by date
     */
    public void searchEntries() {
        // Entering the date
        LocalDateTime dateTime = readDate().atStartOfDay();
        // Searching for entries
        ArrayList<JournalEntry> entries = journalDatabase.findEntries(dateTime, false);
        // Printing entries
        if (entries.size() > 0) {
            System.out.println("Entries found: ");
            for (JournalEntry entry : entries) {
                System.out.println(entry);
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
