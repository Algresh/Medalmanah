package ru.tulupov.alex.medalmanah.DI;

import dagger.Component;
import ru.tulupov.alex.medalmanah.EventFragment;
import ru.tulupov.alex.medalmanah.Model.ModelImpl;
import ru.tulupov.alex.medalmanah.NewsFragment;
import ru.tulupov.alex.medalmanah.Presenter.EventsPresenter;

@Component(modules = {NewsModule.class, EventModule.class})
public interface AppComponent {
    void inject(NewsFragment fragment);
    void inject(ModelImpl model);

    void inject(EventFragment fragment);
}
