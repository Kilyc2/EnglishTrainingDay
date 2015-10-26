package com.android.tfc.englishtrainingday.activities;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.tfc.englishtrainingday.R;
import com.android.tfc.englishtrainingday.entities.HistoricalObj;
import com.android.tfc.englishtrainingday.model.EtdContentProvider;
import com.android.tfc.englishtrainingday.model.HistoricalTable;
import com.android.tfc.englishtrainingday.utils.Constants;
import com.android.tfc.englishtrainingday.utils.CursorUtils;
import com.android.tfc.englishtrainingday.utils.DateUtils;
import com.jjoe64.graphview.CustomLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

public class ResultsActivity extends Activity {

    private int idLesson;
    private String level;
    private String lessonName;

    private HistoricalObj historical;

    private ContentResolver cr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        cr = getContentResolver();
        Bundle bundle = this.getIntent().getExtras();
        idLesson = bundle.getInt(Constants.ID_LESSON);
        lessonName = bundle.getString(Constants.NAME_LESSON);
        level = bundle.getString(Constants.LEVEL_SELECTED);
        setHistorical();
        setupView();
    }

    private void setupView() {
        ((TextView) findViewById(R.id.txtTitle)).setText("Exercises for " + lessonName + " completed!");
        ((TextView) findViewById(R.id.txtExercisesDone)).setText("Exercises done today: " +
                String.valueOf(historical.getExerciseDone()));
        ((TextView) findViewById(R.id.txtExercisesOk)).setText("Correct exercises: " +
                String.valueOf(historical.getExerciseOk()));
        ((TextView) findViewById(R.id.txtScore)).setText("Total score: " +
                String.valueOf(historical.getScore()));
        GraphView graphView = new LineGraphView(
                this, // context
                "Weekly progression" // heading
        );
        graphView.setVerticalLabels(new String[]{"100", "", "80", "", "60", "", "40", "", "20", "", "0"});
        graphView.addSeries(getScoreSeries()); // data
        graphView.setCustomLabelFormatter(new LabelFormat());

        graphView.setScalable(false);
        graphView.setManualYAxisBounds(100, 0);
        graphView.setManualMaxY(true);
        graphView.setManualMinY(true);
        graphView.getGraphViewStyle().setNumHorizontalLabels(7);
        LinearLayout layout = (LinearLayout) findViewById(R.id.graph);
        layout.addView(graphView);
        findViewById(R.id.buttonResults).setOnClickListener(new CloseClickListener());
    }

    private GraphViewSeries getScoreSeries() {
        String[] colHistorical = new String[]{
                HistoricalTable.COLUMN_DATE,
                HistoricalTable.COLUMN_EXERCISE_DONE,
                HistoricalTable.COLUMN_EXERCISE_OK};
        Uri historicalUri = EtdContentProvider.CONTENT_URI_HISTORICAL;
        String firstDate = DateUtils.getPreviousDate(DateUtils.getTodayFormatYYYYMMDD(), 6);
        String today = DateUtils.getTodayFormatYYYYMMDD();
        String[] selArgsIdLesson = new String[]{level, String.valueOf(idLesson), firstDate, today};
        String where = HistoricalTable.COLUMN_LEVEL + " = ? " +
                "AND " + HistoricalTable.COLUMN_ID_LESSON + " = ? " +
                "AND " + HistoricalTable.COLUMN_DATE + " BETWEEN ? AND ? ";
        Cursor cHistorical = cr.query(historicalUri, colHistorical, where, selArgsIdLesson, null);
        HistoricalObj historicalData;
        GraphViewSeries serialScore = null;
        if (CursorUtils.isValidCursor(cHistorical)) {
            int numberOfDay = DateUtils.getDayOfWeek(firstDate);
            GraphView.GraphViewData[] dataScore = new GraphView.GraphViewData[7];
            for (int i = 0; i < 7; i++) {
                int numberOfDayInDB = DateUtils.getDayOfWeek(String.valueOf(
                        cHistorical.getInt(cHistorical.getColumnIndex(
                                HistoricalTable.COLUMN_DATE))));
                int numberOfDayInWeek = numberOfDay;
                if (numberOfDayInWeek > 7)
                    numberOfDayInWeek = numberOfDayInWeek % 7;
                if (numberOfDayInDB == numberOfDayInWeek) {
                    historicalData = new HistoricalObj(level, idLesson, "", "",
                            cHistorical.getInt(cHistorical.getColumnIndex(
                                    HistoricalTable.COLUMN_EXERCISE_DONE)),
                            cHistorical.getInt(cHistorical.getColumnIndex(
                                    HistoricalTable.COLUMN_EXERCISE_OK)));
                    dataScore[i] = new GraphView.GraphViewData(numberOfDay,
                            Double.parseDouble(historicalData.getScore()));
                    cHistorical.moveToNext();
                } else {
                    dataScore[i] = new GraphView.GraphViewData(numberOfDay, 0);
                }
                numberOfDay++;
            }
            serialScore = new GraphViewSeries(dataScore);
        }
        CursorUtils.closeCursor(cHistorical);
        return serialScore;
    }

    private void setHistorical() {
        Uri historicalUri = EtdContentProvider.CONTENT_URI_HISTORICAL;
        String currentDay = DateUtils.getTodayFormatYYYYMMDD();
        String[] colHistorical = new String[]{
                HistoricalTable.COLUMN_EXERCISE_DONE,
                HistoricalTable.COLUMN_EXERCISE_OK};
        String whereHistorical = HistoricalTable.COLUMN_LEVEL + " = ? AND " +
                HistoricalTable.COLUMN_ID_LESSON + " = ? AND " +
                HistoricalTable.COLUMN_DATE + " = ?";
        String[] selArgsHistorical = new String[]{
                level,
                String.valueOf(idLesson),
                currentDay};
        Cursor cHistorical = cr.query(historicalUri, colHistorical, whereHistorical,
                selArgsHistorical, null);
        if (CursorUtils.isValidCursor(cHistorical)) {
            historical = new HistoricalObj(level, idLesson, "", "",
                    cHistorical.getInt(cHistorical.getColumnIndex(
                            HistoricalTable.COLUMN_EXERCISE_DONE)),
                    cHistorical.getInt(cHistorical.getColumnIndex(
                            HistoricalTable.COLUMN_EXERCISE_OK)));
        }
        CursorUtils.closeCursor(cHistorical);
    }

    private class LabelFormat implements CustomLabelFormatter {

        @Override
        public String formatLabel(double value, boolean isValueX) {
            if (isValueX) {
                int dayValue = (int) value;
                if (dayValue > 7) {
                    dayValue = dayValue % 7;
                }
                return DateUtils.getTextDayOfWeek(dayValue);
            }
            return null;
        }
    }

    private class CloseClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            finish();
        }
    }
}
