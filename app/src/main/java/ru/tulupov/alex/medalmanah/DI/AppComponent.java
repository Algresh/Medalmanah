package ru.tulupov.alex.medalmanah.di;

import dagger.Component;
import ru.tulupov.alex.medalmanah.presenter.NewsPresenter;
import ru.tulupov.alex.medalmanah.view.fragments.EventFragment;
import ru.tulupov.alex.medalmanah.model.ModelImpl;
import ru.tulupov.alex.medalmanah.view.fragments.NewsFragment;
import ru.tulupov.alex.medalmanah.presenter.SearchEventsPresenter;
import ru.tulupov.alex.medalmanah.view.activties.SearchEventsActivity;

@Component(modules = {NewsModule.class, EventModule.class})
public interface AppComponent {
    void inject(NewsFragment fragment);
    void inject(ModelImpl model);

    void inject(EventFragment fragment);

    void inject(SearchEventsActivity activity);

    void inject(SearchEventsPresenter presenter);
    void inject(NewsPresenter presenter);
}
