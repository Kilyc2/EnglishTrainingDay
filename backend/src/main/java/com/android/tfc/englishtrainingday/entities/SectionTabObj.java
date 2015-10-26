package com.android.tfc.englishtrainingday.entities;

public class SectionTabObj {

    private int idSectionTab;
    private String level;
    private int idSection;
    private String nameTab;
    private String textTab;

    public SectionTabObj(int idSectionTab, String level, int idSection, String nameTab, String textTab) {
        this.idSectionTab = idSectionTab;
        this.level = level;
        this.idSection = idSection;
        this.nameTab = nameTab;
        this.textTab = textTab;
    }
}
