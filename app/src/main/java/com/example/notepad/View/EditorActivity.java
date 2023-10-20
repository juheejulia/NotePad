package com.example.notepad.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.notepad.Models.EditorContract;
import com.example.notepad.Models.FileManager;
import com.example.notepad.Presenter.EditorPresenter;
import com.example.notepad.Presenter.Navigator;
import com.example.notepad.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

// This editor page viewed new/the selected note to edit and save it.
public class EditorActivity extends AppCompatActivity implements EditorContract.View {

    EditorContract.Presenter presenter;

    Button saveButton, cancelBackButton;
    EditText titleInputText, categoryInputText, contentInputText;
    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        presenter = new EditorPresenter(new FileManager(this), this, navigator);

        titleInputText = findViewById(R.id.titleText);
        categoryInputText = findViewById(R.id.categoryText);
        contentInputText = findViewById(R.id.contentText);
        cancelBackButton = findViewById(R.id.btn_cancel_back);
        saveButton = findViewById(R.id.btn_save);

        cancelBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            navigator.navigateToMainActivity();
            }
        });
    }

    @Override
    public String getNote() {
        return null;
    }
}