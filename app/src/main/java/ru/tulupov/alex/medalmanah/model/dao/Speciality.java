package ru.tulupov.alex.medalmanah.model.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Speciality {

    @SerializedName("id")
    @Expose
    protected int id;

    @SerializedName("title")
    @Expose
    protected String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
