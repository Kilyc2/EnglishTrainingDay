package com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson3;

import com.android.tfc.englishtrainingday.entities.SectionTabObj;

import java.util.ArrayList;

public class Lesson3Section1TabsData {

    public static ArrayList<SectionTabObj> getTabs() {
        ArrayList<SectionTabObj> sectionTabs = new ArrayList<>();
        sectionTabs.add(new SectionTabObj(12030101, "A2", 120301,
                "Questions with do/does/did", getTextTab1()));
        sectionTabs.add(new SectionTabObj(12030102, "A2", 120301,
                "Questions with be", getTextTab2()));
        return sectionTabs;
    }


    private static String getTextTab1() {
        String text;
        text = "<h3>Questions with <i>do / does / did</i> in present simple and past simple</h3>" +
                "<table style='border:1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th style='padding:0.3em; text-align: center;'> Question word </th>" +
                "<th style='padding:0.3em; text-align: center;'> Auxiliary </th>" +
                "<th style='padding:0.3em; text-align: center;'> Subject </th>" +
                "<th style='padding:0.3em; text-align: center;'> Infinitive </th>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left:0.5em'></td>" +
                "<td style='padding-left:0.5em'><b>Do</b></td>" +
                "<td style='padding-left:0.5em'>you</td>" +
                "<td style='padding-left:0.5em'><b>live</b> with your parents?</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left:0.5em'></td>" +
                "<td style='padding-left:0.5em'><b>Did</b></td>" +
                "<td style='padding-left:0.5em'>you</td>" +
                "<td style='padding-left:0.5em'><b>have</b> a holiday last year?</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left:0.5em'>Where</td>" +
                "<td style='padding-left:0.5em'><b>does</b></td>" +
                "<td style='padding-left:0.5em'>you sister</td>" +
                "<td style='padding-left:0.5em'><b>work</b>?</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left:0.5em'>When</td>" +
                "<td style='padding-left:0.5em'><b>did</b></td>" +
                "<td style='padding-left:0.5em'>you</td>" +
                "<td style='padding-left:0.5em'><b>start</b> studying English?</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left:0.5em'>What</td>" +
                "<td style='padding-left:0.5em'><b>did</b></td>" +
                "<td style='padding-left:0.5em'>they</td>" +
                "<td style='padding-left:0.5em'><b>talk</b> about?</td>" +
                "</tr>" +
                "</table>" +
                "<br/>" +
                "<p>Use <b>ASI</b> (<b>A</b>uxiliary, <b>S</b>ubject, <b>I</b>nfinitive) and " +
                "<b>QUASY</b> (<b>Qu</b>estion word, <b>A</b>uxiliary, <b>S</b>ubject, <b>I</b>nfinitive) " +
                "to remember word order in questions.</p>";
        return text;
    }

    private static String getTextTab2() {
        String text;
        text = "<h3>Questions with be</h3>" +
                "<table style='border:1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th style='padding:0.3em; text-align: center;'>Question word</th>" +
                "<th style='padding:0.3em; text-align: center;'>Be</th>" +
                "<th style='padding:0.3em; text-align: center;'>Subject</th>" +
                "<th style='padding:0.3em; text-align: center;'>adjective, noun, etc.</th>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left:0.5em'></td>" +
                "<td style='padding-left:0.5em'><b>Are</b></td>" +
                "<td style='padding-left:0.5em'>you</td>" +
                "<td style='padding-left:0.5em'>hungry?</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left:0.5em'></td>" +
                "<td style='padding-left:0.5em'><b>Is</b></td>" +
                "<td style='padding-left:0.5em'>there</td>" +
                "<td style='padding-left:0.5em'>a bank near here?</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left:0.5em'>What</td>" +
                "<td style='padding-left:0.5em'><b>was</b></td>" +
                "<td style='padding-left:0.5em'>that</td>" +
                "<td style='padding-left:0.5em'>noise?</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left:0.5em'>Where</td>" +
                "<td style='padding-left:0.5em'><b>are</b></td>" +
                "<td style='padding-left:0.5em'>you</td>" +
                "<td style='padding-left:0.5em'>from?</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left:0.5em'>Where</td>" +
                "<td style='padding-left:0.5em'><b>were</b></td>" +
                "<td style='padding-left:0.5em'>you</td>" +
                "<td style='padding-left:0.5em'>born?</td>" +
                "</tr>" +
                "</table>" +
                "<br/>" +
                "<p>Make questions with verb <i>to be</i> by inverting the verb and " +
                "the subject.<br/>" +
                "<span style='padding-left:0.5em;'><b>She is</b> a teacher. <b><i>Is she</i></b> a teacher?</span></p>";
        return text;
    }
}
