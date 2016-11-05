package ru.tulupov.alex.medalmanah;

import android.app.Application;

import ru.tulupov.alex.medalmanah.DI.AppComponent;
import ru.tulupov.alex.medalmanah.DI.DaggerAppComponent;
import ru.tulupov.alex.medalmanah.DI.EventModule;
import ru.tulupov.alex.medalmanah.DI.NewsModule;

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
