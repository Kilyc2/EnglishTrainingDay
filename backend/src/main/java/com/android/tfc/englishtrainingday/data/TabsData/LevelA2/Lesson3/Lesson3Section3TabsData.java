package com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson3;

import com.android.tfc.englishtrainingday.entities.SectionTabObj;

import java.util.ArrayList;

public class Lesson3Section3TabsData {

    public static ArrayList<SectionTabObj> getTabs() {
        ArrayList<SectionTabObj> sectionTabs = new ArrayList<>();
        sectionTabs.add(new SectionTabObj(12030301, "A2", 120303,
                "Present continuous", getTextTab1()));
        sectionTabs.add(new SectionTabObj(12030302, "A2", 120303,
                "Spelling rules", getTextTab2()));
        sectionTabs.add(new SectionTabObj(12030303, "A2", 120303,
                "Simple or continuous?", getTextTab3()));
        return sectionTabs;
    }

    private static String getTextTab1() {
        String text;
        text = "<h3>Present continuous: be + verb + <i>-ing</i></h3>" +
                "<p><table style='border:1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th style='text-align: center;'></th>" +
                "<th style='padding:0.3em; text-align: center;'>I</th>" +
                "<th style='padding:0.3em; text-align: center;'>you / we / they</th>" +
                "<th style='padding:0.3em; text-align: center;'>he / she / it</th>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding:0.3em; text-align: center; background-color: #003399; color: #FFFFFF'>[+]</td>" +
                "<td style='padding-left:0.5em'>I<b>'m working</b></td>" +
                "<td style='padding-left:0.5em'><b>'re working</b></td>" +
                "<td style='padding-left:0.5em'><b>'s working</b></td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding:0.3em; text-align: center; background-color: #003399; color: #FFFFFF'>[–]</td>" +
                "<td style='padding-left:0.5em'>I<b>'m not working</b></td>" +
                "<td style='padding-left:0.5em'><b>aren't working</b></td>" +
                "<td style='padding-left:0.5em'><b>isn't working</b></td>" +
                "</tr>" +
                "</table></p>" +
                "<p><table style='border:1px solid black;'>" +
                "<tr>" +
                "<td style='padding:0.3em; text-align: center; background-color: #003399; color: #FFFFFF'>[?]</td>" +
                "<td style='padding-left:0.5em'><b>Are</b> you <b>working</b>?</td>" +
                "<td style='padding-left:0.5em'><b>Is</b> he <b>working</b>?</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding:0.3em; text-align: center; background-color: #003399; color: #FFFFFF'>[✓]<br/>[x]</td>" +
                "<td style='padding-left:0.5em'><b>Yes</b>, I <b>am</b>.<br/><b>No</b>, I'm <b>not</b>.</td>" +
                "<td style='padding-left:0.5em'><b>Yes</b>, he <b>is</b>.<br/><b>No</b>, he <b>isn't</b>.</td>" +
                "</tr>" +
                "</table></p>" +
                "<p>Use the present continuous:<br/>" +
                "- For things that are happening now, at this moment.<br/>" +
                "<span style='padding-left:0.5em;'><i><b>A: </b>What <b>are you doing</b>?</i></span></br>" +
                "<span style='padding-left:0.5em;'><i><b>B: </b>I<b>'m sending</b> a message to Sarah.</i></span></br>" +
                "- For temporary things that are happening now, this week, etc.<br/>" +
                "<span style='padding-left:0.5em;'><i>My brother <b>is doing</b> a two-month course in the UK.</i></span></br>" +
                "- To describe a picture<br/>" +
                "<span style='padding-left:0.5em;'><i>In this picture the woman <b>is standing</b> near the window.</i></span></br></p>";
        return text;
    }

    private static String getTextTab2() {
        String text;
        text = "<h3>Spelling rules for the <i>-ing</i> form</h3>" +
                "<p><table style='border:1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th style='padding:0.3em; text-align: center;'>Infinitive</th>" +
                "<th style='padding:0.3em; text-align: center;'><i>-ing</i> form</th>" +
                "<th style='padding:0.3em; text-align: center;'>Spelling</th>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left:0.5em'>cook<br/>study</td>" +
                "<td style='padding-left:0.5em'>cook<b>ing</b><br/>study<b>ing</b></td>" +
                "<td style='padding-left:0.5em'>add <i>-ing</i></td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left:0.5em'>live</td>" +
                "<td style='padding-left:0.5em'>liv<b>ing</b></td>" +
                "<td style='padding-left:0.5em'>cut the final <i>e</i> and add <i>-ing</i></td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left:0.5em'>run</td>" +
                "<td style='padding-left:0.5em'>runn<b>ing</b></td>" +
                "<td style='padding-left:0.5em'>double the final consonant and add <i>-ing</i></td>" +
                "</tr>" +
                "</table></p>";
        return text;
    }

    private static String getTextTab3() {
        String text;
        text = "<h3>Present simple or present continuous?</h3>" +
                "<p  style='border: 1px solid black; padding: 0.5em'><b>A:</b> What <b>do you do</b>?" +
                "<b> B: I work</b> for Microsoft.<br/>" +
                "<b>A:</b> What <b>are you doing</b>?" +
                "<b> B: I'm checking</b> my emails.</p>" +
                "<p> Use the present simple for things that are generally true or always happen.</p>" +
                "<p> Use the present continuous for an action happening now or at this moment.</p>" +
                "<p> We normally use verbs which describe states or feeling (non-action verbs), e.g. " +
                "<i>want, need, like, </i>in the present simple, not continuous.";
        return text;
    }
}
