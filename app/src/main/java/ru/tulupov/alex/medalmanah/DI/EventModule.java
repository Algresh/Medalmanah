package ru.tulupov.alex.medalmanah.DI;

import dagger.Module;
import dagger.Provides;
import ru.tulupov.alex.medalmanah.Presenter.EventsPresenter;

@Module
public class EventModule {

    protected String baseUrl;

    public EventModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    EventsPresenter provideEventsPresenter () {
        return new EventsPresenter();
    }
}
