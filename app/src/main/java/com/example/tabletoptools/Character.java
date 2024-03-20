package com.example.tabletoptools;

public class Character {

    int age;
    String name;

    int pp;
    int dp;
    int mp;
    int sp;

    //Base Value

    int baseValuePhys;
    int baseValueDex;
    int baseValueMent;
    int baseValueSoc;

    //Total Value

    int totalValuePhys;
    int totalValueDex;
    int totalValueMent;
    int totalValueSoc;


    //Attribute Modifier
    int modPhys;
    int modDex;
    int modMent;
    int modSoc;


    //HealthPoints

    int head;
    int lArm;
    int rArm;
    int torso;
    int lLeg;
    int rLeg;


    //PhysSkillsValues
    int melleWeapons;
    int brawl;
    int imposition;
    int Athletics;
    int range;

    //MentalSkillsValues

    int math;
    int forgery;
    int alchemy;
    int naturalSciences;
    int philiology;
    int strategy;
    int engineering;
    int law;
    int appraise;
    int investigate;
    int medicine;
    int occult;
    int psychology;
    int firstAid;
    int survival;

    //DexteritySkillsValue

    int lockPicking;
    int sleightOfHand;
    int horseRiding;
    int locksmith;
    int firearms;
    int stealth;
    int throwable;
    int perception;
    int craft;

    //SocialSkillsValue;

    int diplomacy;
    int intimidation;
    int streetWise;
    int negotiation;
    int deception;
    int action;
    int flirt;

    private void calculateAttributeMod(int totalAttributeValue) {
        modPhys = (int) Math.round((age - 10) / 2.0);
        modDex = (int) Math.round((age - 10) / 2.0);
        modMent = (int) Math.round((age - 10) / 2.0);
        modSoc = (int) Math.round((age - 10) / 2.0);

    }

    public int calculateTotalValue(int type) {
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

    public void calculatePoints() {
        // Calculate the common part of the formula
        int ageRelatedValue = (int) Math.round(age * 0.05);

        // Calculate each point based on the base value and the age-related value
        pp = 2 + baseValuePhys + ageRelatedValue;
        dp = 2 + baseValueDex + ageRelatedValue;
        mp = 2 + baseValueMent + ageRelatedValue;
        sp = 2 + baseValueSoc + ageRelatedValue;
    }




    public void calculateHp() {

        double roundedValue = Math.round((age - 10) / 3.0);
        double result = roundedValue + baseValuePhys;
        head = (int) (15 - result);
        lArm = (int) (30 - result);
        rArm = (int) (30 - result);
        lLeg = (int) (30 - result);
        rLeg = (int) (30 - result);
        torso = (int) (50 - result);
    }


    public void calculateSkillMod() {
        // Calculate modifiers based on total attribute values

        // Apply Physical Modifiers to Physical Skills
        melleWeapons += modPhys;
        brawl += modPhys;
        imposition += modPhys;
        Athletics += modPhys;
        range += modPhys;

        // Apply Dexterity Modifiers to Dexterity Skills
        lockPicking += modDex;
        sleightOfHand += modDex;
        horseRiding += modDex;
        locksmith += modDex;
        firearms += modDex;
        stealth += modDex;
        throwable += modDex;
        perception += modDex;
        craft += modDex;

        // Apply Mental Modifiers to Mental Skills
        math += modMent;
        forgery += modMent;
        alchemy += modMent;
        naturalSciences += modMent;
        philiology += modMent;
        strategy += modMent;
        engineering += modMent;
        law += modMent;
        appraise += modMent;
        investigate += modMent;
        medicine += modMent;
        occult += modMent;
        psychology += modMent;
        firstAid += modMent;
        survival += modMent;

        // Apply Social Modifiers to Social Skills
        diplomacy += modSoc;
        intimidation += modSoc;
        streetWise += modSoc;
        negotiation += modSoc;
        deception += modSoc;
        action += modSoc;
        flirt += modSoc;
    }









}
