package com.emerap.app.SlidingTabs;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emerap.library.SlidingTabs.SlidingTabsFragment;

public class TestFragment extends Fragment {

    public TestFragment() {
    }

    public static TestFragment newInstance(String name) {

        Bundle args = new Bundle();

        args.putString("title", name);
        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle args = getArguments();

        View rootView = inflater.inflate(R.layout.fragment_test, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.swipe_tabs_text_title);
        String name = args.getString("title");
        textView.setText(name);
        return rootView;
    }
}
