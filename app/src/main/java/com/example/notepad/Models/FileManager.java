package com.example.notepad.Models;

import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// It reads local storage and builds note objects
public class FileManager {
    //Class/property(egenskap hos en klass)
    // Type variable
    Context context;
    //declare variable with default value
    //cannot call notes outside of this class
    private static ArrayList<Note> notes = new ArrayList<>();

    // constructor
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
        notes.clear(); // Clean array list before populating from storage.
        // Create file manage class
        // Deklarera nytt variabel och sett nytt objekt.
        File path = new File(context.getFilesDir(),"MyNoteFile");
        if (!path.exists()) {
            path.mkdir();
        }
        // lista alla filer i mappen "MyNoteFile"
        File[] list = path.listFiles();
        for (File file : list) {
            //bygga alla rader till en string
            StringBuilder content = new StringBuilder();
            try {
                Scanner scanner = new Scanner(file);
                // så länge scanner se en ny rad i filen loopa, läsa
                while (scanner.hasNextLine()) {
                    // lägg till nästa rad i content
                    content.append(scanner.nextLine());
                    content.append(System.lineSeparator());
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException (e);
            }
            // I use fileName as title so remove file ending
            String noteTitle = file.getName().replace(".txt", "");
            //Model class, skapa nytt objekt av klassen, Note
            Note note = new Note(noteTitle);
            note.setContent(content.toString());
            notes.add(note);
        }
        return notes;
    }
}
