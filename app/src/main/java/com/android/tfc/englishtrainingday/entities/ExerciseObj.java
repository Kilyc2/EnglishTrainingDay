package com.android.tfc.englishtrainingday.entities;

public class ExerciseObj {

    private int idExercise;
    private String version;
    private String level;
    private int idLesson;
    private int exerciseType;
    private String question;
    private String wording;
    private String solution;
    private String tip;
    private String options;

//    public ExerciseObj(int idExercise, int idLesson, String version, String level,
//                       int exerciseType, String question, String wording,
//                       String solution, String tip, String options) {
//        this.idLesson = idLesson;
//        this.version = version;
//        this.level = level;
//        this.idExercise = idExercise;
//        this.exerciseType = exerciseType;
//        this.question = question;
//        this.wording = wording;
//        this.solution = solution;
//        this.tip = tip;
//        this.options = options;
//    }

    public ExerciseObj(int idExercise, int exerciseType, String question, String wording,
                       String solution, String tip, String options) {
        this.idExercise = idExercise;
        this.exerciseType = exerciseType;
        this.question = question;
        this.wording = wording;
        this.solution = solution;
        this.tip = tip;
        this.options = options;
    }

//    public int getIdExercise() {
//        return idExercise;
//    }

    public int getIdLesson() {
        return idLesson;
    }

    public String getVersion() {
        return version;
    }

    public String getLevel() {
        return level;
    }

    public int getExerciseType() {
        return exerciseType;
    }

    public String getQuestion() {
        return question;
    }

    public String getWording() {
        return wording;
    }

    public String getSolution() {
        return solution;
    }

    public String getTip() {
        return tip;
    }

    public String getOptions() {
        return options;
    }
}
