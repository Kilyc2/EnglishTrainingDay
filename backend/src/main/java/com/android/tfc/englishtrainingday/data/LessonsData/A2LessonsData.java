package com.android.tfc.englishtrainingday.data.LessonsData;

import com.android.tfc.englishtrainingday.data.SectionsData.A2SectionsData;
import com.android.tfc.englishtrainingday.entities.LessonObj;
import com.google.gson.Gson;

import java.util.ArrayList;


public class A2LessonsData {

    public static ArrayList<String> getLessons() {
        ArrayList<String> lessonsList = new ArrayList<>();
        Gson gson = new Gson();
        lessonsList.add(gson.toJson(new LessonObj(1201,
                "A2", "Verbs", "00001", A2SectionsData.getLesson1Sections())));
        lessonsList.add(gson.toJson(new LessonObj(1202,
                "A2", "Irregular Verbs", "00001", A2SectionsData.getLesson2Sections())));
        lessonsList.add(gson.toJson(new LessonObj(1203,
                "A2", "Sentence Structure", "00001", A2SectionsData.getLesson3Sections())));
        lessonsList.add(gson.toJson(new LessonObj(1204,
                "A2", "Numbers, Dates and Time", "00001", A2SectionsData.getLesson4Sections())));
        lessonsList.add(gson.toJson(new LessonObj(1205,
                "A2", "Adverbs", "00001", A2SectionsData.getLesson5Sections())));
        lessonsList.add(gson.toJson(new LessonObj(1206,
                "A2", "Relative and Indefinite Pronouns", "00001", A2SectionsData.getLesson6Sections())));
        lessonsList.add(gson.toJson(new LessonObj(1207,
                "A2", "Conjunctions", "00001", A2SectionsData.getLesson7Sections())));
        lessonsList.add(gson.toJson(new LessonObj(1208,
                "A2", "Comparatives and Superlatives", "00001", A2SectionsData.getLesson8Sections())));
        return lessonsList;
    }
}
