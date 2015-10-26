package com.android.tfc.englishtrainingday.services;

import com.android.tfc.englishtrainingday.data.LessonsData.A1LessonsData;
import com.android.tfc.englishtrainingday.data.LessonsData.A2LessonsData;
import com.android.tfc.englishtrainingday.data.LessonsData.B1LessonsData;
import com.android.tfc.englishtrainingday.data.LessonsData.B2LessonsData;
import com.android.tfc.englishtrainingday.data.LessonsData.C1LessonsData;
import com.android.tfc.englishtrainingday.data.LessonsData.C2LessonsData;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LessonsService extends HttpServlet {

    private static final String PARAM_LEVEL = "pLevel";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String level = req.getParameter(PARAM_LEVEL);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String json;
        json = new Gson().toJson(getLessons(level));
        resp.getWriter().write(json);
    }

    private ArrayList<String> getLessons(String level) {
        ArrayList<String> lessonsList = new ArrayList<>();
        EnumLevel eEnumLevel = EnumLevel.valueOf(level);
        switch (eEnumLevel) {
            case A1:
                lessonsList = A1LessonsData.getLessons();
                break;
            case A2:
                lessonsList = A2LessonsData.getLessons();
                break;
            case B1:
                lessonsList = B1LessonsData.getLessons();
                break;
            case B2:
                lessonsList = B2LessonsData.getLessons();
                break;
            case C1:
                lessonsList = C1LessonsData.getLessons();
                break;
            case C2:
                lessonsList = C2LessonsData.getLessons();
                break;
        }
        return lessonsList;
    }

    private enum EnumLevel {
        A1, A2, B1, B2, C1, C2
    }
}
