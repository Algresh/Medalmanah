package ru.tulupov.alex.medalmanah.presenter.callbacks;

import ru.tulupov.alex.medalmanah.model.dao.ListPublications;

public interface CallbackPublications {

    void setPublications(ListPublications publications);
    void failPublications();


}
