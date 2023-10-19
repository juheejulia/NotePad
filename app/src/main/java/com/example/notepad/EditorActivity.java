package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.notepad.Models.Note;

import java.util.List;

// page viewed the selected note and user can edit and save it it.
public class EditorActivity extends AppCompatActivity implements EditorContract.View, MainContract.View {

    EditorContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        presenter = new EditorPresenter(new FileManager(this), this);
    }

    @Override
    public String getNote() {
        return null;
    }

    @Override
    public void displayNotes(List<Note> notes) {

    }
}