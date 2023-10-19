package com.example.notepad.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.notepad.Models.Note;
import com.example.notepad.R;

import java.util.List;

public class NoteAdapter extends ArrayAdapter<Note> {
    public NoteAdapter(Context context, List notes) {
        super(context, 0, notes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //create View object from our new layout .xml
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.listitem_content, parent, false);
        }

        // call user object from out list
        Note note = getItem(position);

        //update our ViewObject with data from our list-object
        TextView tv = view.findViewById(R.id.textTitleCardView);
        tv.setText(note.getTitle());

        return view;
    }
}
