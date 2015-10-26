package com.android.tfc.englishtrainingday.data.LessonsData;

import com.android.tfc.englishtrainingday.data.SectionsData.C1SectionsData;
import com.android.tfc.englishtrainingday.entities.LessonObj;
import com.google.gson.Gson;

import java.util.ArrayList;

public class C1LessonsData {

    public static ArrayList<String> getLessons() {
        ArrayList<String> lessonsList = new ArrayList<>();
        Gson gson = new Gson();
        lessonsList.add(gson.toJson(new LessonObj(3101,
                "C1", "Dummy Lesson 1", "00001", C1SectionsData.getLesson1Sections())));
        lessonsList.add(gson.toJson(new LessonObj(3102,
                "C1", "Dummy Lesson 2", "00001", C1SectionsData.getLesson2Sections())));
        lessonsList.add(gson.toJson(new LessonObj(3103,
                "C1", "Dummy Lesson 3", "00001", C1SectionsData.getLesson3Sections())));
        lessonsList.add(gson.toJson(new LessonObj(3104,
                "C1", "Dummy Lesson 4", "00001", C1SectionsData.getLesson4Sections())));
        lessonsList.add(gson.toJson(new LessonObj(3105,
                "C1", "Dummy Lesson 5", "00001", C1SectionsData.getLesson5Sections())));
        lessonsList.add(gson.toJson(new LessonObj(3106,
                "C1", "Dummy Lesson 6", "00001", C1SectionsData.getLesson6Sections())));
        return lessonsList;
    }
}
