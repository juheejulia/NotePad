package com.example.notepad.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

// main page, It shows all saved notes lists and it is selectable
public class MainActivity extends AppCompatActivity implements MainContract.View, EditorContract.View {

    MainContract.Presenter mainPresenter;
    EditorContract.Presenter editorPresenter;

    Button mapNavigationButton;
    FloatingActionButton createNewNoteButton;
    ListView notesListView;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FileManager fileManager = new FileManager(this);

        mainPresenter = new MainPresenter(fileManager, this, new Navigator(this));
        editorPresenter = new EditorPresenter(fileManager, this);

        notesListView = findViewById(R.id.notesListView);
        createNewNoteButton = (FloatingActionButton) findViewById(R.id.btn_fa_create_new);

        // create a new note on clicking add floating action button
        createNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here you can create new note", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });
        //Todo: create a button that create a new file/note and make a method to save it in local storage
        mainPresenter.onViewCreated();
    }

    @Override
    public String getNote() {
        return null;
    }

    @Override
    public void displayNotes(List<Note> notes) {

        NoteAdapter adapter = new NoteAdapter(this,notes);
        notesListView.setAdapter(adapter);
    }
}