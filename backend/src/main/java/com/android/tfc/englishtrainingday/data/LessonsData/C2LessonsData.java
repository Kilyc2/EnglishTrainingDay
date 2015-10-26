package com.android.tfc.englishtrainingday.data.LessonsData;

import com.android.tfc.englishtrainingday.data.SectionsData.C2SectionsData;
import com.android.tfc.englishtrainingday.entities.LessonObj;
import com.google.gson.Gson;

import java.util.ArrayList;

public class C2LessonsData {

    public static ArrayList<String> getLessons() {
        ArrayList<String> lessonsList = new ArrayList<>();
        Gson gson = new Gson();
        lessonsList.add(gson.toJson(new LessonObj(3201,
                "C2", "Dummy Lesson 1", "00001", C2SectionsData.getLesson1Sections())));
        lessonsList.add(gson.toJson(new LessonObj(3202,
                "C2", "Dummy Lesson 2", "00001", C2SectionsData.getLesson2Sections())));
        lessonsList.add(gson.toJson(new LessonObj(3203,
                "C2", "Dummy Lesson 3", "00001", C2SectionsData.getLesson3Sections())));
        lessonsList.add(gson.toJson(new LessonObj(3204,
                "C2", "Dummy Lesson 4", "00001", C2SectionsData.getLesson4Sections())));
        lessonsList.add(gson.toJson(new LessonObj(3205,
                "C2", "Dummy Lesson 5", "00001", C2SectionsData.getLesson5Sections())));
        lessonsList.add(gson.toJson(new LessonObj(3206,
                "C2", "Dummy Lesson 6", "00001", C2SectionsData.getLesson6Sections())));
        return lessonsList;
    }
}
