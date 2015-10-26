package com.android.tfc.englishtrainingday.activities;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tfc.englishtrainingday.R;
import com.android.tfc.englishtrainingday.adapters.ExercisesCollectionPagerAdapter;
import com.android.tfc.englishtrainingday.entities.ExerciseObj;
import com.android.tfc.englishtrainingday.model.EtdContentProvider;
import com.android.tfc.englishtrainingday.model.ExercisesTable;
import com.android.tfc.englishtrainingday.model.HistoricalTable;
import com.android.tfc.englishtrainingday.utils.Constants;
import com.android.tfc.englishtrainingday.utils.CursorUtils;
import com.android.tfc.englishtrainingday.utils.DateUtils;
import com.android.tfc.englishtrainingday.views.ExerciseViewPager;
import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExercisesActivity extends FragmentActivity implements ActionBar.TabListener {

    private final static int NUMBER_EXERCISES = 10;
    private final static int NUMBER_UPGRADE_LEVEL_EXERCISES = 25;
    private final static int NUMBER_MAX_EXERCISES_FAIL = 5;

    private final static String PREFERENCE_EXERCISE_VERSION = "prefsExerciseVersion";

    private final static String STATE_EXERCISES_DONE = "stateExercisesDone";
    private final static String STATE_EXERCISES_OK = "stateExercisesOk";
    private final static String STATE_EXERCISE_EVALUATED = "stateExerciseEvaluated";
    private final static String STATE_EXERCISES_UPDATED = "stateExerciseUpdated";

    private int lesson;
    private String nameLesson;
    private String level;
    private String apiVersion;
    private String appExerciseVersion;
    private boolean isExercisesUpdated;
    private ArrayList<ExerciseObj> exercises;

    private int positionExercise;

    private ContentResolver cr;

    private RelativeLayout divTip;
    private ExerciseViewPager exercisesPage;
    private ExercisesCollectionPagerAdapter exercisesAdapter;
    private TextView textExercises;

    private int exercisesDone;
    private int exercisesOk;
    private boolean isExerciseEvaluated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        finishLevelActivityIfNotIsNull();
        cr = getContentResolver();
        setupParameters(this.getIntent().getExtras());
        getActionBar().setTitle(getActionbarTitle());
        this.exercises = new ArrayList<>();
        this.exercisesDone = 0;
        this.exercisesOk = 0;
        this.isExerciseEvaluated = false;
        setupPreferences(getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE));
        textExercises = (TextView) findViewById(R.id.textExercise);
        prepareExercises();
        setupButtonExercise();
    }

    private void finishLevelActivityIfNotIsNull() {
        if (LevelActivity.levelActivity != null) {
            finishLevelActivity();
        }
    }

    private void finishLevelActivity() {
        LevelActivity.levelActivity.finish();
    }

    private void setupParameters(Bundle bundle) {
        this.lesson = bundle.getInt(Constants.ID_LESSON, 0);
        this.nameLesson = bundle.getString(Constants.NAME_LESSON, "");
        this.level = bundle.getString(Constants.LEVEL_SELECTED, "");
    }

    private String getActionbarTitle() {
        if (isUpgradeLevel()) {
            return "Exercises Level " + this.level;
        } else {
            return "Exercises " + this.nameLesson;
        }
    }

    private boolean isUpgradeLevel() {
        return this.lesson == 0;
    }

    private void setupPreferences(SharedPreferences preferences) {
        this.appExerciseVersion = preferences.getString(PREFERENCE_EXERCISE_VERSION + level, "");
        this.isExercisesUpdated = preferences.getBoolean(STATE_EXERCISES_UPDATED, false);
        this.apiVersion = preferences.getString(Constants.API_VERSION, "");
    }

    private boolean isVersionUpdate() {
        return this.apiVersion.equals(this.appExerciseVersion);
    }

    private void prepareExercises() {
        if (!isVersionUpdate()) {
            updateExercises();
        } else {
            showExercises();
        }
    }

    private void showExercises() {
        if (this.isExercisesUpdated) {
            setupExercises();
        }
    }

    private void setupButtonExercise() {
        ImageButton buttonMarkExercise = (ImageButton) findViewById(R.id.button_mark_exercise);
        eventOnclickExerciseButton(buttonMarkExercise);
    }

    private void eventOnclickExerciseButton(ImageButton buttonMarkExercise) {
        buttonMarkExercise.setOnClickListener(new EvaluateExerciseClickListener());
    }

    private boolean isOkEvaluateExercise() {
        return !this.isExerciseEvaluated && !this.exercises.isEmpty();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_EXERCISES_DONE, this.exercisesDone);
        outState.putInt(STATE_EXERCISES_OK, this.exercisesOk);
        outState.putBoolean(STATE_EXERCISE_EVALUATED, this.isExerciseEvaluated);
        super.onSaveInstanceState(outState);
    }

    private void setupExercises() {
        fillExercises();
        this.exercisesAdapter =
                new ExercisesCollectionPagerAdapter(getSupportFragmentManager(), this.exercises);
        this.textExercises.setText("Left: " + this.exercises.size() + " - Missed: 0");
        setupExercisesPage();
    }

    private void fillExercises() {
        if (this.exercises.isEmpty()) {
            this.exercises = getExercises();
        }
    }

    private void setupExercisesPage() {
        this.exercisesPage = (ExerciseViewPager) findViewById(R.id.pager_exercise);
        this.exercisesPage.setAdapter(this.exercisesAdapter);
        this.exercisesPage.setOnPageChangeListener(new ExerciseChangeListener());
        for (ExerciseObj exercise : this.exercises) {
            setupExerciseTabs(exercise);
        }
    }

    private void eventOnPageSelected(int positionExercise) {
        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        getActionBar().setSelectedNavigationItem(positionExercise);
        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        this.positionExercise = positionExercise;
    }

    private void setupExerciseTabs(ExerciseObj exercise) {
        ActionBar.Tab tab = getActionBar().newTab().setText(String.valueOf(exercise.getExerciseType()));
        tab.setTabListener(this);
        getActionBar().addTab(tab);
    }

    private void evaluateExercise() {
        hideKeyboard();
        ExerciseObj exercise = exercises.get(positionExercise);
        String userSolution = "";
        boolean isResponseOk = false;
        switch (exercise.getExerciseType()) {
            case 1:
                userSolution = String.valueOf((
                        (EditText) exercisesPage.findViewWithTag(exercisesPage.getCurrentItem())
                                .findViewById(R.id.txtSolution)).getText());
                if (userSolution.trim().isEmpty())
                    isResponseOk = false;
                else {
                    isResponseOk = false;
                    for (String solution : exercise.getSolution().split(";")) {
                        if (solution.toLowerCase().equals(userSolution.toLowerCase().trim())) {
                            isResponseOk = true;
                        }
                    }
                }
                break;
            case 2:
                RadioGroup radioGroup =
                        (RadioGroup) exercisesPage.findViewWithTag(exercisesPage.getCurrentItem())
                                .findViewById(R.id.rgroup);
                try {
                    userSolution = String.valueOf((
                            (RadioButton) radioGroup.findViewById(
                                    radioGroup.getCheckedRadioButtonId())).getText());
                } catch (NullPointerException npe) {
                    userSolution = "";
                }
                isResponseOk = exercise.getSolution().equals(userSolution);
                break;
            case 3:
                LinearLayout checkGroup =
                        (LinearLayout) exercisesPage
                                .findViewWithTag(exercisesPage.getCurrentItem())
                                .findViewById(R.id.chkGroup);
                CheckBox checkOption;
                for (int i = 0; i < checkGroup.getChildCount(); i++) {
                    checkOption = (CheckBox) checkGroup.getChildAt(i);
                    if (checkOption.isChecked()) {
                        if (!userSolution.isEmpty())
                            userSolution = userSolution.concat(";");
                        userSolution = userSolution.concat(checkOption.getText().toString());
                    }
                }
                isResponseOk = exercise.getSolution().equals(userSolution);
                break;
            case 4:
                LinearLayout textGroup =
                        (LinearLayout) exercisesPage
                                .findViewWithTag(exercisesPage.getCurrentItem())
                                .findViewById(R.id.txtGroup);
                EditText response;
                for (int i = 1; i < textGroup.getChildCount(); i = i + 2) {
                    response = (EditText) textGroup.getChildAt(i);
                    if (!userSolution.isEmpty())
                        userSolution = userSolution.concat(";");
                    userSolution = userSolution.concat(response.getText().toString().trim());
                }
                isResponseOk = exercise.getSolution().toLowerCase().equals(
                        userSolution.toLowerCase());
                break;
        }
        Button nextButton;
        TextView textTip;
        exercisesDone++;
        if (isResponseOk) {
            exercisesOk++;
            divTip = (RelativeLayout) findViewById(R.id.div_exercise_ok);
            nextButton = (Button) divTip.findViewById(R.id.button_next_ok);
            textTip = (TextView) divTip.findViewById(R.id.text_tip_ok);
        } else {
            divTip = (RelativeLayout) findViewById(R.id.div_exercise_miss);
            nextButton = (Button) divTip.findViewById(R.id.button_next_miss);
            textTip = (TextView) divTip.findViewById(R.id.text_tip_miss);
        }
        try {
            textTip.setText(Html.fromHtml(exercise.getTip()));
        } catch (NullPointerException npe) {
            textTip.setText("");
        }
        divTip.setVisibility(View.VISIBLE);
        isExerciseEvaluated = true;
        nextButton.setOnClickListener(new NextExerciseClickListener());
    }

    private void hideKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager =
                    (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(
                    getCurrentFocus().getWindowToken(), 0);
        }
    }

    private void unblockLevel() {
        SharedPreferences settings =
                getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        switch (this.level) {
            case "A1":
                editor.putBoolean(Constants.LEVEL_BLOCKED + "A2", true);
                break;
            case "A2":
                editor.putBoolean(Constants.LEVEL_BLOCKED + "B1", true);
                break;
            case "B1":
                editor.putBoolean(Constants.LEVEL_BLOCKED + "B2", true);
                break;
            case "B2":
                editor.putBoolean(Constants.LEVEL_BLOCKED + "C1", true);
                break;
            case "C1":
                editor.putBoolean(Constants.LEVEL_BLOCKED + "C2", true);
                break;
        }
        editor.apply();
        returnLevelActivity(true);
    }

    private void showResults() {
        saveResults();
        Intent intent = new Intent(ExercisesActivity.this, ResultsActivity.class);
        Bundle args = new Bundle();
        args.putInt(Constants.ID_LESSON, lesson);
        args.putString(Constants.NAME_LESSON, nameLesson);
        args.putString(Constants.LEVEL_SELECTED, level);
        intent.putExtras(args);
        startActivity(intent);
        finish();
    }

    private void returnLevelActivity(boolean isUpgradeLevel) {
        Intent intent = new Intent(ExercisesActivity.this, LevelActivity.class);
        Bundle args = new Bundle();
        args.putBoolean(LevelActivity.UPGRADE_LEVEL, isUpgradeLevel);
        intent.putExtras(args);
        startActivity(intent);
        finish();
    }

    private void saveResults() {
        Uri historicalUri = EtdContentProvider.CONTENT_URI_HISTORICAL;
        String currentDay = DateUtils.getTodayFormatYYYYMMDD();
        String[] colHistorical = new String[]{
                HistoricalTable.COLUMN_EXERCISE_DONE,
                HistoricalTable.COLUMN_EXERCISE_OK};
        String[] selArgsHistorical = new String[]{
                level,
                String.valueOf(lesson),
                currentDay};
        String whereHistorical = HistoricalTable.COLUMN_LEVEL + " = ? AND " +
                HistoricalTable.COLUMN_ID_LESSON + " = ? AND " +
                HistoricalTable.COLUMN_DATE + " = ?";
        Cursor cHistorical = cr.query(historicalUri, colHistorical, whereHistorical,
                selArgsHistorical, null);
        ContentValues values = new ContentValues();
        if (CursorUtils.isValidCursor(cHistorical)) {
            int exercisesDoneTotal = exercisesDone +
                    cHistorical.getInt(cHistorical.getColumnIndex(
                            HistoricalTable.COLUMN_EXERCISE_DONE));
            int exercisesOkTotal = exercisesOk + cHistorical.getInt(cHistorical.getColumnIndex(
                    HistoricalTable.COLUMN_EXERCISE_OK));
            values.put(HistoricalTable.COLUMN_EXERCISE_DONE, exercisesDoneTotal);
            values.put(HistoricalTable.COLUMN_EXERCISE_OK, exercisesOkTotal);
            cr.update(historicalUri, values, whereHistorical, selArgsHistorical);
        } else {
            values.put(HistoricalTable.COLUMN_LEVEL, level);
            values.put(HistoricalTable.COLUMN_ID_LESSON, lesson);
            values.put(HistoricalTable.COLUMN_DATE, currentDay);
            values.put(HistoricalTable.COLUMN_EXERCISE_DONE, exercisesDone);
            values.put(HistoricalTable.COLUMN_EXERCISE_OK, exercisesOk);
            cr.insert(historicalUri, values);
        }
        CursorUtils.closeCursor(cHistorical);
    }

    private ArrayList<ExerciseObj> getExercises() {
        ArrayList<ExerciseObj> listExercises = new ArrayList<>();
        String[] colSectExercises = new String[]{
                ExercisesTable._ID,
                ExercisesTable.COLUMN_EXERCISE_TYPE,
                ExercisesTable.COLUMN_QUESTION,
                ExercisesTable.COLUMN_WORDING,
                ExercisesTable.COLUMN_SOLUTION,
                ExercisesTable.COLUMN_TIP,
                ExercisesTable.COLUMN_OPTIONS
        };
        String[] selArgsExercises;
        String whereExercises;
        int numExercises;
        if (isUpgradeLevel()) {
            selArgsExercises = new String[]{this.level};
            whereExercises = ExercisesTable.COLUMN_LEVEL + " = ?";
            numExercises = NUMBER_UPGRADE_LEVEL_EXERCISES;
        } else {
            selArgsExercises = new String[]{this.level, String.valueOf(this.lesson)};
            whereExercises = ExercisesTable.COLUMN_LEVEL + " = ? AND " +
                    ExercisesTable.COLUMN_ID_LESSON + " = ?";
            numExercises = NUMBER_EXERCISES;
        }
        Uri exerciseUri = EtdContentProvider.CONTENT_URI_EXERCISE;
        Cursor cSectExercises = cr.query(exerciseUri, colSectExercises, whereExercises,
                selArgsExercises, null);
        if (CursorUtils.isValidCursor(cSectExercises)) {
            do {
                listExercises.add(new ExerciseObj(
                        cSectExercises.getInt(
                                cSectExercises.getColumnIndex(ExercisesTable._ID)),
                        cSectExercises.getInt(
                                cSectExercises.getColumnIndex(ExercisesTable.COLUMN_EXERCISE_TYPE)),
                        cSectExercises.getString(
                                cSectExercises.getColumnIndex(ExercisesTable.COLUMN_QUESTION)),
                        cSectExercises.getString(
                                cSectExercises.getColumnIndex(ExercisesTable.COLUMN_WORDING)),
                        cSectExercises.getString(
                                cSectExercises.getColumnIndex(ExercisesTable.COLUMN_SOLUTION)),
                        cSectExercises.getString(
                                cSectExercises.getColumnIndex(ExercisesTable.COLUMN_TIP)),
                        cSectExercises.getString(
                                cSectExercises.getColumnIndex(ExercisesTable.COLUMN_OPTIONS))
                ));
            } while (cSectExercises.moveToNext());
        }
        CursorUtils.closeCursor(cSectExercises);
        Collections.shuffle(listExercises);
        return listExercises.size() > numExercises ?
                new ArrayList<>(listExercises.subList(0, numExercises)) :
                listExercises;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager =
                    (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    private void updateExercises() {
        new ApiGetterExercises(this).execute(level);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        return;
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        return;
    }

    private class EvaluateExerciseClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (isOkEvaluateExercise()) {
                evaluateExercise();
            }
        }
    }

    private class ExerciseChangeListener extends ViewPager.SimpleOnPageChangeListener {

        @Override
        public void onPageSelected(int positionExercise) {
            eventOnPageSelected(positionExercise);
        }
    }

    private class NextExerciseClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int exercisesMiss = exercisesDone - exercisesOk;
            String exercisesLeft = String.valueOf(exercises.size() - exercisesDone);
            if (exercisesMiss == NUMBER_MAX_EXERCISES_FAIL && isUpgradeLevel()) {
                returnLevelActivity(false);
            } else if (exercisesPage.getCurrentItem() == exercises.size() - 1) {
                if (isUpgradeLevel())
                    unblockLevel();
                else {
                    showResults();
                }
            } else {
                divTip.setVisibility(View.INVISIBLE);
                isExerciseEvaluated = false;
                exercisesPage.setCurrentItem(exercisesPage.getCurrentItem() + 1);
                textExercises.setText("Left: " + exercisesLeft +
                        " - Missed: " + String.valueOf(exercisesMiss));
            }
        }
    }

    private class ApiGetterExercises extends AsyncTask<String, Void, ArrayList<String>> {

        private static final String PARAM_LEVEL = "pLevel";
        private ProgressDialog updatingExercisesBox;
        private Context context;

        public ApiGetterExercises(Context context) {
            this.context = context;
        }

        @Override
        protected ArrayList<String> doInBackground(String... params) {
            String level = params[0];
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://crypto-plane-693.appspot.com/exercises");
            ArrayList<String> exercisesList = new ArrayList<>();
            try {
                List<NameValuePair> nameValuePairs = new ArrayList<>();
                nameValuePairs.add(new BasicNameValuePair(PARAM_LEVEL, level));
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpClient.execute(httpPost);
                String jsonString = EntityUtils.toString(response.getEntity());
                JSONArray jsonArray = new JSONArray(jsonString);
                for (int i = 0; i < jsonArray.length(); i++) {
                    exercisesList.add(jsonArray.getString(i));
                }
            } catch (ClientProtocolException e) {
                return null;
            } catch (IOException e) {
                return null;
            } catch (JSONException e) {
                return null;
            }
            return exercisesList;
        }

        @Override
        protected void onPreExecute() {
            updatingExercisesBox = ProgressDialog.show(this.context,
                    "Updating exercises", "please wait...", true);
        }

        @Override
        protected void onPostExecute(ArrayList<String> exercisesList) {
            if (exercisesList == null) {
                Toast eToast = Toast.makeText(this.context,
                        "Data haven't been updated, try again later.",
                        Toast.LENGTH_LONG);
                eToast.show();
                isExercisesUpdated = false;
            } else {
                Uri exerciseUri = EtdContentProvider.CONTENT_URI_EXERCISE;
                ContentValues values = new ContentValues();
                Gson gson = new Gson();
                for (String exerciseJson : exercisesList) {
                    final ExerciseObj exercise = gson.fromJson(exerciseJson, ExerciseObj.class);
                    values.put(ExercisesTable.COLUMN_ID_LESSON, exercise.getIdLesson());
                    values.put(ExercisesTable.COLUMN_VERSION_CODE, exercise.getVersion());
                    values.put(ExercisesTable.COLUMN_LEVEL, exercise.getLevel());
                    values.put(ExercisesTable.COLUMN_EXERCISE_TYPE, exercise.getExerciseType());
                    values.put(ExercisesTable.COLUMN_QUESTION, exercise.getQuestion());
                    values.put(ExercisesTable.COLUMN_WORDING, exercise.getWording());
                    values.put(ExercisesTable.COLUMN_SOLUTION, exercise.getSolution());
                    values.put(ExercisesTable.COLUMN_TIP, exercise.getTip());
                    values.put(ExercisesTable.COLUMN_OPTIONS, exercise.getOptions());
                    getContentResolver().insert(exerciseUri, values);
                    values.clear();
                }
                isExercisesUpdated = true;
                SharedPreferences settings = getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString(PREFERENCE_EXERCISE_VERSION + level, apiVersion);
                editor.putBoolean(STATE_EXERCISES_UPDATED, isExercisesUpdated);
                editor.commit();
                Log.i("DATABASE", "EXERCISES COMMIT");
            }
            if (isExercisesUpdated)
                setupExercises();
            updatingExercisesBox.dismiss();
        }
    }
}


