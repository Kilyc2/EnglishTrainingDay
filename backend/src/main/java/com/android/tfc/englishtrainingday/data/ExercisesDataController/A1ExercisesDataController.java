package com.android.tfc.englishtrainingday.data.ExercisesDataController;

import com.android.tfc.englishtrainingday.data.ExercisesData.LevelA1.ExercisesLesson1;
import com.android.tfc.englishtrainingday.data.ExercisesData.LevelA1.ExercisesLesson2;
import com.android.tfc.englishtrainingday.data.ExercisesData.LevelA1.ExercisesLesson3;

import java.util.ArrayList;

public class A1ExercisesDataController {

    public static ArrayList<String> getAllExercises() {
        ArrayList<String> exercises = new ArrayList<>();
        exercises.addAll(ExercisesLesson1.getExercises());
        exercises.addAll(ExercisesLesson2.getExercises());
        exercises.addAll(ExercisesLesson3.getExercises());
        return exercises;
    }
}
