package com.example.notepad.Presenter;

import android.util.Log;
import android.widget.EditText;
import com.example.notepad.Models.EditorContract;
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
}
