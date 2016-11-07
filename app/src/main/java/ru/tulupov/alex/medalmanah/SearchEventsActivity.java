package ru.tulupov.alex.medalmanah;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import ru.tulupov.alex.medalmanah.Presenter.SearchEventsPresenter;

import static ru.tulupov.alex.medalmanah.Constants.MY_TAG;

public class SearchEventsActivity extends AppCompatActivity
        implements View.OnClickListener, MyDatePickerFragment.DatePickerListener, SearchEventView
        , FragmentSpecialitiesDialog.SelectSpeciality, FragmentLocationDialog.SelectLocation {

    private static final String TYPE_DATE_START = "start";
    private static final String TYPE_DATE_END = "end";

    EditText searchLine;
    TextView startDateTV;
    TextView endDateTV;
    TextView specializationTV;
    TextView locationTV;

    ListSpecialities specialityList;

    @Inject
    protected SearchEventsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_events);

        App.getComponent().inject(this);
        presenter.onCreate(this);

        searchLine = (EditText) findViewById(R.id.editSearchEvents);

        startDateTV = (TextView) findViewById(R.id.searchEventsStart);
        startDateTV.setOnClickListener(this);
        endDateTV = (TextView) findViewById(R.id.searchEventsEnd);
        endDateTV.setOnClickListener(this);
        specializationTV = (TextView) findViewById(R.id.searchEventsSpecializations);
        specializationTV.setOnClickListener(this);
        locationTV = (TextView) findViewById(R.id.searchEventsLocation);
        locationTV.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.searchEventsStart:
                setStartDate();
                break;
            case R.id.searchEventsEnd:
                setEndDate();
                break;
            case R.id.searchEventsSpecializations:
                setSpecialization();
                break;
            case R.id.searchEventsLocation:
                setLocation();
                break;

        }
    }

    @Override
    public void showSpecialities(ListSpecialities specialities) {
        specialityList = specialities;
        FragmentSpecialitiesDialog dialog = new FragmentSpecialitiesDialog();
        dialog.setArraySpecialities(specialities);
        dialog.show(getSupportFragmentManager(), "s");
    }

    @Override
    public void showFailSpecialities() {

    }

    private void setStartDate() {
        MyDatePickerFragment fragment = new MyDatePickerFragment();
        fragment.show(getFragmentManager(), TYPE_DATE_START);
    }

    private void setEndDate() {
        MyDatePickerFragment fragment = new MyDatePickerFragment();
        fragment.show(getFragmentManager(), TYPE_DATE_END);
    }

    private void setSpecialization() {
        if (specialityList == null) {
            presenter.getSpecialities();
        } else  {
            FragmentSpecialitiesDialog dialog = new FragmentSpecialitiesDialog();
            dialog.setArraySpecialities(specialityList);
            dialog.show(getSupportFragmentManager(), "s");
        }

    }

    private void setLocation() {
        FragmentLocationDialog dialog = new FragmentLocationDialog();
        dialog.show(getSupportFragmentManager(), "g");
    }

    @Override
    public void onDatePicked(Calendar date, String type) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateFormat = format.format(date.getTime());
        Resources res = getResources();


        if (type.equals(TYPE_DATE_START)) {
            String txt = res.getString(R.string.searchEventsStart);
            startDateTV.setText(txt + ": " + dateFormat);
        } else {
            String txt = res.getString(R.string.searchEventsEnd);
            endDateTV.setText(txt +": " + dateFormat);
        }
    }

    @Override
    public void selectSpeciality(Speciality speciality) {
        Log.d(MY_TAG, speciality.title);
    }

    @Override
    public void selectLocation(int location) {
        Log.d(MY_TAG, location + "");
    }
}
