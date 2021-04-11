package com.example.my_mobile_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.my_mobile_sql.database.NoteManager;
import com.example.my_mobile_sql.models.Note;

public class EditNoteActivity extends AppCompatActivity {
    private EditText editNote;
    private Note note;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        Intent intent = getIntent();
        id = intent.getLongExtra("id", -1);
        Toast.makeText(this, "" + id, Toast.LENGTH_SHORT).show();
        NoteManager noteManager = NoteManager.getInstance(this);
        note = noteManager.findByID(id);

        editNote = findViewById(R.id.tvEditNote);
        editNote.setText(note.getText());
    }

    @Override
    public void onBackPressed() {
        note.setText(editNote.getText().toString());
        note.setId(id);
        NoteManager.getInstance(this).update(note);
        setResult(RESULT_OK);
        super.onBackPressed();
    }
}