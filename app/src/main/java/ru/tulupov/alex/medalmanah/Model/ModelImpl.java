package ru.tulupov.alex.medalmanah.Model;

import javax.inject.Inject;

import ru.tulupov.alex.medalmanah.App;
import ru.tulupov.alex.medalmanah.Model.api.ApiNews;

public class ModelImpl {

    @Inject
    ApiNews apiNews;

    public ModelImpl() {
        App.getComponent().inject(this);
    }
}
