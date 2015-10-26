package com.android.tfc.englishtrainingday.data.SectionsData;

import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson1.Lesson1Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson1.Lesson1Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson1.Lesson1Section3TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson1.Lesson1Section4TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson2.Lesson2Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson2.Lesson2Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson3.Lesson3Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson3.Lesson3Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson3.Lesson3Section3TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson4.Lesson4Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson4.Lesson4Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson4.Lesson4Section3TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson4.Lesson4Section4TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson4.Lesson4Section5TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson5.Lesson5Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson6.Lesson6Section1TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson6.Lesson6Section2TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson6.Lesson6Section3TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson6.Lesson6Section4TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson6.Lesson6Section5TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson6.Lesson6Section6TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson6.Lesson6Section7TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson6.Lesson6Section8TabsData;
import com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson7.Lesson7Section1TabsData;
import com.android.tfc.englishtrainingday.entities.SectionObj;

import java.util.ArrayList;

public class A1SectionsData {

    public static ArrayList<SectionObj> getLesson1Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(110101, "A1", 1101,
                "Personal pronouns", Lesson1Section1TabsData.getTabs()));
        sections.add(new SectionObj(110102, "A1", 1101,
                "Possessive pronouns", Lesson1Section2TabsData.getTabs()));
        sections.add(new SectionObj(110103, "A1", 1101,
                "Demonstrative Pronouns", Lesson1Section3TabsData.getTabs()));
        sections.add(new SectionObj(110104, "A1", 1101,
                "Reflexive Pronouns", Lesson1Section4TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson2Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(110201, "A1", 1102,
                "The Definite Article", Lesson2Section1TabsData.getTabs()));
        sections.add(new SectionObj(110202, "A1", 1102,
                "The Indefinite Article", Lesson2Section2TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson3Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(110301, "A1", 1103,
                "Prepositions", Lesson3Section1TabsData.getTabs()));
        sections.add(new SectionObj(110302, "A1", 1103,
                "Prepositions of place and direction", Lesson3Section2TabsData.getTabs()));
        sections.add(new SectionObj(110303, "A1", 1103,
                "Prepositions of time", Lesson3Section3TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson4Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(110401, "A1", 1104,
                "Nouns", Lesson4Section1TabsData.getTabs()));
        sections.add(new SectionObj(110402, "A1", 1104,
                "Proper Nouns", Lesson4Section2TabsData.getTabs()));
        sections.add(new SectionObj(110403, "A1", 1104,
                "Countable/Uncountable Nouns", Lesson4Section3TabsData.getTabs()));
        sections.add(new SectionObj(110404, "A1", 1104,
                "There be", Lesson4Section4TabsData.getTabs()));
        sections.add(new SectionObj(110405, "A1", 1104,
                "Quantifiers", Lesson4Section5TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson5Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(110501, "A1", 1105,
                "Adjectives", Lesson5Section1TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson6Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(110601, "A1", 1106,
                "Greetings and Introductions", Lesson6Section1TabsData.getTabs()));
        sections.add(new SectionObj(110602, "A1", 1106,
                "At the Airport", Lesson6Section2TabsData.getTabs()));
        sections.add(new SectionObj(110603, "A1", 1106,
                "Directions and Transportation", Lesson6Section3TabsData.getTabs()));
        sections.add(new SectionObj(110604, "A1", 1106,
                "At the Hotel", Lesson6Section4TabsData.getTabs()));
        sections.add(new SectionObj(110605, "A1", 1106,
                "In a Restaurant", Lesson6Section5TabsData.getTabs()));
        sections.add(new SectionObj(110606, "A1", 1106,
                "In a Store", Lesson6Section6TabsData.getTabs()));
        sections.add(new SectionObj(110607, "A1", 1106,
                "Banking and Money", Lesson6Section7TabsData.getTabs()));
        sections.add(new SectionObj(110608, "A1", 1106,
                "Medical Emergencies", Lesson6Section8TabsData.getTabs()));
        return sections;
    }

    public static ArrayList<SectionObj> getLesson7Sections() {
        ArrayList<SectionObj> sections = new ArrayList<>();
        sections.add(new SectionObj(110701, "A1", 1107,
                "Christmas Vocabulary", Lesson7Section1TabsData.getTabs()));
        return sections;
    }
}
