package com.emerap.library.SlidingTabs;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import static android.R.color.darker_gray;
import static android.support.v4.content.ContextCompat.getColor;

/**
 * Swipe Tabs library.
 * <p/>
 * Created by karbunkul on 18/12/15.
 */
public class SlidingTabs {

    final static public int TAB_STYLE_TEXT = 0;
    final static public int TAB_STYLE_ICON = 1;
    final static public int TAB_STYLE_BOTH = 2;
    final static public int TAB_STYLE_AUTO = 3;

    private AppCompatActivity mActivity;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private int drawableTint;
    private SlidingTabsPagerAdapter mPagerAdapter;
    private SlidingTabsFragments mFragments = new SlidingTabsFragments();
    private int mTabStyle = TAB_STYLE_TEXT;

    /**
     * Setup swipe tabs
     *
     * @return
     */
    public void setup() {
        TabLayout tabLayout = this.getTabLayout();
        ViewPager viewPager = this.getViewPager();
        SlidingTabsPagerAdapter pagerAdapter = this.getPagerAdapter();

        if (pagerAdapter == null) {
            pagerAdapter = new SlidingTabsPagerAdapter(this.getActivity().getFragmentManager(), this.mFragments);
        }

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        this.setViewPager(viewPager);
        this.setTabLayout(tabLayout);
        this.setupTabStyles();
    }

    /**
     * Add tab
     *
     * @param title    title tab
     * @param fragment fragment
     * @return SlidingTabs
     */
    public SlidingTabs addTab(String title, Fragment fragment) {
        SlidingTabsFragment swipeTabsFragment = new SlidingTabsFragment()
                .setTitle(title).setFragment(fragment);
        this.mFragments.add(swipeTabsFragment);
        return this;
    }

    public SlidingTabs addTab(SlidingTabsFragment fragment) {
        this.mFragments.add(fragment);
        return this;
    }

    private void setupTabStyles() {
        TabLayout tabLayout = this.getTabLayout();
        SlidingTabsFragments fragments = this.getFragments();
        switch (this.getTabStyle()) {

            case SlidingTabs.TAB_STYLE_TEXT:
                for (int index = 0; index < tabLayout.getTabCount(); index++) {
                    tabLayout.getTabAt(index).setIcon(null);
                }
                break;
            case SlidingTabs.TAB_STYLE_ICON:
                for (int index = 0; index < tabLayout.getTabCount(); index++) {
                    tabLayout.getTabAt(index).setText("");
                    tabLayout.getTabAt(index).setIcon(fragments.getIcon(index));
                }
                break;
            case SlidingTabs.TAB_STYLE_BOTH:
                for (int index = 0; index < tabLayout.getTabCount(); index++) {
                    tabLayout.getTabAt(index).setIcon(fragments.getIcon(index));
                }
                break;
            case SlidingTabs.TAB_STYLE_AUTO:
                for (int index = 0; index < tabLayout.getTabCount(); index++) {
                    Drawable drawable = this.getFragments().getIcon(index);
                    TabLayout.Tab tab = tabLayout.getTabAt(index);
                    if (drawable != null) {
                        tab.setIcon(drawable);
                        tab.setText("");
                    } else {
                        tab.setText(fragments.getTitle(index));
                    }
                }
                break;
        }

        this.setTabLayout(tabLayout);
    }


    /**
     * Constructor SlidingTabs
     *
     * @param activity activity object
     */
    public SlidingTabs(AppCompatActivity activity) {
        this.setActivity(activity);
    }

    /**
     * Get ViewPager
     *
     * @return ViewPager
     */
    public ViewPager getViewPager() {
        return mViewPager;
    }

    /**
     * Get ViewPager static method
     *
     * @param activity   activity
     * @param resourceId resource ID
     * @return
     */
    public static ViewPager getViewPager(AppCompatActivity activity, int resourceId) {
        return (ViewPager) activity.findViewById(resourceId);
    }

    /**
     * Set ViewPager from resource ID
     *
     * @param resourceId resource ID
     * @return SlidingTabs
     */
    public SlidingTabs setViewPager(int resourceId) {
        ViewPager viewPager = SlidingTabs.getViewPager(this.getActivity(), resourceId);
        this.setViewPager(viewPager);
        return this;
    }

    /**
     * Set ViewPager helper
     *
     * @param viewPager ViewPager
     */
    private void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
    }

    /**
     * Get TabLayout
     *
     * @return TabLayout
     */
    public TabLayout getTabLayout() {
        return mTabLayout;
    }

    /**
     * Get TabLayout static method
     *
     * @param activity   activity
     * @param resourceId resource ID
     * @return TabLayout
     */
    public static TabLayout getTabLayout(AppCompatActivity activity, int resourceId) {
        return (TabLayout) activity.findViewById(resourceId);
    }

    /**
     * Set TabLayout from resource ID
     *
     * @param resourceId resource ID
     * @return SlidingTabs
     */
    public SlidingTabs setTabLayout(int resourceId) {
        TabLayout tabLayout = SlidingTabs.getTabLayout(this.getActivity(), resourceId);
        this.setTabLayout(tabLayout);
        return this;
    }

    /**
     * Setter for field "mTabLayout"
     *
     * @param tabLayout TabLayout
     */
    private void setTabLayout(TabLayout tabLayout) {
        this.mTabLayout = tabLayout;
    }

    /**
     * Getter for field "mPagerAdapter"
     *
     * @return PagerAdapter
     */
    private SlidingTabsPagerAdapter getPagerAdapter() {
        return mPagerAdapter;
    }

    /**
     * Setter for field "mPagerAdapter"
     *
     * @param pagerAdapter PagerAdapter
     * @return SlidingTabs
     */
    public SlidingTabs setPagerAdapter(SlidingTabsPagerAdapter pagerAdapter) {
        this.mPagerAdapter = pagerAdapter;
        return this;
    }

    /**
     * Get activity object
     *
     * @return activity
     */
    public AppCompatActivity getActivity() {
        return mActivity;
    }

    /**
     * Set activity
     *
     * @param activity
     */
    public SlidingTabs setActivity(AppCompatActivity activity) {
        this.mActivity = activity;
        return this;
    }

    public int getTabStyle() {
        return mTabStyle;
    }

    public SlidingTabs setTabStyle(int tabStyle) {
        this.mTabStyle = tabStyle;
        return this;
    }

    public int getDrawableTint() {
        return drawableTint;
    }

    public SlidingTabs setDrawableTint(int drawableTint) {
        this.drawableTint = drawableTint;
        return this;
    }


    public SlidingTabsFragments getFragments() {
        return mFragments;
    }
}