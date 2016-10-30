package ru.tulupov.alex.medalmanah;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class TabsMainAdapter extends FragmentPagerAdapter {

    public static final int TAB_NEWS = 0;
    public static final int TAB_EVENTS = 1;

    private String[] titleTabs;

    private NewsFragment newsFragment;
    private EventFragment eventFragment;

    public TabsMainAdapter(FragmentManager fm, String[] titleTabs) {
        super(fm);
        this.titleTabs = titleTabs;
        newsFragment = NewsFragment.getInstance();
        eventFragment = EventFragment.getInstance();
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case TAB_NEWS:
                return newsFragment;
            case TAB_EVENTS:
                return eventFragment;
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleTabs[position];
    }

    @Override
    public int getCount() {
        return titleTabs.length;
    }
}
