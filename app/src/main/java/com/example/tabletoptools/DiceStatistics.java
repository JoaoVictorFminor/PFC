package com.example.tabletoptools;
import android.content.Context;
import org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class DiceStatistics {
    // A map to hold the total rolls and sum of rolls for each dice type.
    private Map<Integer, DiceStats> diceStatsMap;

    public DiceStatistics() {
        this.diceStatsMap = new HashMap<>();
        // Initialize statistics for commonly used dice.
        initializeDiceTypes();
    }

    private void initializeDiceTypes() {
        for (int diceType : new int[]{4, 6, 8, 10, 12, 20, 100}) {
            diceStatsMap.put(diceType, new DiceStats());
        }
    }

    // Update statistics for a specific dice roll.
    public void updateStatistics(int diceType, int roll) {
        DiceStats stats = diceStatsMap.getOrDefault(diceType, new DiceStats());
        stats.totalRolls++;
        stats.totalSum += roll;
        diceStatsMap.put(diceType, stats);
    }

    // Reads dice statistics from a JSON file.
    public void readFromJson(Context context) {
        try {
            File file = new File(context.getFilesDir(), "dice_statistics.json");
            if (!file.exists()) return; // File doesn't exist, nothing to load.

            FileInputStream fis = new FileInputStream(file);
            StringBuilder builder = new StringBuilder();
            int ch;
            while ((ch = fis.read()) != -1) {
                builder.append((char) ch);
            }
            fis.close();

            JSONObject jsonObject = new JSONObject(builder.toString());
            for (int diceType : diceStatsMap.keySet()) {
                String key = "D" + diceType;
                if (jsonObject.has(key)) {
                    JSONObject statsJson = jsonObject.getJSONObject(key);
                    DiceStats stats = new DiceStats();
                    stats.totalRolls = statsJson.optInt("totalRolls", 0);
                    stats.totalSum = statsJson.optInt("totalSum", 0);
                    diceStatsMap.put(diceType, stats);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Writes the current dice statistics to a JSON file.
    public void writeToJson(Context context) {
        try {
            File file = new File(context.getFilesDir(), "dice_statistics.json");
            JSONObject jsonObject = new JSONObject();

            for (Map.Entry<Integer, DiceStats> entry : diceStatsMap.entrySet()) {
                int diceType = entry.getKey();
                DiceStats stats = entry.getValue();
                JSONObject statsJson = new JSONObject();
                statsJson.put("totalRolls", stats.totalRolls);
                statsJson.put("totalSum", stats.totalSum);
                jsonObject.put("D" + diceType, statsJson);
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(jsonObject.toString().getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper class to store statistics for a single dice type.
    private static class DiceStats {
        int totalRolls;
        int totalSum;

        public DiceStats() {
            this.totalRolls = 0;
            this.totalSum = 0;
        }
    }

    public int getTotalRolls(int diceType) {
        if (diceStatsMap.containsKey(diceType)) {
            return diceStatsMap.get(diceType).totalRolls;
        }
        return 0;
    }

    // Get the average roll result for a specific dice type
    public double getAverageRoll(int diceType) {
        if (diceStatsMap.containsKey(diceType)) {
            DiceStats stats = diceStatsMap.get(diceType);
            return stats.totalRolls == 0 ? 0 : (double) stats.totalSum / stats.totalRolls;
        }
        return 0;
    }

    // Get the number of times the maximum roll was achieved for a specific dice type
    public int getMaxRolls(int diceType) {
        // This method's implementation depends on how you're tracking max rolls.
        // If you're not currently tracking max rolls directly, you might need to adjust your data model.
        // Placeholder implementation:
        return 0;
    }

    // Get the number of times the minimum roll was achieved for a specific dice type
    public int getMinRolls(int diceType) {
        // Similar to getMaxRolls, this depends on your tracking strategy.
        // Placeholder implementation:
        return 0;
    }

    public void clearAllStatistics() {
        // Iterate through all entries in the map and reset the statistics
        for (Map.Entry<Integer, DiceStats> entry : diceStatsMap.entrySet()) {
            DiceStats stats = entry.getValue();
            stats.totalRolls = 0;
            stats.totalSum = 0;
            // If you're tracking max and min rolls specifically, reset those values here as well
        }
    }
}