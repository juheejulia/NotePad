package com.example.notepad.Models;

public interface EditorContract {

    interface View {
    }

    interface Presenter {
        void onSaveButtonClicked();
    }
}
