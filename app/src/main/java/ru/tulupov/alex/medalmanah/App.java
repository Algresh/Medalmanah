package ru.tulupov.alex.medalmanah;

import android.app.Application;

import ru.tulupov.alex.medalmanah.di.AppComponent;
import ru.tulupov.alex.medalmanah.di.DaggerAppComponent;
import ru.tulupov.alex.medalmanah.di.EventModule;
import ru.tulupov.alex.medalmanah.di.NewsModule;

public class App extends Application {

    public static final String DOMAIN = "https://medalmanah.ru";

    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder().newsModule(new NewsModule(DOMAIN))
                .eventModule(new EventModule(DOMAIN)).build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }
}
