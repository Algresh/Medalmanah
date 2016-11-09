package ru.tulupov.alex.medalmanah.view.fragments;


import ru.tulupov.alex.medalmanah.model.dao.ListPublications;

public interface NewsView {

    void showNews (ListPublications publications);
    void showNewsByPage (ListPublications publications);
    void failShowNews();
}
