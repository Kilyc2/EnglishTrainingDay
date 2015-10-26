package com.android.tfc.englishtrainingday.model;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;


public class LessonsTable implements BaseColumns {

    public static final String TABLE_LESSONS = "lessons";
    public static final String COLUMN_LEVEL = "level";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_VERSION_CODE = "version_code";

    private static final String DATABASE_CREATE = "create table " +
            TABLE_LESSONS +
            "(" +
            _ID + " integer primary key, " +
            COLUMN_LEVEL + " text not null, " +
            COLUMN_NAME + " text not null, " +
            COLUMN_VERSION_CODE + " text not null " +
            ");";

    public static void onCreate(SQLiteDatabase database) {

        database.execSQL(DATABASE_CREATE);

    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w(LessonsTable.class.getName(), "Upgrading database from version " +
                +oldVersion + " to " + newVersion +
                ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_LESSONS);
        onCreate(database);
    }
}
