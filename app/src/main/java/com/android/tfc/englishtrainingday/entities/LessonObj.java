package com.android.tfc.englishtrainingday.entities;

import java.util.ArrayList;

public class LessonObj {

    private int idLesson;
    private String level;
    private String name;
    private String versionCode;
    private ArrayList<SectionObj> sections;

    public LessonObj() {
    }

    public int getIdLesson() {
        return idLesson;
    }

    public String getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public ArrayList<SectionObj> getSections() {
        return sections;
    }
}
