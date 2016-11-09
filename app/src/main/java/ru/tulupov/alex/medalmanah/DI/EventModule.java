package ru.tulupov.alex.medalmanah.di;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import ru.tulupov.alex.medalmanah.model.ModelImpl;
import ru.tulupov.alex.medalmanah.model.api.ApiEvents;
import ru.tulupov.alex.medalmanah.presenter.EventsPresenter;
import ru.tulupov.alex.medalmanah.presenter.SearchEventsPresenter;

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

    @Provides
    SearchEventsPresenter provideSearchEventsPresenter () {
        return new SearchEventsPresenter();
    }

    @Provides
    ModelImpl provideModelImpl () {
        return new ModelImpl();
    }

    @Provides
    ApiEvents provideApiEvents() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(baseUrl).build();
        return adapter.create(ApiEvents.class);
    }
}
