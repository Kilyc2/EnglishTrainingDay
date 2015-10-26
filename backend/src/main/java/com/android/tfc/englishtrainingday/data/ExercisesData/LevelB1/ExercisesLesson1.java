package com.android.tfc.englishtrainingday.data.ExercisesData.LevelB1;


import com.android.tfc.englishtrainingday.entities.ExerciseObj;
import com.android.tfc.englishtrainingday.utils.VersionUtils;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ExercisesLesson1 {

    private final static int ID_LESSON = 2101;

    public static ArrayList<String> getExercises() {
        ArrayList<String> exercises = new ArrayList<>();
        Gson gson = new Gson();

        exercises.add(gson.toJson(new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 2,
                "Choose the correct auxiliary verb",
                "Where ____ your parents come from?",
                "do",
                "Where do your parents come from?",
                "are;do")));

        exercises.add(gson.toJson(new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 2,
                "Choose the correct auxiliary verb",
                "Johnny ____ got 16 cousins!",
                "has",
                "Johnny has got 16 cousins!",
                "is;has")));

        exercises.add(gson.toJson(new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 2,
                "Choose the correct auxiliary verb",
                "I really enjoyed the concert, but the others ____.",
                "didn't",
                "I really enjoyed the concert, but the others didn't.",
                "weren't;didn't")));

        exercises.add(gson.toJson(new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 2,
                "Choose the correct auxiliary verb",
                "A: Have you got any money with you?\nB: No, I ____.",
                "haven't",
                "A: Have you got any money with you?<br/>B: No, I haven't.",
                "don't;haven't")));

        exercises.add(gson.toJson(new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 2,
                "Choose the correct auxiliary verb",
                "Where ____ you born?",
                "were",
                "Where were you born?",
                "were;did")));

        exercises.add(gson.toJson(new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 2,
                "Choose the correct auxiliary verb",
                "My boyfriend likes my new hairstyle, but my mother ____.",
                "doesn't",
                "My boyfriend likes my new hairstyle, but my mother doesn't.",
                "isn't;doesn't")));

        exercises.add(gson.toJson(new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 2,
                "Choose the correct auxiliary verb",
                "How ____ your course going?",
                "is",
                "How is your course going?",
                "is;does")));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Complete the questions with suitable words.",
                "____ were your parents born, in China or in America?",
                "Where",
                "Where were your parents born, in China or in America?", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Complete the questions with suitable words.",
                "____'s your new car going?",
                "How",
                "How's your new car going?", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Complete the questions with suitable words.",
                "____ ____ do you have lunch normally?",
                "What time",
                "What time do you have lunch normally?", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Complete the questions with suitable words.",
                "What ____ you studying at university?",
                "Are",
                "What are you studying at university?", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Complete the questions with suitable words.",
                "____ ____ do you want: red or blue?",
                "What colour",
                "What colour do you want: red or blue?", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Complete the questions with suitable words.",
                "____ ____ ____ books do you like?",
                "What kind of",
                "What kind of books do you like?", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Complete the questions with suitable words.",
                "____ bag is this?",
                "Whose",
                "Whose bag is this?", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Complete the questions with suitable words.",
                "____ ____ do you go to the gym?",
                "How often",
                "How often do you go to the gym?", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Is the verb correct in the Present continuous? \n" +
                        "If not, rewrite with the correct Present simple form.",
                "Tomas isn't usually speaking much in class?",
                "Tomas doesn't usually speak much in class?",
                "Tomas doesn't usually speak much in class?", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Is the verb correct in the Present continuous? \n" +
                        "If not, rewrite with the correct Present simple form.",
                "Paula says she'll call you back - she's making a cake.",
                "",
                "It's correct!", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Is the verb correct in the Present continuous? \n" +
                        "If not, rewrite with the correct Present simple form.",
                "Shh! The children are having a little rest.",
                "",
                "It's correct!", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Is the verb correct in the Present continuous? \n" +
                        "If not, rewrite with the correct Present simple form.",
                "Look, it's getting dark already!",
                "",
                "It's correct!", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Is the verb correct in the Present continuous? \n" +
                        "If not, rewrite with the correct Present simple form.",
                "I'm not knowing your brother.",
                "I don't know your brother",
                "I don't know your brother.", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Is the verb correct in the Present continuous? \n" +
                        "If not, rewrite with the correct Present simple form.",
                "Harry's having six older sisters.",
                "Harry has six older sisters",
                "Harry has six older sisters.", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Is the verb correct in the Present continuous? \n" +
                        "If not, rewrite with the correct Present simple form.",
                "This city is becoming very expensive.",
                "",
                "It's correct!", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 1,
                "Is the verb correct in the Present continuous? \n" +
                        "If not, rewrite with the correct Present simple form.",
                "I'm understanding the Present continuous perfectly.",
                "I understand the Present continuous perfectly",
                "I understand the Present continuous perfectly.", null))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 4,
                "Write the correct form of the verb in brackets",
                "Her husband is a taxi driver so he ____(get) home late.",
                "gets",
                "Her husband is a taxi driver so he gets home late.", "get"))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 4,
                "Write the correct form of the verb in brackets",
                "____(you like) my new shoes?",
                "Do you like",
                "Do you like my new shoes?", "like"))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 4,
                "Write the correct form of the verb in brackets",
                "You can't use the bathroom. Alice ____(have) a shower.",
                "is having",
                "You can't use the bathroom. Alice is having a shower.", "have"))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 4,
                "Write the correct form of the verb in brackets",
                "I must go to the hairdresser's. My hair ____(get) very long.",
                "is getting",
                "I must go to the hairdresser's. My hair is getting very long.", "get"))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 4,
                "Write the correct form of the verb in brackets",
                "Sorry, but I ____(think) you're wrong.",
                "think",
                "Sorry, but I think you're wrong.", "think"))));

        exercises.add(gson.toJson((new ExerciseObj(ID_LESSON, VersionUtils.getVersionCode(), "B1", 4,
                "Write the correct form of the verb in brackets",
                "In my job, I ____(spend) a lot of time on the phone.",
                "spend",
                "In my job, I ____(spend) a lot of time on the phone.", "spend"))));

        return exercises;
    }
}
