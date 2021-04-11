package com.example.my_mobile_sql;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.my_mobile_sql.adapters.NoteAdapter;
import com.example.my_mobile_sql.database.NoteManager;
import com.example.my_mobile_sql.models.Note;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvNote;
    private List<Note> notes;
    private NoteAdapter noteAdapter;
    private NoteManager noteManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNote = findViewById(R.id.rvNote);


        noteManager = NoteManager.getInstance(MainActivity.this);
        notes = noteManager.all();
        noteAdapter = new NoteAdapter(notes);

        rvNote.setAdapter(noteAdapter);
        rvNote.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.AddNote:
                Intent intent =  new Intent(this, AddNoteActivity.class);
                startActivityForResult(intent, 1);
                break;

        }

        return false;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "" + requestCode    , Toast.LENGTH_SHORT).show();
        if(resultCode == RESULT_OK &&(requestCode == 2 || requestCode == 1)){
            notes.clear();
            notes.addAll(noteManager.all());
            noteAdapter.notifyDataSetChanged();
        }
    }
}