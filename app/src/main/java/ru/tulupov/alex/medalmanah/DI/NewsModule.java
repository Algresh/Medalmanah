package ru.tulupov.alex.medalmanah.di;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import ru.tulupov.alex.medalmanah.model.api.ApiNews;
import ru.tulupov.alex.medalmanah.presenter.NewsPresenter;

@Module
public class NewsModule {

    protected String baseUrl;

    public NewsModule(String bseUrl) {
        this.baseUrl = bseUrl;
    }


    @Provides
    NewsPresenter provideNewsPresenter() {
        return new NewsPresenter();
    }

    @Provides
    ApiNews provideApiNews() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(baseUrl).build();
        return adapter.create(ApiNews.class);
    }
}
