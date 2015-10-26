package com.android.tfc.englishtrainingday.model;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

public class SectionTabsTable implements BaseColumns {

    public static final String TABLE_SECTION_TABS = "section_tabs";
    public static final String COLUMN_LEVEL = "level";
    public static final String COLUMN_ID_SECTION = "id_section";
    public static final String COLUMN_NAME_TAB = "name_tab";
    public static final String COLUMN_TEXT_TAB = "text_tab";

    private static final String DATABASE_CREATE = "create table " +
            TABLE_SECTION_TABS +
            "(" +
            _ID + " integer primary key, " +
            COLUMN_LEVEL + " text not null, " +
            COLUMN_ID_SECTION + " integer not null, " +
            COLUMN_NAME_TAB + " text not null, " +
            COLUMN_TEXT_TAB + " text not null " +
            ");";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w(LessonsTable.class.getName(), "Upgrading database from version " +
                +oldVersion + " to " + newVersion +
                ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_SECTION_TABS);
        onCreate(database);
    }

}
