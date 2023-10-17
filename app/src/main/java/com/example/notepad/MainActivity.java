package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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

        mainPresenter = new MainPresenter(new DataManager(), this, new Navigator(this));
        editorPresenter = new EditorPresenter(new DataManager(), this);

        notePadListView = findViewById(R.id.notePadListView);

        //editTextInput = findViewById(R.id.et_text);
        //deleteButtonInput = findViewById(R.id.btn_delete);

    }

    @Override
    public String getNote() {
        return null;
    }

    @Override
    public void displayNotes(List<Note> notes) {

    }
}