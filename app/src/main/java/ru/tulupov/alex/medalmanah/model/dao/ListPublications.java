package ru.tulupov.alex.medalmanah.model.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListPublications {

    @SerializedName("publications")
    @Expose
    protected List<News> publications;

    public List<News> getPublications() {
        return publications;
    }

    public void setPublications(List<News> publications) {
        this.publications = publications;
    }
}
