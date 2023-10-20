package com.example.notepad.Presenter;

import android.view.Display;
import com.example.notepad.Models.EditorContract;
import com.example.notepad.Models.FileManager;

import java.util.List;

public class EditorPresenter implements EditorContract.Presenter {

    FileManager fileManager;
    EditorContract.View view;
    Navigator navigator;
    Display display;

    public EditorPresenter(FileManager fileManager, EditorContract.View view, Navigator navigator) {
        this.fileManager = fileManager;
        this.view = view;
        this.navigator = navigator;
    }

    @Override
    public void onSaveButtonClicked() {

    }
}
