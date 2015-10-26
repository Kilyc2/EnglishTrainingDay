package com.android.tfc.englishtrainingday.data.LessonsData;

import com.android.tfc.englishtrainingday.data.SectionsData.B1SectionsData;
import com.android.tfc.englishtrainingday.entities.LessonObj;
import com.google.gson.Gson;

import java.util.ArrayList;

public class B1LessonsData {

    public static ArrayList<String> getLessons() {
        ArrayList<String> lessonsList = new ArrayList<>();
        Gson gson = new Gson();
        lessonsList.add(gson.toJson(new LessonObj(2101,
                "B1", "Your world", "00001", B1SectionsData.getLesson1Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2102,
                "B1", "Memory", "00001", B1SectionsData.getLesson2Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2103,
                "B1", "Across the globe", "00001", B1SectionsData.getLesson3Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2104,
                "B1", "Real lives", "00001", B1SectionsData.getLesson4Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2105,
                "B1", "Go for it!", "00001", B1SectionsData.getLesson5Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2106,
                "B1", "True stories", "00001", B1SectionsData.getLesson6Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2107,
                "B1", "Must see!", "00001", B1SectionsData.getLesson7Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2108,
                "B1", "Social life", "00001", B1SectionsData.getLesson8Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2109,
                "B1", "Stuff!", "00001", B1SectionsData.getLesson9Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2110,
                "B1", "Society and change", "00001", B1SectionsData.getLesson10Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2111,
                "B1", "Rules", "00001", B1SectionsData.getLesson11Sections())));
        lessonsList.add(gson.toJson(new LessonObj(2112,
                "B1", "Your choice", "00001", B1SectionsData.getLesson12Sections())));
        return lessonsList;
    }
}
