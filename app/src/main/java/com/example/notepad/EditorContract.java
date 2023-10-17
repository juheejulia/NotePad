package com.example.notepad;

import java.util.List;

public interface EditorContract {

    interface View {
        String getNote();
    }

    interface Presenter {
        void onSaveButtonClicked();
    }
}
