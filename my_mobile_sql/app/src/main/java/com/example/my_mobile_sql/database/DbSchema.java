package com.example.my_mobile_sql.database;

import android.database.sqlite.SQLiteDatabase;

public class DbSchema {
    public final class NoteTable {
        public static final String NAME = "notes";

        public final class Cols {
            public static final String TEXT = "text";
        }
    }
}
