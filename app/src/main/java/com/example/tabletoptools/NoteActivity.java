package com.example.tabletoptools;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class NoteActivity extends AppCompatActivity {

    private EditText noteTitle;
    private EditText noteContent;

    private ImageView backButton;
    private String noteId = "uniqueNoteId"; // Example ID, in a real app this could be dynamic

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        noteTitle = findViewById(R.id.noteTitle);
        noteContent = findViewById(R.id.noteContent);
        backButton = findViewById(R.id.backButton);

        // Check if a noteId was passed in the intent, if not generate a new one
        noteId = getIntent().getStringExtra("noteId");
        if (noteId == null) {
            // Generate a new unique noteId, e.g., based on the current timestamp
            noteId = "note_" + System.currentTimeMillis();
        } else {
            // Existing noteId provided, load the note
            loadNote();
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveNote();
    }

    private void saveNote() {
        String title = noteTitle.getText().toString();
        String content = noteContent.getText().toString();
        Note note = new Note(noteId, title, content);

        // Saving the note to the app's internal storage
        note.saveToFile(getFilesDir() + File.separator + "notes");
    }

    private void loadNote() {
        // Reading the note from the app's internal storage
        String noteData = Note.readFromFile(getFilesDir() + File.separator + "notes", noteId);
        if (noteData != null && !noteData.isEmpty()) {
            // Assuming the first line is the title and the rest is the content
            String[] parts = noteData.split("\n\n", 2);
            String title = parts.length > 0 ? parts[0].replaceFirst("Title: ", "") : "";
            String content = parts.length > 1 ? parts[1] : "";
            noteTitle.setText(title);
            noteContent.setText(content);
        }
    }
}