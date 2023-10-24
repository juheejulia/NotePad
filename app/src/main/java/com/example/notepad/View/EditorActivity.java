package com.example.notepad.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.notepad.Models.EditorContract;
import com.example.notepad.Models.FileManager;
import com.example.notepad.Models.Note;
import com.example.notepad.Presenter.EditorPresenter;
import com.example.notepad.Presenter.Navigator;
import com.example.notepad.R;

import java.util.ArrayList;

// This editor page viewed new/the selected note to edit and save it.
public class EditorActivity extends AppCompatActivity implements EditorContract.View {

    EditorContract.Presenter presenter;
    FileManager fileManager;
    ImageButton cancelBackButton, saveButton, deleteButton;;
    EditText titleInputText, categoryInputText, contentInputText;
    Navigator navigator;
    String selectedNoteTitle, selectedNoteContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        presenter = new EditorPresenter(new FileManager(this), this, navigator);
        fileManager = new FileManager(this);

        titleInputText = findViewById(R.id.titleText);
        categoryInputText = findViewById(R.id.categoryText);
        contentInputText = findViewById(R.id.contentText);
        cancelBackButton = findViewById(R.id.btn_cancel_back);
        saveButton = findViewById(R.id.btn_save);
        deleteButton = findViewById(R.id.btn_delete);

        // It gets extras from MainActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            selectedNoteTitle = extras.getString("NoteTitle");
            selectedNoteContent = extras.getString("NoteContent");
        }
        if (selectedNoteTitle != null) {
            titleInputText.setText(selectedNoteTitle);
            contentInputText.setText(selectedNoteContent);
        }
        //assert selectedNoteTitle != null;
        //Log.d("notTitle", selectedNoteTitle);

        cancelBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fileManager.saveNoteToFile(
                        titleInputText.getText().toString(),
                        contentInputText.getText().toString()
                );
                finish();
                navigator = new Navigator(view.getContext());
                navigator.navigateToMainActivity();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    selectedNoteTitle = extras.getString("NoteTitle");
                }
                fileManager.deleteFile(selectedNoteTitle);
                finish();
                navigator = new Navigator(view.getContext());
                navigator.navigateToMainActivity();
            }
        });
    }
}