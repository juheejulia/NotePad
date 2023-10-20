package com.example.notepad.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.notepad.Models.EditorContract;
import com.example.notepad.Models.FileManager;
import com.example.notepad.Models.Note;
import com.example.notepad.Presenter.EditorPresenter;
import com.example.notepad.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

// This editor page viewed new/the selected note to edit and save it.
public class EditorActivity extends AppCompatActivity implements EditorContract.View {

    EditorContract.Presenter presenter;

    Button saveButton, cancelBackButton;
    EditText titleInputText, categoryInputText, contentInputText;
    FileManager fileManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        presenter = new EditorPresenter(new FileManager(this), this);
        fileManager = new FileManager(this);

        titleInputText = findViewById(R.id.titleText);
        categoryInputText = findViewById(R.id.categoryText);
        contentInputText = findViewById(R.id.contentText);
        cancelBackButton = findViewById(R.id.btn_cancel_back);
        saveButton = findViewById(R.id.btn_save);


        cancelBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Canceled", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent intent = new Intent(EditorActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Saved", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                fileManager.saveNoteToFile(titleInputText.getText().toString(), contentInputText.getText().toString(), categoryInputText.getText().toString());

            }
        });
    }

    @Override
    public String getNote() {
        return null;
    }

}