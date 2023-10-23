package com.example.notepad.Models;

import java.util.List;

public interface EditorContract {

    interface View {
    }

    interface Presenter {
        void onSaveButtonClicked();
    }
}
