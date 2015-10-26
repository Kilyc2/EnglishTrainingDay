package com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson3;

import com.android.tfc.englishtrainingday.entities.SectionTabObj;

import java.util.ArrayList;

public class Lesson3Section2TabsData {

    public static ArrayList<SectionTabObj> getTabs() {
        ArrayList<SectionTabObj> sectionTabs = new ArrayList<>();
        sectionTabs.add(new SectionTabObj(12030201, "A2", 120302,
                "Present simple", getTextTab1()));
        sectionTabs.add(new SectionTabObj(12030202, "A2", 120302,
                "Spelling rules", getTextTab2()));
        sectionTabs.add(new SectionTabObj(12030203, "A2", 120302,
                "Adverbs of frequency", getTextTab3()));
        sectionTabs.add(new SectionTabObj(12030204, "A2", 120302,
                "Expressions of frequency", getTextTab4()));
        return sectionTabs;
    }

    private static String getTextTab1() {
        String text;
        text = "<h3>Present simple</h3>" +
                "<table style='border:1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th style='padding:0.3em; text-align: center;'></th>" +
                "<th style='padding:0.3em; text-align: center;'>I / you / we / they</th>" +
                "<th style='padding:0.3em; text-align: center;'>he / she/ it</th>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding:0.3em; text-align: center; background-color: #003399; color: #FFFFFF'>[+] </td>" +
                "<td style='padding-left:0.5em'>I usually <b>work</b> at home.</td>" +
                "<td style='padding-left:0.5em'>Holly <b>knows</b> me very well.</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding:0.3em; text-align: center; background-color: #003399; color: #FFFFFF'>[–] </td>" +
                "<td style='padding-left:0.5em'>They <b>don't live</b> near here.</td>" +
                "<td style='padding-left:0.5em'>It <b>doesn't</b> often <b>rain</b> here.</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding:0.3em; text-align: center; background-color: #003399; color: #FFFFFF'>[?] </td>" +
                "<td style='padding-left:0.5em'><b>Do</b> you <b>speak</b> French?</td>" +
                "<td style='padding-left:0.5em'><b>Does</b> Alice <b>like</b> jazz?</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding:0.3em; text-align: center; background-color: #003399; color: #FFFFFF'>[✓] <br/>[x] </td>" +
                "<td style='padding-left:0.5em'>Yes, I <b>do</b>.<br/>No, I <b>don't</b>.</td>" +
                "<td style='padding-left:0.5em'>Yes, she <b>does</b>.<br/>No, she <b>doesn't</b>.</td>" +
                "</tr>" +
                "</table>" +
                "<br/>" +
                "<p>Use the present simple for things you do every day / week / year, or for things " +
                "which are generally true or always happen.</p>" +
                "<p>Use <i>don't/doesn't</i> to make negative sentences, and <i>do/does</i> to make questions.";
        return text;
    }

    private static String getTextTab2() {
        String text;
        text = "<h3>Spelling rules for the 3rd person -s (he, she, it)</h3>" +
                "<table style='border:1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th style='padding:0.3em; text-align: center;'>Infinitive</th>" +
                "<th style='padding:0.3em; text-align: center;'>3rd person</th>" +
                "<th style='padding:0.3em; text-align: center;'>Spelling</th>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left:0.5em'>work</td>" +
                "<td style='padding-left:0.5em'>works</td>" +
                "<td style='padding-left:0.5em'>add <i>-s</i></td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left:0.5em'>study</td>" +
                "<td style='padding-left:0.5em'>studies</td>" +
                "<td style='padding-left:0.5em'>consonant + <i>y</i> = <i>ies</i> </td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left:0.5em'>finish</td>" +
                "<td style='padding-left:0.5em'>finishes</td>" +
                "<td style='padding-left:0.5em'>add <i>-es</i> after <i>sh, ch, s, x</i></td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left:0.5em'>go / do</td>" +
                "<td style='padding-left:0.5em'>goes / does</td>" +
                "<td style='padding-left:0.5em'>add <i>-es</i></td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left:0.5em'>have</td>" +
                "<td style='padding-left:0.5em'>has</td>" +
                "<td style='padding-left:0.5em'>change to <i>-s</i></td>" +
                "</tr>" +
                "</table>" +
                "<br/>";
        return text;
    }

    private static String getTextTab3() {
        String text;
        text = "<h3>Adverbs of frequency</h3>" +
                "<p style='border: 1px solid black; padding: 0.5em'>We <b>often</b> go out on Friday night.<br/>" +
                "She doesn't <b>usually</b> study at weekends.<br/>" +
                "I'm <b>never</b> ill.<br/>" +
                "He's <b>always</b> late for work.</p>" +
                "<p>We often use the present simple with adverbs of frequency (<i>always, " +
                "usually, often, sometimes, hardly ever, never</i>).<br/>" +
                "- Adverbs of frequency go <u>before</u> the main verb.<br/>" +
                "- Adverbs of frequency go <u>after</u> <i>be</i><br/>" +
                "<span style='padding-left:0.5em;'><i>She's <b>never</b> ill</i>. <i><strike>She's ill never,</strike></i></span><br/>" +
                "- Remember to use a [+] verb with <i>never</i>.<br/>" +
                "<span style='padding-left:0.5em;'><i>It never rains</i>. <i><strike>It doesn't never rain.</strike></i></span></p>";
        return text;
    }

    private static String getTextTab4() {
        String text;
        text = "<h3>Expressions of frequency</h3>" +
                "<p style='border: 1px solid black; padding: 0.5em'>She gets up early <b>every day</b>.<br/>" +
                "We have English classes <b>twice a week</b>.</p>" +
                "<p>Expressions of frequency (<i>every day, once a week,</i> etc.) usually go at the end of a sentence.</p>";
        return text;
    }
}
