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

    // The new created note which is added shall be displayed on the list view in MainActivity
    @Override
    public void onViewCreated() {
        List<Note> notes = fileManager.getNotesFromStorage();
        view.displayNotes(notes);
    }
}
