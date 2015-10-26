package com.android.tfc.englishtrainingday.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EtdDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "etd_database.db";
    private static final int DATABASE_VERSION = 1;

    public EtdDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        LessonsTable.onCreate(database);
        SectionsTable.onCreate(database);
        SectionTabsTable.onCreate(database);
        ExercisesTable.onCreate(database);
        HistoricalTable.onCreate(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        LessonsTable.onUpgrade(database, oldVersion, newVersion);
        SectionsTable.onUpgrade(database, oldVersion, newVersion);
        SectionTabsTable.onUpgrade(database, oldVersion, newVersion);
        ExercisesTable.onUpgrade(database, oldVersion, newVersion);
        HistoricalTable.onUpgrade(database, oldVersion, newVersion);
    }
}
