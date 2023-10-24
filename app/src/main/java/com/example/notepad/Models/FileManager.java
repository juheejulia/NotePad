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

    public Note createNote(String title, String content) {
        Note note = new Note(title);
        note.setContent(content);
        return note;
    }

    public void saveNoteToFile(String fileName, String content) {
        if (!content.isEmpty()) {
            File folder = new File(context.getFilesDir(), "MyNoteFile");
            if (!folder.exists()) {
                folder.mkdir();
            }

            File noteFile = new File(folder, fileName + ".txt");

            try {
                FileWriter writer = new FileWriter(noteFile, false);
                writer.write(content);
                //writer.flush();
                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void deleteFile(String fileName) {
        try {
            File file = new File(context.getFilesDir(), "/MyNoteFile/" + fileName + ".txt");
            file.delete();
            notes.clear();
        } catch (SecurityException e) {
            throw new RuntimeException (e);
        }
    }

    // Saved note shows on the list view
    public List<Note> getNotes() {
        File path = new File(context.getFilesDir(),"MyNoteFile");
        if (!path.exists()) {
            path.mkdir();
        }
        File[] list = path.listFiles();
        for (File file : list) {
            String line = "";
            try {
                Scanner scanner = new Scanner(file);
                line = scanner.nextLine();
            } catch (FileNotFoundException e) {
                throw new RuntimeException (e);
            }
            String noteTitle = file.getName().replace(".txt", "");
            Note note = createNote(noteTitle, line); //line
            notes.add(note);
        }
        return notes;
    }
}
