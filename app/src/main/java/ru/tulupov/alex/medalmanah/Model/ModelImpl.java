package ru.tulupov.alex.medalmanah.model;

import android.util.Log;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import ru.tulupov.alex.medalmanah.App;
import ru.tulupov.alex.medalmanah.model.dao.ListPublications;
import ru.tulupov.alex.medalmanah.model.dao.ListSpecialities;
import ru.tulupov.alex.medalmanah.model.api.ApiEvents;
import ru.tulupov.alex.medalmanah.model.api.ApiNews;
import ru.tulupov.alex.medalmanah.presenter.callbacks.CallbackPublications;
import ru.tulupov.alex.medalmanah.presenter.callbacks.CallbackSpecialities;

import static ru.tulupov.alex.medalmanah.Constants.MY_TAG;

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

    public void getListPublicationsByPage (int page, final CallbackPublications callbackPublications) {
        apiNews.getPublicationsByPage(page, new Callback<ListPublications>() {
            @Override
            public void success(ListPublications listPublications, Response response) {
                Log.d(MY_TAG, "fffffs");
                if (listPublications != null) {
                    callbackPublications.setPublications(listPublications);
                } else {
                    callbackPublications.failPublications();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                callbackPublications.failPublications();
            }
        });

    }
}
