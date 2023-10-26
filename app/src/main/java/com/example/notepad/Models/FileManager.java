package com.example.notepad.Models;

import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// It reads local storage and builds note objects
public class FileManager {
    Context context;
    private static ArrayList<Note> notes = new ArrayList<>();

    public FileManager(Context context) {
        this.context = context;
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

    // Read all notes from local storage and add to notes array list.
    public List<Note> getNotesFromStorage() {
        notes.clear();
        File path = new File(context.getFilesDir(),"MyNoteFile");
        if (!path.exists()) {
            path.mkdir();
        }
        File[] list = path.listFiles();
        for (File file : list) {
            StringBuilder content = new StringBuilder();
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    content.append(scanner.nextLine());
                    content.append(System.lineSeparator());
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException (e);
            }
            String noteTitle = file.getName().replace(".txt", "");
            long lastmodified = file.lastModified();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Note note = new Note(noteTitle);
            note.setContent(content.toString());
            note.setDate(dateFormat.format(lastmodified));
            notes.add(note);
        }
        return notes;
    }
}
