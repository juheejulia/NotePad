package com.example.notepad;

public class EditorPresenter implements EditorContract.Presenter {

    DataManager dataManager;
    EditorContract.View view;
    Navigator navigator;

    public EditorPresenter(DataManager dataManager, EditorContract.View view) {
        this.dataManager = dataManager;
        this.view = view;
    }

    @Override
    public void onSaveButtonClicked() {
        String note = view.getNote();
    }
}
