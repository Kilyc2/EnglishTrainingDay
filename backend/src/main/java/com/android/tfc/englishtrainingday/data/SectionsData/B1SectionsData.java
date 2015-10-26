package com.android.tfc.englishtrainingday.data.SectionsData;

import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson1.Lesson1Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson1.Lesson1Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson10.Lesson10Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson10.Lesson10Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson11.Lesson11Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson11.Lesson11Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson12.Lesson12Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson12.Lesson12Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson2.Lesson2Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson2.Lesson2Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson3.Lesson3Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson3.Lesson3Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson4.Lesson4Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson4.Lesson4Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson5.Lesson5Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson5.Lesson5Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson6.Lesson6Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson6.Lesson6Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson7.Lesson7Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson7.Lesson7Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson8.Lesson8Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson8.Lesson8Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson9.Lesson9Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson9.Lesson9Section2TabsData;
import com.android.tfc.englishtrainingday.entities.SectionObj;

import java.util.ArrayList;

public class B1SectionsData {
    //TODO fill in the methods with the sections' data
    public static ArrayList<SectionObj> getLesson1Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(210101, "B1", 2101,
                "Questions and short answers", Lesson1Section1TabsData.getTabs()));
        sections.add(new SectionObj(210102, "B1", 2101,
                "Present simple and Present continuous", Lesson1Section2TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson2Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(210201, "B1", 2102,
                "Past simple and Past continuous", Lesson2Section1TabsData.getTabs()));
        sections.add(new SectionObj(210202, "B1", 2102,
                "Contrasting past and present", Lesson2Section2TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson3Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(210301, "B1", 2103,
                "Comparative and superlative adjectives", Lesson3Section1TabsData.getTabs()));
        sections.add(new SectionObj(210302, "B1", 2103,
                "Different ways of comparing", Lesson3Section2TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson4Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(210401, "B1", 2104,
                "Present perfect simple and Past simple", Lesson4Section1TabsData.getTabs()));
        sections.add(new SectionObj(210402, "B1", 2104,
                "Present perfect continuous", Lesson4Section2TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson5Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(210501, "B1", 2105,
                "Future forms for plans and intentions", Lesson5Section1TabsData.getTabs()));
        sections.add(new SectionObj(210502, "B1", 2105,
                "Future clauses with if, when, unless, etc.", Lesson5Section2TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson6Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(210601, "B1", 2106,
                "Past perfect", Lesson6Section1TabsData.getTabs()));
        sections.add(new SectionObj(210602, "B1", 2106,
                "Reported speech and reported questions", Lesson6Section2TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson7Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(210701, "B1", 2107,
                "-ed/-ing adjectives", Lesson7Section1TabsData.getTabs()));
        sections.add(new SectionObj(210702, "B1", 2107,
                "The passive", Lesson7Section2TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson8Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(210801, "B1", 2108,
                "Polite request", Lesson8Section1TabsData.getTabs()));
        sections.add(new SectionObj(210802, "B1", 2108,
                "will and shall (for instant responses)", Lesson8Section2TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson9Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(210901, "B1", 2109,
                "Defining relative clauses", Lesson9Section1TabsData.getTabs()));
        sections.add(new SectionObj(210902, "B1", 2109,
                "Quantifiers", Lesson9Section2TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson10Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(211001, "B1", 2110,
                "Making predictions", Lesson10Section1TabsData.getTabs()));
        sections.add(new SectionObj(211002, "B1", 2110,
                "Hypothetical possibilities with if", Lesson10Section2TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson11Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(211101, "B1", 2111,
                "Obligation and permission in the present", Lesson11Section1TabsData.getTabs()));
        sections.add(new SectionObj(211102, "B1", 2111,
                "Linking words", Lesson11Section2TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson12Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(211201, "B1", 2112,
                "Past modal verbs (could have / should have / would have)", Lesson12Section1TabsData.getTabs()));
        sections.add(new SectionObj(211202, "B1", 2112,
                "Hypothetical situations in the past with if", Lesson12Section2TabsData.getTabs()));
        return sections;
    }
}
