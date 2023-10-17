package com.example.notepad;

// note data
public class Note {

    private String title;
    private String content;

    // constructor, skapa instans av klassen
    public Note(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
