package com.fiap.carango.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.fiap.carango.fragments.CarsFragment;

/**
 * TODO Finish description
 * Responsible for work with parameters, ...
 */

public class TabAdapter extends FragmentStatePagerAdapter {

    // How many tabs we want
    public static final int TOTAL_TABS = 2;

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Returns which fragment we'll display
     */

    @Override
    public Fragment getItem(int position) {

        // Pass information between fragments
        Bundle b = new Bundle();

        if (position == 0) {
            b.putString("type", "classicos");
        } else {
            b.putString("type", "esportivos");
        }

        Fragment frag = new CarsFragment();
        frag.setArguments(b);

        return frag;
    }

    // Returns total tabs
    @Override
    public int getCount() {
        return TOTAL_TABS;
    }
}