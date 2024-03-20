package com.example.tabletoptools;
import android.os.Bundle;
import android.os.Handler;
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






}