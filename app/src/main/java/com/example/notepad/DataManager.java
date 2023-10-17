package com.example.notepad;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static ArrayList<Note> notes = new ArrayList<>();

    public String createNote(String note) {
        Note notes = new Note(note);
        notes.add(note);
        return note;
    }

    public List<Note> getNote() {
        return notes;
    }
}
