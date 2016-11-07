package ru.tulupov.alex.medalmanah.Presenter;

import javax.inject.Inject;

import ru.tulupov.alex.medalmanah.App;
import ru.tulupov.alex.medalmanah.ListSpecialities;
import ru.tulupov.alex.medalmanah.Model.ModelImpl;
import ru.tulupov.alex.medalmanah.Presenter.Callbacks.CallbackSpecialities;
import ru.tulupov.alex.medalmanah.SearchEventView;

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
