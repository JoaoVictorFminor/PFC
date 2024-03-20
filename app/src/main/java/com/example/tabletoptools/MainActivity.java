package com.example.tabletoptools;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private ConstraintLayout bannerConstraintLayout;
    private ConstraintLayout diceConstraintLayout;
    private ImageView profileImageButton;
    private ImageView characterImageButton;
    private TextView diceDisplay;
    private Button buttonD4;
    private Button buttonD6;
    private Button buttonD8;
    private Button buttonD12;
    private Button buttonD20;
    private Button buttonD100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Character character = printCharacterInfo();


        // Initialize the ConstraintLayouts
        bannerConstraintLayout = findViewById(R.id.bannerConstraintLayout);
        diceConstraintLayout = findViewById(R.id.diceConstraintLayout);

        // Initialize the ImageViews
        profileImageButton = findViewById(R.id.profileImageButton);
        characterImageButton = findViewById(R.id.characterImageButton);

        // Initialize the TextView
        diceDisplay = findViewById(R.id.diceDisplay);

        // Initialize the Buttons
        buttonD4 = findViewById(R.id.buttonD4);
        buttonD6 = findViewById(R.id.buttonD6);
        buttonD8 = findViewById(R.id.buttonD8);
        buttonD12 = findViewById(R.id.buttonD12);
        buttonD20 = findViewById(R.id.buttonD20);
        buttonD100 = findViewById(R.id.buttonD100);

        // Set click listeners for each button



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


    private static Character printCharacterInfo() {
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

        return character;
    }




}