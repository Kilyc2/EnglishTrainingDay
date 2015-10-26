package com.android.tfc.englishtrainingday.data.ExercisesDataController;

import com.android.tfc.englishtrainingday.data.ExercisesData.LevelB1.ExercisesLesson1;

import java.util.ArrayList;

public class B1ExercisesDataController {

    public static ArrayList<String> getAllExercises() {
        ArrayList<String> exercises = new ArrayList<>();
        exercises.addAll(ExercisesLesson1.getExercises());
        return exercises;
    }
}
