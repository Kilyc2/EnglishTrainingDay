package com.android.tfc.englishtrainingday.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.android.tfc.englishtrainingday.R;

public class GrammarTabFragment extends Fragment {

    public static final String TABTEXT = "tab_text";
    public static final String LESSONTAB = "lesson_tab";
    private final static String ESPACIOS_BOTON = "<br/><br/><br/>";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View grammarView = inflater.inflate(R.layout.grammar_tab, container, false);
        WebView textGrammar = (WebView) grammarView.findViewById(R.id.textViewTab);
        String text = getArguments().getString(TABTEXT) + ESPACIOS_BOTON;
        textGrammar.loadDataWithBaseURL(null, text, "text/html", "utf-8", null);
        return grammarView;
    }
}
