package com.example.notepad;

import java.util.ArrayList;
import java.util.List;

// It reads local storage and builds note objects
public class FileManager {
    private static ArrayList<Note> notes = new ArrayList<>();

    public Note createNote(String title) {
        //Todo: create a file in local storage
        String content = "This is the content of the note";
        Note note = new Note(title);
        note.setContent(content);
        notes.add(note);
        return note;
    }

    public List<Note> getNotes() {
        createNote("Helloworld");
        return notes;
    }
}
