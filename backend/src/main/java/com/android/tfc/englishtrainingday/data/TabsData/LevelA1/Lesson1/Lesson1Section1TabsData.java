package com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson1;

import com.android.tfc.englishtrainingday.entities.SectionTabObj;

import java.util.ArrayList;

public class Lesson1Section1TabsData {

    public static ArrayList<SectionTabObj> getTabs() {
        ArrayList<SectionTabObj> sectionTabs = new ArrayList<>();
        sectionTabs.add(new SectionTabObj(11010101, "A1", 110101,
                "Personal Pronouns Subject", getTextTab1()));
        sectionTabs.add(new SectionTabObj(11010102, "A1", 110101,
                "Personal Pronouns Object", getTextTab2()));
        return sectionTabs;
    }

    private static String getTextTab1() {
        String text;
        text = "<h3>Personal pronouns subject</h3>" +
                "<table style='border: 1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th style='padding: 0.3em; text-align: center;'>Number</th>" +
                "<th style='padding: 0.3em; text-align: center;'>Person</th>" +
                "<th style='padding: 0.3em; text-align: center;'>Gender</th>" +
                "<th style='padding: 0.3em; text-align: center;'>Subject</th>" +
                "</tr>" +
                "<tr>" +
                "<td rowspan='5' style='padding-left: 0.5em'>singular</td>" +
                "<td style='padding-left: 0.5em'>1st</td>" +
                "<td style='padding-left: 0.5em'>male / female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>I</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'>2nd</td>" +
                "<td style='padding-left: 0.5em'>male / female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>you</td>" +
                "</tr>" +
                "<tr>" +
                "<td rowspan='3' style='padding-left: 0.5em'>3rd</td>" +
                "<td style='padding-left: 0.5em'>male</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>he</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'>female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>she</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'>neuter</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>it</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td rowspan='3' style='padding-left: 0.5em'>plural</td>" +
                "<td style='padding-left: 0.5em'>1st</td>" +
                "<td style='padding-left: 0.5em'>male / female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>we</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'>2nd</td>" +
                "<td style='padding-left: 0.5em'>male / female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>you</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'>3rd</td>" +
                "<td style='padding-left: 0.5em'>male / female / neuter</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>they</td>" +
                "</tr>" +
                "</table>" +
                "<br/>";
        return text;
    }

    private static String getTextTab2() {
        String text;
        text = "<h3>Personal pronouns object</h3>" +
                "<table style='border: 1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th style='padding: 0.3em; text-align: center;'>Number</th>" +
                "<th style='padding: 0.3em; text-align: center;'>Person</th>" +
                "<th style='padding: 0.3em; text-align: center;'>Gender</th>" +
                "<th style='padding: 0.3em; text-align: center;'>Subject</th>" +
                "</tr>" +
                "<tr>" +
                "<td rowspan='5' style='padding-left: 0.5em'>singular</td>" +
                "<td style='padding-left: 0.5em'>1st</td>" +
                "<td style='padding-left: 0.5em'>male / female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>me</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'>2nd</td>" +
                "<td style='padding-left: 0.5em'>male / female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>you</td>" +
                "</tr>" +
                "<tr>" +
                "<td rowspan='3' style='padding-left: 0.5em'>3rd</td>" +
                "<td style='padding-left: 0.5em'>male</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>him</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'>female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>her</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'>neuter</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>it</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td rowspan='3' style='padding-left: 0.5em'>plural</td>" +
                "<td style='padding-left: 0.5em'>1st</td>" +
                "<td style='padding-left: 0.5em'>male / female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>us</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'>2nd</td>" +
                "<td style='padding-left: 0.5em'>male / female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>you</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'>3rd</td>" +
                "<td style='padding-left: 0.5em'>male / female / neuter</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>them</td>" +
                "</tr>" +
                "</table>" +
                "<br/>";
        return text;
    }
}
