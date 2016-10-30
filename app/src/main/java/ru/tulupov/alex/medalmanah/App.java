package ru.tulupov.alex.medalmanah;

import android.app.Application;

import ru.tulupov.alex.medalmanah.DI.AppComponent;

/**
 * Created by tulup on 30.10.2016.
 */

public class App extends Application {

    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

//    protected AppComponent buildComponent() {
//
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = getComponent();
    }
}
