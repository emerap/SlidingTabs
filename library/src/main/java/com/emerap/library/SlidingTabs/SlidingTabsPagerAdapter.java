package com.emerap.library.SlidingTabs;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

/**
 * SlidingTabsPagerAdapter class.
 * Created by karbunkul on 18/12/15.
 */
public class SlidingTabsPagerAdapter extends FragmentPagerAdapter {

    private SlidingTabsFragments mFragments;

    public SlidingTabsPagerAdapter(FragmentManager fm, SlidingTabsFragments fragments) {
        super(fm);
        this.setFragments(fragments);
    }

    public SlidingTabsFragments getFragments() {
        return mFragments;
    }

    public void setFragments(SlidingTabsFragments fragments) {
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.getFragments().getItem(position);
    }

    @Override
    public int getCount() {
        return this.getFragments().getCount();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.getFragments().getTitle(position);
    }
}
