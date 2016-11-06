package ru.tulupov.alex.medalmanah;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;


public class MainActivity extends BaseActivity {

    TabsMainAdapter tabsMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();
        initToolbar(resources.getString(R.string.news));
        initNavigationView();
        initTabs();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabEvents);
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
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 200 && data != null) {

            /**
             * TODO add argument for searching
             */
            tabsMainAdapter.getEventFragment().searchEvents();
        }

    }
}
