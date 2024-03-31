package com.example.tabletoptools;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class GlobalVariables extends Application {
    private static final String PREFS_NAME = "GlobalVariablesPrefs";
    private static final String SHARED_TEXT_KEY = "CharacterNameKey";

    public String getSharedText() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        // Return the saved value or "Initial Value" if nothing is saved
        return prefs.getString(SHARED_TEXT_KEY, "Jacques Armand");
    }

    public void setSharedText(String sharedText) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(SHARED_TEXT_KEY, sharedText);
        editor.apply(); // Apply changes asynchronously
    }
}