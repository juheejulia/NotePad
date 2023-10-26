package com.example.notepad.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.example.notepad.Presenter.EditorContract;
import com.example.notepad.Models.FileManager;
import com.example.notepad.Presenter.EditorPresenter;
import com.example.notepad.Presenter.Navigator;
import com.example.notepad.R;

// This editor activity viewed new/selected note in order to edit and save it.
public class EditorActivity extends AppCompatActivity implements EditorContract.View {
    EditorContract.Presenter editorPresenter;
    FileManager fileManager;
    Navigator navigator;
    EditText titleInputText, contentInputText;
    ImageButton cancelBackButton, saveButton, deleteButton;;
    String selectedNoteTitle, selectedNoteContent;
    Bundle extras;

    public String getTitleInputText() {
        return titleInputText.getText().toString();
    }

    public String getContentInputText() {
        return contentInputText.getText().toString();
    }

    public String getSelectedNoteTitle() {
        return selectedNoteTitle;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        fileManager = new FileManager(this);
        navigator = new Navigator(this);
        editorPresenter = new EditorPresenter(fileManager, this, navigator);

        titleInputText = findViewById(R.id.titleText);
        contentInputText = findViewById(R.id.contentText);
        cancelBackButton = findViewById(R.id.btn_cancel_back);
        saveButton = findViewById(R.id.btn_save);
        deleteButton = findViewById(R.id.btn_delete);

        extras = getIntent().getExtras();
        getValuesFromExtras();

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

    private void getValuesFromExtras() {
        if (extras != null) {
            selectedNoteTitle = extras.getString("NoteTitle");
            selectedNoteContent = extras.getString("NoteContent");
        }
        if (selectedNoteTitle != null) {
            titleInputText.setText(selectedNoteTitle);
            contentInputText.setText(selectedNoteContent);
        }
    }
}