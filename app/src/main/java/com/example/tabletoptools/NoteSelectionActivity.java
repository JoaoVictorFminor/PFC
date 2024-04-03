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

public class NoteSelectionActivity extends AppCompatActivity implements NotesAdapter.OnNoteClickListener {

    private RecyclerView notesRecyclerView;
    private NotesAdapter adapter;

    private ImageView backButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_selection);

        // ImageView for adding a new note
        ImageView addNoteImageView = findViewById(R.id.addNoteButton);
        backButton = findViewById(R.id.backButton);


        // Set up the RecyclerView
        notesRecyclerView = findViewById(R.id.notesRecyclerView);
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load existing notes and display them
        loadNotes();

        // Set an OnClickListener to open NoteActivity for creating a new note
        addNoteImageView.setOnClickListener(v -> {
            Intent intent = new Intent(NoteSelectionActivity.this, NoteActivity.class);
            startActivity(intent);
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onNoteClick(Note note) {
        // When a note is clicked, open NoteActivity for editing that note
        Intent intent = new Intent(this, NoteActivity.class);
        intent.putExtra("noteId", note.getId()); // Pass the note ID to identify which note to edit
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadNotes(); // Refresh the list of notes
    }

    private void loadNotes() {
        List<Note> notes = new ArrayList<>();
        String directoryPath = getFilesDir() + File.separator + "notes";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                // Assuming file names are the note IDs
                String noteId = file.getName().replace(".txt", "");
                String noteData = Note.readFromFile(directoryPath, noteId);
                if (noteData != null && !noteData.isEmpty()) {
                    // Assuming the first line is the title
                    String[] parts = noteData.split("\n\n", 2);
                    String title = parts[0].replaceFirst("Title: ", "");
                    String content = parts.length > 1 ? parts[1] : "";
                    notes.add(new Note(noteId, title, content));
                }
            }
        }

        adapter = new NotesAdapter(this, notes, this);
        notesRecyclerView.setAdapter(adapter);
    }
    }
