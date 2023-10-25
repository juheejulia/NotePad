package com.example.notepad.Models;

import android.widget.EditText;

public interface EditorContract {

    interface View {
    }

    interface Presenter {
        void onSaveButtonClicked(EditText titleInputText, EditText contentInputText);
    }
}
