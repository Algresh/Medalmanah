package ru.tulupov.alex.medalmanah;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();
        initToolbar(resources.getString(R.string.news));
        initNavigationView();
        initTabs();
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
