package com.example.tabletoptools;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabletoptools.R;

import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.ViewHolder> {

    private List<Character> characters;
    private LayoutInflater inflater;
    private Context context; // Add this to store the context

    public CharactersAdapter(Context context, List<Character> characters) {
        this.inflater = LayoutInflater.from(context);
        this.characters = characters;
        this.context = context; // Initialize the context
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.character_selection_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Character character = characters.get(position);
        holder.nameTextView.setText(character.getName());
        // Handle star icon click
        holder.starIconImageView.setOnClickListener(v -> {
            // Update the global variable with this character's name
            GlobalVariables globalVariables = (GlobalVariables) context.getApplicationContext();
            globalVariables.setSharedText(character.getName());
        });
        // Set other attributes as needed
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    // Other code remains unchanged

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView starIconImageView; // Add this

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.characterNameTextView);
            starIconImageView = itemView.findViewById(R.id.starIconImageView); // Initialize it
            // Initialize other views
        }
    }
}