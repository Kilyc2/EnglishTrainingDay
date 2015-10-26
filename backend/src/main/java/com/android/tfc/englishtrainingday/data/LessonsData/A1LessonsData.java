package com.android.tfc.englishtrainingday.data.LessonsData;

import com.android.tfc.englishtrainingday.data.SectionsData.A1SectionsData;
import com.android.tfc.englishtrainingday.entities.LessonObj;
import com.google.gson.Gson;

import java.util.ArrayList;

public class A1LessonsData {

    public static ArrayList<String> getLessons() {
        ArrayList<String> lessonsList = new ArrayList<>();
        Gson gson = new Gson();
        lessonsList.add(gson.toJson(new LessonObj(1101,
                "A1", "Pronouns", "00001", A1SectionsData.getLesson1Sections())));
        lessonsList.add(gson.toJson(new LessonObj(1102,
                "A1", "The Article", "00001", A1SectionsData.getLesson2Sections())));
        lessonsList.add(gson.toJson(new LessonObj(1103,
                "A1", "Prepositions", "00001", A1SectionsData.getLesson3Sections())));
        lessonsList.add(gson.toJson(new LessonObj(1104,
                "A1", "Nouns", "00001", A1SectionsData.getLesson4Sections())));
        lessonsList.add(gson.toJson(new LessonObj(1105,
                "A1", "Adjectives", "00001", A1SectionsData.getLesson5Sections())));
        lessonsList.add(gson.toJson(new LessonObj(1106,
                "A1", "Travel Vocabulary", "00001", A1SectionsData.getLesson6Sections())));
        lessonsList.add(gson.toJson(new LessonObj(1107,
                "A1", "Christmas Vocabulary", "00001", A1SectionsData.getLesson7Sections())));
        return lessonsList;
    }
}
