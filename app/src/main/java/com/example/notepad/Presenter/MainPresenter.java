package com.example.notepad.Presenter;

import com.example.notepad.Models.FileManager;
import com.example.notepad.Models.MainContract;
import com.example.notepad.Models.Note;

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

    @Override
    public void onViewCreated() {
        List<Note> notes = fileManager.getNotesFromStorage();
        view.displayNotes(notes);
    }

    @Override
    public void onCreateNewNoteButtonClicked() {
        navigator.navigateToEditorActivity();
    }
}
