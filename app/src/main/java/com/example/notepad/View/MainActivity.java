// This is MVP architecture.

package com.example.notepad.View;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.notepad.Models.EditorContract;
import com.example.notepad.Models.FileManager;
import com.example.notepad.Models.MainContract;
import com.example.notepad.Models.Note;
import com.example.notepad.Presenter.Navigator;
import com.example.notepad.Presenter.MainPresenter;
import com.example.notepad.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;

// This main page shows all saved notes list and it is selectable
public class MainActivity extends AppCompatActivity implements MainContract.View, EditorContract.View {
    MainContract.Presenter mainPresenter;
    FloatingActionButton createNewNoteButton;
    ListView notesListView;
    FileManager fileManager;
    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileManager = new FileManager(this);
        navigator = new Navigator(this);
        mainPresenter = new MainPresenter(fileManager, this, navigator);
        notesListView = findViewById(R.id.notesListView);

        createNewNoteButton = (FloatingActionButton) findViewById(R.id.btn_fa_create_new);

        mainPresenter.onViewCreated();

        createNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here you can create a new note", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mainPresenter.onCreateNewNoteButtonClicked();
            }
        });

        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note selectedNote = (Note) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                intent.putExtra("NoteTitle", selectedNote.getTitle());
                intent.putExtra("NoteContent", selectedNote.getContent());
                startActivity(intent);
            }
        });
    }

    @Override
    public void displayNotes(List<Note> notes) {
        NoteAdapter adapter = new NoteAdapter(this,notes);
        notesListView.setAdapter(adapter);
    }

    @Override
    public String getTitleInputText() {
        return null;
    }

    @Override
    public String getContentInputText() {
        return null;
    }

    @Override
    public String getSelectedNoteTitle() {
        return null;
    }
}