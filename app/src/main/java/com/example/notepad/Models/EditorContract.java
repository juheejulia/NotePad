package com.example.notepad.Models;

import android.widget.EditText;

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
