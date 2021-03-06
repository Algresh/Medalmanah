package ru.tulupov.alex.medalmanah;

import android.content.res.Resources;
import android.os.Bundle;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Resources resources = getResources();
        initToolbar(resources.getString(R.string.news));
        initNavigationView();

    }
}
