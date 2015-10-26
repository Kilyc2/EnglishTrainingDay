package com.android.tfc.englishtrainingday.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.tfc.englishtrainingday.entities.ExerciseObj;
import com.android.tfc.englishtrainingday.fragments.ExerciseFragment;
import com.android.tfc.englishtrainingday.model.ExercisesTable;

import java.util.ArrayList;

public class ExercisesCollectionPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<ExerciseObj> listExercises;

    public ExercisesCollectionPagerAdapter(FragmentManager fm, ArrayList<ExerciseObj> listExercises) {
        super(fm);
        this.listExercises = listExercises;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment exerciseFragment = new ExerciseFragment();
        Bundle args = new Bundle();
        args.putInt(ExercisesTable.COLUMN_EXERCISE_TYPE, listExercises.get(position).getExerciseType());
        args.putString(ExercisesTable.COLUMN_QUESTION, listExercises.get(position).getQuestion());
        args.putString(ExercisesTable.COLUMN_WORDING, listExercises.get(position).getWording());
        args.putString(ExercisesTable.COLUMN_OPTIONS, listExercises.get(position).getOptions());
        args.putInt(ExerciseFragment.TAG, position);

        exerciseFragment.setArguments(args);
        return exerciseFragment;
    }

    @Override
    public int getCount() {
        return listExercises.size();
    }
}
