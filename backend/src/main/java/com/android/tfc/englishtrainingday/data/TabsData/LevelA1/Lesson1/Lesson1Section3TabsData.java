package com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson1;

import com.android.tfc.englishtrainingday.entities.SectionTabObj;

import java.util.ArrayList;

public class Lesson1Section3TabsData {

    public static ArrayList<SectionTabObj> getTabs() {
        ArrayList<SectionTabObj> sectionTabs = new ArrayList<>();
        sectionTabs.add(new SectionTabObj(11010301, "A1", 110103,
                "Demonstrative Pronouns", getTextTab1()));
        return sectionTabs;
    }

    private static String getTextTab1() {
        String text;
        text = "<h3>Demonstrative pronouns</h3>" +
                "<table style='border: 1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th style='padding: 0.3em; text-align: center;'>Number</th>" +
                "<th style='padding: 0.3em; text-align: center;'>Distance</th>" +
                "<th style='padding: 0.3em; text-align: center;'>Pronoun</th>" +
                "</tr>" +
                "<tr>" +
                "<td rowspan='2' style='padding-left: 0.5em'>singular</td>" +
                "<td style='padding-left: 0.5em;'>near</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>this</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em;'>far</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>that</td>" +
                "</tr>" +
                "<tr>" +
                "<td rowspan='2' style='background-color: #33B5E5; padding-left: 0.5em'>plural</td>" +
                "<td style='padding-left: 0.5em;'>near</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>these</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em;'>far</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>those</td>" +
                "</tr>" +
                "</table>" +
                "</p>" +
                "<p>" +
                "Normally we use demonstrative pronouns for things only. But we can use them for " +
                "people when the person is identified. Look at these examples:<br/>" +
                "- <i><b>This</b> is Josef speaking. Is <b>that</b> Mary?</i><br/>" +
                "- <i><b>That</b> sounds like John.</i>" +
                "</p>";
        return text;
    }
}
