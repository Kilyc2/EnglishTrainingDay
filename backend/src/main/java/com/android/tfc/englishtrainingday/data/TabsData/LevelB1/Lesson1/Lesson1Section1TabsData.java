package com.android.tfc.englishtrainingday.data.TabsData.LevelB1.Lesson1;

import com.android.tfc.englishtrainingday.entities.SectionTabObj;

import java.util.ArrayList;

public class Lesson1Section1TabsData {

    public static ArrayList<SectionTabObj> getTabs() {
        ArrayList<SectionTabObj> sectionTabs = new ArrayList<>();
        sectionTabs.add(new SectionTabObj(21010101, "B1", 210101,
                "Auxiliary verbs", getTextTab1()));
        sectionTabs.add(new SectionTabObj(21010102, "B1", 210101,
                "Auxiliary verbs in questions", getTextTab2()));
        sectionTabs.add(new SectionTabObj(21010103, "B1", 210101,
                "Wh- questions", getTextTab3()));
        sectionTabs.add(new SectionTabObj(21010104, "B1", 210101,
                "Auxiliaries used on their own", getTextTab4()));
        return sectionTabs;
    }

    private static String getTextTab1() {
        String text;
        text = "<p>We use <i>be, have</i> and <i>do</i> to form tenses, questions and negative forms, " +
                "and we use then in short answers, question tags, etc.<br/>" +
                "In all these cases they are called <b>auxiliary verbs</b>.</p>" +
                "<ul>" +
                "<li>We use <i>be</i> (+ verb + <i>-ing</i>) to form <b>continuous</b> tenses.<br/>" +
                "Present continuous: <i>he<b>'s studying</b> to become a doctor.</i><br/>" +
                "Past continuous: <i>I <b>was talking</b> to Charles the other day.</i>" +
                "</li>" +
                "<li>We use <i>have</i> (+ past participle) to form <b>perfect</b> tenses.<br/>" +
                "Present perfect: <i>We<b>'ve been</b> here for three months.</i><br/>" +
                "Past perfect: <i>The film <b>had started</b> when we got there.</i>" +
                "</li>" +
                "<li>We use <i>do</i> in <b>simple</b> tenses (in the question and negative forms).<br/>" +
                "Present simple: <i><b>Do</b> all your family live round here?</i><br/>" +
                "Past simple: <i>I <b>didn't</b> get your email.</i>" +
                "</li>" +
                "</ul>" +
                "<br />";
        return text;
    }

    private static String getTextTab2() {
        String text;
        text = "<p>In continuous and perfect tenses, <b>questions</b> are formed by inverting the " +
                "subject and auxiliary verb.</p>" +
                "<p><i><b>Is he</b> studying to become a doctor?</i><br/>" +
                "<i>How long <b>have your brother and sister</b> lived here?</i>" +
                "<br/>" +
                "<p>In simple tenses, we add <i>do/does</i> or <i>did</i>.</p>" +
                "<br />";
        return text;
    }

    private static String getTextTab3() {
        String text;
        text = "<p>We form many questions with <i>wh-</i> words and phrases.</p>" +
                "<table>" +
                "<tr><td><i>When ...?</i></td><td><i>Where ...?</i></td><td><i>What ...?</i></td></tr>" +
                "<tr><td><i>Which ...?</i></td><td><i>Why ...?</i></td><td><i>Who ...?</i></td></tr>" +
                "<tr><td><i>Whose ...?</i></td><td><i>How ...?</i></td><td><i>What kind of ...?</i></td></tr>" +
                "<tr><td><i>What sort of ...?</i></td><td><i>What time ...?</i></td><td><i>What colour ...?</i></td></tr>" +
                "<tr><td colspan='2'><i>Which book/school/woman,etc. ...?</i></td><td><i>How many ...?</i></td></tr>" +
                "<tr><td><i>How much ...?</i></td><td><i>How often ...?</i></td><td><i>How old ...?</i></td></tr>" +
                "<tr><td><i>What exactly ...?</i></td><td><i>Where exactly ...?</i></td><td><i>Why exactly ...?</i></td></tr>" +
                "</table>" +
                "<br/>" +
                "<p>Notice the word order after most <i>Wh-</i> questions.</p>" +
                "<table style='border: 1px solid black;'>" +
                "<tr style='background-color: #003399; color: #FFFFFF; padding-left: 0.5em'>" +
                "<th>(<i>wh-</i> word)</th>" +
                "<th>Auxiliary verb</th>" +
                "<th>Subject</th>" +
                "<th>Main verb, etc.</th>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'>What time</td>" +
                "<td style='padding-left: 0.5em'>are</td>" +
                "<td style='padding-left: 0.5em'>your friends</td>" +
                "<td style='padding-left: 0.5em'>arriving?</td>" +
                "</tr>" +
                "<tr style='background-color: #33B5E5;'>" +
                "<td style='padding-left: 0.5em'>Where</td>" +
                "<td style='padding-left: 0.5em'>do</td>" +
                "<td style='padding-left: 0.5em'>the other students in your class</td>" +
                "<td style='padding-left: 0.5em'>live?</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='padding-left: 0.5em'>What kind of music</td>" +
                "<td style='padding-left: 0.5em'>does</td>" +
                "<td style='padding-left: 0.5em'>your boyfriend</td>" +
                "<td style='padding-left: 0.5em'>listen to?</td>" +
                "</tr>" +
                "</tbody>" +
                "</table>" +
                "<br />";
        return text;
    }

    private static String getTextTab4() {
        String text;
        text = "<p><b>SHORT ANSWERS</b></p>" +
                "<ul>" +
                "<li>These can make the speaker sound more polite/interested.<br/>" +
                "<i><b>A:</b> Have you been here before?</i><br/>" +
                "<i><b>B:</b> Yes, I <b>have</b>.</i>" +
                "</li>" +
                "<li>We also use auxiliaries to avoid repeating long sentences.<br/>" +
                "<i><b>A:</b> Does your family live in Paris?</i><br/>" +
                "<i><b>B:</b> My father <b>does</b>, but my mother <b>doesn't</b>.</i>" +
                "</li>" +
                "</ul>" +
                "<p><b>SHORT QUESTIONS AND QUESTION TAGS</b></p>" +
                "<ul>" +
                "<li>" +
                "<i><b>A:</b> My brother's gone to live in Australia</i><br/>" +
                "<i><b>B: Has </b> he?</i>" +
                "<i>You were at home last night, <b>weren't</b> you?</i>" +
                "</li>" +
                "</ul>" +
                "<br />";
        return text;
    }
}
