package ru.tulupov.alex.medalmanah.Model.api;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import ru.tulupov.alex.medalmanah.ListSpecialities;
import ru.tulupov.alex.medalmanah.News;
import ru.tulupov.alex.medalmanah.Speciality;

public interface ApiEvents {

    @GET("/api/specialty")
    void getAllSpecialities(Callback<ListSpecialities> specialities);

}
