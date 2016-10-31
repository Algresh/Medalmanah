package ru.tulupov.alex.medalmanah.Presenter;

import ru.tulupov.alex.medalmanah.NewsView;

public class NewsPresenter implements Presenter {


    private NewsView newsView;

    public void onCreate(NewsView newsView) {
        this.newsView = newsView;
    }

    @Override
    public void onStop() {
        this.newsView = null;
    }
}
