package com.android.tfc.englishtrainingday.entities;

public class ExerciseObj {

    private int idLesson;
    private String version;
    private String level;
    private int exerciseType;
    private String question;
    private String wording;
    private String solution;
    private String tip;
    private String options;

    public ExerciseObj(int idLesson, String version, String level, int exerciseType,
                       String question, String wording, String solution, String tip, String options) {

        this.idLesson = idLesson;
        this.version = version;
        this.level = level;
        this.exerciseType = exerciseType;
        this.question = question;
        this.wording = wording;
        this.solution = solution;
        this.tip = tip;
        this.options = options;
    }
}
