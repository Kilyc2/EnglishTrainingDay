package com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson1;

import com.android.tfc.englishtrainingday.entities.SectionTabObj;

import java.util.ArrayList;

public class Lesson1Section4TabsData {

    public static ArrayList<SectionTabObj> getTabs() {
        ArrayList<SectionTabObj> sectionTabs = new ArrayList<>();
        sectionTabs.add(new SectionTabObj(11010401, "A1", 110104,
                "Reflexive Pronouns", getTextTab1()));
        sectionTabs.add(new SectionTabObj(11010402, "A1", 110104,
                "Examples", getTextTab2()));
        sectionTabs.add(new SectionTabObj(11010403, "A1", 110104,
                "Intensive Pronouns", getTextTab3()));
        return sectionTabs;
    }

    private static String getTextTab1() {
        String text;
        text = "<h3>Reflexive pronouns</h3>" +
                "<table style='border: 1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th style='padding: 0.3em; text-align: center;'>Number</th>" +
                "<th style='padding: 0.3em; text-align: center;'>Person</th>" +
                "<th style='padding: 0.3em; text-align: center;'>Gender</th>" +
                "<th style='padding: 0.3em; text-align: center;'>Reflexive</th>" +
                "</tr>" +
                "<tr>" +
                "<td rowspan='5' style='padding-left: 0.5em'>singular</td>" +
                "<td style='padding-left: 0.5em'>1st</td>" +
                "<td style='padding-left: 0.5em'>male / female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>myself</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'>2nd</td>" +
                "<td style='padding-left: 0.5em'>male / female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>yourself</td>" +
                "</tr>" +
                "<tr>" +
                "<td rowspan='3' style='padding-left: 0.5em'>3rd</td>" +
                "<td style='padding-left: 0.5em'>male</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>himself</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'>female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>herself</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'>other</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>itself</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td rowspan='3' style='padding-left: 0.5em'>plural</td>" +
                "<td style='padding-left: 0.5em'>1st</td>" +
                "<td style='padding-left: 0.5em'>male / female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>ourselves</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'>2nd</td>" +
                "<td style='padding-left: 0.5em'>male / female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>yourselves</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'>3rd</td>" +
                "<td style='padding-left: 0.5em'>male / female</td>" +
                "<td style='padding-left: 0.5em; font-weight: bold'>themselves</td>" +
                "</tr>" +
                "</table>" +
                "<br/>";
        return text;
    }

    private static String getTextTab2() {
        String text;
        text = "<table style='border: 1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th style='padding: 0.3em; text-align: center;'>non-reflexive <br/>" +
                "The <u>underlined</u> words are NOT the same person/thing</th>" +
                "<th style='padding: 0.3em; text-align: center;'>REFLEXIVE pronouns<br/>" +
                "The <u>underlined</u> words are the SAME person/thing</th>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'><u>John</u> saw <u>me</u>.</td>" +
                "<td style='padding-left: 0.5em'><u>I</u> saw <u><b>myself</b></u> in the mirror.</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'>Why does <u>he</u> blame <u>you</u>?</td>" +
                "<td style='padding-left: 0.5em'>Why do <u>you</u> blame <u><b>yourself</b></u>?</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'><u>David</u> sent <u>him</u> a copy.</td>" +
                "<td style='padding-left: 0.5em'><u>John</u> sent <u><b>himself</b></u> a copy.</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'><u>David</u> sent <u>her</u> a copy.</td>" +
                "<td style='padding-left: 0.5em'><u>Mary</u> sent <u><b>herself</b></u> a copy.</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'><u>My dog</u> hurt <u>the cat</u>.</td>" +
                "<td style='padding-left: 0.5em'><u>My dog</u> hurt <u><b>itself</b></u>.</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'><u>We</u> blame <u>you</u>.</td>" +
                "<td style='padding-left: 0.5em'><u>We</u> blame <u><b>ourselves</b></u>.</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'>Can <u>you</u> help <u>my children</u>?</td>" +
                "<td style='padding-left: 0.5em'>Can <u>you</u> help <u><b>yourselves</b></u>?</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'><u>They</u> cannot look after <u>the babies</u>.</td>" +
                "<td style='padding-left: 0.5em'><u>They</u> cannot look after <u><b>themselves</b></u>.</td>" +
                "</tr>" +
                "</table>" +
                "<br/>";
        return text;
    }

    private static String getTextTab3() {
        String text;
        text = "<h3>Intensive pronouns</h3>" +
                "<p>Notice that all the above reflexive pronouns can also act as" +
                "intensive pronouns, but the function and usage are different. An" +
                "intensive pronoun emphasizes its antecedent. Look at these examples:</p>" +
                "<ul>" +
                "<li>I made it <b>myself</b>. <i>OR</i> I <b>myself</b>" +
                "made it." +
                "</li>" +
                "<li>Have you <b>yourself</b> seen it? <i>OR</i> Have" +
                "you seen it <b>yourself</b>?" +
                "</li>" +
                "<li>The President <b>himself</b> promised to stop the" +
                "war." +
                "</li>" +
                "<li>She spoke to me <b>herself</b>. <i>OR</i> She <b>herself</b>" +
                "spoke to me." +
                "</li>" +
                "<li>The exam <b>itself</b> wasn't difficult, but the" +
                "exam room was horrible." +
                "</li>" +
                "<li>Never mind. We'll do it <b>ourselves</b>." +
                "</li>" +
                "<li>You <b>yourselves</b> asked us to do it." +
                "</li>" +
                "<li>They recommend this book even though they <b>themselves</b>" +
                "had never read it. <i>OR</i> They recommend this book even though" +
                "they had never read it <b>themselves</b>." +
                "</li>" +
                "</ul>" +
                "<br/>";
        return text;
    }
}
