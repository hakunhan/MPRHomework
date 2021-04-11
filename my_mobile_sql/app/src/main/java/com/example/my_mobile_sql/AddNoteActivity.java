package com.example.my_mobile_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.my_mobile_sql.database.NoteManager;
import com.example.my_mobile_sql.models.Note;

public class AddNoteActivity extends AppCompatActivity {
    private EditText addNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        addNote = findViewById(R.id.tvAddNote);
    }

    @Override
    public void onBackPressed() {
        String text = addNote.getText().toString();
        Note note = new Note(text);
        NoteManager.getInstance(this).add(note);

        setResult(this.RESULT_OK);
        super.onBackPressed();
    }
}