package com.example.tabletoptools;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CharacterSelectionActivity extends AppCompatActivity {

    private RecyclerView charactersRecyclerView;
    private CharactersAdapter adapter;
    private List<Character> characters;

    private ImageView backButton;
    private ImageView characterImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection);

        charactersRecyclerView = findViewById(R.id.charactersRecyclerView);
        characterImageButton = findViewById(R.id.characterImageButton);
        backButton = findViewById(R.id.backButton);


        // Initial setup of the RecyclerView
        charactersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        updateIconsColor();

        characterImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CharacterSelectionActivity.this, CreateCharacterActivity.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });




    }

    private void updateIconsColor() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(android.R.attr.colorPrimary, typedValue, true); // Use a universally recognized attribute
        int color = typedValue.data;

        updateImageViewColor(R.id.characterImageButton, R.drawable.plus, color); // Assuming plus is your add icon drawable
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

    @Override
    protected void onResume() {
        super.onResume();
        loadCharacters(); // Reload characters from JSON
        updateIconsColor();
        adapter = new CharactersAdapter(this, characters);
        charactersRecyclerView.setAdapter(adapter); // Refresh adapter
    }

    private void loadCharacters() {
        characters = new ArrayList<>();
        String folderName = "savedcharacter"; // Folder name where JSON files are stored
        File directory = new File(getFilesDir() + File.separator + folderName);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                Character character = new Character();
                character.readCharacterFromJson(this, file.getName().replace(".json", ""));
                characters.add(character);
            }
        }
    }
}