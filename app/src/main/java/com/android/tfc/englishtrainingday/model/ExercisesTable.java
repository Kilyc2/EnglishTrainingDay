package com.android.tfc.englishtrainingday.model;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

public class ExercisesTable implements BaseColumns {

    public static final String TABLE_EXERCISES = "exercises";
    public static final String COLUMN_VERSION_CODE = "version_code";
    public static final String COLUMN_LEVEL = "level";
    public static final String COLUMN_ID_LESSON = "id_lesson";
    public static final String COLUMN_EXERCISE_TYPE = "exercise_type";
    public static final String COLUMN_QUESTION = "question";
    public static final String COLUMN_WORDING = "wording";
    public static final String COLUMN_SOLUTION = "solution";
    public static final String COLUMN_TIP = "tip";
    public static final String COLUMN_OPTIONS = "options";

    private static final String DATABASE_CREATE = "create table " +
            TABLE_EXERCISES +
            "(" +
            _ID + " integer primary key autoincrement, " +
            COLUMN_VERSION_CODE + " text not null, " +
            COLUMN_LEVEL + " text not null, " +
            COLUMN_ID_LESSON + " integer not null, " +
            COLUMN_EXERCISE_TYPE + " integer not null, " +
            COLUMN_QUESTION + " text not null, " +
            COLUMN_WORDING + " text not null, " +
            COLUMN_SOLUTION + " text not null, " +
            COLUMN_TIP + " text, " +
            COLUMN_OPTIONS + " text " +
            ");";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w(ExercisesTable.class.getName(), "Upgrading database from version " +
                +oldVersion + " to " + newVersion +
                ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISES);
        onCreate(database);
    }
}
