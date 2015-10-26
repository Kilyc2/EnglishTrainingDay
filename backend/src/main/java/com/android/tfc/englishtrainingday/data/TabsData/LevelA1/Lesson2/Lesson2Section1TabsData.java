package com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson2;

import com.android.tfc.englishtrainingday.entities.SectionTabObj;

import java.util.ArrayList;

public class Lesson2Section1TabsData {

    public static ArrayList<SectionTabObj> getTabs() {
        ArrayList<SectionTabObj> sectionTabs = new ArrayList<>();
        sectionTabs.add(new SectionTabObj(11020101, "A1", 110201,
                "The definite article -the", getTextTab1()));
        sectionTabs.add(new SectionTabObj(11020102, "A1", 110201,
                "Without or with", getTextTab2()));
        return sectionTabs;
    }

    private static String getTextTab1() {
        String text;
        text = "<h3>" +
                "The definite article -<i>the</i>" +
                "</h3>" +
                "<p>" +
                "The definite article <strong><i>the</i> is the same for all " +
                "genders in singular and in plural</strong>." +
                "</p>" +
                "<ul>" +
                "<li><i>The</i> boy</li>" +
                "<li><i>The</i> girl</li>" +
                "<li><i>The</i> cat</li>" +
                "<li><i>The</i> computers</li>" +
                "</ul>" +
                "<br/>";
        return text;
    }

    private static String getTextTab2() {
        String text;
        text = "<table style='border: 1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF'>" +
                "<th>without the definite article</th>" +
                "<th>with the definite article &ndash; <i>the</i></th>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'><i>general words" +
                "(indefinite)</i>" +
                "<ul>" +
                "<li>Life is too short.</li>" +
                "<li>I like flowers.</li>" +
                "</ul></td>" +
                "<td style='padding-left: 0.5em'><i>general words (definite)</i>" +
                "<ul>" +
                "<li>I've read a book on <b><i>the</i></b> life of Bill Clinton." +
                "</li>" +
                "<li>I like <b><i>the</i></b> flowers in your garden." +
                "</li>" +
                "</ul></td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'><i>names of persons on the singular, relatives</i>" +
                "<ul>" +
                "<li>Peter and John live in London.</li>" +
                "<li>Aunt Mary lives in Los Angeles.</li>" +
                "</ul></td>" +
                "<td style='padding-left: 0.5em'><i>family names in the plural</i>" +
                "<ul>" +
                "<li><b><i>The</i></b> Smiths live in Chicago.</li>" +
                "</ul></td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'><i>public buildings, institutions, " +
                "means of transport (indefinite)</i>" +
                "<ul>" +
                "<li>Mandy doesn't like school.</li>" +
                "<li>We go to school by bus.</li>" +
                "<li>Some people go to church on Sundays.</li>" +
                "</ul></td>" +
                "<td style='padding-left: 0.5em'><i>public buildings, " +
                "institutions, means of transport (definite)</i>" +
                "<ul>" +
                "<li><b><i>The</i></b> school that Mandy goes to is old.</li>" +
                "<li><b><i>The</i></b> bus to Dresden leaves at 7.40.</li>" +
                "<li><b><i>The</i></b> round church in Klingenthal is famous.</li>" +
                "</ul></td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'><i>names of countries in the " +
                "singular, summits of mountains, continents, towns</i>" +
                "<ul>" +
                "<li>Germany</li>" +
                "<li>France</li>" +
                "<li>Mount Whitney</li>" +
                "<li>Mount McKinley</li>" +
                "<li>Africa</li>" +
                "<li>Europe</li>" +
                "<li>Cairo</li>" +
                "<li>New York</li>" +
                "</ul></td>" +
                "<td style='padding-left: 0.5em'><i>names of countries in the " +
                "plural, mountain ranges, regions</i>" +
                "<ul>" +
                "<li><b><i>The</i></b> United States of America</li>" +
                "<li><b><i>The</i></b> NeTherlands</li>" +
                "<li><b><i>The</i></b> HighlandsThe</li>" +
                "<li><b><i>The</i></b> Rocky Mountains</li>" +
                "<li><b><i>The</i></b> Alps</li>" +
                "<li><b><i>The</i></b> Middle East</li>" +
                "<li><b><i>The</i></b> west of Australia</li>" +
                "</ul></td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'><i>single islands</i>" +
                "<ul>" +
                "<li>Corfu</li>" +
                "<li>Bermuda</li>" +
                "<li>Sicily</li>" +
                "</ul></td>" +
                "<td style='padding-left: 0.5em'><i>groups of islands</i>" +
                "<ul>" +
                "<li><b><i>The</i></b> Bahamas</li>" +
                "<li><b><i>The</i></b> British Isles</li>" +
                "<li><b><i>The</i></b> Canaries</li>" +
                "</ul></td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'><i>parks, lakes, streets</i>" +
                "<ul>" +
                "<li>Central Park</li>" +
                "<li>Hyde Park</li>" +
                "<li>Lake Michigan</li>" +
                "<li>Loch Ness</li>" +
                "<li>42nd Street</li>" +
                "<li>Oxford Street</li>" +
                "</ul></td>" +
                "<td style='padding-left: 0.5em'><i>name with of-phrase, oceans, seas, rivers</i>" +
                "<ul>" +
                "<li><b><i>The</i></b> Statue of Liberty</li>" +
                "<li><b><i>The</i></b> Tower (of London)</li>" +
                "<li><b><i>The</i></b> Isle of Wight</li>" +
                "<li><b><i>The</i></b> Atlantic (Ocean)</li>" +
                "<li><b><i>The</i></b> Mediterranean (Sea)</li>" +
                "<li><b><i>The</i></b> Nile</li>" +
                "<li><b><i>The</i></b> Rhine</li>" +
                "<li><b><i>The</i></b> Suez Canal</li>" +
                "</ul></td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'><i>months, days of the week (indefinite)</i>" +
                "<ul>" +
                "<li>The weekend is over on Monday morning.</li>" +
                "<li>July and August are the most popular months for holidays.</li>" +
                "</ul></td>" +
                "<td style='padding-left: 0.5em'><i>months, days of the week (definite)</i>" +
                "<ul>" +
                "<li>I always remember <b><i>the</i></b> Monday when I had an accident." +
                "</li>" +
                "<li><b><i>The</i></b> August of 2001 was hot and dry.</li>" +
                "</ul></td>" +
                "</tr>" +
                "</table>" +
                "<br/>";
        return text;
    }
}
