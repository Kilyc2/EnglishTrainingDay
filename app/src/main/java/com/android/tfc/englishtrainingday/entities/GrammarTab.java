package com.android.tfc.englishtrainingday.entities;

public class GrammarTab {

    private int idLesson;
    private String nameTab;
    private String textTab;

    public GrammarTab(int idLesson, String nameTab, String textTab) {
        this.idLesson = idLesson;
        this.nameTab = nameTab;
        this.textTab = textTab;
    }

    public int getIdLesson() {
        return idLesson;
    }

    public String getNameTab() {
        return nameTab;
    }

    public String getTextTab() {
        return textTab;
    }
}
