package com.example.my_mobile_sql.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.example.my_mobile_sql.models.Note;

import java.util.List;


public class NoteManager {
    // singleton
    private static NoteManager instance;

    private static final String INSERT_STMT =
            "INSERT INTO " + DbSchema.NoteTable.NAME + "(text) VALUES (?)";

    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public static NoteManager getInstance(Context context) {
        if (instance == null) {
            instance = new NoteManager(context);
        }

        return instance;
    }

    private NoteManager(Context context) {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public List<Note> all() {
        String sql = "SELECT * FROM notes";
        Cursor cursor = db.rawQuery(sql, null);
        NoteCursorWrapper cursorWrapper = new NoteCursorWrapper(cursor);

        return cursorWrapper.getNotes();
    }

    /**
     * @modifies Note
     */
    public boolean add(Note Note) {
        SQLiteStatement statement = db.compileStatement(INSERT_STMT);

        statement.bindString(1, Note.getText());

        Long id = statement.executeInsert();
        statement.executeUpdateDelete();
        // a
        if (id > 0) {
            Note.setId(id);
            return true;
        }

        return false;
    }

    public boolean update(Note note){
        ContentValues contentValues = new ContentValues();
        contentValues.put("text", note.getText());
        int result = db.update(DbSchema.NoteTable.NAME, contentValues, "id = ?", new String[]{note.getId()+""});
        return result >0;

    }

    public boolean delete(long id) {
        int result = db.delete(DbSchema.NoteTable.NAME, "id = ?", new String[]{ id+"" });

        return result > 0;
    }

    public Note findByID(long id){
        System.out.println(id);
        String sqlStatement = "SELECT * FROM notes WHERE id = ?";
        Cursor cursor = db.rawQuery(sqlStatement, new String[]{id + ""});
        NoteCursorWrapper noteCursorWrapper = new NoteCursorWrapper(cursor);
        return noteCursorWrapper.getNote();
    }
}
