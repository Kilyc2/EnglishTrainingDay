package com.android.tfc.englishtrainingday.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import com.android.tfc.englishtrainingday.entities.GrammarTab;
import com.android.tfc.englishtrainingday.fragments.GrammarTabFragment;

import java.util.ArrayList;

public class GrammarCollectionPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<GrammarTab> listTabs;

    public GrammarCollectionPagerAdapter(FragmentManager fm, ArrayList<GrammarTab> listTabs) {
        super(fm);
        this.listTabs = listTabs;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment tabFragment = new GrammarTabFragment();
        Bundle args = new Bundle();
        args.putInt(GrammarTabFragment.LESSONTAB, listTabs.get(position).getIdLesson());
        args.putString(GrammarTabFragment.TABTEXT, listTabs.get(position).getTextTab());
        tabFragment.setArguments(args);
        return tabFragment;
    }

    @Override
    public int getCount() {
        return listTabs.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        if (position <= getCount()) {
            FragmentManager manager = ((Fragment) object).getFragmentManager();
            FragmentTransaction trans = manager.beginTransaction();
            trans.remove((Fragment) object);
            trans.commit();
        }
    }

}
