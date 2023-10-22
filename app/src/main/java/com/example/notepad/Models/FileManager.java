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
        //Todo: create a file in local storage
        //saveNoteToFile(title, content);
        Note note = new Note(title);
        note.setContent(content);
        //notes.add(note);
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
                PrintWriter writer =
                        new PrintWriter(new BufferedWriter(new FileWriter(noteFile, true)));
                writer.append(content);
                writer.flush();
                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Note getNoteFromFile(String fileName) {
        String content = "";
        try {
            File readFile = new File(context.getFilesDir(), "/MyNoteFile/" + fileName);
            Scanner scanner = new Scanner(readFile);
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                content = String.valueOf(stringBuilder.append(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException (e);
        }
        return createNote(fileName, content);
    }

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
            Note note = createNote(file.getName(), line); //line
            notes.add(note);
        }
        return notes;
    }


}
