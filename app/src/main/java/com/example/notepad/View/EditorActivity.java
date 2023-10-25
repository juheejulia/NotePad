package com.example.notepad.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.example.notepad.Models.EditorContract;
import com.example.notepad.Models.FileManager;
import com.example.notepad.Presenter.EditorPresenter;
import com.example.notepad.Presenter.Navigator;
import com.example.notepad.R;

// This editor page viewed new/the selected note to edit and save it.
public class EditorActivity extends AppCompatActivity implements EditorContract.View {

    EditorContract.Presenter editorPresenter;
    FileManager fileManager;
    ImageButton cancelBackButton, saveButton, deleteButton;;
    EditText titleInputText, categoryInputText, contentInputText;
    Navigator navigator;
    String selectedNoteTitle, selectedNoteContent;

    public String getTitleInputText() {
        return titleInputText.getText().toString();
    }

    public String getContentInputText() {
        return contentInputText.getText().toString();
    }

    public String getSelectedNoteTitle() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            selectedNoteTitle = extras.getString("NoteTitle");
        }
        return selectedNoteTitle;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        navigator = new Navigator(this);
        editorPresenter = new EditorPresenter(new FileManager(this), this, navigator);
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

        cancelBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editorPresenter.onSaveButtonClicked();
                finish();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editorPresenter.onDeleteButtonClicked();
                finish();
            }
        });
    }
}