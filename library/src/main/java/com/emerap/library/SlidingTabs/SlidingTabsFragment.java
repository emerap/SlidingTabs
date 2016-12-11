package com.emerap.library.SlidingTabs;

import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

/**
 * SlidingTabsFragment class.
 *
 * Created by karbunkul on 19.12.15.
 */
public class SlidingTabsFragment {

    private String mTitle;
    private Fragment mFragment;
    private Drawable mIcon;

    public SlidingTabsFragment() {

    }

    public String getTitle() {
        return mTitle;
    }

    public SlidingTabsFragment setTitle(String title) {
        this.mTitle = title;
        return this;
    }

    Fragment getFragment() {
        return mFragment;
    }

    public SlidingTabsFragment setFragment(Fragment fragment) {
        this.mFragment = fragment;
        return this;
    }

    Drawable getIcon() {
        return mIcon;
    }

    private SlidingTabsFragment setIcon(Drawable icon) {
        this.mIcon = icon;
        return this;
    }

    public SlidingTabsFragment setIcon(Context context, int resId){
        this.setIcon(ContextCompat.getDrawable(context, resId));
        return this;
    }
}
