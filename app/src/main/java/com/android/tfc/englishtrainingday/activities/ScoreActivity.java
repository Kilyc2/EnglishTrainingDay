package com.android.tfc.englishtrainingday.activities;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import com.android.tfc.englishtrainingday.R;
import com.android.tfc.englishtrainingday.adapters.ScoreListAdapter;
import com.android.tfc.englishtrainingday.entities.HistoricalObj;
import com.android.tfc.englishtrainingday.model.EtdContentProvider;
import com.android.tfc.englishtrainingday.model.HistoricalTable;
import com.android.tfc.englishtrainingday.model.LessonsTable;
import com.android.tfc.englishtrainingday.utils.Constants;
import com.android.tfc.englishtrainingday.utils.CursorUtils;

import java.util.ArrayList;
import java.util.Set;

public class ScoreActivity extends ListActivity {

    private ContentResolver cr;
    private ArrayList<HistoricalObj> lessonItems = new ArrayList<>();
    private ScoreListAdapter adapter;
    private String level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        cr = getContentResolver();
        Bundle bundle = this.getIntent().getExtras();
        this.level = bundle.getString(Constants.LEVEL_SELECTED);
        getItems();
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        adapter = new ScoreListAdapter(this, R.layout.score_item, lessonItems);
        setListAdapter(adapter);
        ActionBar aBar = getActionBar();
        aBar.setDisplayHomeAsUpEnabled(true);
        getListView().setMultiChoiceModeListener(new ScoreMultiChoiceListener());
    }

    private void getItems() {
        HistoricalObj lessonHistorical;
        String[] colLessons = new String[]{
                LessonsTable._ID,
                LessonsTable.COLUMN_NAME,
                LessonsTable.COLUMN_VERSION_CODE};
        Uri lessonsUri = EtdContentProvider.CONTENT_URI_LESSON;
        String[] selArgsLevel = new String[]{this.level};
        Cursor cLessons = cr.query(lessonsUri, colLessons, LessonsTable.COLUMN_LEVEL + " = ?",
                selArgsLevel, null);
        String[] colHistorical = new String[]{
                HistoricalTable.COLUMN_EXERCISE_DONE,
                HistoricalTable.COLUMN_EXERCISE_OK};
        Uri historicalUri = EtdContentProvider.CONTENT_URI_HISTORICAL;
        if (CursorUtils.isValidCursor(cLessons)) {
            do {
                int idLesson = cLessons.getInt(cLessons.getColumnIndex(LessonsTable._ID));
                String[] selArgsIdLesson = new String[]{String.valueOf(idLesson)};
                Cursor cHistorical = cr.query(historicalUri, colHistorical,
                        HistoricalTable.COLUMN_ID_LESSON + " = ?", selArgsIdLesson, null);
                int exercisesDoneTotal = 0;
                int exercisesOkTotal = 0;
                if (CursorUtils.isValidCursor(cHistorical)) {
                    do {
                        exercisesDoneTotal +=
                                cHistorical.getInt(cHistorical.getColumnIndex(
                                        HistoricalTable.COLUMN_EXERCISE_DONE));
                        exercisesOkTotal +=
                                cHistorical.getInt(cHistorical.getColumnIndex(
                                        HistoricalTable.COLUMN_EXERCISE_OK));
                    } while (cHistorical.moveToNext());
                }
                CursorUtils.closeCursor(cHistorical);
                lessonHistorical = new HistoricalObj(
                        this.level,
                        cLessons.getInt(cLessons.getColumnIndex(LessonsTable._ID)),
                        cLessons.getString(cLessons.getColumnIndex(LessonsTable.COLUMN_NAME)),
                        cLessons.getString(cLessons.getColumnIndex(LessonsTable.COLUMN_VERSION_CODE)),
                        exercisesDoneTotal,
                        exercisesOkTotal);
                lessonItems.add(lessonHistorical);
            } while (cLessons.moveToNext());
        }
        CursorUtils.closeCursor(cLessons);
    }

    private int resetScore(Set<Integer> itemsPosition) {
        Uri historicalUri = EtdContentProvider.CONTENT_URI_HISTORICAL;
        String where = HistoricalTable.COLUMN_ID_LESSON + " IN (";
        String[] selArgsIdLesson = new String[itemsPosition.size()];
        int i = 0;
        for (int itemPosition : itemsPosition) {
            selArgsIdLesson[i] = String.valueOf(adapter.getItem(itemPosition).getIdLesson());
            where = where.concat("?,");
            i++;
        }
        where = where.substring(0, where.lastIndexOf(",")).concat(")");
        return cr.delete(historicalUri, where, selArgsIdLesson);
    }

    private class ScoreMultiChoiceListener implements AbsListView.MultiChoiceModeListener {

        private int numberOfRowsSelected = 0;

        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position,
                                              long id, boolean checked) {
            if (checked) {
                numberOfRowsSelected++;
                adapter.setNewSelection(position, true);
            } else {
                numberOfRowsSelected--;
                adapter.removeSelection(position);
            }
            mode.setTitle(numberOfRowsSelected + " selected");
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            numberOfRowsSelected = 0;
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.contextual_score_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_reset_score:
                    resetScore(adapter.getCurrentCheckedPosition());
                    lessonItems.clear();
                    getItems();
                    numberOfRowsSelected = 0;
                    adapter.clearSelection();
                    mode.finish();
                    break;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            for (int i = 0; i < lessonItems.size(); i++)
                adapter.removeSelection(i);
        }
    }
}