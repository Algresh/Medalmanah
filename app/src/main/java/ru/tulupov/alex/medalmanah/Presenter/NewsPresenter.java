package ru.tulupov.alex.medalmanah.presenter;

import javax.inject.Inject;

import ru.tulupov.alex.medalmanah.App;
import ru.tulupov.alex.medalmanah.model.ModelImpl;
import ru.tulupov.alex.medalmanah.model.dao.ListPublications;
import ru.tulupov.alex.medalmanah.presenter.callbacks.CallbackPublications;
import ru.tulupov.alex.medalmanah.view.fragments.NewsView;

public class NewsPresenter implements Presenter {


    private NewsView newsView;
    @Inject
    protected ModelImpl model;

    public void onCreate(NewsView newsView) {
        this.newsView = newsView;
        App.getComponent().inject(this);
    }

    public void showNews () {
        model.getListPublicationsByPage(1, new CallbackPublications() {
            @Override
            public void setPublications(ListPublications publications) {
                newsView.showNews(publications);
            }

            @Override
            public void failPublications() {
                newsView.failShowNews();
            }
        });
    }

    @Override
    public void onStop() {
        this.newsView = null;
    }
}
