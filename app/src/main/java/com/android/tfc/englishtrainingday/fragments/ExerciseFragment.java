package com.android.tfc.englishtrainingday.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.tfc.englishtrainingday.R;
import com.android.tfc.englishtrainingday.model.ExercisesTable;

public class ExerciseFragment extends Fragment {

    public final static String TAG = "tag";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View exerciseView;
        int exerciseType = getArguments().getInt(ExercisesTable.COLUMN_EXERCISE_TYPE);
        String question = getArguments().getString(ExercisesTable.COLUMN_QUESTION);
        String wording = getArguments().getString(ExercisesTable.COLUMN_WORDING);
        String options = getArguments().getString(ExercisesTable.COLUMN_OPTIONS);
        int tag = getArguments().getInt(TAG);
        switch (exerciseType) {
            case 1:
                exerciseView = inflater.inflate(R.layout.exercise_type1, container, false);
                break;
            case 2:
                exerciseView = inflater.inflate(R.layout.exercise_type2, container, false);
                RadioGroup radioGroup = (RadioGroup) exerciseView.findViewById(R.id.rgroup);
                RadioButton radioButton;
                for (String opt : options.split(";")) {
                    radioButton = new RadioButton(container.getContext());
                    radioButton.setText(opt);
                    radioGroup.addView(radioButton);
                }
                break;
            case 3:
                exerciseView = inflater.inflate(R.layout.exercise_type3, container, false);
                LinearLayout checkGroup = (LinearLayout) exerciseView.findViewById(R.id.chkGroup);
                CheckBox checkBox;
                for (String opt : options.split(";")) {
                    checkBox = new CheckBox(container.getContext());
                    checkBox.setText(opt);
                    checkGroup.addView(checkBox);
                }
                break;
            case 4:
                exerciseView = inflater.inflate(R.layout.exercise_type4, container, false);
                LinearLayout textGroup = (LinearLayout) exerciseView.findViewById(R.id.txtGroup);
                TextView lblExercise;
                EditText txtExercise;
                for (String line : options.split(";")) {
                    lblExercise = new TextView(container.getContext());
                    lblExercise.setText(line);
                    txtExercise = new EditText(container.getContext());
                    txtExercise.setLines(1);
                    txtExercise.setSingleLine(true);
                    textGroup.addView(lblExercise);
                    textGroup.addView(txtExercise);
                }
                break;
            default:
                return null;
        }
        TextView textQuestion = (TextView) exerciseView.findViewById(R.id.txtQuestion);
        TextView textWording = (TextView) exerciseView.findViewById(R.id.txtWording);
        textQuestion.setText(question);
        textWording.setText(wording);
        exerciseView.setTag(tag);
        return exerciseView;
    }
}
