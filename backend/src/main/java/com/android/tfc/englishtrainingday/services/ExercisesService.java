package com.android.tfc.englishtrainingday.services;

import com.android.tfc.englishtrainingday.data.ExercisesDataController.A1ExercisesDataController;
import com.android.tfc.englishtrainingday.data.ExercisesDataController.A2ExercisesDataController;
import com.android.tfc.englishtrainingday.data.ExercisesDataController.B1ExercisesDataController;
import com.android.tfc.englishtrainingday.data.ExercisesDataController.B2ExercisesDataController;
import com.android.tfc.englishtrainingday.data.ExercisesDataController.C1ExercisesDataController;
import com.android.tfc.englishtrainingday.data.ExercisesDataController.C2ExercisesDataController;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExercisesService extends HttpServlet {

    private static final String PARAM_LEVEL = "pLevel";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String level = req.getParameter(PARAM_LEVEL);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String json;
        json = new Gson().toJson(getExercises(level));
        resp.getWriter().write(json);
    }

    private ArrayList<String> getExercises(String level) {
        ArrayList<String> exercisesList = new ArrayList<>();
        EnumLevel eEnumLevel = EnumLevel.valueOf(level);
        switch (eEnumLevel) {
            case A1:
                exercisesList = A1ExercisesDataController.getAllExercises();
                break;
            case A2:
                exercisesList = A2ExercisesDataController.getAllExercises();
                break;
            case B1:
                exercisesList = B1ExercisesDataController.getAllExercises();
                break;
            case B2:
                exercisesList = B2ExercisesDataController.getAllExercises();
                break;
            case C1:
                exercisesList = C1ExercisesDataController.getAllExercises();
                break;
            case C2:
                exercisesList = C2ExercisesDataController.getAllExercises();
                break;
        }
        return exercisesList;
    }

    private enum EnumLevel {
        A1, A2, B1, B2, C1, C2
    }
}
