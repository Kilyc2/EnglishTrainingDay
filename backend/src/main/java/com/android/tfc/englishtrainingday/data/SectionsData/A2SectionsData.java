package com.android.tfc.englishtrainingday.data.SectionsData;

import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson1.Lesson1Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson1.Lesson1Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson2.Lesson2Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson3.Lesson3Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson3.Lesson3Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson3.Lesson3Section3TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson4.Lesson4Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson4.Lesson4Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson4.Lesson4Section3TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson4.Lesson4Section4TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson5.Lesson5Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson5.Lesson5Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson6.Lesson6Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson6.Lesson6Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson7.Lesson7Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson8.Lesson8Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson8.Lesson8Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson8.Lesson8Section3TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson8.Lesson8Section4TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson8.Lesson8Section5TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson8.Lesson8Section6TabsData;
import com.android.tfc.englishtrainingday.entities.SectionObj;

import java.util.ArrayList;

public class A2SectionsData {

    public static ArrayList<SectionObj> getLesson1Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(120101, "A2", 1201,
                "The imperative", Lesson1Section1TabsData.getTabs()));
        sections.add(new SectionObj(120102, "A2", 1201,
                "State verbs", Lesson1Section2TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson2Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(120201, "A2", 1202,
                "Irregular verbs", Lesson2Section1TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson3Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(120301, "A2", 1203,
                "Word order in questions", Lesson3Section1TabsData.getTabs()));
        sections.add(new SectionObj(120302, "A2", 1203,
                "Present simple", Lesson3Section2TabsData.getTabs()));
        sections.add(new SectionObj(120303, "A2", 1203,
                "Present continuous", Lesson3Section3TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson4Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(120401, "A2", 1204,
                "Cardinal Numbers", Lesson4Section1TabsData.getTabs()));
        sections.add(new SectionObj(120402, "A2", 1204,
                "Ordinal Numbers", Lesson4Section2TabsData.getTabs()));
        sections.add(new SectionObj(120403, "A2", 1204,
                "The Date", Lesson4Section3TabsData.getTabs()));
        sections.add(new SectionObj(120404, "A2", 1204,
                "Time", Lesson4Section4TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson5Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(120501, "A2", 1205,
                "Cardinal Numbers", Lesson5Section1TabsData.getTabs()));
        sections.add(new SectionObj(120502, "A2", 1205,
                "Ordinal Numbers", Lesson5Section2TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson6Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(120601, "A2", 1206,
                "Cardinal Numbers", Lesson6Section1TabsData.getTabs()));
        sections.add(new SectionObj(120602, "A2", 1206,
                "Ordinal Numbers", Lesson6Section2TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson7Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(120701, "A2", 1207,
                "Cardinal Numbers", Lesson7Section1TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson8Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(120801, "A2", 1208,
                "Cardinal Numbers", Lesson8Section1TabsData.getTabs()));
        sections.add(new SectionObj(120802, "A2", 1208,
                "Ordinal Numbers", Lesson8Section2TabsData.getTabs()));
        sections.add(new SectionObj(120803, "A2", 1208,
                "The Date", Lesson8Section3TabsData.getTabs()));
        sections.add(new SectionObj(120804, "A2", 1208,
                "Time", Lesson8Section4TabsData.getTabs()));
        sections.add(new SectionObj(120805, "A2", 1208,
                "Cardinal Numbers", Lesson8Section5TabsData.getTabs()));
        sections.add(new SectionObj(120806, "A2", 1208,
                "Ordinal Numbers", Lesson8Section6TabsData.getTabs()));
        return sections;
    }
}
