package com.example.notepad.Models;

import android.content.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// It reads local storage and builds note objects
public class FileManager {
    Context context;
    private static ArrayList<Note> notes = new ArrayList<>();

    public FileManager(Context context) {
        //String[] array;
        this.context = context;
    }

    public Note createNote(String title, String category, String content) {
        //Todo: create a file in local storage

        saveNoteToFile(title, category, content);
        Note note = new Note(title);
        note.setContent(content);
        notes.add(note);
        return note;
    }

    public void saveNoteToFile(String fileName, String noteToSave, String category) {
        if (!noteToSave.isEmpty()) {
            File folder = new File(context.getFilesDir(), "MyNoteFile");
            if (!folder.exists()) {
                folder.mkdir();
            }

            File noteFile = new File(folder, fileName + ".txt");

            try {
                PrintWriter writer =
                        new PrintWriter(new BufferedWriter(new FileWriter(noteFile, true)));
                writer.append(noteToSave);
                writer.flush();
                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String loadFromFile() {
        try {
            File readFile = new File(context.getFilesDir(), "/MyNoteFile/MyNewFile.txt");
            Scanner scanner = new Scanner(readFile);
            String s = scanner.nextLine();
            return s;
        } catch (FileNotFoundException e) {
            throw new RuntimeException (e);
        }
    }

    public List<Note> getNotes() {
        createNote("MyNewFile", "Food", "This is the content of the file");
        createNote("MyNewFile2", "School","This is the content of the file 2");
        createNote("MyNewFile3", "Work", "This is the content of the file 3");
        createNote("MyNewFile4", "Food", "This is the content of the file 4");
        createNote("MyNewFile5", "School", "This is the content of the file 5");
        createNote("MyNewFile6", "School", "This is the content of the file 6");
        createNote("MyNewFile7", "Work", "This is the content of the file 7");
        return notes;
    }

}
