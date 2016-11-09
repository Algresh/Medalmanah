package ru.tulupov.alex.medalmanah.presenter.Callbacks;

import ru.tulupov.alex.medalmanah.model.dao.ListPublications;

public interface CallbackPublications {

    void setPublications(ListPublications publications);
    void failPublications();


}
