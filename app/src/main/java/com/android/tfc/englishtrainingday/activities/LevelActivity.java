package com.android.tfc.englishtrainingday.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.android.tfc.englishtrainingday.R;
import com.android.tfc.englishtrainingday.utils.Constants;

public class LevelActivity extends Activity implements View.OnClickListener {

    public final static String UPGRADE_LEVEL = "pUpgradeLevel";
    public static Activity levelActivity;
    private RelativeLayout message;
    private String[] levels = new String[]{"A2", "B1", "B2", "C1", "C2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        levelActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        if (GrammarActivity.grammarActivity != null)
            GrammarActivity.grammarActivity.finish();
        if (MainActivity.mainActivity != null)
            MainActivity.mainActivity.finish();
        unblockLevel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        unblockLevel();
    }

    @Override
    public void onClick(View view) {
        SharedPreferences settings =
                getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        String level = "";
        boolean isLevelSelectedBlocked = false;
        switch (view.getId()) {
            case R.id.buttonLevelA1:
                level = "A1";
                isLevelSelectedBlocked = false;
                break;
            case R.id.buttonLevelA2:
                level = "A2";
                isLevelSelectedBlocked = false;
                break;
            case R.id.buttonLevelB1:
                level = "B1";
                isLevelSelectedBlocked = false;
                break;
            case R.id.buttonLevelB2:
                level = "B2";
                isLevelSelectedBlocked = false;
                break;
            case R.id.buttonLevelC1:
                level = "C1";
                isLevelSelectedBlocked = false;
                break;
            case R.id.buttonLevelC2:
                level = "C2";
                isLevelSelectedBlocked = false;
                break;
            case R.id.buttonLevelA2Block:
                level = "A1";
                isLevelSelectedBlocked = true;
                break;
            case R.id.buttonLevelB1Block:
                level = "A2";
                isLevelSelectedBlocked = true;
                break;
            case R.id.buttonLevelB2Block:
                level = "B1";
                isLevelSelectedBlocked = true;
                break;
            case R.id.buttonLevelC1Block:
                level = "B2";
                isLevelSelectedBlocked = true;
                break;
            case R.id.buttonLevelC2Block:
                level = "C1";
                isLevelSelectedBlocked = true;
                break;
            case R.id.lblLevel:
                unblockAllLevels();
                return;
        }
        if (!isLevelSelectedBlocked) {
            editor.putString(Constants.LEVEL_SELECTED, level);
            editor.apply();
            goToGrammar(level);
        } else {
            goToExercises(level);
        }
    }

    private void goToExercises(String levelSelected) {
        Intent intent = new Intent(LevelActivity.this, ExercisesActivity.class);
        Bundle args = new Bundle();
        args.putString(Constants.LEVEL_SELECTED, levelSelected);
        args.putInt(Constants.ID_LESSON, 0);
        intent.putExtras(args);
        startActivity(intent);
    }

    private void goToGrammar(String levelSelected) {
        Intent intent = new Intent(LevelActivity.this, GrammarActivity.class);
        Bundle args = new Bundle();
        args.putString(Constants.LEVEL_SELECTED, levelSelected);
        intent.putExtras(args);
        startActivity(intent);
    }

    private void unblockLevel() {
        SharedPreferences preferenceInitial =
                getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
        for (int i = 4; i >= 0; i--) {
            if (preferenceInitial.getBoolean(Constants.LEVEL_BLOCKED + levels[i], false)) {
                switch (i) {
                    case 4:
                        findViewById(R.id.buttonLevelC2Block).setVisibility(View.INVISIBLE);
                    case 3:
                        findViewById(R.id.buttonLevelC1Block).setVisibility(View.INVISIBLE);
                    case 2:
                        findViewById(R.id.buttonLevelB2Block).setVisibility(View.INVISIBLE);
                    case 1:
                        findViewById(R.id.buttonLevelB1Block).setVisibility(View.INVISIBLE);
                    case 0:
                        findViewById(R.id.buttonLevelA2Block).setVisibility(View.INVISIBLE);
                        break;
                }
                break;
            }
        }
    }

    private void unblockAllLevels() {
        findViewById(R.id.buttonLevelC2Block).setVisibility(View.INVISIBLE);
        findViewById(R.id.buttonLevelC1Block).setVisibility(View.INVISIBLE);
        findViewById(R.id.buttonLevelB2Block).setVisibility(View.INVISIBLE);
        findViewById(R.id.buttonLevelB1Block).setVisibility(View.INVISIBLE);
        findViewById(R.id.buttonLevelA2Block).setVisibility(View.INVISIBLE);
        SharedPreferences settings =
                getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(Constants.LEVEL_BLOCKED + "C2", true);
        editor.apply();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            Button closeButton;
            boolean isLevelUpgrade = bundle.getBoolean(UPGRADE_LEVEL);
            if (isLevelUpgrade) {
                message = (RelativeLayout) findViewById(R.id.div_upgrade_ok);
                closeButton = (Button) message.findViewById(R.id.button_close_ok);
            } else {
                message = (RelativeLayout) findViewById(R.id.div_upgrade_miss);
                closeButton = (Button) message.findViewById(R.id.button_close_miss);
            }
            message.setVisibility(View.VISIBLE);
            closeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    message.setVisibility(View.INVISIBLE);
                }
            });
        }
    }
}