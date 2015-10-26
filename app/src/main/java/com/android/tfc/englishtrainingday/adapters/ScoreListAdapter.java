package com.android.tfc.englishtrainingday.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.tfc.englishtrainingday.R;
import com.android.tfc.englishtrainingday.entities.HistoricalObj;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ScoreListAdapter extends ArrayAdapter<HistoricalObj> {

    private HashMap<Integer, Boolean> mSelection = new HashMap<>();

    public ScoreListAdapter(Context context, int resource, List<HistoricalObj> objects) {
        super(context, resource, objects);
    }

    public void setNewSelection(int position, boolean value) {
        mSelection.put(position, value);
        notifyDataSetChanged();
    }

    public Set<Integer> getCurrentCheckedPosition() {
        return mSelection.keySet();
    }

    public void removeSelection(int position) {
        mSelection.remove(position);
        notifyDataSetChanged();
    }

    public void clearSelection() {
        mSelection = new HashMap<>();
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HistoricalObj item = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.score_item, null);
        }
        TextView txtLesson = (TextView) convertView.findViewById(R.id.lesson_text);
        TextView txtScore = (TextView) convertView.findViewById(R.id.score_text);
        TextView txtDetail = (TextView) convertView.findViewById(R.id.detail_score_text);

        txtLesson.setText(item.getName());
        txtScore.setText(String.valueOf(item.getScore()));
        txtDetail.setText(item.getDetail());

        convertView.setBackgroundResource(R.drawable.item_score_bg);

        if (mSelection.get(position) != null) {
            convertView.setBackgroundResource(android.R.color.holo_blue_light);
        }

        return convertView;
    }

    @Override
    public HistoricalObj getItem(int position) {
        return super.getItem(position);
    }
}
