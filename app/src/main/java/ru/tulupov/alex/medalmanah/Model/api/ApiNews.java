package ru.tulupov.alex.medalmanah.model.api;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import ru.tulupov.alex.medalmanah.model.dao.News;

public interface ApiNews {

    @GET("/api/publications/{page}")
    void getPublicationsByPage(@Path("type") int page, Callback<List<News>> news);

}
