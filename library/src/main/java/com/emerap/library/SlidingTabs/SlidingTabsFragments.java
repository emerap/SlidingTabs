package com.emerap.library.SlidingTabs;

import android.app.Fragment;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * SlidingTabsFragments class
 *
 * Created by karbunkul on 19.12.15.
 */
public class SlidingTabsFragments {

    private ArrayList<SlidingTabsFragment> mFragments = new ArrayList<>();

    /**
     * Add fragment
     *
     * @param fragment fragment
     */
    public void add(SlidingTabsFragment fragment) {
        ArrayList<SlidingTabsFragment> fragments = this.getFragments();
        if (fragments.add(fragment)) this.setFragments(fragments);
    }

    /**
     * Get count
     *
     * @return count
     */
    public int getCount() {

        return this.getFragments().size();
    }

    public Fragment getItem(int index){
        return this.getFragments().get(index).getFragment();
    }

    /**
     * Constructor
     */
    public SlidingTabsFragments() {
    }

    /**
     * Get fragments
     *
     * @return fragments
     */
    public ArrayList<SlidingTabsFragment> getFragments() {
        return mFragments;
    }

    /**
     * Set fragments
     *
     * @param fragments fragments
     */
    private void setFragments(ArrayList<SlidingTabsFragment> fragments) {
        this.mFragments = fragments;
    }

    public CharSequence getTitle(int index) {
        return this.getFragments().get(index).getTitle();
    }

    public Drawable getIcon(int index){
        return this.getFragments().get(index).getIcon();
    }
}
