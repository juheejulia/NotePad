package com.example.notepad.Models;

public class Note {

    private String title;
    private String content;
    private int date;

    public Note(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return content;
    }
}
