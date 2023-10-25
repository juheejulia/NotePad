package com.example.notepad.Models;

import android.widget.EditText;

public interface EditorContract {

    interface View {
        String getTitleInputText();

        String getContentInputText();
    }

    interface Presenter {
        void onSaveButtonClicked();
    }
}
