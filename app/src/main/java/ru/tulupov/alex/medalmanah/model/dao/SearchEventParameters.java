package ru.tulupov.alex.medalmanah.model.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchEventParameters implements Parcelable {

    private Speciality speciality;

    private int location = 0;

    private String searchLine;

    private String start;

    private String end;

    public SearchEventParameters() {}

    protected SearchEventParameters(Parcel in) {
        location = in.readInt();
        searchLine = in.readString();
        start = in.readString();
        end = in.readString();

        speciality = new Speciality();
        speciality.setId(in.readInt());
        speciality.setTitle(in.readString());
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getSearchLine() {
        return searchLine;
    }

    public void setSearchLine(String searchLine) {
        this.searchLine = searchLine;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public static final Creator<SearchEventParameters> CREATOR = new Creator<SearchEventParameters>() {
        @Override
        public SearchEventParameters createFromParcel(Parcel in) {
            return new SearchEventParameters(in);
        }

        @Override
        public SearchEventParameters[] newArray(int size) {
            return new SearchEventParameters[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(location);
        parcel.writeString(searchLine);
        parcel.writeString(start);
        parcel.writeString(end);
        parcel.writeInt(speciality.getId());
        parcel.writeString(speciality.getTitle());
    }
}
