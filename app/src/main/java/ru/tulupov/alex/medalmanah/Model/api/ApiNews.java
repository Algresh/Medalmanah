package ru.tulupov.alex.medalmanah.model.api;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import ru.tulupov.alex.medalmanah.model.dao.ListPublications;
import ru.tulupov.alex.medalmanah.model.dao.News;

public interface ApiNews {

    @GET("/api/publications/{page}")
    void getPublicationsByPage(@Path("page") int page, Callback<ListPublications> news);

}
