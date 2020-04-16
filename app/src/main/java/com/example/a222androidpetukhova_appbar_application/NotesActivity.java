package com.example.a222androidpetukhova_appbar_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NotesActivity extends AppCompatActivity {

    private EditText mInputNote;
    private Button mBtnSaveNote;
    private SharedPreferences myNoteSharedPref;
    private static String NOTE_TEXT = "note_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        initViews();
        getDateFromSharedPref();
    }

    private void initViews() {

        mInputNote = findViewById(R.id.inputNote);
        mBtnSaveNote = findViewById(R.id.btnSaveNote);

        myNoteSharedPref = getSharedPreferences("MyNote", MODE_PRIVATE);

        mBtnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mInputNote.getText().length() == 0) {
                    Toast.makeText(NotesActivity.this, "Введите заметку", Toast.LENGTH_SHORT).show();
                } else {

                    SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
                    String noteTxt = mInputNote.getText().toString();
                    myEditor.putString(NOTE_TEXT, noteTxt);
                    myEditor.apply();
                    Toast.makeText(NotesActivity.this, "данные сохранены", Toast.LENGTH_LONG).show();
                }
            }

        });
    }

    private void getDateFromSharedPref() {
        String noteTxt = myNoteSharedPref.getString(NOTE_TEXT, "");
        mInputNote.setText(noteTxt);

    }
}

