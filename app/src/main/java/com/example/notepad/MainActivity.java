package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// main page, It shows all notes lists and it is selectable
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}