package ru.tulupov.alex.medalmanah;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import ru.tulupov.alex.medalmanah.view.activties.BaseActivity;
import ru.tulupov.alex.medalmanah.view.TabsMainAdapter;

import static ru.tulupov.alex.medalmanah.Constants.MY_TAG;


public class MainActivity extends BaseActivity {

    TabsMainAdapter tabsMainAdapter;
    FloatingActionButton fab;

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            if (position != 1) {
                Animation animation = AnimationUtils.loadAnimation(getApplication(), R.anim.fab_event_filter_hide);
                fab.startAnimation(animation);
                fab.setVisibility(View.GONE);
            } else {
                Animation animation = AnimationUtils.loadAnimation(getApplication(), R.anim.fab_event_filter_start);
                fab.startAnimation(animation);
                fab.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();
        initToolbar(resources.getString(R.string.app_name));
        initNavigationView();
        initTabs();

        fab = (FloatingActionButton) findViewById(R.id.fabEvents);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchEventsActivity.class);
                startActivityForResult(intent, 200);
            }
        });



    }

    private void initTabs() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        String[] tabsTitle = getResources().getStringArray(R.array.tabs_main);
        tabsMainAdapter = new TabsMainAdapter(getSupportFragmentManager(), tabsTitle);
        viewPager.setAdapter(tabsMainAdapter);
        viewPager.addOnPageChangeListener(pageChangeListener);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 200 && data != null) {

            SearchEventParameters parameters =
                    (SearchEventParameters) data.getParcelableExtra(SearchEventsActivity.SEARCH_PARAMETERS);

            Log.d(MY_TAG, parameters.getSpeciality().getTitle());
            /**
             * TODO add argument for searching
             */
            tabsMainAdapter.getEventFragment().searchEvents();
        }

    }
}
