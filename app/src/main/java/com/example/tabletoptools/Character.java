package com.example.tabletoptools;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Character {

    // Initial values set to 0 for integers and "" for String
    public int age = 0;
    public String name = "";

    // Points initialized to 0
    public int pp = 0;
    public int dp = 0;
    public int mp = 0;
    public int sp = 0;

    // Base Values initialized to 0
    public int baseValuePhys = 0;
    public int baseValueDex = 0;
    public int baseValueMent = 0;
    public int baseValueSoc = 0;

    // Total Values initialized to 0
    public int totalValuePhys = 0;
    public int totalValueDex = 0;
    public int totalValueMent = 0;
    public int totalValueSoc = 0;

    // Attribute Modifiers initialized to 0
    public int modPhys = 0;
    public int modDex = 0;
    public int modMent = 0;
    public int modSoc = 0;

    // Health Points initialized to 0
    public int head = 0;
    public int lArm = 0;
    public int rArm = 0;
    public int torso = 0;
    public int lLeg = 0;
    public int rLeg = 0;

    // Physical Skills Values initialized to 0
    public int melleWeapons = 0;
    public int brawl = 0;
    public int imposition = 0;
    public int Athletics = 0;
    public int range = 0;

    // Mental Skills Values initialized to 0
    public int math = 0;
    public int forgery = 0;
    public int alchemy = 0;
    public int naturalSciences = 0;
    public int philiology = 0;
    public int strategy = 0;
    public int engineering = 0;
    public int law = 0;
    public int appraise = 0;
    public int investigate = 0;
    public int medicine = 0;
    public int occult = 0;
    public int psychology = 0;
    public int firstAid = 0;
    public int survival = 0;

    // Dexterity Skills Value initialized to 0
    public int lockPicking = 0;
    public int sleightOfHand = 0;
    public int horseRiding = 0;
    public int locksmith = 0;
    public int firearms = 0;
    public int stealth = 0;
    public int throwable = 0;
    public int perception = 0;
    public int craft = 0;

    // Social Skills Value initialized to 0
    public int diplomacy = 0;
    public int intimidation = 0;
    public int streetWise = 0;
    public int negotiation = 0;
    public int deception = 0;
    public int action = 0;
    public int flirt = 0;



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
    public void calculateAttributeMod() {
        this.setModPhys((int) Math.round((this.calculateTotalValue(1) - 10) / 2.0));
        this.setModDex((int) Math.round((this.calculateTotalValue(2) - 10) / 2.0));
        this.setModMent((int) Math.round((this.calculateTotalValue(3) - 10) / 2.0));
        this.setModSoc((int) Math.round((this.calculateTotalValue(4) - 10) / 2.0));
    }

    public void setTotalValues() {
        // Calculate Physical Total Value
        int physResult = age < 35 ? 0 : (int) (Math.floor(age * 0.2) - 3);
        setTotalValuePhys(baseValuePhys - physResult);

        // Calculate Dexterity Total Value
        int dexResult = age < 35 ? 0 : (int) (Math.floor(age * 0.2) - 1);
        setTotalValueDex(baseValueDex - dexResult);

        // Set Mental and Social total values directly as they do not change with age in this model
        setTotalValueMent(baseValueMent);
        setTotalValueSoc(baseValueSoc);
    }
    public int calculateTotalValue(int type) {
        int totalvalue;
        int result;
        switch (type) {
            case 1: // Phys
                result = this.getAge() < 35 ? 0 : (int) (Math.floor(this.getAge() * 0.2) - 3);
                totalvalue = this.getBaseValuePhys() - result;
                break;
            case 2: // Dex
                result = this.getAge() < 35 ? 0 : (int) (Math.floor(this.getAge() * 0.2) - 1);
                totalvalue = this.getBaseValueDex() - result;
                break;
            case 3: // Ment
                totalvalue = this.getBaseValueMent();
                break;
            case 4: // Soc
                totalvalue = this.getBaseValueSoc();
                break;
            default:
                totalvalue = 0;
                break;
        }
        return totalvalue;
    }

    public void calculatePoints() {
        int ageRelatedValue = (int) Math.round(this.getAge() * 0.05);
        this.setPp(2 + this.getBaseValuePhys() + ageRelatedValue);
        this.setDp(2 + this.getBaseValueDex() + ageRelatedValue);
        this.setMp(2 + this.getBaseValueMent() + ageRelatedValue);
        this.setSp(2 + this.getBaseValueSoc() + ageRelatedValue);
    }

    public void calculateHp() {
        double calculationPart = (this.getAge() - 10) / 3.0;
        int rounded = (int) Math.round(calculationPart);
        this.setHead(15 - rounded + this.getBaseValuePhys());
        this.setlArm(30 - rounded + this.getBaseValuePhys());
        this.setrArm(30 - rounded + this.getBaseValuePhys());
        this.setlLeg(30 - rounded + this.getBaseValuePhys());
        this.setrLeg(30 - rounded + this.getBaseValuePhys());
        this.setTorso(50 - rounded + this.getBaseValuePhys());
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


        // Use Log.d for debug logging. The first parameter is a tag and the second is the message.
        Log.d("CharacterInfo", "____________________________________________________________________________________________");
        Log.d("CharacterInfo", "");
        Log.d("CharacterInfo", "");
        Log.d("CharacterInfo", "");
        Log.d("CharacterInfo", "");
        Log.d("CharacterInfo", "Character Information saved:");
        Log.d("CharacterInfo", "Name: " + getName() + ", Age: " + getAge());
        Log.d("CharacterInfo", "");
        Log.d("CharacterInfo", "");
        Log.d("CharacterInfo", "");
        Log.d("CharacterInfo", "");
        Log.d("CharacterInfo", "____________________________________________________________________________________________");

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getBaseValuePhys() {
        return baseValuePhys;
    }

    public void setBaseValuePhys(int baseValuePhys) {
        this.baseValuePhys = baseValuePhys;
    }

    public int getBaseValueDex() {
        return baseValueDex;
    }

    public void setBaseValueDex(int baseValueDex) {
        this.baseValueDex = baseValueDex;
    }

    public int getBaseValueMent() {
        return baseValueMent;
    }

    public void setBaseValueMent(int baseValueMent) {
        this.baseValueMent = baseValueMent;
    }

    public int getBaseValueSoc() {
        return baseValueSoc;
    }

    public void setBaseValueSoc(int baseValueSoc) {
        this.baseValueSoc = baseValueSoc;
    }

    public int getTotalValuePhys() {
        return totalValuePhys;
    }

    public void setTotalValuePhys(int totalValuePhys) {
        this.totalValuePhys = totalValuePhys;
    }

    public int getTotalValueDex() {
        return totalValueDex;
    }

    public void setTotalValueDex(int totalValueDex) {
        this.totalValueDex = totalValueDex;
    }

    public int getTotalValueMent() {
        return totalValueMent;
    }

    public void setTotalValueMent(int totalValueMent) {
        this.totalValueMent = totalValueMent;
    }

    public int getTotalValueSoc() {
        return totalValueSoc;
    }

    public void setTotalValueSoc(int totalValueSoc) {
        this.totalValueSoc = totalValueSoc;
    }

    public int getModPhys() {
        return modPhys;
    }

    public void setModPhys(int modPhys) {
        this.modPhys = modPhys;
    }

    public int getModDex() {
        return modDex;
    }

    public void setModDex(int modDex) {
        this.modDex = modDex;
    }

    public int getModMent() {
        return modMent;
    }

    public void setModMent(int modMent) {
        this.modMent = modMent;
    }

    public int getModSoc() {
        return modSoc;
    }

    public void setModSoc(int modSoc) {
        this.modSoc = modSoc;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getlArm() {
        return lArm;
    }

    public void setlArm(int lArm) {
        this.lArm = lArm;
    }

    public int getrArm() {
        return rArm;
    }

    public void setrArm(int rArm) {
        this.rArm = rArm;
    }

    public int getTorso() {
        return torso;
    }

    public void setTorso(int torso) {
        this.torso = torso;
    }

    public int getlLeg() {
        return lLeg;
    }

    public void setlLeg(int lLeg) {
        this.lLeg = lLeg;
    }

    public int getrLeg() {
        return rLeg;
    }

    public void setrLeg(int rLeg) {
        this.rLeg = rLeg;
    }

    public int getMelleWeapons() {
        return melleWeapons;
    }

    public void setMelleWeapons(int melleWeapons) {
        this.melleWeapons = melleWeapons;
    }

    public int getBrawl() {
        return brawl;
    }

    public void setBrawl(int brawl) {
        this.brawl = brawl;
    }

    public int getImposition() {
        return imposition;
    }

    public void setImposition(int imposition) {
        this.imposition = imposition;
    }

    public int getAthletics() {
        return Athletics;
    }

    public void setAthletics(int athletics) {
        Athletics = athletics;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getForgery() {
        return forgery;
    }

    public void setForgery(int forgery) {
        this.forgery = forgery;
    }

    public int getAlchemy() {
        return alchemy;
    }

    public void setAlchemy(int alchemy) {
        this.alchemy = alchemy;
    }

    public int getNaturalSciences() {
        return naturalSciences;
    }

    public void setNaturalSciences(int naturalSciences) {
        this.naturalSciences = naturalSciences;
    }

    public int getPhiliology() {
        return philiology;
    }

    public void setPhiliology(int philiology) {
        this.philiology = philiology;
    }

    public int getStrategy() {
        return strategy;
    }

    public void setStrategy(int strategy) {
        this.strategy = strategy;
    }

    public int getEngineering() {
        return engineering;
    }

    public void setEngineering(int engineering) {
        this.engineering = engineering;
    }

    public int getLaw() {
        return law;
    }

    public void setLaw(int law) {
        this.law = law;
    }

    public int getAppraise() {
        return appraise;
    }

    public void setAppraise(int appraise) {
        this.appraise = appraise;
    }

    public int getInvestigate() {
        return investigate;
    }

    public void setInvestigate(int investigate) {
        this.investigate = investigate;
    }

    public int getMedicine() {
        return medicine;
    }

    public void setMedicine(int medicine) {
        this.medicine = medicine;
    }

    public int getOccult() {
        return occult;
    }

    public void setOccult(int occult) {
        this.occult = occult;
    }

    public int getPsychology() {
        return psychology;
    }

    public void setPsychology(int psychology) {
        this.psychology = psychology;
    }

    public int getFirstAid() {
        return firstAid;
    }

    public void setFirstAid(int firstAid) {
        this.firstAid = firstAid;
    }

    public int getSurvival() {
        return survival;
    }

    public void setSurvival(int survival) {
        this.survival = survival;
    }

    public int getLockPicking() {
        return lockPicking;
    }

    public void setLockPicking(int lockPicking) {
        this.lockPicking = lockPicking;
    }

    public int getSleightOfHand() {
        return sleightOfHand;
    }

    public void setSleightOfHand(int sleightOfHand) {
        this.sleightOfHand = sleightOfHand;
    }

    public int getHorseRiding() {
        return horseRiding;
    }

    public void setHorseRiding(int horseRiding) {
        this.horseRiding = horseRiding;
    }

    public int getLocksmith() {
        return locksmith;
    }

    public void setLocksmith(int locksmith) {
        this.locksmith = locksmith;
    }

    public int getFirearms() {
        return firearms;
    }

    public void setFirearms(int firearms) {
        this.firearms = firearms;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getThrowable() {
        return throwable;
    }

    public void setThrowable(int throwable) {
        this.throwable = throwable;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getCraft() {
        return craft;
    }

    public void setCraft(int craft) {
        this.craft = craft;
    }

    public int getDiplomacy() {
        return diplomacy;
    }

    public void setDiplomacy(int diplomacy) {
        this.diplomacy = diplomacy;
    }

    public int getIntimidation() {
        return intimidation;
    }

    public void setIntimidation(int intimidation) {
        this.intimidation = intimidation;
    }

    public int getStreetWise() {
        return streetWise;
    }

    public void setStreetWise(int streetWise) {
        this.streetWise = streetWise;
    }

    public int getNegotiation() {
        return negotiation;
    }

    public void setNegotiation(int negotiation) {
        this.negotiation = negotiation;
    }

    public int getDeception() {
        return deception;
    }

    public void setDeception(int deception) {
        this.deception = deception;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getFlirt() {
        return flirt;
    }

    public void setFlirt(int flirt) {
        this.flirt = flirt;
    }
}
