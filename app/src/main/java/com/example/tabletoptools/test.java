package com.example.tabletoptools;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class test extends AppCompatActivity {

    public static Context context;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Character Manager!");
        System.out.println("Do you want to create a new character or read one from a JSON file? (Enter 'create' or 'read'):");
        String action = scanner.nextLine().trim().toLowerCase();

        Character character = null;

        switch (action) {
            case "create":
                // Logic for creating a new character (already provided in your starting point)
                character = createCharacter(scanner);
                break;
            case "read":
                // Logic for reading a character from a JSON file
                System.out.println("Enter the name of the character to read:");
                String name = scanner.nextLine();
                character = new Character(); // Assuming default constructor exists
                character.readCharacterFromJson(context, name); // `context` needs to be provided somehow, typically in Android this would be an Activity or similar
                break;
            default:
                System.out.println("Invalid action.");
                System.exit(1);
        }

        // Assuming character creation or loading was successful
        if (character != null) {
            // Display character information
            printCharacterInfo(character);
        } else {
            System.out.println("An error occurred.");
        }
    }

    private static Character createCharacter(Scanner scanner) {
        // Reuse your existing character creation logic here
        // This is just a placeholder to represent where your logic will go
        return new Character(); // Return the created character
    }

    private static void printCharacterInfo(Character character) {
        // Display basic character info, points, and health
        System.out.println("Character Information:");
        System.out.println("Name: " + character.name + ", Age: " + character.age);
        System.out.println("Base Values - Physical: " + character.baseValuePhys + ", Dexterity: " + character.baseValueDex +
                ", Mental: " + character.baseValueMent + ", Social: " + character.baseValueSoc);
        System.out.println("Points - Physical Points: " + character.pp + ", Dexterity Points: " + character.dp +
                ", Mental Points: " + character.mp + ", Social Points: " + character.sp);
        System.out.println("Health Points - Head: " + character.head + ", Left Arm: " + character.lArm + ", Right Arm: " + character.rArm +
                ", Torso: " + character.torso + ", Left Leg: " + character.lLeg + ", Right Leg: " + character.rLeg);
    }
}
