package com.example.my_mobile_sql.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.my_mobile_sql.database.DbSchema;
import com.example.my_mobile_sql.models.Note;

import java.util.ArrayList;
import java.util.List;


public class NoteCursorWrapper extends CursorWrapper {
    public NoteCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Note getNote() {
        String text = getString(getColumnIndex(DbSchema.NoteTable.Cols.TEXT));

        Note note = new Note(text);

        return note;
    }

    public List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();

        moveToFirst();
        while (!isAfterLast()) {
            Note note = getNote();
            notes.add(note);

            moveToNext();
        }

        return notes;
    }
}
