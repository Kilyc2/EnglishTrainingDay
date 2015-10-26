package com.android.tfc.englishtrainingday.data.TabsData.LevelA1.Lesson3;

import com.android.tfc.englishtrainingday.entities.SectionTabObj;

import java.util.ArrayList;

public class Lesson3Section1TabsData {

    public static ArrayList<SectionTabObj> getTabs() {
        ArrayList<SectionTabObj> sectionTabs = new ArrayList<>();
        sectionTabs.add(new SectionTabObj(11030101, "A1", 110301,
                "The preposition in", getTextTab1()));
        sectionTabs.add(new SectionTabObj(11030102, "A1", 110301,
                "The preposition at", getTextTab2()));
        sectionTabs.add(new SectionTabObj(11030103, "A1", 110301,
                "The preposition on", getTextTab3()));
        return sectionTabs;
    }

    private static String getTextTab1() {
        String text;
        text = "<h3>Examples</h3>" +
                "<ul>" +
                "<li>We sit <b>in the room</b>." +
                "</li>" +
                "<li>I see a house <b>in the picture</b>." +
                "</li>" +
                "<li>There are trout <b>in the river</b>." +
                "</li>" +
                "<li>He lives <b>in Paris</b>." +
                "</li>" +
                "<li>I found the picture <b>in the paper</b>." +
                "</li>" +
                "<li>He sits <b>in the corner of the room</b>." +
                "</li>" +
                "<li>There is a big tree <b>in the middle of the garden</b>." +
                "</li>" +
                "<li>He sits <b>in the back of the car</b>." +
                "</li>" +
                "<li>We <b>arrive in Madrid</b>." +
                "</li>" +
                "<li>He gets <b>in the car</b>." +
                "</li>" +
                "<li>She likes walking <b>in the rain</b>." +
                "</li>" +
                "<li>My cousin lives <b>in the country</b>." +
                "</li>" +
                "<li>There are kites <b>in the sky</b>." +
                "</li>" +
                "<li>He plays <b>in the street</b>." +
                "</li>" +
                "<li>She lives <b>in a hotel</b>." +
                "</li>" +
                "<li>The boys stand <b>in a line</b>." +
                "</li>" +
                "<li>He is <b>in town</b>." +
                "</li>" +
                "<li>I have to stay <b>in bed</b>." +
                "</li>" +
                "<li>The robber is <b>in prison</b> now." +
                "</li>" +
                "<li>You mustn't park your car <b>in front of the school</b>." +
                "</li>" +
                "</ul>" +
                "<br/>";
        return text;
    }

    private static String getTextTab2() {
        String text;
        text = "<h3>Examples</h3>" +
                "<ul>" +
                "<li>She sits <b>at the desk</b>." +
                "</li>" +
                "<li>Open your books <b>at page 10</b>." +
                "</li>" +
                "<li>The bus stops <b>at Graz</b>." +
                "</li>" +
                "<li>I stay <b>at my grandmother's</b>." +
                "</li>" +
                "<li>I stand <b>at the door</b>." +
                "</li>" +
                "<li>Look <b>at the top of the page</b>." +
                "</li>" +
                "<li>The car stands <b>at the end of the street</b>." +
                "</li>" +
                "<li>Can we meet <b>at the corner of the street</b>?" +
                "</li>" +
                "<li>I met John <b>at a party</b>." +
                "</li>" +
                "<li>Write this information <b>at the beginning of the letter</b>." +
                "</li>" +
                "<li>Pat wasn't <b>at home</b> yesterday." +
                "</li>" +
                "<li>I study economics <b>at university</b>." +
                "</li>" +
                "<li>The childen are <b>at gandmother's</b>." +
                "</li>" +
                "<li>He's looking <b>at the park</b>." +
                "</li>" +
                "<li>He always arrives late <b>at school</b>." +
                "</li>" +
                "</ul>" +
                "<br/>";
        return text;
    }

    private static String getTextTab3() {
        String text;
        text = "<h3>Examples</h3>" +
                "<ul>" +
                "<li>The map lies <b>on the desk</b>." +
                "</li>" +
                "<li>The picture is <b>on page 10</b>." +
                "</li>" +
                "<li>The photo hangs <b>on the wall</b>." +
                "</li>" +
                "<li>He lives <b>on a farm</b>." +
                "</li>" +
                "<li>Dresden lies <b>on the river Elbe</b>." +
                "</li>" +
                "<li>Men's clothes are <b>on the second floor</b>." +
                "</li>" +
                "<li>He lives <b>on Heligoland</b>." +
                "</li>" +
                "<li>The shop is <b>on the left</b>." +
                "</li>" +
                "<li>My friend is <b>on the way</b> to Moscow." +
                "</li>" +
                "<li>When she was a little girl people saw unrealistic cowboy films <b>on television</b>." +
                "</li>" +
                "</ul>" +
                "<br/>";
        return text;
    }
}
