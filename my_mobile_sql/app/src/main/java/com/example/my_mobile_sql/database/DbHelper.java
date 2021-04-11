package com.example.my_mobile_sql.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
    private Context mContext;
    private static final String DATABASE_NAME = "friends.db";
    private static final int DATABASE_VERSION = 2;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + DbSchema.NoteTable.NAME + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DbSchema.NoteTable.Cols.TEXT + " TEXT " + ")");

        // other tables here
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("My Friends", "My Friends: upgrading DB; dropping/recreating tables.");
        db.execSQL("DROP TABLE IF EXISTS " + DbSchema.NoteTable.NAME);

        // other tables here

        onCreate(db);
    }
}
