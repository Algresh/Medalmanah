package ru.tulupov.alex.medalmanah.DI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import ru.tulupov.alex.medalmanah.Model.api.ApiNews;
import ru.tulupov.alex.medalmanah.Presenter.NewsPresenter;

@Module
public class NewsModule {

    protected String bseUrl;

    public NewsModule(String bseUrl) {
        this.bseUrl = bseUrl;
    }


    @Provides
    NewsPresenter provideNewsPresenter() {
        return new NewsPresenter();
    }

    @Provides
    ApiNews provideApiNews() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(bseUrl).build();
        return adapter.create(ApiNews.class);
    }
}
