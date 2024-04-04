package com.example.tabletoptools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private List<Note> notes;
    private LayoutInflater inflater;
    private Context context; // Add this to store context
    private OnNoteClickListener noteClickListener;

    // Update constructor to also store context
    public NotesAdapter(Context context, List<Note> notes, OnNoteClickListener listener) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.notes = notes;
        this.noteClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.note_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.noteTitleTextView.setText(note.getTitle());

        // Resolve the color attribute directly within the adapter context
        TypedValue typedValue = new TypedValue();
        holder.itemView.getContext().getTheme().resolveAttribute(android.R.attr.colorPrimary, typedValue, true);
        int color = typedValue.data;

        // Correctly access the drawable and set its tint
        Drawable drawable = DrawableCompat.wrap(AppCompatResources.getDrawable(holder.itemView.getContext(), R.drawable.bin));
        DrawableCompat.setTint(drawable, color);
        holder.binIconImageView.setImageDrawable(drawable);

        // Set the click listener for the itemView
        holder.itemView.setOnClickListener(view -> {
            if (noteClickListener != null) {
                noteClickListener.onNoteClick(note);
            }
        });

        // Set the click listener for the bin icon to handle note deletion
        holder.binIconImageView.setOnClickListener(view -> {
            // Here you might want to show a confirmation dialog before deletion
            deleteNote(note, position);
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView noteTitleTextView;
        ImageView binIconImageView;

        ViewHolder(View itemView) {
            super(itemView);
            noteTitleTextView = itemView.findViewById(R.id.noteTitleTextView);
            binIconImageView = itemView.findViewById(R.id.binIconImageView);
        }
    }
    public interface OnNoteClickListener {
        void onNoteClick(Note note);
    }

    private void deleteNote(Note note, int position) {
        // Delete the note from persistent storage if applicable
        File file = new File(context.getFilesDir() + File.separator + "notes" + File.separator + note.getId() + ".txt");
        if (file.delete()) {
            // Remove the note from the list and notify adapter
            notes.remove(position);
            notifyItemRemoved(position);
        } else {
            // Handle the case where the note could not be deleted
        }
    }



}