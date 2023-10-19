package com.example.notepad.Presenter;

import com.example.notepad.Models.EditorContract;
import com.example.notepad.Models.FileManager;

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
        String note = view.getNote();
    }
}