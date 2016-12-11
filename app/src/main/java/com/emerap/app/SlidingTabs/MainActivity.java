package com.emerap.app.SlidingTabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.emerap.library.SlidingTabs.SlidingTabs;
import com.emerap.library.SlidingTabs.SlidingTabsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        SlidingTabs slidingTabs = new SlidingTabs(this)
                .setTabLayout(R.id.swipe_tabs_tabs)
                .setViewPager(R.id.swipe_tabs_pager)
                .setDrawableTint(R.color.colorAccent)
                .setTabStyle(SlidingTabs.TAB_STYLE_AUTO)
                .addTab(new SlidingTabsFragment()
                        .setTitle("Archive")
                        .setFragment(TestFragment.newInstance("Archive fragment"))
                        .setIcon(this, R.drawable.ic_archive))
                .addTab(new SlidingTabsFragment()
                        .setTitle("Android").setFragment(TestFragment.newInstance("Android fragment"))
                        .setIcon(this, R.drawable.ic_android))
                .addTab(new SlidingTabsFragment()
                        .setTitle("Education").setFragment(TestFragment.newInstance("Education fragment"))
                        .setIcon(this, R.drawable.ic_school));

        slidingTabs.setup();

    }
}
