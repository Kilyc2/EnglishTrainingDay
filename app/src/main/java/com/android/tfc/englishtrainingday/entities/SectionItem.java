package com.android.tfc.englishtrainingday.entities;

public class SectionItem {

    private int idSection;
    private String sectionName;
    private boolean isSelected;

    public SectionItem(int id, String name) {
        this.idSection = id;
        this.sectionName = name;
        this.isSelected = false;
    }

    public int getIdSection() {
        return idSection;
    }

    public String getSectionName() {
        return sectionName;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
