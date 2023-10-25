package com.example.notepad.Presenter;

import android.view.View;

import com.example.notepad.Models.FileManager;
import com.example.notepad.Models.MainContract;
import com.example.notepad.Models.Note;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    FileManager fileManager;
    MainContract.View view;
    Navigator navigator;

    public MainPresenter(FileManager fileManager, MainContract.View view, Navigator navigator) {
        this.fileManager = fileManager;
        this.view = view;
        this.navigator = navigator;
    }

    // The new created note which is added shall be displayed on the list view in MainActivity
    @Override
    public void onViewCreated() {
        List<Note> notes = fileManager.getNotesFromStorage();
        view.displayNotes(notes);
    }

    @Override
    public void onCreateNewNoteButtonClicked() {
        navigator.navigateToEditorActivity();
        //Intent intent = new Intent(MainActivity.this, EditorActivity.class);
        //startActivity(intent);
    }
}
