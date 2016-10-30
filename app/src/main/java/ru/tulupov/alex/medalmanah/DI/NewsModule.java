package ru.tulupov.alex.medalmanah.DI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.tulupov.alex.medalmanah.Presenter.NewsPresenter;

@Module
public class NewsModule {

    @Provides
    @Singleton
    NewsPresenter provideNewPresenter() {
        return new NewsPresenter();
    }
}
