package com.example.notepad;

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
