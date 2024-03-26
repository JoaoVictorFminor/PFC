package com.example.tabletoptools;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private ConstraintLayout bannerConstraintLayout;
    private ConstraintLayout diceConstraintLayout;
    private ImageView profileImageButton;
    private ImageView characterImageButton;
    private TextView diceDisplay;
    static TextView characterNameTextView;
    static TextView characterAgeTextView;

    private TextView gridPhysTotalValue;
    private TextView gridPhysBaseValue;
    private TextView gridPhysMod;

    private TextView gridDexTotalValue;
    private TextView gridDexBaseValue;
    private TextView gridDexMod;

    private TextView gridMentTotalValue;
    private TextView gridMentBaseValue;
    private TextView gridMentMod;

    private TextView gridSocTotalValue;
    private TextView gridSocBaseValue;
    private TextView gridSocMod;

    private TextView healthHead, healthTorso, healthLeftArm, healthLeftLeg, healthRightArm, healthRightLeg;

    private TextView valMeleeWeapons, modMeleeWeapons;
    private TextView valBrawl, modBrawl;
    private TextView valImposition, modImposition;
    private TextView valAthletics, modAthletics;
    private TextView valRange, modRange;
    private TextView valMath, modMath;
    private TextView valForgery, modForgery;
    private TextView valAlchemy, modAlchemy;
    private TextView valNaturalSciences, modNaturalSciences;
    private TextView valPhiliology, modPhiliology;
    private TextView valStrategy, modStrategy;
    private TextView valEngineering, modEngineering;
    private TextView valLaw, modLaw;
    private TextView valAppraise, modAppraise;
    private TextView valInvestigate, modInvestigate;
    private TextView valMedicine, modMedicine;
    private TextView valOccult, modOccult;
    private TextView valPsychology, modPsychology;
    private TextView valFirstAid, modFirstAid;
    private TextView valSurvival, modSurvival;
    private TextView valLockPicking, modLockPicking;
    private TextView valSleightOfHand, modSleightOfHand;
    private TextView valHorseRiding, modHorseRiding;
    private TextView valLocksmith, modLocksmith;
    private TextView valFirearms, modFirearms;
    private TextView valStealth, modStealth;
    private TextView valThrowable, modThrowable;
    private TextView valPerception, modPerception;
    private TextView valCraft, modCraft;
    private TextView valDiplomacy, modDiplomacy;
    private TextView valIntimidation, modIntimidation;
    private TextView valStreetWise, modStreetWise;
    private TextView valNegotiation, modNegotiation;
    private TextView valDeception, modDeception;
    private TextView valAction, modAction;
    private TextView valFlirt, modFlirt;

    //_____________________________________________
    private Button buttonD4;
    private Button buttonD6;
    private Button buttonD8;
    private Button buttonD12;
    private Button buttonD20;
    private Button buttonD100;

    private Character character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        // Initialize the ConstraintLayouts
        bannerConstraintLayout = findViewById(R.id.bannerConstraintLayout);
        diceConstraintLayout = findViewById(R.id.diceConstraintLayout);

        // Initialize the ImageViews
        profileImageButton = findViewById(R.id.profileImageButton);
        characterImageButton = findViewById(R.id.characterImageButton);

        // Initialize the TextView
        diceDisplay = findViewById(R.id.diceDisplay);
        characterNameTextView = findViewById(R.id.characterNameTextView);
        characterAgeTextView = findViewById(R.id.characterAgeTextView);

        gridPhysTotalValue = findViewById(R.id.gridPhysTotalValue);
        gridPhysBaseValue = findViewById(R.id.gridPhysBaseValue);
        gridPhysMod = findViewById(R.id.gridPhysMod);

        gridDexTotalValue = findViewById(R.id.gridDexTotalValue);
        gridDexBaseValue = findViewById(R.id.gridDexBaseValue);
        gridDexMod = findViewById(R.id.gridDexMod);

        gridMentTotalValue = findViewById(R.id.gridMentTotalValue);
        gridMentBaseValue = findViewById(R.id.gridMentBaseValue);
        gridMentMod = findViewById(R.id.gridMentMod);

        gridSocTotalValue = findViewById(R.id.gridSocTotalValue);
        gridSocBaseValue = findViewById(R.id.gridSocBaseValue);
        gridSocMod = findViewById(R.id.gridSocMod);

        healthHead = findViewById(R.id.healthHeadGrid);
        healthTorso = findViewById(R.id.healthTorsoGrid);
        healthLeftArm = findViewById(R.id.healthTorsolArm);
        healthLeftLeg = findViewById(R.id.healthlLegGrid);
        healthRightArm = findViewById(R.id.healthrArmGrid);
        healthRightLeg = findViewById(R.id.healthrLegGrid);

        valMeleeWeapons = findViewById(R.id.valMeleeWeapons);
        modMeleeWeapons = findViewById(R.id.modMeleeWeapons);

        valBrawl = findViewById(R.id.valBrawl);
        modBrawl = findViewById(R.id.modBrawl);

        valImposition = findViewById(R.id.valImposition);
        modImposition = findViewById(R.id.modImposition);

        valAthletics = findViewById(R.id.valAthletics);
        modAthletics = findViewById(R.id.modAthletics);

        valRange = findViewById(R.id.valRange);
        modRange = findViewById(R.id.modRange);

        valMath = findViewById(R.id.valMath);
        modMath = findViewById(R.id.modMath);

        valForgery = findViewById(R.id.valForgery);
        modForgery = findViewById(R.id.modForgery);

        valAlchemy = findViewById(R.id.valAlchemy);
        modAlchemy = findViewById(R.id.modAlchemy);

        valNaturalSciences = findViewById(R.id.valNaturalSciences);
        modNaturalSciences = findViewById(R.id.modNaturalSciences);

        valPhiliology = findViewById(R.id.valPhiliology);
        modPhiliology = findViewById(R.id.modPhiliology);

        valStrategy = findViewById(R.id.valStrategy);
        modStrategy = findViewById(R.id.modStrategy);

        valEngineering = findViewById(R.id.valEngineering);
        modEngineering = findViewById(R.id.modEngineering);

        valLaw = findViewById(R.id.valLaw);
        modLaw = findViewById(R.id.modLaw);

        valAppraise = findViewById(R.id.valAppraise);
        modAppraise = findViewById(R.id.modAppraise);

        valInvestigate = findViewById(R.id.valInvestigate);
        modInvestigate = findViewById(R.id.modInvestigate);

        valMedicine = findViewById(R.id.valMedicine);
        modMedicine = findViewById(R.id.modMedicine);

        valOccult = findViewById(R.id.valOccult);
        modOccult = findViewById(R.id.modOccult);

        valPsychology = findViewById(R.id.valPsychology);
        modPsychology = findViewById(R.id.modPsychology);

        valFirstAid = findViewById(R.id.valFirstAid);
        modFirstAid = findViewById(R.id.modFirstAid);

        valSurvival = findViewById(R.id.valSurvival);
        modSurvival = findViewById(R.id.modSurvival);

        valLockPicking = findViewById(R.id.valLockPicking);
        modLockPicking = findViewById(R.id.modLockPicking);

        valSleightOfHand = findViewById(R.id.valSleightOfHand);
        modSleightOfHand = findViewById(R.id.modSleightOfHand);

        valHorseRiding = findViewById(R.id.valHorseRiding);
        modHorseRiding = findViewById(R.id.modHorseRiding);

        valLocksmith = findViewById(R.id.valLocksmith);
        modLocksmith = findViewById(R.id.modLocksmith);

        valFirearms = findViewById(R.id.valFirearms);
        modFirearms = findViewById(R.id.modFirearms);

        valStealth = findViewById(R.id.valStealth);
        modStealth = findViewById(R.id.modStealth);

        valThrowable = findViewById(R.id.valThrowable);
        modThrowable = findViewById(R.id.modThrowable);

        valPerception = findViewById(R.id.valPerception);
        modPerception = findViewById(R.id.modPerception);

        valCraft = findViewById(R.id.valCraft);
        modCraft = findViewById(R.id.modCraft);

        valDiplomacy = findViewById(R.id.valDiplomacy);
        modDiplomacy = findViewById(R.id.modDiplomacy);

        valIntimidation = findViewById(R.id.valIntimidation);
        modIntimidation = findViewById(R.id.modIntimidation);

        valStreetWise = findViewById(R.id.valStreetWise);
        modStreetWise = findViewById(R.id.modStreetWise);

        valNegotiation = findViewById(R.id.valNegotiation);
        modNegotiation = findViewById(R.id.modNegotiation);

        valDeception = findViewById(R.id.valDeception);
        modDeception = findViewById(R.id.modDeception);

        valAction = findViewById(R.id.valAction);
        modAction = findViewById(R.id.modAction);

        valFlirt = findViewById(R.id.valFlirt);
        modFlirt = findViewById(R.id.modFlirt);


        // Initialize the Buttons
        buttonD4 = findViewById(R.id.buttonD4);
        buttonD6 = findViewById(R.id.buttonD6);
        buttonD8 = findViewById(R.id.buttonD8);
        buttonD12 = findViewById(R.id.buttonD12);
        buttonD20 = findViewById(R.id.buttonD20);
        buttonD100 = findViewById(R.id.buttonD100);

        // Set click listeners for each button

        loadCharacterInfo();

        characterImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateCharacterActivity.class);
                startActivity(intent);
            }
        });

        buttonD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle buttonD4 click
                diceroll(4);
            }
        });

        buttonD6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle buttonD6 click
                diceroll(6);
            }
        });


        buttonD8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceroll(8);
            }
        });

        buttonD12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceroll(12);
            }
        });

        buttonD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceroll(20);
            }
        });

        buttonD100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceroll(100);
            }
        });
    }

    private void diceroll(final int maxNumber) {
        final Handler handler = new Handler();
        final int delayTime = 50; // Time in milliseconds between each number change.
        final int numberOfChanges = 20; // Number of random numbers to display before stopping.

        Runnable runnable = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                if (count < numberOfChanges) {
                    // Generate a random number and display it
                    int randomNumber = new Random().nextInt(maxNumber) + 1;
                    diceDisplay.setText(String.valueOf(randomNumber));
                    handler.postDelayed(this, delayTime);
                    count++;
                } else {
                    // Finally, display the actual final random number
                    int finalNumber = new Random().nextInt(maxNumber) + 1;
                    diceDisplay.setText(String.valueOf(finalNumber));
                }
            }
        };

        // Start the animation
        handler.post(runnable);
    }


    private Character testCharacter(){

        Character character = new Character();
        character.readCharacterFromJson(this,"Raoul Maskelyne");
/*
        //Character placeholder
        Character character = new Character();
        Character.name = "Raoul Maskelyne";
        Character.age = 47;
        Character.baseValuePhys = 7;
        Character.baseValueDex = 16;
        Character.baseValueMent = 8;
        Character.baseValueSoc = 14;


        Character.calculateAttributeMod();
        Character.calculatePoints();
        Character.calculateHp();

        Character.totalValuePhys = Character.calculateTotalValue(1);
        Character.totalValueDex = Character.calculateTotalValue(2);
        Character.totalValueMent = Character.calculateTotalValue(3);
        Character.totalValueSoc = Character.calculateTotalValue(4);


        character.melleWeapons = 2;
        character.brawl = 3; // Assuming 'brawl' was meant to be 'Bows etc' with value 1; if not listed, setting to 0
        character.imposition = 2; // Not listed, assuming 0
        character.Athletics = 3;
        character.range = 1; // 'range' is not explicitly listed, assuming it's similar to 'Bows etc'

// Assuming these mental skills are fields in your Character class
        character.math = 0; // 'Math' was listed without a value, assuming 0
        character.forgery = 2; // Not listed, assuming 0
        character.alchemy = 0; // Not listed, assuming 0
        character.naturalSciences = 0; // Not listed, assuming 0
        character.philiology = 0; // Not listed, assuming 0
        character.strategy = 3; // Not listed, assuming 0
        character.engineering = 0; // Not listed, assuming 0
        character.law = 0; // Not listed, assuming 0
        character.appraise = 0; // Not listed, assuming 0
        character.investigate = 0; // Not listed, assuming 0
        character.medicine = 0; // Not listed, assuming 0
        character.occult = 5; // Not listed, assuming 0
        character.psychology = 0; // Not listed, assuming 0
        character.firstAid = 0; // Not listed, assuming 0
        character.survival = 2; // Not listed, assuming 0

// Assuming these dexterity skills are fields in your Character class
        character.lockPicking = 5; // Not listed, assuming 0
        character.sleightOfHand = 6; // Not listed, assuming 0
        character.horseRiding = 0; // Not listed, assuming 0
        character.locksmith = 0; // Not listed, assuming 0
        character.firearms = 0; // Not listed, assuming 0
        character.stealth = 4; // Not listed, assuming 0
        character.throwable = 0; // Not listed, assuming 0
        character.perception = 5; // Not listed, assuming 0
        character.craft = 0; // Not listed, assuming 0

// Assuming these social skills are fields in your Character class
        character.diplomacy = 0; // Not listed, assuming 0
        character.intimidation = 0; // Not listed, assuming 0
        character.streetWise = 3; // Not listed, assuming 0
        character.negotiation = 3; // Not listed, assuming 0
        character.deception = 5; // Not listed, assuming 0
        character.action = 7; // Not listed, assuming 0
        character.flirt = 0;

        // Use Log.d for debug logging. The first parameter is a tag and the second is the message.
        Log.d("CharacterInfo", "____________________________________________________________________________________________");
        Log.d("CharacterInfo", "Character Information:");
        Log.d("CharacterInfo", "Name: " + character.name + ", Age: " + character.age);
        Log.d("CharacterInfo", "Base Values - Physical: " + character.baseValuePhys + ", Dexterity: " + character.baseValueDex +
                ", Mental: " + character.baseValueMent + ", Social: " + character.baseValueSoc);
        Log.d("CharacterInfo", "Points - Physical Points: " + character.pp + ", Dexterity Points: " + character.dp +
                ", Mental Points: " + character.mp + ", Social Points: " + character.sp);
        Log.d("CharacterInfo", "Health Points - Head: " + character.head + ", Left Arm: " + character.lArm + ", Right Arm: " + character.rArm +
                ", Torso: " + character.torso + ", Left Leg: " + character.lLeg + ", Right Leg: " + character.rLeg);

        // Skills and Modifiers
        Log.d("CharacterSkills", "Skills and Modifiers:");
        Log.d("CharacterSkills", "Melee Weapons: " + character.melleWeapons + ", Modifier: " + (character.melleWeapons + character.modPhys));
        Log.d("CharacterSkills", "Brawl: " + character.brawl + ", Modifier: " + (character.brawl + character.modPhys));
        Log.d("CharacterSkills", "Imposition: " + character.imposition + ", Modifier: " + (character.imposition + character.modPhys));
        Log.d("CharacterSkills", "Athletics: " + character.Athletics + ", Modifier: " + (character.Athletics + character.modPhys));
        Log.d("CharacterSkills", "Range: " + character.range + ", Modifier: " + (character.range + character.modPhys));
        // Mental Skills
        Log.d("CharacterSkills", "Math: " + character.math + ", Modifier: " + (character.math + character.modMent));
        Log.d("CharacterSkills", "Forgery: " + character.forgery + ", Modifier: " + (character.forgery + character.modMent));
        Log.d("CharacterSkills", "Alchemy: " + character.alchemy + ", Modifier: " + (character.alchemy + character.modMent));
        Log.d("CharacterSkills", "Occult: " + character.occult + ", Modifier: " + (character.occult + character.modMent));
        Log.d("CharacterSkills", "Survival: " + character.survival + ", Modifier: " + (character.survival + character.modMent));


        // Dexterity Skills
        Log.d("CharacterSkills", "Lock Picking: " + character.lockPicking + ", Modifier: " + (character.lockPicking + character.modDex));
        Log.d("CharacterSkills", "Sleight of Hand: " + character.sleightOfHand + ", Modifier: " + (character.sleightOfHand + character.modDex));
        Log.d("CharacterSkills", "Stealth: " + character.stealth + ", Modifier: " + (character.stealth + character.modDex));
        Log.d("CharacterSkills", "Perception: " + character.perception + ", Modifier: " + (character.perception + character.modDex));
        // Social Skills
        Log.d("CharacterSkills", "Street Wise: " + character.streetWise + ", Modifier: " + (character.streetWise + character.modSoc));
        Log.d("CharacterSkills", "Negotiation: " + character.negotiation + ", Modifier: " + (character.negotiation + character.modSoc));
        Log.d("CharacterSkills", "Deception: " + character.deception + ", Modifier: " + (character.deception + character.modSoc));
        Log.d("CharacterSkills", "Action: " + character.action + ", Modifier: " + (character.action + character.modSoc));
        Log.d("CharacterSkills", "Flirt: " + character.flirt + ", Modifier: " + (character.flirt + character.modSoc));
*/

        return character;


    }


    private void loadCharacterInfo() {

        character = testCharacter();

        characterNameTextView.setText(character.name);
        characterAgeTextView.setText("Age: " + String.valueOf(character.age));

        gridPhysTotalValue.setText(String.valueOf(character.totalValuePhys));
        gridPhysBaseValue.setText(String.valueOf(character.baseValuePhys));
        gridPhysMod.setText(String.valueOf(character.modPhys));

        gridDexTotalValue.setText(String.valueOf(character.totalValueDex));
        gridDexBaseValue.setText(String.valueOf(character.baseValueDex));
        gridDexMod.setText(String.valueOf(character.modDex));

        gridMentTotalValue.setText(String.valueOf(character.totalValueMent));
        gridMentBaseValue.setText(String.valueOf(character.baseValueMent));
        gridMentMod.setText(String.valueOf(character.modMent));

        gridSocTotalValue.setText(String.valueOf(character.totalValueSoc));
        gridSocBaseValue.setText(String.valueOf(character.baseValueSoc));
        gridSocMod.setText(String.valueOf(character.modSoc));

        healthHead.setText(String.valueOf(character.getHead()));
        healthTorso.setText(String.valueOf(character.getTorso()));
        healthLeftArm.setText(String.valueOf(character.getlArm()));
        healthLeftLeg.setText(String.valueOf(character.getlLeg()));
        healthRightArm.setText(String.valueOf(character.getrArm()));
        healthRightLeg.setText(String.valueOf(character.getrLeg()));

        initSpinners();


// Setting the character's basic info
        characterNameTextView.setText(character.getName());
        characterAgeTextView.setText("Age: " + character.getAge());

        // Setting the base, total values, and modifiers for attributes
        gridPhysTotalValue.setText(String.valueOf(character.getTotalValuePhys()));
        gridPhysBaseValue.setText(String.valueOf(character.getBaseValuePhys()));
        gridPhysMod.setText(String.valueOf(character.getModPhys()));

        gridDexTotalValue.setText(String.valueOf(character.getTotalValueDex()));
        gridDexBaseValue.setText(String.valueOf(character.getBaseValueDex()));
        gridDexMod.setText(String.valueOf(character.getModDex()));

        gridMentTotalValue.setText(String.valueOf(character.getTotalValueMent()));
        gridMentBaseValue.setText(String.valueOf(character.getBaseValueMent()));
        gridMentMod.setText(String.valueOf(character.getModMent()));

        gridSocTotalValue.setText(String.valueOf(character.getTotalValueSoc()));
        gridSocBaseValue.setText(String.valueOf(character.getBaseValueSoc()));
        gridSocMod.setText(String.valueOf(character.getModSoc()));

        // Setting health points for each body part
        healthHead.setText(String.valueOf(character.getHead()));
        healthTorso.setText(String.valueOf(character.getTorso()));
        healthLeftArm.setText(String.valueOf(character.getlArm()));
        healthLeftLeg.setText(String.valueOf(character.getlLeg()));
        healthRightArm.setText(String.valueOf(character.getrArm()));
        healthRightLeg.setText(String.valueOf(character.getrLeg()));

        // Setting Physical Skills Values and Modifiers
        setSkillValueAndModifier(valMeleeWeapons, modMeleeWeapons, character.getMelleWeapons(), character.getModPhys());
        setSkillValueAndModifier(valBrawl, modBrawl, character.getBrawl(), character.getModPhys());
        setSkillValueAndModifier(valImposition, modImposition, character.getImposition(), character.getModPhys());
        setSkillValueAndModifier(valAthletics, modAthletics, character.getAthletics(), character.getModPhys());
        setSkillValueAndModifier(valRange, modRange, character.getRange(), character.getModPhys());

        // Setting Mental Skills Values and Modifiers
        setSkillValueAndModifier(valMath, modMath, character.getMath(), character.getModMent());
        setSkillValueAndModifier(valForgery, modForgery, character.getForgery(), character.getModMent());
        setSkillValueAndModifier(valAlchemy, modAlchemy, character.getAlchemy(), character.getModMent());
        setSkillValueAndModifier(valNaturalSciences, modNaturalSciences, character.getNaturalSciences(), character.getModMent());
        setSkillValueAndModifier(valPhiliology, modPhiliology, character.getPhiliology(), character.getModMent());
        setSkillValueAndModifier(valStrategy, modStrategy, character.getStrategy(), character.getModMent());
        setSkillValueAndModifier(valEngineering, modEngineering, character.getEngineering(), character.getModMent());
        setSkillValueAndModifier(valLaw, modLaw, character.getLaw(), character.getModMent());
        setSkillValueAndModifier(valAppraise, modAppraise, character.getAppraise(), character.getModMent());
        setSkillValueAndModifier(valInvestigate, modInvestigate, character.getInvestigate(), character.getModMent());
        setSkillValueAndModifier(valMedicine, modMedicine, character.getMedicine(), character.getModMent());
        setSkillValueAndModifier(valOccult, modOccult, character.getOccult(), character.getModMent());
        setSkillValueAndModifier(valPsychology, modPsychology, character.getPsychology(), character.getModMent());
        setSkillValueAndModifier(valFirstAid, modFirstAid, character.getFirstAid(), character.getModMent());
        setSkillValueAndModifier(valSurvival, modSurvival, character.getSurvival(), character.getModMent());

        // Setting Dexterity Skills Values and Modifiers
        setSkillValueAndModifier(valLockPicking, modLockPicking, character.getLockPicking(), character.getModDex());
        setSkillValueAndModifier(valSleightOfHand, modSleightOfHand, character.getSleightOfHand(), character.getModDex());
        setSkillValueAndModifier(valHorseRiding, modHorseRiding, character.getHorseRiding(), character.getModDex());
        setSkillValueAndModifier(valLocksmith, modLocksmith, character.getLocksmith(), character.getModDex());
        setSkillValueAndModifier(valFirearms, modFirearms, character.getFirearms(), character.getModDex());
        setSkillValueAndModifier(valStealth, modStealth, character.getStealth(), character.getModDex());
        setSkillValueAndModifier(valThrowable, modThrowable, character.getThrowable(), character.getModDex());
        setSkillValueAndModifier(valPerception, modPerception, character.getPerception(), character.getModDex());
        setSkillValueAndModifier(valCraft, modCraft, character.getCraft(), character.getModDex());

        // Setting Social Skills Values and Modifiers
        setSkillValueAndModifier(valDiplomacy, modDiplomacy, character.getDiplomacy(), character.getModSoc());
        setSkillValueAndModifier(valIntimidation, modIntimidation, character.getIntimidation(), character.getModSoc());
        setSkillValueAndModifier(valStreetWise, modStreetWise, character.getStreetWise(), character.getModSoc());
        setSkillValueAndModifier(valNegotiation, modNegotiation, character.getNegotiation(), character.getModSoc());
        setSkillValueAndModifier(valDeception, modDeception, character.getDeception(), character.getModSoc());
        setSkillValueAndModifier(valAction, modAction, character.getAction(), character.getModSoc());
        setSkillValueAndModifier(valFlirt, modFlirt, character.getFlirt(), character.getModSoc());
    }



    // Assuming 'character' is your Character instance available in this context
    private void initSpinners() {
        // Initialize each spinner with numbers based on the character's health points for each body part
        initSpinnerWithRange(findViewById(R.id.damageHead), character.getHead());
        initSpinnerWithRange(findViewById(R.id.damageTorso), character.getTorso());
        initSpinnerWithRange(findViewById(R.id.damagelArm), character.getlArm());
        initSpinnerWithRange(findViewById(R.id.damageLleg), character.getlLeg());
        initSpinnerWithRange(findViewById(R.id.damagerArm), character.getrArm());
        initSpinnerWithRange(findViewById(R.id.damagerLeg), character.getrLeg());
    }


    private void initSpinnerWithRange(Spinner spinner, int maxHealth) {
        List<String> numbers = new ArrayList<>();
        // Range from 0 to maxHealth
        for (int i = 0; i <= maxHealth; i++) {
            numbers.add(String.valueOf(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, numbers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void setSkillValueAndModifier(TextView valueTextView, TextView modifierTextView, int skillValue, int attributeModifier) {
        valueTextView.setText(String.valueOf(skillValue));
        int skillModifier = skillValue + attributeModifier;
        String modifierText = skillModifier >= 0 ? "+" + skillModifier : String.valueOf(skillModifier);
        modifierTextView.setText(modifierText);
    }



}