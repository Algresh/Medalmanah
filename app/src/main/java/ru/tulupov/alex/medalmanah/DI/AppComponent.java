package ru.tulupov.alex.medalmanah.di;

import dagger.Component;
import ru.tulupov.alex.medalmanah.view.EventFragment;
import ru.tulupov.alex.medalmanah.model.ModelImpl;
import ru.tulupov.alex.medalmanah.view.NewsFragment;
import ru.tulupov.alex.medalmanah.presenter.SearchEventsPresenter;
import ru.tulupov.alex.medalmanah.SearchEventsActivity;

@Component(modules = {NewsModule.class, EventModule.class})
public interface AppComponent {
    void inject(NewsFragment fragment);
    void inject(ModelImpl model);

    void inject(EventFragment fragment);

    void inject(SearchEventsActivity activity);

    void inject(SearchEventsPresenter presenter);
}
