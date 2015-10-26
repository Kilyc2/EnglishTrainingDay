package com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson2;

import com.android.tfc.englishtrainingday.entities.SectionTabObj;

import java.util.ArrayList;

public class Lesson2Section2TabsData {

    public static ArrayList<SectionTabObj> getTabs() {
        ArrayList<SectionTabObj> sectionTabs = new ArrayList<>();
        sectionTabs.add(new SectionTabObj(11020201, "A1", 110202,
                "The indefinite article -a", getTextTab1()));
        sectionTabs.add(new SectionTabObj(11020202, "A1", 110202,
                "Use of the indefinite article a/an", getTextTab2()));
        return sectionTabs;
    }

    private static String getTextTab1() {
        String text;
        text = "<h3>" +
                "The indefinite article -<i>a</i>" +
                "</h3>" +
                "<p>" +
                "The indefinite article <b><i>a</i></b> is the same for all genders." +
                "</p>" +
                "<ul class=\"text-list\">" +
                "<li>a boy</li>" +
                "<li>a girl</li>" +
                "<li>a cat</li>" +
                "</ul>" +
                "<p>" +
                "The indefinite article has <i>no</i> plural form." +
                "</p>" +
                "<ul>" +
                "<li>a boy &#x2192; boys</li>" +
                "</ul>" +
                "<p>" +
                "We use <b><i>an</i></b> if the following word starts with a spoken" +
                "vowel." +
                "</p>" +
                "<table style='border: 1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th>the following word starts with a spoken <b>consonant</b></th>" +
                "<th>the following word starts with a spoken <b>vowel</b></th>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'><ul>" +
                "<li>a <b>b</b>oy" +
                "</li>" +
                "<li>a <b>s</b>chool" +
                "</li>" +
                "<li>a <b>g</b>irl" +
                "</li>" +
                "</ul></td>" +
                "<td style='padding-left: 0.5em'><ul>" +
                "<li>an <b>a</b>unt" +
                "</li>" +
                "<li>an <b>o</b>ld school" +
                "</li>" +
                "<li>an <b>A</b>merican girl" +
                "</li>" +
                "</ul></td>" +
                "</tr>" +
                "</table>" +
                "<br/>";
        return text;
    }

    private static String getTextTab2() {
        String text;
        text = "<h3>Before phrases of time and measurements (per week/weekly)</h3>" +
                "<ul>" +
                "<li>We have English 4 times <b><i>a</i> week</b>." +
                "</li>" +
                "<li>I go on holiday twice <b><i>a</i> year</b>." +
                "</li>" +
                "<li>Our car can do 136 miles <b><i>an</i> hour</b>." +
                "</li>" +
                "<li>Tomatoes are &pound;2 <b><i>a</i> kilo</b>." +
                "</li>" +
                "</ul>" +
                "<h3>Before phrases of jobs</h3>" +
                "<ul>" +
                "<li>My father is <b><i>a</i> car mechanic</b>." +
                "</li>" +
                "</ul>" +
                "<h3>With a noun complement</h3>" +
                "<ul>" +
                "<li>He is <b><i>a</i> good boy</b>." +
                "</li>" +
                "</ul>" +
                "<h3>Before phrases of nationality</h3>" +
                "<ul>" +
                "<li>Bruce Springsteen is <b><i>an</i> American</b>." +
                "</li>" +
                "</ul>" +
                "<h3>" +
                "<i>Half/quite</i>" +
                "</h3>" +
                "<ul>" +
                "<li>We need <b>half <i>a</i> pound" +
                "</b> of sugar." +
                "</li>" +
                "<li>This is <b>quite <i>a</i> good story" +
                "</b>." +
                "</li>" +
                "</ul>" +
                "<br/>";
        return text;
    }
}
