package ru.tulupov.alex.medalmanah.model;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import ru.tulupov.alex.medalmanah.App;
import ru.tulupov.alex.medalmanah.ListSpecialities;
import ru.tulupov.alex.medalmanah.model.api.ApiEvents;
import ru.tulupov.alex.medalmanah.model.api.ApiNews;
import ru.tulupov.alex.medalmanah.presenter.Callbacks.CallbackSpecialities;

public class ModelImpl {

    @Inject
    ApiNews apiNews;

    @Inject
    ApiEvents apiEvents;

    public ModelImpl() {
        App.getComponent().inject(this);
    }

    public void getSpecialities (final CallbackSpecialities callbackSpecialities) {
        apiEvents.getAllSpecialities(new Callback<ListSpecialities>() {
            @Override
            public void success(ListSpecialities specialities, Response response) {
                if (specialities != null) {
                    callbackSpecialities.setSpecialities(specialities);
                } else {
                    callbackSpecialities.failSpecialities();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                callbackSpecialities.failSpecialities();
            }
        });
    }
}
