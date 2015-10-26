package com.android.tfc.englishtrainingday.model;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

public class HistoricalTable implements BaseColumns {

    public static final String TABLE_HISTORICAL = "historical";
    public static final String COLUMN_LEVEL = "level";
    public static final String COLUMN_ID_LESSON = "id_lesson";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_EXERCISE_DONE = "exercise_done";
    public static final String COLUMN_EXERCISE_OK = "exercise_ok";

    private static final String DATABASE_CREATE = "create table " +
            TABLE_HISTORICAL +
            "(" +
            _ID + " integer primary key autoincrement, " +
            COLUMN_LEVEL + " text not null, " +
            COLUMN_ID_LESSON + " integer not null, " +
            COLUMN_DATE + " text not null, " +
            COLUMN_EXERCISE_DONE + " integer not null, " +
            COLUMN_EXERCISE_OK + " integer not null " +
            ");";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w(LessonsTable.class.getName(), "Upgrading database from version " +
                +oldVersion + " to " + newVersion +
                ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORICAL);
        onCreate(database);
    }

}
