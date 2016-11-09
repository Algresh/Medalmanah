package ru.tulupov.alex.medalmanah.presenter;


import ru.tulupov.alex.medalmanah.view.fragments.EventView;

public class EventsPresenter implements Presenter {

    protected EventView eventView;

    public void onCreate(EventView eventView) {
        this.eventView = eventView;
    }

    @Override
    public void onStop() {

    }
}
