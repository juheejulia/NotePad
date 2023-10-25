package com.example.notepad.Models;

public interface EditorContract {

    interface View {
        String getTitleInputText();

        String getContentInputText();

        String getSelectedNoteTitle();
    }

    interface Presenter {
        void onSaveButtonClicked();

        void onDeleteButtonClicked();
    }
}
