package com.android.tfc.englishtrainingday.entities;

import java.util.ArrayList;

public class SectionObj {

    private int idSection;
    private String level;
    private int idLesson;
    private String name;
    private ArrayList<SectionTabObj> tabs;

    public SectionObj() {
    }

    public int getIdSection() {
        return idSection;
    }

    public String getLevel() {
        return level;
    }

    public int getIdLesson() {
        return idLesson;
    }

    public String getName() {
        return name;
    }

    public ArrayList<SectionTabObj> getTabs() {
        return tabs;
    }
}
