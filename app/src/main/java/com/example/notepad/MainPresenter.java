package com.example.notepad;

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

        List<Note> notes = fileManager.getNotes();
        //Log.d("onViewCreated", String.valueOf(notes.get(0).getTitle()));
        view.displayNotes(notes);

    }
}
