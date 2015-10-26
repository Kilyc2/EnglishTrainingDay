package com.android.tfc.englishtrainingday.data.TabsData.LevelA2.Lesson1;

import com.android.tfc.englishtrainingday.entities.SectionTabObj;

import java.util.ArrayList;

public class Lesson1Section2TabsData {

    public static ArrayList<SectionTabObj> getTabs() {
        ArrayList<SectionTabObj> sectionTabs = new ArrayList<>();
        sectionTabs.add(new SectionTabObj(12010201, "A2", 120102,
                "Use of state verbs", getTextTab1()));
        sectionTabs.add(new SectionTabObj(12010202, "A2", 120102,
                "Examples", getTextTab2()));
        return sectionTabs;
    }

    private static String getTextTab1() {
        String text;
        text = "<p>Not every verb can be used in a progressive form. We do not use" +
                "verbs which express situations in these forms. But we often use verbs" +
                "which express actions (dynamic verbs) in progressive forms.</p>" +
                "<p>" +
                "The following verbs are <em>not normally used</em> in progressive" +
                "forms:" +
                "</p>" +
                "<ul class=\"text-list\">" +
                "<li>agree</li>" +
                "<li>be</li>" +
                "<li>like</li>" +
                "<li>hate</li>" +
                "<li>hear</li>" +
                "<li>imagine</li>" +
                "<li>know</li>" +
                "<li>need</li>" +
                "<li>prefer</li>" +
                "<li>promise</li>" +
                "<li>realize</li>" +
                "<li>remember</li>" +
                "<li>see.</li>" +
                "</ul>" +
                "<br />";
        return text;
    }

    private static String getTextTab2() {
        String text;
        text = "<p>Sometimes verbs can be used in  progressive forms when they have certain meanings. In other meanings it is not possible to use them in  progressive forms. Watch the following examples:</p>" +
                "<table style='border: 1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th>Verb</th>" +
                "<th>Simple forms</th>" +
                "<th>Progressive forms</th>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'>feel (to have an opinion)</td>" +
                "<td style='padding-left: 0.5em'>I <b>feel</b> I should go on holiday.</td>" +
                "<td style='padding-left: 0.5em'>---</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'>feel (to feel sth.)</td>" +
                "<td style='padding-left: 0.5em'>How do you <b>feel</b> when you are on holiday?</td>" +
                "<td style='padding-left: 0.5em'>How <b>are</b> you <b>feeling</b> today?</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'>have (to possess)</td>" +
                "<td style='padding-left: 0.5em'>I <b>have</b> a new computer.</td>" +
                "<td style='padding-left: 0.5em'>---</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'>have (to eat)</td>" +
                "<td style='padding-left: 0.5em'>I always <b>have</b> a cola for lunch.</td>" +
                "<td style='padding-left: 0.5em'>I <b>am having</b> dinner right now.</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'>see (to understand)</td>" +
                "<td style='padding-left: 0.5em'>Oh, I <b>see</b>.</td>" +
                "<td style='padding-left: 0.5em'>---</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'>see (to meet someone)</td>" +
                "<td style='padding-left: 0.5em'>I often <b\">see</b> Mandy at the disco.</td>" +
                "<td style='padding-left: 0.5em'>I <b>am seeing</b> Peter tonight.</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'>think (to believe)</td>" +
                "<td style='padding-left: 0.5em'>I <b>think</b> you should see a doctor.</td>" +
                "<td style='padding-left: 0.5em'>---</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'>think (to think about)</td>" +
                "<td style='padding-left: 0.5em'>I have to <sb>think</b> about it.</td>" +
                "<td style='padding-left: 0.5em'>I <b>am thinking</b> about my girlfriend now.</td>" +
                "</tr>" +
                "</table>" +
                "<br/>";
        return text;
    }
}
