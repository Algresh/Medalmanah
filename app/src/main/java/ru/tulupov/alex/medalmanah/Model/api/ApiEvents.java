package ru.tulupov.alex.medalmanah.model.api;

import retrofit.Callback;
import retrofit.http.GET;
import ru.tulupov.alex.medalmanah.ListSpecialities;

public interface ApiEvents {

    @GET("/api/specialty")
    void getAllSpecialities(Callback<ListSpecialities> specialities);

}
