package com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson1;

import com.android.tfc.englishtrainingday.entities.SectionTabObj;

import java.util.ArrayList;

public class Lesson1Section1TabsData {

    public static ArrayList<SectionTabObj> getTabs() {
        ArrayList<SectionTabObj> sectionTabs = new ArrayList<>();
        sectionTabs.add(new SectionTabObj(12010101, "A2", 120101,
                "The form of the Imperative", getTextTab1()));
        sectionTabs.add(new SectionTabObj(12010102, "A2", 120101,
                "The Imperative with let's", getTextTab2()));
        return sectionTabs;
    }

    private static String getTextTab1() {
        String text;
        text = "<p>We use the infinitive to form the Imperative.</p>" +
                "<table style='border: 1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th>Affirmative sentences</th>" +
                "<th>Negative sentences</th>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'><b>Come</b> here.</td>" +
                "<td style='padding-left: 0.5em'><b>Don't come</b> now.</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'><b>Clean</b> the bathroom.</td>" +
                "<td style='padding-left: 0.5em'><b>Don't clean</b> the living room.</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'><b>Help</b> your father.</td>" +
                "<td style='padding-left: 0.5em'><b>Don't play</b> on the computer.</td>" +
                "</tr>" +
                "</table>" +
                "<p>" +
                "Use the exclamation only when you want to make an exclamation, e.g. <i>Stop! Help!</i>" +
                "</p>" +
                "<br />";
        return text;
    }

    private static String getTextTab2() {
        String text;
        text = "<table style='border: 1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th>Affirmative sentences</th>" +
                "<th>Negative sentences</th>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'><b>Let's</b> ask the teacher.</td>" +
                "<td style='padding-left: 0.5em'><b>Let's</b> not ask the teacher.</td>" +
                "</tr>" +
                "</table>" +
                "<br />";
        return text;
    }
}
