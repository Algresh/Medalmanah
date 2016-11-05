package ru.tulupov.alex.medalmanah;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;


public class MainActivity extends BaseActivity {

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

                FilterEventsDialogFragment fragment = new FilterEventsDialogFragment();
                fragment.show(getFragmentManager(),"sd" );
            }
        });
    }

    private void initTabs() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        String[] tabsTitle = getResources().getStringArray(R.array.tabs_main);
        TabsMainAdapter tabsMainAdapter = new TabsMainAdapter(getSupportFragmentManager(), tabsTitle);
        viewPager.setAdapter(tabsMainAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
