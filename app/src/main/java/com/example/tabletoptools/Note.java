package com.example.tabletoptools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Note {
    private String id;
    private String title;
    private String text;

    public Note(String id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    // Getter for the title
    public String getTitle() {
        return title;
    }

    // Getter for the id
    public String getId() {
        return id;
    }

    // Getter for the text
    public String getText() {
        return text;
    }

    // Modified to accept a directory path parameter
    public void saveToFile(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                System.out.println("Failed to create the directory: " + directoryPath);
                return;
            }
        }

        File noteFile = new File(directory, this.id + ".txt");
        if (noteFile.exists()) {
            if (!noteFile.delete()) {
                System.out.println("Failed to delete existing file with ID: " + this.id);
                return;
            }
        }

        try (FileWriter writer = new FileWriter(noteFile)) {
            writer.write("Title: " + this.title + "\n\n" + this.text);
            System.out.println("Note saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while trying to save the note.");
            e.printStackTrace();
        }
    }

    // Modified to accept a directory path parameter
    public static String readFromFile(String directoryPath, String id) {
        File noteFile = new File(directoryPath, id + ".txt");
        if (noteFile.exists()) {
            StringBuilder contentBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(noteFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    contentBuilder.append(line).append("\n");
                }
                return contentBuilder.toString().trim();
            } catch (IOException e) {
                System.out.println("An error occurred while trying to read the note.");
                e.printStackTrace();
                return null;
            }
        } else {
            System.out.println("No note found with ID: " + id);
            return null;
        }
    }
}