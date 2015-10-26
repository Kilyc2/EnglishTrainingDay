package com.android.tfc.englishtrainingday.adapters;

import android.app.Activity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.android.tfc.englishtrainingday.R;
import com.android.tfc.englishtrainingday.entities.LessonItem;
import com.android.tfc.englishtrainingday.entities.SectionItem;

public class GrammarItemsAdapter extends BaseExpandableListAdapter {

    private final SparseArray<LessonItem> items;
    public LayoutInflater inflater;
    public Activity activity;

    public GrammarItemsAdapter(Activity activity, SparseArray<LessonItem> items) {
        this.activity = activity;
        this.items = items;
        this.inflater = this.activity.getLayoutInflater();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.items.get(groupPosition).getSection(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return ((SectionItem) getChild(groupPosition, childPosition)).getIdSection();
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        final SectionItem children = (SectionItem) getChild(groupPosition, childPosition);
        TextView textViewChildren;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.children_item, null);
        }
        textViewChildren = (TextView) convertView.findViewById(R.id.childrenItem);
        textViewChildren.setText(children.getSectionName());
        if (children.isSelected()) {
            convertView.setBackgroundColor(
                    parent.getResources().getColor(R.color.children_selected_bg));
        } else {
            convertView.setBackgroundResource(R.drawable.item_bg);
        }
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.items.get(groupPosition).countSections();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.items.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.items.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return ((LessonItem) getGroup(groupPosition)).getIdLesson();
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.group_item, null);
        }
        LessonItem group = (LessonItem) getGroup(groupPosition);
        CheckedTextView groupItem = (CheckedTextView) convertView.findViewById(R.id.groupItem);
        groupItem.setText(group.getLessonName());
        groupItem.setChecked(isExpanded);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void deselectedChildren() {
        for (int idGroup = 0; idGroup < getGroupCount(); idGroup++) {
            for (int idChild = 0; idChild < getChildrenCount(idGroup); idChild++) {
                SectionItem child = (SectionItem) getChild(idGroup, idChild);
                if (child.isSelected()) {
                    child.setSelected(false);
                    return;
                }
            }
        }
    }
}
