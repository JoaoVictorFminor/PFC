package com.example.tabletoptools;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabletoptools.R;

import java.util.List;


public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.ViewHolder> {
    private int selectedPosition = -1;
    private List<Character> characters;
    private LayoutInflater inflater;
    private Context context; // Add this to store the context

    public CharactersAdapter(Context context, List<Character> characters) {
        this.inflater = LayoutInflater.from(context);
        this.characters = characters;
        this.context = context; // Initialize the context

        // Initialize selectedPosition based on the global variable
        String selectedCharacterName = ((GlobalVariables) context.getApplicationContext()).getSharedText();
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).getName().equals(selectedCharacterName)) {
                selectedPosition = i;
                break; // Exit loop once the selected character is found
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.character_selection_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Character character = characters.get(position);
        holder.nameTextView.setText(character.getName());

        // Change color if this character is selected
        if (selectedPosition == position) {
            holder.nameTextView.setTextColor(Color.GREEN); // Selected character's name in green
        } else {
            holder.nameTextView.setTextColor(Color.BLACK); // Other characters' names in black
        }

        // Update the selected position and global variable when the star icon is clicked
        holder.starIconImageView.setOnClickListener(v -> {
            GlobalVariables globalVariables = (GlobalVariables) context.getApplicationContext();
            globalVariables.setSharedText(character.getName());

            // Show toast message for new main character selection
            Toast.makeText(context, "New Main Character Selected", Toast.LENGTH_SHORT).show();

            int previousSelectedPosition = selectedPosition;
            selectedPosition = position;

            // Notify changes to refresh colors and selection indication
            notifyItemChanged(previousSelectedPosition);
            notifyItemChanged(selectedPosition);
        });

        holder.binIconImageView.setOnClickListener(v -> {
            // Create an AlertDialog.Builder with the current context
            new AlertDialog.Builder(context)
                    .setTitle("Delete Character") // Set the title of the dialog
                    .setMessage("Are you sure you want to delete this character?") // Set the message to display
                    .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                        // Positive button was clicked/tapped
                        character.deleteCharacterJson(context, character.getName());
                        characters.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, characters.size());

                        // If the deleted character was the selected one, reset selectedPosition
                        if (selectedPosition == position) {
                            selectedPosition = -1; // Reset selected position as no character is selected
                        } else if (selectedPosition > position) {
                            // Adjust for the shift in positions due to the deletion
                            selectedPosition -= 1;
                        }

                        Toast.makeText(context, "Character deleted", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton(android.R.string.no, null) // Null listener represents clicking will dismiss the dialog
                    .setIcon(android.R.drawable.ic_dialog_alert) // Set an icon for the dialog
                    .show(); // Display the AlertDialog
        });
    }


    @Override
    public int getItemCount() {
        return characters.size();
    }

    // Other code remains unchanged

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        ImageView starIconImageView, binIconImageView; // Include reference to bin icon

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.characterNameTextView);
            starIconImageView = itemView.findViewById(R.id.starIconImageView);
            binIconImageView = itemView.findViewById(R.id.binIconImageView); // Initialize the bin icon
        }

    }
}