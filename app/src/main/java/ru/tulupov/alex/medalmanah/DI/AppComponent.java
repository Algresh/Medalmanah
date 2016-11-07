package ru.tulupov.alex.medalmanah.DI;

import dagger.Component;
import ru.tulupov.alex.medalmanah.EventFragment;
import ru.tulupov.alex.medalmanah.Model.ModelImpl;
import ru.tulupov.alex.medalmanah.NewsFragment;
import ru.tulupov.alex.medalmanah.Presenter.EventsPresenter;
import ru.tulupov.alex.medalmanah.Presenter.SearchEventsPresenter;
import ru.tulupov.alex.medalmanah.SearchEventsActivity;

@Component(modules = {NewsModule.class, EventModule.class})
public interface AppComponent {
    void inject(NewsFragment fragment);
    void inject(ModelImpl model);

    void inject(EventFragment fragment);

    void inject(SearchEventsActivity activity);

    void inject(SearchEventsPresenter presenter);
}
