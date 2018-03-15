package com.example.cs260.journalapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This main method is for testing in the counsel all code needs to be placed within the MainActivity and attached to the UI
     * @param args contains the command line arguments
     */
    public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);
    // diary instance
    Journal diary = new Journal();
    String choice = "0";
    // main loop
        while(!choice.equals("4"))

    {
        diary.printHomeScreen();
        System.out.println();
        System.out.println("Choose an action:");
        System.out.println("0 - Show all tags");
        System.out.println("1 - Add an entry");
        System.out.println("2 - Search for entries");
        System.out.println("3 - Delete entries");
        System.out.println("4 - End");
        choice = scanner.nextLine();
        System.out.println();
        // reaction to the choice
        switch (choice) {
            case "0":
                diary.showAllTags();
            case "1":
                diary.addEntry();
                break;
            case "2":
                diary.searchEntries();
                break;
            case "3":
                diary.deleteEntries();
                break;
            case "4":
                System.out.println("Press any key to quit the program...");
                break;
            default:
                System.out.println("Error. Press any key to choose another action.");
                break;
        }
    }
}



}
