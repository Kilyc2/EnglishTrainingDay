package com.android.tfc.englishtrainingday.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.tfc.englishtrainingday.R;
import com.android.tfc.englishtrainingday.adapters.GrammarCollectionPagerAdapter;
import com.android.tfc.englishtrainingday.adapters.GrammarItemsAdapter;
import com.android.tfc.englishtrainingday.entities.GrammarTab;
import com.android.tfc.englishtrainingday.entities.LessonItem;
import com.android.tfc.englishtrainingday.entities.LessonObj;
import com.android.tfc.englishtrainingday.entities.SectionItem;
import com.android.tfc.englishtrainingday.entities.SectionObj;
import com.android.tfc.englishtrainingday.entities.SectionTabObj;
import com.android.tfc.englishtrainingday.model.EtdContentProvider;
import com.android.tfc.englishtrainingday.model.LessonsTable;
import com.android.tfc.englishtrainingday.model.SectionTabsTable;
import com.android.tfc.englishtrainingday.model.SectionsTable;
import com.android.tfc.englishtrainingday.utils.Constants;
import com.android.tfc.englishtrainingday.utils.CursorUtils;
import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
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
import java.util.List;

public class GrammarActivity extends FragmentActivity implements ActionBar.TabListener {

    private final static String PREFERENCE_LESSON_OK = "prefLessonOk";
    private final static String PREFERENCE_APP_VERSION = "prefAppVersion";
    private final static String PREFERENCE_LESSON_INI = "prefLessonInitial";
    private final static String PREFERENCE_SECTION_INI = "prefSectionInitial";
    private final static String STATE_DRAWER_OPEN = "stateDrawerOpen";
    public static Activity grammarActivity;
    private DrawerLayout leftMenu;
    private ExpandableListView lessonsList;
    private ActionBarDrawerToggle grammarActionBar;
    private boolean isChildPressed = true;
    private String grammarTitle;
    private SparseArray<LessonItem> sectionWithTabs = new SparseArray<>();
    private ViewPager tabsPager;
    private GrammarItemsAdapter grammarAdapter;
    private boolean isLessonLoaded;
    private boolean isLeftMenuOpen = false;
    private int lessonSelected;
    private int sectionSelected;
    private SectionItem childSelected;
    private String appVersion;
    private String levelSelected;
    private int idLessonSelected;
    private String nameLesson;
    private ApiGetterLessons apiGetterLessonsProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (MainActivity.mainActivity != null)
            MainActivity.mainActivity.finish();
        if (LevelActivity.levelActivity != null)
            LevelActivity.levelActivity.finish();
        grammarActivity = this;
        setContentView(R.layout.activity_grammar);
        Bundle bundle = this.getIntent().getExtras();
        this.levelSelected = bundle.getString(Constants.LEVEL_SELECTED);
        ActionBar aBar = getActionBar();
        aBar.setDisplayHomeAsUpEnabled(true);
        aBar.setHomeButtonEnabled(true);
        this.grammarTitle = Constants.APP_TITLE;
        setupDrawList();
        if (savedInstanceState != null) {
            this.isLeftMenuOpen =
                    savedInstanceState.getBoolean(STATE_DRAWER_OPEN + levelSelected, false);
            this.appVersion =
                    savedInstanceState.getString(PREFERENCE_APP_VERSION + levelSelected, "");
            this.lessonSelected =
                    savedInstanceState.getInt(PREFERENCE_LESSON_INI + levelSelected, 0);
            this.sectionSelected =
                    savedInstanceState.getInt(PREFERENCE_SECTION_INI + levelSelected, 0);
            this.isLessonLoaded =
                    savedInstanceState.getBoolean(PREFERENCE_LESSON_OK + levelSelected, false);
            restoreUI();
        } else {
            this.isLeftMenuOpen = false;
            SharedPreferences preferenceInitial =
                    getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
            String apiVersion =
                    preferenceInitial.getString(Constants.API_VERSION, "");
            this.appVersion =
                    preferenceInitial.getString(PREFERENCE_APP_VERSION + levelSelected, "");
            this.lessonSelected =
                    preferenceInitial.getInt(PREFERENCE_LESSON_INI + levelSelected, 0);
            this.sectionSelected =
                    preferenceInitial.getInt(PREFERENCE_SECTION_INI + levelSelected, 0);
            this.isLessonLoaded =
                    preferenceInitial.getBoolean(PREFERENCE_LESSON_OK + levelSelected, false);
            if (!apiVersion.isEmpty() || isLessonLoaded) {
                if (!apiVersion.equals(appVersion)) {
                    updateLessons();
                    SharedPreferences settings = getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString(PREFERENCE_APP_VERSION + levelSelected, apiVersion);
                    editor.apply();
                    appVersion = apiVersion;
                } else {
                    if (isLessonLoaded) {
                        try {
                            restoreUI();
                        } catch (Exception e) {
                            Toast eToast = Toast.makeText(this,
                                    "Data haven't been updated, try again later.",
                                    Toast.LENGTH_LONG);
                            eToast.show();
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(STATE_DRAWER_OPEN + levelSelected, this.isLeftMenuOpen);
        outState.putInt(PREFERENCE_LESSON_INI + levelSelected, this.lessonSelected);
        outState.putInt(PREFERENCE_SECTION_INI + levelSelected, this.sectionSelected);
        outState.putBoolean(PREFERENCE_LESSON_OK + levelSelected, this.isLessonLoaded);
        outState.putString(PREFERENCE_APP_VERSION + levelSelected, this.appVersion);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences initialPreferences =
                getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = initialPreferences.edit();
        editor.putInt(PREFERENCE_LESSON_INI + levelSelected, this.lessonSelected);
        editor.putInt(PREFERENCE_SECTION_INI + levelSelected, this.sectionSelected);
        editor.apply();
    }

    private void setupTabs() {
        final ActionBar aBar = getActionBar();
        ArrayList<GrammarTab> grammarTabs =
                getTabs(this.childSelected.getIdSection(), this.lessonSelected);
        if (grammarTabs.size() > 0) {
            aBar.removeAllTabs();
        }
        GrammarCollectionPagerAdapter mGrammarCollectionPagerAdapter =
                new GrammarCollectionPagerAdapter(getSupportFragmentManager(), grammarTabs);
        this.tabsPager = (ViewPager) findViewById(R.id.pager_grammar);
        this.tabsPager.setAdapter(mGrammarCollectionPagerAdapter);
        this.tabsPager.setOnPageChangeListener(new TabChangeListener());
        for (GrammarTab grammarTab : grammarTabs) {
            ActionBar.Tab tab = aBar.newTab().setText(grammarTab.getNameTab());
            tab.setTabListener(this);
            aBar.addTab(tab);
        }
        ImageButton buttonExercise = (ImageButton) findViewById(R.id.button_exercise);
        buttonExercise.setVisibility(View.VISIBLE);
        buttonExercise.setOnClickListener(new ExercisesClickListener());
    }

    private void setupDrawList() {
        getSectionsWithTabs();
        this.leftMenu = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.lessonsList = (ExpandableListView) findViewById(R.id.left_drawer);
        this.grammarAdapter = new GrammarItemsAdapter(this, this.sectionWithTabs);
        this.lessonsList.setAdapter(this.grammarAdapter);
        this.lessonsList.setOnChildClickListener(new SectionClickListener());
        grammarActionBar = new GrammarActionBar(this, leftMenu, R.drawable.ic_drawer,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.leftMenu.setDrawerListener(grammarActionBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.grammar_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean isLeftMenuShowed = leftMenu.isDrawerOpen(lessonsList);
        if (isLeftMenuShowed)
            menu.findItem(R.id.action_perfil).setVisible(false);
        else
            menu.findItem(R.id.action_perfil).setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (this.grammarActionBar.onOptionsItemSelected(item)) {
            return true;
        }
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_perfil:
                intent = new Intent(GrammarActivity.this, ScoreActivity.class);
                Bundle args = new Bundle();
                args.putString(Constants.LEVEL_SELECTED, levelSelected);
                intent.putExtras(args);
                startActivity(intent);
                return true;
            case R.id.action_update_lessons:

                updateLessons();
                return true;
            case R.id.action_change_level:
                SharedPreferences settings =
                        getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString(Constants.LEVEL_SELECTED, "");
                editor.apply();
                intent = new Intent(GrammarActivity.this, LevelActivity.class);
                startActivity(intent);
                return true;
        }
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.grammarActionBar.syncState();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.grammarActionBar.onConfigurationChanged(newConfig);
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.i("ActionBar", tab.getText() + " reseleccionada.");
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.i("ActionBar", tab.getText() + " seleccionada.");
        tabsPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.i("ActionBar", tab.getText() + " deseleccionada.");
    }

    private void getSectionsWithTabs() {
        String[] columnsQueryLesson = new String[]{LessonsTable._ID, LessonsTable.COLUMN_NAME};
        String[] columnsQuerySections = new String[]{SectionsTable._ID, SectionsTable.COLUMN_NAME};
        Uri lessonUri = EtdContentProvider.CONTENT_URI_LESSON;
        Uri sectionUri = EtdContentProvider.CONTENT_URI_SECTION;
        String[] argLevelSelected = new String[]{this.levelSelected};
        Cursor cursorLesson = getContentResolver().query(lessonUri, columnsQueryLesson,
                LessonsTable.COLUMN_LEVEL + " = ?", argLevelSelected, null);
        Log.i("DATABASE", "QUERY ITEMS");
        LessonItem lessonItem;
        int indexLesson = 0;
        if (CursorUtils.isValidCursor(cursorLesson)) {
            do {
                String lessonName = cursorLesson.getString(
                        cursorLesson.getColumnIndex(LessonsTable.COLUMN_NAME));
                int idLesson = cursorLesson.getInt(cursorLesson.getColumnIndex(LessonsTable._ID));
                lessonItem = new LessonItem(idLesson, lessonName);
                String[] argIdLesson = new String[]{String.valueOf(idLesson)};
                Cursor cursorSection = getContentResolver().query(sectionUri, columnsQuerySections,
                        SectionsTable.COLUMN_ID_LESSON + " = ?", argIdLesson, null);
                if (CursorUtils.isValidCursor(cursorSection)) {
                    do {
                        lessonItem.addSection(
                                cursorSection.getInt(
                                        cursorSection.getColumnIndex(SectionsTable._ID)),
                                cursorSection.getString(
                                        cursorSection.getColumnIndex(SectionsTable.COLUMN_NAME)));
                    } while (cursorSection.moveToNext());
                }
                CursorUtils.closeCursor(cursorSection);
                sectionWithTabs.append(indexLesson++, lessonItem);
            } while (cursorLesson.moveToNext());
        }
        CursorUtils.closeCursor(cursorLesson);
    }

    private ArrayList<GrammarTab> getTabs(int idSection, int idLesson) {
        ArrayList<GrammarTab> listGrammarTabs = new ArrayList<>();
        Uri sectionTabsUri = EtdContentProvider.CONTENT_URI_SECTION_TAB;
        String[] colSectTabs = new String[]{SectionTabsTable.COLUMN_NAME_TAB,
                SectionTabsTable.COLUMN_TEXT_TAB};
        String[] selArgs = new String[]{String.valueOf(idSection)};
        Cursor cSectTabs = getContentResolver().query(sectionTabsUri, colSectTabs,
                SectionTabsTable.COLUMN_ID_SECTION + " = ?", selArgs, null);
        if (CursorUtils.isValidCursor(cSectTabs)) {
            do {
                listGrammarTabs.add(new GrammarTab(idLesson,
                        cSectTabs.getString(
                                cSectTabs.getColumnIndex(SectionTabsTable.COLUMN_NAME_TAB)),
                        cSectTabs.getString(
                                cSectTabs.getColumnIndex(SectionTabsTable.COLUMN_TEXT_TAB))
                ));
            } while (cSectTabs.moveToNext());
        }
        CursorUtils.closeCursor(cSectTabs);
        return listGrammarTabs;
    }

    private void updateLessons() {
        apiGetterLessonsProcess = new ApiGetterLessons(this);
        apiGetterLessonsProcess.execute(levelSelected);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (apiGetterLessonsProcess != null &&
                    apiGetterLessonsProcess.getStatus() == AsyncTask.Status.RUNNING) {
                apiGetterLessonsProcess.cancel(true);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void restoreUI() {
        setupDrawList();
        if (!grammarAdapter.isEmpty()) {
            idLessonSelected = ((LessonItem) grammarAdapter.getGroup(this.lessonSelected)).getIdLesson();
            nameLesson = ((LessonItem) grammarAdapter.getGroup(this.lessonSelected)).getLessonName();
            childSelected = (SectionItem) grammarAdapter.getChild(
                    this.lessonSelected, sectionSelected);
            grammarTitle = childSelected.getSectionName();
            childSelected.setSelected(true);
            if (!isLeftMenuOpen) {
                getActionBar().setTitle(grammarTitle);
                getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
                setupTabs();
            } else {
                getActionBar().setTitle(Constants.APP_TITLE);
                getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
                lessonsList.setSelectedGroup(this.lessonSelected);
                lessonsList.setSelected(true);
                lessonsList.expandGroup(this.lessonSelected);
            }
        }
    }

    private class TabChangeListener extends ViewPager.SimpleOnPageChangeListener {

        @Override
        public void onPageSelected(int position) {
            ActionBar aBar = getActionBar();
            aBar.setSelectedNavigationItem(position);
        }
    }

    private class ExercisesClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(GrammarActivity.this, ExercisesActivity.class);
            Bundle args = new Bundle();
            args.putString(Constants.LEVEL_SELECTED, levelSelected);
            args.putInt(Constants.ID_LESSON, idLessonSelected);
            args.putString(Constants.NAME_LESSON, nameLesson);
            intent.putExtras(args);
            startActivity(intent);
        }
    }

    private class SectionClickListener implements
            ExpandableListView.OnChildClickListener {

        @Override
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                                    int childPosition, long id) {
            grammarAdapter.deselectedChildren();
            lessonSelected = groupPosition;
            sectionSelected = childPosition;
            childSelected = (SectionItem) grammarAdapter.getChild(lessonSelected, sectionSelected);
            ActionBar aBar = getActionBar();
            grammarTitle = childSelected.getSectionName();
            childSelected.setSelected(true);
            aBar.setTitle(grammarTitle);
            aBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            idLessonSelected = ((LessonItem) grammarAdapter.getGroup(lessonSelected)).getIdLesson();
            nameLesson = ((LessonItem) grammarAdapter.getGroup(lessonSelected)).getLessonName();
            leftMenu.closeDrawer(lessonsList);
            isChildPressed = true;
            return true;
        }
    }

    private class GrammarActionBar extends ActionBarDrawerToggle {

        public GrammarActionBar(Activity activity, DrawerLayout drawerLayout, int drawerImageRes,
                                int openDrawerContentDescRes, int closeDrawerContentDescRes) {
            super(activity, drawerLayout, drawerImageRes, openDrawerContentDescRes,
                    closeDrawerContentDescRes);
        }

        public void onDrawerClosed(View drawerView) {
            getActionBar().setTitle(grammarTitle);
            if (!grammarTitle.equals(Constants.APP_TITLE)) {
                getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
                if (isChildPressed)
                    setupTabs();
            }
            isLeftMenuOpen = false;
            ActivityCompat.invalidateOptionsMenu(GrammarActivity.this);
        }

        public void onDrawerOpened(View drawerView) {
            getActionBar().setTitle(Constants.APP_TITLE);
            getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
            isChildPressed = false;
            isLeftMenuOpen = true;
            if (!grammarAdapter.isEmpty()) {
                lessonsList.setSelectedGroup(lessonSelected);
                lessonsList.setSelected(true);
                lessonsList.expandGroup(lessonSelected);
            }
            ActivityCompat.invalidateOptionsMenu(GrammarActivity.this);
        }
    }

    private class ApiGetterLessons extends AsyncTask<String, Void, ArrayList<String>> {
        private static final String PARAM_LEVEL = "pLevel";
        private ProgressDialog updatingLessonBox;
        private Context context;
        private String level;

        public ApiGetterLessons(Context context) {
            this.context = context;
        }

        @Override
        protected ArrayList<String> doInBackground(String... params) {
            level = params[0];
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://crypto-plane-693.appspot.com/lessons");
            ArrayList<String> lessonsList = new ArrayList<>();
            try {
                List<NameValuePair> nameValuePairs = new ArrayList<>(1);
                nameValuePairs.add(new BasicNameValuePair(PARAM_LEVEL, level));
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpClient.execute(httpPost);
                String jsonString = EntityUtils.toString(response.getEntity());
                JSONArray jsonArray = new JSONArray(jsonString);
                for (int i = 0; i < jsonArray.length(); i++) {
                    lessonsList.add(jsonArray.getString(i));
                }
            } catch (JSONException e) {
                return null;
            } catch (IOException e) {
                return null;
            }
            return lessonsList;
        }

        @Override
        protected void onPreExecute() {
            updatingLessonBox = ProgressDialog.show(this.context,
                    "Updating lessons", "please wait...", true);
        }

        @Override
        protected void onPostExecute(ArrayList<String> lessonsList) {
            if (lessonsList == null) {
                Toast eToast = Toast.makeText(this.context,
                        "Data haven't been updated, try again later.",
                        Toast.LENGTH_LONG);
                eToast.show();
            } else {
                Uri lessonUri = EtdContentProvider.CONTENT_URI_LESSON;
                Uri sectionUri = EtdContentProvider.CONTENT_URI_SECTION;
                Uri sectionTabUri = EtdContentProvider.CONTENT_URI_SECTION_TAB;
                ContentValues values = new ContentValues();
                Gson gson = new Gson();
                String[] argsLevel = new String[]{level};
                getContentResolver().delete(lessonUri,
                        LessonsTable.COLUMN_LEVEL + " = ?", argsLevel);
                getContentResolver().delete(sectionUri,
                        SectionsTable.COLUMN_LEVEL + " = ?", argsLevel);
                getContentResolver().delete(sectionTabUri,
                        SectionTabsTable.COLUMN_LEVEL + " = ?", argsLevel);
                for (String lessonJson : lessonsList) {
                    final LessonObj lesson = gson.fromJson(lessonJson, LessonObj.class);
                    values.put(LessonsTable._ID, lesson.getIdLesson());
                    values.put(LessonsTable.COLUMN_LEVEL, lesson.getLevel());
                    values.put(LessonsTable.COLUMN_NAME, lesson.getName());
                    values.put(LessonsTable.COLUMN_VERSION_CODE, lesson.getVersionCode());
                    getContentResolver().insert(lessonUri, values);
                    values.clear();
                    for (SectionObj section : lesson.getSections()) {
                        values.put(SectionsTable._ID, section.getIdSection());
                        values.put(SectionsTable.COLUMN_LEVEL, section.getLevel());
                        values.put(SectionsTable.COLUMN_ID_LESSON, section.getIdLesson());
                        values.put(SectionsTable.COLUMN_NAME, section.getName());
                        getContentResolver().insert(sectionUri, values);
                        values.clear();
                        for (SectionTabObj sectionTab : section.getTabs()) {
                            values.put(SectionTabsTable._ID, sectionTab.getIdSectionTab());
                            values.put(SectionTabsTable.COLUMN_LEVEL, sectionTab.getLevel());
                            values.put(SectionTabsTable.COLUMN_ID_SECTION, sectionTab.getIdSection());
                            values.put(SectionTabsTable.COLUMN_NAME_TAB, sectionTab.getNameTab());
                            values.put(SectionTabsTable.COLUMN_TEXT_TAB, sectionTab.getTextTab());
                            getContentResolver().insert(sectionTabUri, values);
                            values.clear();
                        }
                    }
                }
                SharedPreferences settings = getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                isLessonLoaded = true;
                editor.putBoolean(PREFERENCE_LESSON_OK + levelSelected, isLessonLoaded);
                editor.apply();
                lessonSelected = 0;
                sectionSelected = 0;
            }
            if (isLessonLoaded)
                try {
                    restoreUI();
                } catch (Exception e) {
                    Toast eToast = Toast.makeText(this.context,
                            "Data haven't been updated, try again later.",
                            Toast.LENGTH_LONG);
                    eToast.show();
                }
            updatingLessonBox.dismiss();
        }
    }
}