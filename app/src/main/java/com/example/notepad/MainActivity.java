package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Collections;
import java.util.List;

// main page, It shows all saved notes lists and it is selectable
public class MainActivity extends AppCompatActivity implements MainContract.View, EditorContract.View {

    MainContract.Presenter mainPresenter;
    EditorContract.Presenter editorPresenter;

    EditText editTextInput;
    Button deleteInput;
    ListView notePadListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FileManager fileManager = new FileManager(this);

        mainPresenter = new MainPresenter(fileManager, this, new Navigator(this));
        editorPresenter = new EditorPresenter(fileManager, this);

        notePadListView = findViewById(R.id.notePadListView);
        //Todo: create a button that create a new file/note and make a method to save it in local storage


        mainPresenter.onViewCreated();

        //editTextInput = findViewById(R.id.et_text);
        //deleteButtonInput = findViewById(R.id.btn_delete);

    }

    @Override
    public String getNote() {
        return null;
    }

    @Override
    public void displayNotes(List<Note> notes) {

        NoteAdapter adapter = new NoteAdapter(this,notes);
        notePadListView.setAdapter(adapter);
    }
}