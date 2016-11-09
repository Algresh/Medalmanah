package ru.tulupov.alex.medalmanah.model.dao;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListSpecialities {

    @SerializedName("specialties")
    @Expose
    protected List<Speciality> specialties;

    public ListSpecialities(List<Speciality> specialties) {
        this.specialties = specialties;
    }

    public ListSpecialities() {}

    public List<Speciality> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Speciality> specialties) {
        this.specialties = specialties;
    }

    @Override
    public String toString() {
        return specialties.toString();
    }
}
