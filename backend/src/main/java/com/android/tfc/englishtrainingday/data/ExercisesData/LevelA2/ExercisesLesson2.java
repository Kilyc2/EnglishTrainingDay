package com.android.tfc.englishtrainingday.data.ExercisesData.LevelA2;


import com.android.tfc.englishtrainingday.entities.ExerciseObj;
import com.android.tfc.englishtrainingday.utils.VersionUtils;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ExercisesLesson2 {

    private final static int ID_LESSON = 1202;

    public static ArrayList<String> getExercises() {
        ArrayList<String> exercises = new ArrayList<>();
        Gson gson = new Gson();

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "A2", 4,
                "Put in the verb in the correct forms.",
                "Go",
                "Went;Gone",
                "Go - Went - Gone", "Past Simple;Past Participle"))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "A2", 4,
                "Put in the verb in the correct forms.",
                "Broken",
                "Break;Broke",
                "Break - Broke - Broken", "Infinitive;Past Simple"))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "A2", 4,
                "Put in the verb in the correct forms.",
                "Drank",
                "drink;drunk",
                "Drink - Drank - Drunk", "Infinitive;Past Participle"))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "A2", 4,
                "Put in the verb in the correct forms.",
                "Bet",
                "bet;bet",
                "Bet - Bet - Bet", "Past Simple;Past Participle"))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "A2", 4,
                "Put in the verb in the correct forms.",
                "Ridden",
                "Ride;Rode",
                "Ride - Rode - Ridden", "Infinitive;Past Simple"))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "A2", 4,
                "Put in the verb in the correct forms.",
                "Lend",
                "Lent;Lent",
                "Lend - Lent - Lent", "Past Simple;Past Participle"))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "A2", 4,
                "Put in the verb in the correct forms.",
                "Stung",
                "Sting;Stung",
                "Sting - Stung - Stung", "Infinitive;Past Simple"))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "A2", 3,
                "Choose the Past Simple and Past Participle.",
                "Eat",
                "Ate;Eaten",
                "Eat - Ate - Eaten", "Ate;Eat;Eaten;Atte"))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "A2", 3,
                "Choose the Past Simple and Past Participle.",
                "See",
                "Seen;Saw",
                "See - Saw - Seen", "Seed;Seen;Saw;Sawed"))));

        return exercises;
    }
}
