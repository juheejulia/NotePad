package com.example.notepad.Presenter;

import android.content.Context;
import android.content.Intent;
import com.example.notepad.View.EditorActivity;
import com.example.notepad.View.MainActivity;

public class Navigator {
    private Context context;
    public Navigator(Context context) {
        this.context = context;
    }

    public void navigateToEditorActivity(){
        Intent intent = new Intent(context, EditorActivity.class);
        context.startActivity(intent);
    }

    public void navigateToMainActivity(){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
