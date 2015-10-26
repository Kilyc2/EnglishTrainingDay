package com.android.tfc.englishtrainingday.entities;

public class HistoricalObj {

    private String level;
    private int idLesson;
    private String name;
    private int exerciseDone;
    private int exerciseOk;
    private String versionCode;

    public HistoricalObj(String level, int idLesson, String name, String versionCode,
                         int exerciseDone, int exerciseOk) {
        this.level = level;
        this.idLesson = idLesson;
        this.name = name;
        this.versionCode = versionCode;
        this.exerciseDone = exerciseDone;
        this.exerciseOk = exerciseOk;
    }

    public String getLevel() {
        return level;
    }

    public int getIdLesson() {
        return idLesson;
    }

    public String getName() {
        return name;
    }

//    public String getVersionCode() {
//        return versionCode;
//    }

    public int getExerciseDone() {
        return exerciseDone;
    }

    public int getExerciseOk() {
        return exerciseOk;
    }

    public String getScore() {
        try {
            return String.valueOf((this.exerciseOk * 100) / this.exerciseDone);
        } catch (ArithmeticException ae) {
            return "";
        }
    }

    public String getDetail() {
        return "Done: " + this.exerciseDone + " - Correct: " + this.exerciseOk;
    }
}
