package com.android.tfc.englishtrainingday.entities;

import java.util.ArrayList;

public class LessonObj {

    private int idLesson;
    private String level;
    private String name;
    private String versionCode;
    private ArrayList<SectionObj> sections;

    public LessonObj(int idLesson, String level, String name,
                     String versionCode, ArrayList<SectionObj> sections) {
        this.idLesson = idLesson;
        this.level = level;
        this.name = name;
        this.versionCode = versionCode;
        this.sections = sections;
    }
}
