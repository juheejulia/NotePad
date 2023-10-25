// This is MVP architecture.

package com.example.notepad.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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
import com.example.notepad.Presenter.EditorPresenter;
import com.example.notepad.Presenter.MainPresenter;
import com.example.notepad.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;

// This main page shows all saved notes list and it is selectable
public class MainActivity extends AppCompatActivity implements MainContract.View, EditorContract.View {
    MainContract.Presenter mainPresenter;
    EditorContract.Presenter editorPresenter;
    FloatingActionButton createNewNoteButton;
    ListView notesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FileManager fileManager = new FileManager(this);

        mainPresenter = new MainPresenter(fileManager, this, new Navigator(this));
        editorPresenter = new EditorPresenter(fileManager, this, new Navigator(this));
        notesListView = findViewById(R.id.notesListView);
        createNewNoteButton = (FloatingActionButton) findViewById(R.id.btn_fa_create_new);

        // The new created note which is added shall be displayed on the list view in MainActivity
        mainPresenter.onViewCreated();

        // create a new note on clicking add floating action button
        createNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here you can create a new note", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        // The old note shall be opened on the EditorActivity to edit and re-save
        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note selectedNote = (Note) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                // lägga till key, value pare som jag kan hämta från intent
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