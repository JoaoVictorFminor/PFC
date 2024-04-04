package com.example.tabletoptools;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;

import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DiceStatisticsActivity extends AppCompatActivity {
    private DiceStatistics diceStatistics;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_statistics);
        backButton = findViewById(R.id.backButton);

        // Initialize and load the dice statistics
        diceStatistics = new DiceStatistics();
        diceStatistics.readFromJson(this);

        // Display the statistics for all dice types
        updateIconsColor();
        displayStatistics();

        Button clearAllButton = findViewById(R.id.clearAllButton);
        clearAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear all statistics
                diceStatistics.clearAllStatistics();
                // Save the cleared statistics to JSON
                diceStatistics.writeToJson(DiceStatisticsActivity.this);
                // Refresh the UI to reflect the cleared statistics
                displayStatistics();
                // Optionally show a toast message confirming the clear action
                Toast.makeText(DiceStatisticsActivity.this, "All statistics cleared.", Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void displayStatistics() {
        // Displaying statistics for D4
        updateTextView(R.id.d4_total_rolls, "Total Rolls: " + diceStatistics.getTotalRolls(4));
        updateTextView(R.id.d4_average_result, "Average Result: " + diceStatistics.getAverageRoll(4));
        updateTextView(R.id.d4_max_rolls, "Max Value Rolls: " + diceStatistics.getMaxRolls(4));
        updateTextView(R.id.d4_min_rolls, "Min Value Rolls: " + diceStatistics.getMinRolls(4));

        // Displaying statistics for D6
        updateTextView(R.id.d6_total_rolls, "Total Rolls: " + diceStatistics.getTotalRolls(6));
        updateTextView(R.id.d6_average_result, "Average Result: " + diceStatistics.getAverageRoll(6));
        updateTextView(R.id.d6_max_rolls, "Max Value Rolls: " + diceStatistics.getMaxRolls(6));
        updateTextView(R.id.d6_min_rolls, "Min Value Rolls: " + diceStatistics.getMinRolls(6));

        // Displaying statistics for D8
        updateTextView(R.id.d8_total_rolls, "Total Rolls: " + diceStatistics.getTotalRolls(8));
        updateTextView(R.id.d8_average_result, "Average Result: " + diceStatistics.getAverageRoll(8));
        updateTextView(R.id.d8_max_rolls, "Max Value Rolls: " + diceStatistics.getMaxRolls(8));
        updateTextView(R.id.d8_min_rolls, "Min Value Rolls: " + diceStatistics.getMinRolls(8));

        // Displaying statistics for D12
        updateTextView(R.id.d12_total_rolls, "Total Rolls: " + diceStatistics.getTotalRolls(12));
        updateTextView(R.id.d12_average_result, "Average Result: " + diceStatistics.getAverageRoll(12));
        updateTextView(R.id.d12_max_rolls, "Max Value Rolls: " + diceStatistics.getMaxRolls(12));
        updateTextView(R.id.d12_min_rolls, "Min Value Rolls: " + diceStatistics.getMinRolls(12));

        // Displaying statistics for D20
        updateTextView(R.id.d20_total_rolls, "Total Rolls: " + diceStatistics.getTotalRolls(20));
        updateTextView(R.id.d20_average_result, "Average Result: " + diceStatistics.getAverageRoll(20));
        updateTextView(R.id.d20_max_rolls, "Max Value Rolls: " + diceStatistics.getMaxRolls(20));
        updateTextView(R.id.d20_min_rolls, "Min Value Rolls: " + diceStatistics.getMinRolls(20));

        // Displaying statistics for D100
        updateTextView(R.id.d100_total_rolls, "Total Rolls: " + diceStatistics.getTotalRolls(100));
        updateTextView(R.id.d100_average_result, "Average Result: " + diceStatistics.getAverageRoll(100));
        updateTextView(R.id.d100_max_rolls, "Max Value Rolls: " + diceStatistics.getMaxRolls(100));
        updateTextView(R.id.d100_min_rolls, "Min Value Rolls: " + diceStatistics.getMinRolls(100));

    }

    private void updateTextView(int textViewId, String text) {
        TextView textView = findViewById(textViewId);
        textView.setText(text);
    }

    private void updateIconsColor() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(android.R.attr.colorPrimary, typedValue, true); // Use a universally recognized attribute
        int color = typedValue.data;
        updateImageViewColor(R.id.backButton, R.drawable.backicon, color);
    }

    private void updateImageViewColor(int imageViewId, int drawableId, int color) {
        ImageView imageView = findViewById(imageViewId);
        if (imageView != null) {
            Drawable drawable = DrawableCompat.wrap(AppCompatResources.getDrawable(this, drawableId));
            DrawableCompat.setTint(drawable, color);
            imageView.setImageDrawable(drawable);
        }
    }
}