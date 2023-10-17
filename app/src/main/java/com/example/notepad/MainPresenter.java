package com.example.notepad;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    DataManager dataManager;
    MainContract.View view;
    Navigator navigator;

    public MainPresenter(DataManager dataManager, MainContract.View view, Navigator navigator) {
        this.dataManager = dataManager;
        this.view = view;
        this.navigator = navigator;
    }

    @Override
    public void onViewCreated() {
        List<Note> notes = dataManager.getNote();
        view.displayNotes(notes);

    }
}
