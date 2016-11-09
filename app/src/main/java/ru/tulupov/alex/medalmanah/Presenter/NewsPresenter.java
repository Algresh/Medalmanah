package ru.tulupov.alex.medalmanah.presenter;

import javax.inject.Inject;

import ru.tulupov.alex.medalmanah.App;
import ru.tulupov.alex.medalmanah.model.ModelImpl;
import ru.tulupov.alex.medalmanah.model.dao.ListPublications;
import ru.tulupov.alex.medalmanah.presenter.Callbacks.CallbackPublications;
import ru.tulupov.alex.medalmanah.view.fragments.NewsView;

public class NewsPresenter implements Presenter {


    private NewsView newsView;
    @Inject
    protected ModelImpl model;

    public void onCreate(NewsView newsView) {
        this.newsView = newsView;
        App.getComponent().inject(this);
    }

    public void showNews (int page) {
        model.getListPublicationsByPage(page, new CallbackPublications() {
            @Override
            public void setPublications(ListPublications publications) {

            }

            @Override
            public void failPublications() {

            }
        });
    }

    @Override
    public void onStop() {
        this.newsView = null;
    }
}
