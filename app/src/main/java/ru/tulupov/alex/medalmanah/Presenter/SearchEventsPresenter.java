package ru.tulupov.alex.medalmanah.presenter;

import javax.inject.Inject;

import ru.tulupov.alex.medalmanah.App;
import ru.tulupov.alex.medalmanah.model.dao.ListSpecialities;
import ru.tulupov.alex.medalmanah.model.ModelImpl;
import ru.tulupov.alex.medalmanah.presenter.Callbacks.CallbackSpecialities;
import ru.tulupov.alex.medalmanah.view.activties.SearchEventView;

public class SearchEventsPresenter implements Presenter {

    protected SearchEventView searchEventView;

    @Inject
    protected ModelImpl model;

    public void onCreate(SearchEventView searchEventView) {
        this.searchEventView = searchEventView;
        App.getComponent().inject(this);
    }

    public void getSpecialities () {
        model.getSpecialities(new CallbackSpecialities() {
            @Override
            public void setSpecialities(ListSpecialities specialities) {
                searchEventView.showSpecialities(specialities);
            }

            @Override
            public void failSpecialities() {
                searchEventView.showFailSpecialities();
            }
        });
    }

    @Override
    public void onStop() {
        this.searchEventView = null;
    }
}
