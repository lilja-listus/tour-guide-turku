package com.example.lilja.somethingtodointurku;

/**
 * Created by lilja on 7/5/17.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;

    //creating new Category Adapter
    public CategoryAdapter(Context context, FragmentManager manager) {
        super(manager);
        mContext = context;
    }
    //the controls

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new WelcomeFragment();
        } else if (position == 1) {
            return new PlacesFragment();
        } else if (position == 2) {
            return new DrinksFragment();
        } else if (position == 3) {
            return new EventsFragment();
        } else {
            return new PhrasesFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 5;
    }

    /**
     * @param position
     * @return the title of the page that is opened at the moment
     */
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.title_activity_welcome);
        } else if (position == 1) {
            return mContext.getString(R.string.title_activity_places);
        } else if (position == 2) {
            return mContext.getString(R.string.title_activity_drinks);
        } else if (position == 3) {
            return mContext.getString(R.string.title_activity_events);
        } else {
            return mContext.getString(R.string.title_activity_phrases);
        }
    }
}