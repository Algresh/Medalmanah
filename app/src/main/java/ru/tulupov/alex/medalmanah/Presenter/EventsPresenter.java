package ru.tulupov.alex.medalmanah.Presenter;


import ru.tulupov.alex.medalmanah.EventView;

public class EventsPresenter implements Presenter {

    protected EventView eventView;

    public void onCreate(EventView eventView) {
        this.eventView = eventView;
    }

    @Override
    public void onStop() {

    }
}
