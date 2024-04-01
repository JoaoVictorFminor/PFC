package com.example.tabletoptools;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
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

    @Override
    protected void onResume() {
        super.onResume();
        loadCharacters(); // Reload characters from JSON
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