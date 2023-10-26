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

        View view = convertView;
        if(view == null){
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.listitem_content, parent, false);
        }

        Note note = getItem(position);

        //update our ViewObject with data from our list-object
        TextView title = view.findViewById(R.id.textTitleCardView);
        assert note != null;
        title.setText(note.getTitle());
        TextView content = view.findViewById(R.id.contentText);
        content.setText(note.getContent());

        return view;
    }
}
