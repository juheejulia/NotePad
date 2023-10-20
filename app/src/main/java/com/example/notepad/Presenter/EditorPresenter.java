package com.example.notepad.Presenter;

import com.example.notepad.Models.EditorContract;
import com.example.notepad.Models.FileManager;
import com.example.notepad.Models.Note;

import java.util.List;

public class EditorPresenter implements EditorContract.Presenter {

    FileManager fileManager;
    EditorContract.View view;
    Navigator navigator;

    public EditorPresenter(FileManager fileManager, EditorContract.View view) {
        this.fileManager = fileManager;
        this.view = view;
    }

    @Override
    public void onSaveButtonClicked() {
        List<Note> note = fileManager.getNotes();
    }
}
