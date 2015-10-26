package com.android.tfc.englishtrainingday.entities;

import java.util.ArrayList;

public class SectionObj {

    private int idSection;
    private String level;
    private int idLesson;
    private String name;
    private ArrayList<SectionTabObj> tabs;

    public SectionObj(int idSection, String level, int idLesson, String name, ArrayList<SectionTabObj> tabs) {
        this.idSection = idSection;
        this.level = level;
        this.idLesson = idLesson;
        this.name = name;
        this.tabs = tabs;
    }
}
