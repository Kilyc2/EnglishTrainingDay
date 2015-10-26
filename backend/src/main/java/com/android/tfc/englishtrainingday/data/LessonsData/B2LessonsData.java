package com.android.tfc.englishtrainingday.data.LessonsData;

import com.android.tfc.englishtrainingday.data.SectionsData.B2SectionsData;
import com.android.tfc.englishtrainingday.entities.LessonObj;
import com.google.gson.Gson;

import java.util.ArrayList;

public class B2LessonsData {

    public static ArrayList<String> getLessons() {
        ArrayList<String> lessonsList = new ArrayList<>();
        Gson gson = new Gson();
        lessonsList.add(gson.toJson(new LessonObj(2201,
                "B2", "Dummy Lesson 1", "00001", B2SectionsData.getLesson1Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2202,
                "B2", "Dummy Lesson 2", "00001", B2SectionsData.getLesson2Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2203,
                "B2", "Dummy Lesson 3", "00001", B2SectionsData.getLesson3Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2204,
                "B2", "Dummy Lesson 4", "00001", B2SectionsData.getLesson4Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2205,
                "B2", "Dummy Lesson 5", "00001", B2SectionsData.getLesson5Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2206,
                "B2", "Dummy Lesson 6", "00001", B2SectionsData.getLesson6Sections())));
        return lessonsList;
    }
}
