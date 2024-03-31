package com.example.tabletoptools;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CreateCharacterActivity extends AppCompatActivity {

    private EditText characterNameEditText;
    private EditText characterAgeEditText;
    private Button saveButton;
    private EditText physicalAttributesEditText;
    private EditText dexterityAttributesEditText;
    private EditText mentalAttributesEditText;
    private EditText socialAttributesEditText;


    // EditTexts for Values
    private EditText valMeleeWeapons, valBrawl, valImposition, valAthletics, valRange, valMath, valForgery, valAlchemy, valNaturalSciences, valPhiliology, valStrategy, valEngineering, valLaw, valAppraise, valInvestigate, valMedicine, valOccult, valPsychology, valFirstAid, valSurvival, valLockPicking, valSleightOfHand, valHorseRiding, valLocksmith, valFirearms, valStealth, valThrowable, valPerception, valCraft, valDiplomacy, valIntimidation, valStreetWise, valNegotiation, valDeception, valAction, valFlirt;

    // TextViews for Mods
    private TextView modMeleeWeapons, modBrawl, modImposition, modAthletics, modRange, modMath, modForgery, modAlchemy, modNaturalSciences, modPhiliology, modStrategy, modEngineering, modLaw, modAppraise, modInvestigate, modMedicine, modOccult, modPsychology, modFirstAid, modSurvival, modLockPicking, modSleightOfHand, modHorseRiding, modLocksmith, modFirearms, modStealth, modThrowable, modPerception, modCraft, modDiplomacy, modIntimidation, modStreetWise, modNegotiation, modDeception, modAction, modFlirt;

    private TextView instructionTextView;
    private Character character;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character);

        character = new Character();

        // Initialize EditTexts
        characterNameEditText = findViewById(R.id.characterNameEditText);
        characterAgeEditText = findViewById(R.id.characterAgeEditText);
        saveButton = findViewById(R.id.saveButton); // Initialize the button, make sure to have it in your layout


        // EditTexts for Values
        valMeleeWeapons = findViewById(R.id.valMeleeWeapons);
        valBrawl = findViewById(R.id.valBrawl);
        valImposition = findViewById(R.id.valImposition);
        valAthletics = findViewById(R.id.valAthletics);
        valRange = findViewById(R.id.valRange);
        valMath = findViewById(R.id.valMath);
        valForgery = findViewById(R.id.valForgery);
        valAlchemy = findViewById(R.id.valAlchemy);
        valNaturalSciences = findViewById(R.id.valNaturalSciences);
        valPhiliology = findViewById(R.id.valPhiliology);
        valStrategy = findViewById(R.id.valStrategy);
        valEngineering = findViewById(R.id.valEngineering);
        valLaw = findViewById(R.id.valLaw);
        valAppraise = findViewById(R.id.valAppraise);
        valInvestigate = findViewById(R.id.valInvestigate);
        valMedicine = findViewById(R.id.valMedicine);
        valOccult = findViewById(R.id.valOccult);
        valPsychology = findViewById(R.id.valPsychology);
        valFirstAid = findViewById(R.id.valFirstAid);
        valSurvival = findViewById(R.id.valSurvival);
        valLockPicking = findViewById(R.id.valLockPicking);
        valSleightOfHand = findViewById(R.id.valSleightOfHand);
        valHorseRiding = findViewById(R.id.valHorseRiding);
        valLocksmith = findViewById(R.id.valLocksmith);
        valFirearms = findViewById(R.id.valFirearms);
        valStealth = findViewById(R.id.valStealth);
        valThrowable = findViewById(R.id.valThrowable);
        valPerception = findViewById(R.id.valPerception);
        valCraft = findViewById(R.id.valCraft);
        valDiplomacy = findViewById(R.id.valDiplomacy);
        valIntimidation = findViewById(R.id.valIntimidation);
        valStreetWise = findViewById(R.id.valStreetWise);
        valNegotiation = findViewById(R.id.valNegotiation);
        valDeception = findViewById(R.id.valDeception);
        valAction = findViewById(R.id.valAction);
        valFlirt = findViewById(R.id.valFlirt);
        physicalAttributesEditText = findViewById(R.id.physicalAttributesEditText);
        dexterityAttributesEditText = findViewById(R.id.dexterityAttributesEditText);
        mentalAttributesEditText = findViewById(R.id.mentalAttributesEditText);
        socialAttributesEditText = findViewById(R.id.socialAttributesEditText);

        modMeleeWeapons = findViewById(R.id.modMeleeWeapons);
        modBrawl = findViewById(R.id.modBrawl);
        modImposition = findViewById(R.id.modImposition);
        modAthletics = findViewById(R.id.modAthletics);
        modRange = findViewById(R.id.modRange);
        modMath = findViewById(R.id.modMath);
        modForgery = findViewById(R.id.modForgery);
        modAlchemy = findViewById(R.id.modAlchemy);
        modNaturalSciences = findViewById(R.id.modNaturalSciences);
        modPhiliology = findViewById(R.id.modPhiliology);
        modStrategy = findViewById(R.id.modStrategy);
        modEngineering = findViewById(R.id.modEngineering);
        modLaw = findViewById(R.id.modLaw);
        modAppraise = findViewById(R.id.modAppraise);
        modInvestigate = findViewById(R.id.modInvestigate);
        modMedicine = findViewById(R.id.modMedicine);
        modOccult = findViewById(R.id.modOccult);
        modPsychology = findViewById(R.id.modPsychology);
        modFirstAid = findViewById(R.id.modFirstAid);
        modSurvival = findViewById(R.id.modSurvival);
        modLockPicking = findViewById(R.id.modLockPicking);
        modSleightOfHand = findViewById(R.id.modSleightOfHand);
        modHorseRiding = findViewById(R.id.modHorseRiding);
        modLocksmith = findViewById(R.id.modLocksmith);
        modFirearms = findViewById(R.id.modFirearms);
        modStealth = findViewById(R.id.modStealth);
        modThrowable = findViewById(R.id.modThrowable);
        modPerception = findViewById(R.id.modPerception);
        modCraft = findViewById(R.id.modCraft);
        modDiplomacy = findViewById(R.id.modDiplomacy);
        modIntimidation = findViewById(R.id.modIntimidation);
        modStreetWise = findViewById(R.id.modStreetWise);
        modNegotiation = findViewById(R.id.modNegotiation);
        modDeception = findViewById(R.id.modDeception);
        modAction = findViewById(R.id.modAction);
        modFlirt = findViewById(R.id.modFlirt);

        instructionTextView = findViewById(R.id.instructionTextView);
        setupSkillValueTextWatchers();


        // Set onClickListener for the save butto
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.d("CharacterInfo", "SAVE BUTTON CLICKED");
                character.saveCharacterToJson(CreateCharacterActivity.this);
            }
        });



    }


    private void setupSkillValueTextWatchers() {
        // Creating a general TextWatcher for all EditText fields related to skills
        TextWatcher skillValueWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Before text is changed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // When text is being changed
            }

            @Override
            public void afterTextChanged(Editable s) {
                // After text has been changed
                updateCharacterFromInputs();
            }
        };

        characterNameEditText.addTextChangedListener(skillValueWatcher);
        characterAgeEditText.addTextChangedListener(skillValueWatcher);
        characterNameEditText.addTextChangedListener(skillValueWatcher);
        characterAgeEditText.addTextChangedListener(skillValueWatcher);
        physicalAttributesEditText.addTextChangedListener(skillValueWatcher);
        dexterityAttributesEditText.addTextChangedListener(skillValueWatcher);
        mentalAttributesEditText.addTextChangedListener(skillValueWatcher);
        socialAttributesEditText.addTextChangedListener(skillValueWatcher);


        // Assigning the TextWatcher to each EditText
        valMeleeWeapons.addTextChangedListener(skillValueWatcher);
        valBrawl.addTextChangedListener(skillValueWatcher);
        valImposition.addTextChangedListener(skillValueWatcher);
        valAthletics.addTextChangedListener(skillValueWatcher);
        valRange.addTextChangedListener(skillValueWatcher);
        valMath.addTextChangedListener(skillValueWatcher);
        valForgery.addTextChangedListener(skillValueWatcher);
        valAlchemy.addTextChangedListener(skillValueWatcher);
        valNaturalSciences.addTextChangedListener(skillValueWatcher);
        valPhiliology.addTextChangedListener(skillValueWatcher);
        valStrategy.addTextChangedListener(skillValueWatcher);
        valEngineering.addTextChangedListener(skillValueWatcher);
        valLaw.addTextChangedListener(skillValueWatcher);
        valAppraise.addTextChangedListener(skillValueWatcher);
        valInvestigate.addTextChangedListener(skillValueWatcher);
        valMedicine.addTextChangedListener(skillValueWatcher);
        valOccult.addTextChangedListener(skillValueWatcher);
        valPsychology.addTextChangedListener(skillValueWatcher);
        valFirstAid.addTextChangedListener(skillValueWatcher);
        valSurvival.addTextChangedListener(skillValueWatcher);
        valLockPicking.addTextChangedListener(skillValueWatcher);
        valSleightOfHand.addTextChangedListener(skillValueWatcher);
        valHorseRiding.addTextChangedListener(skillValueWatcher);
        valLocksmith.addTextChangedListener(skillValueWatcher);
        valFirearms.addTextChangedListener(skillValueWatcher);
        valStealth.addTextChangedListener(skillValueWatcher);
        valThrowable.addTextChangedListener(skillValueWatcher);
        valPerception.addTextChangedListener(skillValueWatcher);
        valCraft.addTextChangedListener(skillValueWatcher);
        valDiplomacy.addTextChangedListener(skillValueWatcher);
        valIntimidation.addTextChangedListener(skillValueWatcher);
        valStreetWise.addTextChangedListener(skillValueWatcher);
        valNegotiation.addTextChangedListener(skillValueWatcher);
        valDeception.addTextChangedListener(skillValueWatcher);
        valAction.addTextChangedListener(skillValueWatcher);
        valFlirt.addTextChangedListener(skillValueWatcher);

    }


    private void updateUiBasedOncharacterState() {

        int totalPhysicalSkillsPointsUsed = character.getMelleWeapons() + character.getBrawl() + character.getImposition() + character.getAthletics() + character.getRange();
        int totalDexteritySkillsPointsUsed = character.getLockPicking() + character.getSleightOfHand() + character.getHorseRiding() + character.getLocksmith() + character.getFirearms() + character.getStealth() + character.getThrowable() + character.getPerception() + character.getCraft();
        int totalMentalSkillsPointsUsed = character.getMath() + character.getForgery() + character.getAlchemy() + character.getNaturalSciences() + character.getPhiliology() + character.getStrategy() + character.getEngineering() + character.getLaw() + character.getAppraise() + character.getInvestigate() + character.getMedicine() + character.getOccult() + character.getPsychology() + character.getFirstAid() + character.getSurvival();

        String instruction = "Next step: ";

        // Check if name is entered
        if (character.getName() == null || character.getName().isEmpty()) {
            instruction += "Enter Name.";
        }
        // Check if age is entered and valid
        else if (character.getAge() <= 0) {
            instruction += "Enter a Valid Age.";
        }
        // Check if the sum of base attributes is less than or greater than 45
        else if ((character.getBaseValuePhys() + character.getBaseValueDex() + character.getBaseValueMent() + character.getBaseValueSoc()) != 45) {
            int totalAttributes = character.getBaseValuePhys() + character.getBaseValueDex() + character.getBaseValueMent() + character.getBaseValueSoc();
            if (totalAttributes < 45) {
                instruction += "Distribute " + (45 - totalAttributes) + " more points in attributes.";
            } else {
                instruction += "Remove " + (totalAttributes - 45) + " points from attributes.";
            }
        } else {
            // Assuming calculatePoints() method updates pp, dp, mp, sp based on age and base attributes
            character.calculatePoints();

            instruction = "Next step: ";

            // Physical Points Distribution
            if (totalPhysicalSkillsPointsUsed > character.getPp()) {
                instruction += "Remove " + (totalPhysicalSkillsPointsUsed - character.getPp()) + " Physical Points from physical skills.";
            } else if (totalPhysicalSkillsPointsUsed < character.getPp()) {
                instruction += "Distribute " + (character.getPp() - totalPhysicalSkillsPointsUsed) + " more Physical Points in physical skills.";
            } else {
                // Mental Points Distribution
                if (totalMentalSkillsPointsUsed > character.getMp()) {
                    instruction += "Remove " + (totalMentalSkillsPointsUsed - character.getMp()) + " Mental Points from mental skills.";
                } else if (totalMentalSkillsPointsUsed < character.getMp()) {
                    instruction += "Distribute " + (character.getMp() - totalMentalSkillsPointsUsed) + " more Mental Points in mental skills.";
                } else {
                    // Dexterity Points Distribution
                    if (totalDexteritySkillsPointsUsed > character.getDp()) {
                        instruction += "Remove " + (totalDexteritySkillsPointsUsed - character.getDp()) + " Dexterity Points from dexterity skills.";
                    } else if (totalDexteritySkillsPointsUsed < character.getDp()) {
                        instruction += "Distribute " + (character.getDp() - totalDexteritySkillsPointsUsed) + " more Dexterity Points in dexterity skills.";
                    } else {
                        // Social Points Distribution
                        int totalSocialSkillsPointsUsed = character.getDiplomacy() + character.getIntimidation() + character.getStreetWise() + character.getNegotiation() + character.getDeception() + character.getAction() + character.getFlirt();
                        if (totalSocialSkillsPointsUsed > character.getSp()) {
                            instruction += "Remove " + (totalSocialSkillsPointsUsed - character.getSp()) + " Social Points from social skills.";
                        } else if (totalSocialSkillsPointsUsed < character.getSp()) {
                            instruction += "Distribute " + (character.getSp() - totalSocialSkillsPointsUsed) + " more Social Points in social skills.";
                        } else {
                            // If all points are correctly distributed
                            instruction = "All points distributed. Review your character or press Save.";
                        }
                    }
                }
            }
        }
        instructionTextView.setText(instruction);
        setSkillValuesAndModifiers();
    }


    private void setSkillValuesAndModifiers() {
        // Physical Skills
        setSkillValueAndModifier(modMeleeWeapons, character.getMelleWeapons(), character.getModPhys());
        setSkillValueAndModifier(modBrawl, character.getBrawl(), character.getModPhys());
        setSkillValueAndModifier(modImposition, character.getImposition(), character.getModPhys());
        setSkillValueAndModifier(modAthletics, character.getAthletics(), character.getModPhys());
        setSkillValueAndModifier(modRange, character.getRange(), character.getModPhys());

        // Mental Skills
        setSkillValueAndModifier(modMath, character.getMath(), character.getModMent());
        setSkillValueAndModifier(modForgery, character.getForgery(), character.getModMent());
        setSkillValueAndModifier(modAlchemy, character.getAlchemy(), character.getModMent());
        setSkillValueAndModifier(modNaturalSciences, character.getNaturalSciences(), character.getModMent());
        setSkillValueAndModifier(modPhiliology, character.getPhiliology(), character.getModMent());
        setSkillValueAndModifier(modStrategy, character.getStrategy(), character.getModMent());
        setSkillValueAndModifier(modEngineering, character.getEngineering(), character.getModMent());
        setSkillValueAndModifier(modLaw, character.getLaw(), character.getModMent());
        setSkillValueAndModifier(modAppraise, character.getAppraise(), character.getModMent());
        setSkillValueAndModifier(modInvestigate, character.getInvestigate(), character.getModMent());
        setSkillValueAndModifier(modMedicine, character.getMedicine(), character.getModMent());
        setSkillValueAndModifier(modOccult, character.getOccult(), character.getModMent());
        setSkillValueAndModifier(modPsychology, character.getPsychology(), character.getModMent());
        setSkillValueAndModifier(modFirstAid, character.getFirstAid(), character.getModMent());
        setSkillValueAndModifier(modSurvival, character.getSurvival(), character.getModMent());

        // Dexterity Skills
        setSkillValueAndModifier(modLockPicking, character.getLockPicking(), character.getModDex());
        setSkillValueAndModifier(modSleightOfHand, character.getSleightOfHand(), character.getModDex());
        setSkillValueAndModifier(modHorseRiding, character.getHorseRiding(), character.getModDex());
        setSkillValueAndModifier(modLocksmith, character.getLocksmith(), character.getModDex());
        setSkillValueAndModifier(modFirearms, character.getFirearms(), character.getModDex());
        setSkillValueAndModifier(modStealth, character.getStealth(), character.getModDex());
        setSkillValueAndModifier(modThrowable, character.getThrowable(), character.getModDex());
        setSkillValueAndModifier(modPerception, character.getPerception(), character.getModDex());
        setSkillValueAndModifier(modCraft, character.getCraft(), character.getModDex());

        // Social Skills
        setSkillValueAndModifier(modDiplomacy, character.getDiplomacy(), character.getModSoc());
        setSkillValueAndModifier(modIntimidation, character.getIntimidation(), character.getModSoc());
        setSkillValueAndModifier(modStreetWise, character.getStreetWise(), character.getModSoc());
        setSkillValueAndModifier(modNegotiation, character.getNegotiation(), character.getModSoc());
        setSkillValueAndModifier(modDeception, character.getDeception(), character.getModSoc());
        setSkillValueAndModifier(modAction, character.getAction(), character.getModSoc());
        setSkillValueAndModifier(modFlirt, character.getFlirt(), character.getModSoc());
    }

    private void setSkillValueAndModifier(TextView modTextView, int skillValue, int attributeModifier) {

        modTextView.setText(String.valueOf(skillValue + attributeModifier));

    }

    private void updateCharacterFromInputs() {
        String name = characterNameEditText.getText().toString();
        character.setName(name.isEmpty() ? "" : name);

        try {
            int age = Integer.parseInt(characterAgeEditText.getText().toString());
            character.setAge(age);
        } catch (NumberFormatException e) {
            character.setAge(0); // Default to 0 if parsing fails
        }

        // Setting base attribute values
        character.setBaseValuePhys(parseEditTextToInt(physicalAttributesEditText));
        character.setBaseValueDex(parseEditTextToInt(dexterityAttributesEditText));
        character.setBaseValueMent(parseEditTextToInt(mentalAttributesEditText));
        character.setBaseValueSoc(parseEditTextToInt(socialAttributesEditText));

        // Update skill values based on the EditText inputs
        updateSkillValuesFromInputs();

        // Recalculate character's state based on the updated attributes
        character.calculateAttributeMod();
        character.calculatePoints();
        character.calculateHp();

        // Update UI based on the updated character state
        updateUiBasedOncharacterState();
    }

    private void updateSkillValuesFromInputs() {
        // Setting the skill values from the EditText inputs
        character.setMelleWeapons(parseEditTextToInt(valMeleeWeapons));
        character.setBrawl(parseEditTextToInt(valBrawl));
        character.setImposition(parseEditTextToInt(valImposition));
        character.setAthletics(parseEditTextToInt(valAthletics));
        character.setRange(parseEditTextToInt(valRange));
        character.setMath(parseEditTextToInt(valMath));
        character.setForgery(parseEditTextToInt(valForgery));
        character.setAlchemy(parseEditTextToInt(valAlchemy));
        character.setNaturalSciences(parseEditTextToInt(valNaturalSciences));
        character.setPhiliology(parseEditTextToInt(valPhiliology));
        character.setStrategy(parseEditTextToInt(valStrategy));
        character.setEngineering(parseEditTextToInt(valEngineering));
        character.setLaw(parseEditTextToInt(valLaw));
        character.setAppraise(parseEditTextToInt(valAppraise));
        character.setInvestigate(parseEditTextToInt(valInvestigate));
        character.setMedicine(parseEditTextToInt(valMedicine));
        character.setOccult(parseEditTextToInt(valOccult));
        character.setPsychology(parseEditTextToInt(valPsychology));
        character.setFirstAid(parseEditTextToInt(valFirstAid));
        character.setSurvival(parseEditTextToInt(valSurvival));
        character.setLockPicking(parseEditTextToInt(valLockPicking));
        character.setSleightOfHand(parseEditTextToInt(valSleightOfHand));
        character.setHorseRiding(parseEditTextToInt(valHorseRiding));
        character.setLocksmith(parseEditTextToInt(valLocksmith));
        character.setFirearms(parseEditTextToInt(valFirearms));
        character.setStealth(parseEditTextToInt(valStealth));
        character.setThrowable(parseEditTextToInt(valThrowable));
        character.setPerception(parseEditTextToInt(valPerception));
        character.setCraft(parseEditTextToInt(valCraft));
        character.setDiplomacy(parseEditTextToInt(valDiplomacy));
        character.setIntimidation(parseEditTextToInt(valIntimidation));
        character.setStreetWise(parseEditTextToInt(valStreetWise));
        character.setNegotiation(parseEditTextToInt(valNegotiation));
        character.setDeception(parseEditTextToInt(valDeception));
        character.setAction(parseEditTextToInt(valAction));
        character.setFlirt(parseEditTextToInt(valFlirt));
    }

    private int parseEditTextToInt(EditText editText) {
        try {
            return Integer.parseInt(editText.getText().toString());
        } catch (NumberFormatException e) {
            return 0; // Default to 0 if parsing fails
        }
    }
}
