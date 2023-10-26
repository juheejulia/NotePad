package com.example.notepad.Presenter;

import com.example.notepad.Models.FileManager;

public class EditorPresenter implements EditorContract.Presenter {
    FileManager fileManager;
    EditorContract.View view;
    Navigator navigator;

    public EditorPresenter(FileManager fileManager, EditorContract.View view, Navigator navigator) {
        this.fileManager = fileManager;
        this.view = view;
        this.navigator = navigator;
    }

    @Override
    public void onSaveButtonClicked() {
        fileManager.saveNoteToFile(view.getTitleInputText(), view.getContentInputText());
        navigator.navigateToMainActivity();
    }

    @Override
    public void onDeleteButtonClicked() {
        fileManager.deleteFile(view.getSelectedNoteTitle());
        navigator.navigateToMainActivity();
    }
}
