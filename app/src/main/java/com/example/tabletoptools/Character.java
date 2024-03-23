package com.example.tabletoptools;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Character {

    public static int age;
    public static String name;

    public static int pp;
    public static int dp;
    public static int mp;
    public static int sp;

    //Base Value

    public static int baseValuePhys;
    public static int baseValueDex;
    public static int baseValueMent;
    public static int baseValueSoc;

    //Total Value

    public static int totalValuePhys;
    public static int totalValueDex;
    public static int totalValueMent;
    public static int totalValueSoc;


    //Attribute Modifier
    public static int modPhys;
    public static int modDex;
    public static int modMent;
    public static int modSoc;


    //HealthPoints

    public static int head;
    public static int lArm;
    public static int rArm;
    public static int torso;
    public static int lLeg;
    public static int rLeg;


    //PhysSkillsValues
    public static int melleWeapons;
    public static int brawl;
    public static int imposition;
    public static int Athletics;
    public static int range;

    //MentalSkillsValues

    public static int math;
    public static int forgery;
    public static int alchemy;
    public static int naturalSciences;
    public static int philiology;
    public static int strategy;
    public static int engineering;
    public static int law;
    public static int appraise;
    public static int investigate;
    public static int medicine;
    public static int occult;
    public static int psychology;
    public static int firstAid;
    public static int survival;

    //DexteritySkillsValue

    public static int lockPicking;
    public static int sleightOfHand;
    public static int horseRiding;
    public static int locksmith;
    public static int firearms;
    public static int stealth;
    public static int throwable;
    public static int perception;
    public static int craft;

    //SocialSkillsValue;

    public static int diplomacy;
    public static int intimidation;
    public static int streetWise;
    public static int negotiation;
    public static int deception;
    public static int action;
    public static int flirt;


    public void readCharacterFromJson(Context context, String characterName) {
        try {
            // Define the folder name where characters are saved
            String folderName = "savedcharacter"; // Changed to match the new directory

            // Construct the file path using the internal directory
            File internalDir = new File(context.getFilesDir(), folderName);

            // Sanitize the characterName to be used as the filename
            String sanitizedFilename = characterName.replaceAll("[^a-zA-Z0-9\\._]+", "_") + ".json";

            // Create a file object for the saved character data
            File file = new File(internalDir, sanitizedFilename);

            // Check if the character file exists
            if (!file.exists()) {
                throw new IOException("Character file does not exist.");
            }

            // Read the content of the file
            FileInputStream fis = new FileInputStream(file);
            StringBuilder builder = new StringBuilder();
            int ch;
            while ((ch = fis.read()) != -1) {
                builder.append((char) ch);
            }
            String jsonString = builder.toString();

            // Close the FileInputStream
            fis.close();

            // Parse the JSON string
            JSONObject characterJson = new JSONObject(jsonString);

            // Set character attributes from the JSON object
            name = characterJson.optString("name");
            age = characterJson.optInt("age");
            baseValuePhys = characterJson.optInt("baseValuePhys");
            baseValueDex = characterJson.optInt("baseValueDex");
            baseValueMent = characterJson.optInt("baseValueMent");
            baseValueSoc = characterJson.optInt("baseValueSoc");
            melleWeapons = characterJson.optInt("melleWeapons");
            brawl = characterJson.optInt("brawl");
            imposition = characterJson.optInt("imposition");
            Athletics = characterJson.optInt("Athletics");
            range = characterJson.optInt("range");
            math = characterJson.optInt("math");
            forgery = characterJson.optInt("forgery");
            alchemy = characterJson.optInt("alchemy");
            naturalSciences = characterJson.optInt("naturalSciences");
            philiology = characterJson.optInt("philiology");
            strategy = characterJson.optInt("strategy");
            engineering = characterJson.optInt("engineering");
            law = characterJson.optInt("law");
            appraise = characterJson.optInt("appraise");
            investigate = characterJson.optInt("investigate");
            medicine = characterJson.optInt("medicine");
            occult = characterJson.optInt("occult");
            psychology = characterJson.optInt("psychology");
            firstAid = characterJson.optInt("firstAid");
            survival = characterJson.optInt("survival");
            lockPicking = characterJson.optInt("lockPicking");
            sleightOfHand = characterJson.optInt("sleightOfHand");
            horseRiding = characterJson.optInt("horseRiding");
            locksmith = characterJson.optInt("locksmith");
            firearms = characterJson.optInt("firearms");
            stealth = characterJson.optInt("stealth");
            throwable = characterJson.optInt("throwable");
            perception = characterJson.optInt("perception");
            craft = characterJson.optInt("craft");
            diplomacy = characterJson.optInt("diplomacy");
            intimidation = characterJson.optInt("intimidation");
            streetWise = characterJson.optInt("streetWise");
            negotiation = characterJson.optInt("negotiation");
            deception = characterJson.optInt("deception");
            action = characterJson.optInt("action");
            flirt = characterJson.optInt("flirt");

            // calculate any derived attributes after loading
            calculateAttributeMod(); // Example method call, adjust based on your class structure
            calculatePoints();
            calculateHp();

            Log.d("CHARACTERLOAD" , "CHARACTER LOADED WITH SUCCESS");

        } catch (Exception e) {
            e.printStackTrace();
            // Handle error - for example, by setting default values or logging an error
            System.err.println("ERROR READING CHARACTER FROM JSON " + e);
        }
    }
    static void calculateAttributeMod() {
        modPhys = (int) Math.round((Character.calculateTotalValue(1) - 10) / 2.0);
        modDex = (int) Math.round((Character.calculateTotalValue(2) - 10) / 2.0);
        modMent = (int) Math.round((Character.calculateTotalValue(3) - 10) / 2.0);
        modSoc = (int) Math.round((Character.calculateTotalValue(4)- 10) / 2.0);

    }

    public static int calculateTotalValue(int type) {
        int totalvalue;
        if (type == 1) {
            int result;
            if (age < 35) {
                result = 0;
            } else {
                result = (int) (Math.floor(age * 0.2) - 3);
            }
            totalvalue = baseValuePhys - result;
        } else if (type == 2) {
            int result;
            if (age < 35) {
                result = 0;
            } else {
                result = (int) (Math.floor(age * 0.2) - 1);
            }
            totalvalue = baseValueDex - result;
        } else if (type == 3) {
            totalvalue = baseValueMent;
        } else if (type == 4) {
            totalvalue = baseValueSoc;
        } else {
            totalvalue = 0;
        }

        return totalvalue;

    }

    public static void calculatePoints() {
        // Calculate the common part of the formula
        int ageRelatedValue = (int) Math.round(age * 0.05);

        // Calculate each point based on the base value and the age-related value
        pp = 2 + baseValuePhys + ageRelatedValue;
        dp = 2 + baseValueDex + ageRelatedValue;
        mp = 2 + baseValueMent + ageRelatedValue;
        sp = 2 + baseValueSoc + ageRelatedValue;
    }




    public static void calculateHp() {
        double calculationPart = (age - 10) / 3.0;
        int rounded = (int) Math.round(calculationPart); // Round to nearest integer
        head = 15 - rounded + baseValuePhys;
        lArm = 30 - rounded + baseValuePhys;
        rArm = 30 - rounded + baseValuePhys;
        lLeg = 30 - rounded + baseValuePhys;
        rLeg = 30 - rounded + baseValuePhys;
        torso = 50 - rounded + baseValuePhys;
    }

    public void saveCharacterToJson(Context context) {
        try {
            // Creating a JSONObject to store character data
            JSONObject characterJson = new JSONObject();

            // Populating the JSON object with character attributes
            characterJson.put("name", name);
            characterJson.put("age", age);
            characterJson.put("baseValuePhys", baseValuePhys);
            characterJson.put("baseValueDex", baseValueDex);
            characterJson.put("baseValueMent", baseValueMent);
            characterJson.put("baseValueSoc", baseValueSoc);
            characterJson.put("melleWeapons", melleWeapons);
            characterJson.put("brawl", brawl);
            characterJson.put("imposition", imposition);
            characterJson.put("Athletics", Athletics);
            characterJson.put("range", range);
            characterJson.put("math", math);
            characterJson.put("forgery", forgery);
            characterJson.put("alchemy", alchemy);
            characterJson.put("naturalSciences", naturalSciences);
            characterJson.put("philiology", philiology);
            characterJson.put("strategy", strategy);
            characterJson.put("engineering", engineering);
            characterJson.put("law", law);
            characterJson.put("appraise", appraise);
            characterJson.put("investigate", investigate);
            characterJson.put("medicine", medicine);
            characterJson.put("occult", occult);
            characterJson.put("psychology", psychology);
            characterJson.put("firstAid", firstAid);
            characterJson.put("survival", survival);
            characterJson.put("lockPicking", lockPicking);
            characterJson.put("sleightOfHand", sleightOfHand);
            characterJson.put("horseRiding", horseRiding);
            characterJson.put("locksmith", locksmith);
            characterJson.put("firearms", firearms);
            characterJson.put("stealth", stealth);
            characterJson.put("throwable", throwable);
            characterJson.put("perception", perception);
            characterJson.put("craft", craft);
            characterJson.put("diplomacy", diplomacy);
            characterJson.put("intimidation", intimidation);
            characterJson.put("streetWise", streetWise);
            characterJson.put("negotiation", negotiation);
            characterJson.put("deception", deception);
            characterJson.put("action", action);
            characterJson.put("flirt", flirt);

            String characterString = characterJson.toString();

            // Define the folder name where characters will be saved
            String folderName = "savedcharacter";

            // Getting the internal directory
            File internalDir = new File(context.getFilesDir(), folderName);

            // Ensure the directory exists
            if (!internalDir.exists()) {
                internalDir.mkdirs();
            }

            // Define the filename using the character's name and ensure it is a valid filename
            String filename = name.replaceAll("[^a-zA-Z0-9\\._]+", "_") + ".json";

            // Create a file object within the savedcharacter directory
            File file = new File(internalDir, filename);

            // Check if a character file with the same name already exists, and if so, delete it
            if (file.exists()) {
                boolean deleted = file.delete();
                if (deleted) {
                    Log.d("CHARACTERLOAD", "Previous character file deleted.");
                } else {
                    Log.e("CHARACTERLOAD", "Failed to delete previous character file.");
                    return; // Exit the method as we couldn't delete the old file
                }
            }

            // Write the new JSON string to the file
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(characterString.getBytes());
                System.out.println("Character saved to " + file.getAbsolutePath());
                Log.d("CHARACTERLOAD", "CHARACTER SAVED WITH SUCCESS");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteCharacterJson(Context context, String characterName) {
        try {
            // Define the folder name where characters are saved
            String folderName = "savedcharacter"; // Folder name where character files are saved

            // Sanitize the characterName to be used as the filename
            String sanitizedFilename = characterName.replaceAll("[^a-zA-Z0-9\\._]+", "_") + ".json";

            // Create a file object for the character data
            File internalDir = new File(context.getFilesDir(), folderName);
            File file = new File(internalDir, sanitizedFilename);

            // Check if the character file exists
            if (!file.exists()) {
                Log.d("DELETECHARACTER", "Character file does not exist.");
            }

            // Attempt to delete the file
            boolean deleted = file.delete();
            if (deleted) {
                Log.d("DELETECHARACTER", "Character deleted successfully.");
            } else {
                Log.d("DELETECHARACTER", "Failed to delete character.");
            }

        } catch (Exception e) {
            Log.e("DELETECHARACTER", "Error deleting character.", e);
        }
    }
}
