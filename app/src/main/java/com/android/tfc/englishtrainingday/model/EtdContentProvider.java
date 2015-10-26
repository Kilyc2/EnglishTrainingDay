package com.android.tfc.englishtrainingday.model;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

public class EtdContentProvider extends ContentProvider {

    private static final int LESSON = 1;
    private static final int LESSON_ID = 2;
    private static final int SECTION = 3;
    private static final int SECTION_ID = 4;
    private static final int SECTION_TAB = 5;
    private static final int SECTION_TAB_ID = 6;
    private static final int EXERCISE = 7;
    private static final int EXERCISE_ID = 8;
    private static final int HISTORICAL = 9;
    private static final int HISTORICAL_ID = 10;
    private static final String AUTHORITY = "com.android.tfc.englishtrainingday.contentprovider";
    private static final String BASE_PATH_LESSON = LessonsTable.TABLE_LESSONS;
    public static final Uri CONTENT_URI_LESSON =
            Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH_LESSON);
    private static final String BASE_PATH_SECTION = SectionsTable.TABLE_SECTIONS;
    public static final Uri CONTENT_URI_SECTION =
            Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH_SECTION);
    private static final String BASE_PATH_SECTION_TAB = SectionTabsTable.TABLE_SECTION_TABS;
    public static final Uri CONTENT_URI_SECTION_TAB =
            Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH_SECTION_TAB);
    private static final String BASE_PATH_EXERCISE = ExercisesTable.TABLE_EXERCISES;
    public static final Uri CONTENT_URI_EXERCISE =
            Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH_EXERCISE);
    private static final String BASE_PATH_HISTORICAL = HistoricalTable.TABLE_HISTORICAL;
    public static final Uri CONTENT_URI_HISTORICAL =
            Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH_HISTORICAL);
    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sURIMatcher.addURI(AUTHORITY, BASE_PATH_LESSON, LESSON);
        sURIMatcher.addURI(AUTHORITY, BASE_PATH_LESSON + "/#", LESSON_ID);

        sURIMatcher.addURI(AUTHORITY, BASE_PATH_SECTION, SECTION);
        sURIMatcher.addURI(AUTHORITY, BASE_PATH_SECTION + "/#", SECTION_ID);

        sURIMatcher.addURI(AUTHORITY, BASE_PATH_SECTION_TAB, SECTION_TAB);
        sURIMatcher.addURI(AUTHORITY, BASE_PATH_SECTION_TAB + "/#", SECTION_TAB_ID);

        sURIMatcher.addURI(AUTHORITY, BASE_PATH_EXERCISE, EXERCISE);
        sURIMatcher.addURI(AUTHORITY, BASE_PATH_EXERCISE + "/#", EXERCISE_ID);

        sURIMatcher.addURI(AUTHORITY, BASE_PATH_HISTORICAL, HISTORICAL);
        sURIMatcher.addURI(AUTHORITY, BASE_PATH_HISTORICAL + "/#", HISTORICAL_ID);
    }

    private EtdDatabaseHelper database;

    @Override
    public boolean onCreate() {
        database = new EtdDatabaseHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] select, String where,
                        String[] whereArgs, String sortOrder) {

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        int uriType = sURIMatcher.match(uri);
        switch (uriType) {
            case LESSON:
                queryBuilder.setTables(LessonsTable.TABLE_LESSONS);
                break;
            case LESSON_ID:
                queryBuilder.setTables(LessonsTable.TABLE_LESSONS);
                queryBuilder.appendWhere(LessonsTable._ID + "=" + uri.getLastPathSegment());
                break;
            case SECTION:
                queryBuilder.setTables(SectionsTable.TABLE_SECTIONS);
                break;
            case SECTION_ID:
                queryBuilder.setTables(SectionsTable.TABLE_SECTIONS);
                queryBuilder.appendWhere(SectionsTable._ID + "=" + uri.getLastPathSegment());
                break;
            case SECTION_TAB:
                queryBuilder.setTables(SectionTabsTable.TABLE_SECTION_TABS);
                break;
            case SECTION_TAB_ID:
                queryBuilder.setTables(SectionTabsTable.TABLE_SECTION_TABS);
                queryBuilder.appendWhere(SectionTabsTable._ID + "=" + uri.getLastPathSegment());
                break;
            case EXERCISE:
                queryBuilder.setTables(ExercisesTable.TABLE_EXERCISES);
                break;
            case EXERCISE_ID:
                queryBuilder.setTables(ExercisesTable.TABLE_EXERCISES);
                queryBuilder.appendWhere(ExercisesTable._ID + "=" + uri.getLastPathSegment());
                break;
            case HISTORICAL:
                queryBuilder.setTables(HistoricalTable.TABLE_HISTORICAL);
                break;
            case HISTORICAL_ID:
                queryBuilder.setTables(HistoricalTable.TABLE_HISTORICAL);
                queryBuilder.appendWhere(HistoricalTable._ID + "=" + uri.getLastPathSegment());
                break;
        }

        SQLiteDatabase db = database.getWritableDatabase();
        Cursor cursor = queryBuilder.query(db, select, where,
                whereArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public String getType(Uri uri) {

        int match = sURIMatcher.match(uri);

        switch (match) {
            case LESSON:
                return "vnd.android.cursor.dir/vnd.englishTrainingDay.lesson";
            case LESSON_ID:
                return "vnd.android.cursor.item/vnd.englishTrainingDay.lesson";
            case SECTION:
                return "vnd.android.cursor.dir/vnd.englishTrainingDay.section";
            case SECTION_ID:
                return "vnd.android.cursor.item/vnd.englishTrainingDay.section";
            case SECTION_TAB:
                return "vnd.android.cursor.dir/vnd.englishTrainingDay.sectionTab";
            case SECTION_TAB_ID:
                return "vnd.android.cursor.item/vnd.englishTrainingDay.sectionTab";
            case EXERCISE:
                return "vnd.android.cursor.dir/vnd.englishTrainingDay.exercise";
            case EXERCISE_ID:
                return "vnd.android.cursor.item/vnd.englishTrainingDay.exercise";
            case HISTORICAL:
                return "vnd.android.cursor.dir/vnd.englishTrainingDay.historical";
            case HISTORICAL_ID:
                return "vnd.android.cursor.item/vnd.englishTrainingDay.historical";
            default:
                return null;
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int uriType = sURIMatcher.match(uri);
        SQLiteDatabase sqlDB = database.getWritableDatabase();
        long id;
        Uri newUri = null;
        switch (uriType) {
            case LESSON:
                id = sqlDB.insert(LessonsTable.TABLE_LESSONS, null, values);
                newUri = ContentUris.withAppendedId(CONTENT_URI_LESSON, id);
                break;
            case SECTION:
                id = sqlDB.insert(SectionsTable.TABLE_SECTIONS, null, values);
                newUri = ContentUris.withAppendedId(CONTENT_URI_SECTION, id);
                break;
            case SECTION_TAB:
                id = sqlDB.insert(SectionTabsTable.TABLE_SECTION_TABS, null, values);
                newUri = ContentUris.withAppendedId(CONTENT_URI_SECTION_TAB, id);
                break;
            case EXERCISE:
                id = sqlDB.insert(ExercisesTable.TABLE_EXERCISES, null, values);
                newUri = ContentUris.withAppendedId(CONTENT_URI_EXERCISE, id);
                break;
            case HISTORICAL:
                id = sqlDB.insert(HistoricalTable.TABLE_HISTORICAL, null, values);
                newUri = ContentUris.withAppendedId(CONTENT_URI_HISTORICAL, id);
                break;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return newUri;
    }

    @Override
    public int delete(Uri uri, String where, String[] whereArgs) {
        int uriType = sURIMatcher.match(uri);
        SQLiteDatabase sqlDB = database.getWritableDatabase();
        int rowsDeleted = 0;
        String id;
        switch (uriType) {
            case LESSON:
                rowsDeleted = sqlDB.delete(LessonsTable.TABLE_LESSONS, where, whereArgs);
                break;
            case LESSON_ID:
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(where)) {
                    rowsDeleted = sqlDB.delete(
                            LessonsTable.TABLE_LESSONS,
                            LessonsTable._ID + "=" + id,
                            null);
                } else {
                    rowsDeleted = sqlDB.delete(
                            LessonsTable.TABLE_LESSONS,
                            LessonsTable._ID + "=" + id + " and " + where,
                            whereArgs);
                }
                break;
            case SECTION:
                rowsDeleted = sqlDB.delete(SectionsTable.TABLE_SECTIONS, where, whereArgs);
                break;
            case SECTION_ID:
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(where)) {
                    rowsDeleted = sqlDB.delete(
                            SectionsTable.TABLE_SECTIONS,
                            SectionsTable._ID + "=" + id,
                            null);
                } else {
                    rowsDeleted = sqlDB.delete(
                            SectionsTable.TABLE_SECTIONS,
                            SectionsTable._ID + "=" + id + " and " + where,
                            whereArgs
                    );
                }
                break;
            case SECTION_TAB:
                rowsDeleted = sqlDB.delete(SectionTabsTable.TABLE_SECTION_TABS, where, whereArgs);
                break;
            case SECTION_TAB_ID:
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(where)) {
                    rowsDeleted = sqlDB.delete(
                            SectionTabsTable.TABLE_SECTION_TABS,
                            SectionTabsTable._ID + "=" + id,
                            null);
                } else {
                    rowsDeleted = sqlDB.delete(
                            SectionTabsTable.TABLE_SECTION_TABS,
                            SectionTabsTable._ID + "=" + id + " and " + where,
                            whereArgs
                    );
                }
                break;
            case EXERCISE:
                rowsDeleted = sqlDB.delete(ExercisesTable.TABLE_EXERCISES, where, whereArgs);
                break;
            case EXERCISE_ID:
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(where)) {
                    rowsDeleted = sqlDB.delete(
                            ExercisesTable.TABLE_EXERCISES,
                            ExercisesTable._ID + "=" + id,
                            null);
                } else {
                    rowsDeleted = sqlDB.delete(
                            ExercisesTable.TABLE_EXERCISES,
                            ExercisesTable._ID + "=" + id + " and " + where,
                            whereArgs
                    );
                }
                break;
            case HISTORICAL:
                rowsDeleted = sqlDB.delete(
                        HistoricalTable.TABLE_HISTORICAL, where, whereArgs);
                break;
            case HISTORICAL_ID:
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(where)) {
                    rowsDeleted = sqlDB.delete(
                            HistoricalTable.TABLE_HISTORICAL,
                            HistoricalTable._ID + "=" + id,
                            null);
                } else {
                    rowsDeleted = sqlDB.delete(
                            HistoricalTable.TABLE_HISTORICAL,
                            HistoricalTable._ID + "=" + id + " and " + where,
                            whereArgs
                    );
                }
                break;
        }
        getContext().getContentResolver().notifyChange(uri, null);

        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
        int uriType = sURIMatcher.match(uri);
        SQLiteDatabase sqlDB = database.getWritableDatabase();
        int rowsUpdated = 0;
        String id;
        switch (uriType) {
            case LESSON:
                rowsUpdated = sqlDB.update(LessonsTable.TABLE_LESSONS,
                        values,
                        where,
                        whereArgs);
                break;
            case LESSON_ID:
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(where)) {
                    rowsUpdated = sqlDB.update(LessonsTable.TABLE_LESSONS,
                            values,
                            LessonsTable._ID + "=" + id,
                            null);
                } else {
                    rowsUpdated = sqlDB.update(LessonsTable.TABLE_LESSONS,
                            values,
                            LessonsTable._ID + "=" + id + " and " + where,
                            whereArgs);
                }
                break;
            case SECTION:
                rowsUpdated = sqlDB.update(SectionsTable.TABLE_SECTIONS,
                        values,
                        where,
                        whereArgs);
                break;
            case SECTION_ID:
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(where)) {
                    rowsUpdated = sqlDB.update(SectionsTable.TABLE_SECTIONS,
                            values,
                            SectionsTable._ID + "=" + id,
                            null);
                } else {
                    rowsUpdated = sqlDB.update(SectionsTable.TABLE_SECTIONS,
                            values,
                            SectionsTable._ID + "=" + id + " and " + where,
                            whereArgs
                    );
                }
                break;
            case SECTION_TAB:
                rowsUpdated = sqlDB.update(SectionTabsTable.TABLE_SECTION_TABS,
                        values,
                        where,
                        whereArgs);
                break;
            case SECTION_TAB_ID:
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(where)) {
                    rowsUpdated = sqlDB.update(SectionTabsTable.TABLE_SECTION_TABS,
                            values,
                            SectionTabsTable._ID + "=" + id,
                            null);
                } else {
                    rowsUpdated = sqlDB.update(SectionTabsTable.TABLE_SECTION_TABS,
                            values,
                            SectionTabsTable._ID + "=" + id + " and " + where,
                            whereArgs
                    );
                }
                break;
            case EXERCISE:
                rowsUpdated = sqlDB.update(ExercisesTable.TABLE_EXERCISES,
                        values,
                        where,
                        whereArgs);
                break;
            case EXERCISE_ID:
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(where)) {
                    rowsUpdated = sqlDB.update(ExercisesTable.TABLE_EXERCISES,
                            values,
                            ExercisesTable._ID + "=" + id,
                            null);
                } else {
                    rowsUpdated = sqlDB.update(ExercisesTable.TABLE_EXERCISES,
                            values,
                            ExercisesTable._ID + "=" + id + " and " + where,
                            whereArgs);
                }
                break;
            case HISTORICAL:
                rowsUpdated = sqlDB.update(HistoricalTable.TABLE_HISTORICAL,
                        values,
                        where,
                        whereArgs);
                break;
            case HISTORICAL_ID:
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(where)) {
                    rowsUpdated = sqlDB.update(HistoricalTable.TABLE_HISTORICAL,
                            values,
                            HistoricalTable._ID + "=" + id,
                            null);
                } else {
                    rowsUpdated = sqlDB.update(HistoricalTable.TABLE_HISTORICAL,
                            values,
                            HistoricalTable._ID + "=" + id + " and " + where,
                            whereArgs);
                }
                break;
        }

        getContext().getContentResolver().notifyChange(uri, null);

        return rowsUpdated;
    }
}
