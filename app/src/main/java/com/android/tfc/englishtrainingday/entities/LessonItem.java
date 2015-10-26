package com.android.tfc.englishtrainingday.entities;

import java.util.ArrayList;

public class LessonItem {

    private final ArrayList<SectionItem> sections = new ArrayList<>();
    private int idLesson;
    private String lessonName;

    public LessonItem(int idLesson, String lessonName) {
        this.idLesson = idLesson;
        this.lessonName = lessonName;
    }

    public void addSection(int idSection, String sectionName) {
        this.sections.add(new SectionItem(idSection, sectionName));
    }

    public int getIdLesson() {
        return idLesson;
    }

    public String getLessonName() {
        return lessonName;
    }

    public SectionItem getSection(int position) {
        return sections.get(position);
    }

    public int countSections() {
        return this.sections.size();
    }
}
