package com.example.notepad;

import com.example.notepad.Models.Note;

import java.util.List;

public interface MainContract {

    interface View {
        void displayNotes(List<Note> notes);
    }

    interface Presenter {

        void onViewCreated();
    }
}

