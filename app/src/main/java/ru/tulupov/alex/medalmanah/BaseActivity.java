package ru.tulupov.alex.medalmanah;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;

public class BaseActivity extends AppCompatActivity {


    @BindView(R.id.drawer_layout)
    protected DrawerLayout drawerLayout;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @BindView(R.id.navigationView)
    protected NavigationView navigationView;

    protected void initToolbar(String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
    }

    protected void initNavigationView() {
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();

                return true;
            }
        });
    }

}
