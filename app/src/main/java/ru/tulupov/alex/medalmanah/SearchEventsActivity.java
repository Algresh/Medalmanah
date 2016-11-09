package ru.tulupov.alex.medalmanah;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import ru.tulupov.alex.medalmanah.presenter.SearchEventsPresenter;
import ru.tulupov.alex.medalmanah.view.FragmentLocationDialog;
import ru.tulupov.alex.medalmanah.view.FragmentSpecialitiesDialog;
import ru.tulupov.alex.medalmanah.view.MyDatePickerFragment;

import static ru.tulupov.alex.medalmanah.Constants.MY_TAG;

public class SearchEventsActivity extends AppCompatActivity
        implements View.OnClickListener, MyDatePickerFragment.DatePickerListener, SearchEventView
        , FragmentSpecialitiesDialog.SelectSpeciality, FragmentLocationDialog.SelectLocation {

    private static final String TYPE_DATE_START = "start";
    private static final String TYPE_DATE_END = "end";
    private static final String TAG_SPECIALITIES_DIALOG = "specialities";
    private static final String TAG_LOCATION_DIALOG = "location";

    public static final String SEARCH_PARAMETERS = "parameters";

    EditText searchLine;
    TextView startDateTV;
    TextView endDateTV;
    TextView specializationTV;
    TextView locationTV;

    ListSpecialities specialityList;
    SearchEventParameters searchParameters;

    @Inject
    protected SearchEventsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_events);
        searchParameters = new SearchEventParameters();

        App.getComponent().inject(this);
        presenter.onCreate(this);

        searchLine = (EditText) findViewById(R.id.editSearchEvents);

        startDateTV = (TextView) findViewById(R.id.searchEventsStart);
        TextView addStartTv = (TextView) findViewById(R.id.addSearchEventStart);
        addStartTv.setOnClickListener(this);

        endDateTV = (TextView) findViewById(R.id.searchEventsEnd);
        TextView addEndTv = (TextView) findViewById(R.id.addSearchEventEnd);
        addEndTv.setOnClickListener(this);

        specializationTV = (TextView) findViewById(R.id.searchEventsSpecializations);
        TextView addSpecialityTv = (TextView) findViewById(R.id.addSearchEventSpecialities);
        addSpecialityTv.setOnClickListener(this);

        locationTV = (TextView) findViewById(R.id.searchEventsLocation);
        TextView addLocationTv = (TextView) findViewById(R.id.addSearchEventLocation);
        addLocationTv.setOnClickListener(this);

        Button btnFilter = (Button) findViewById(R.id.btnEventsFilter);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(SEARCH_PARAMETERS, searchParameters);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.addSearchEventStart:
                setStartDate();
                break;
            case R.id.addSearchEventEnd:
                setEndDate();
                break;
            case R.id.addSearchEventSpecialities:
                setSpecialization();
                break;
            case R.id.addSearchEventLocation:
                setLocation();
                break;

        }
    }

    @Override
    public void showSpecialities(ListSpecialities specialities) {
        specialityList = specialities;
        FragmentSpecialitiesDialog dialog = new FragmentSpecialitiesDialog();
        dialog.setArraySpecialities(specialities);
        dialog.setSelectedItem(searchParameters.getSpeciality());
        dialog.show(getSupportFragmentManager(), TAG_SPECIALITIES_DIALOG);
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
            dialog.setSelectedItem(searchParameters.getSpeciality());
            dialog.show(getSupportFragmentManager(), TAG_SPECIALITIES_DIALOG);
        }

    }

    private void setLocation() {
        FragmentLocationDialog dialog = new FragmentLocationDialog();
        dialog.setSelectedItem(searchParameters.getLocation());
        dialog.show(getSupportFragmentManager(), TAG_LOCATION_DIALOG);
    }

    @Override
    public void onDatePicked(Calendar date, String type) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateFormat = format.format(date.getTime());
        Resources res = getResources();


        if (type.equals(TYPE_DATE_START)) {
            searchParameters.setStart(dateFormat);
            String txt = res.getString(R.string.searchEventsStart);
            startDateTV.setText(txt + ": " + dateFormat);
        } else {
            String txt = res.getString(R.string.searchEventsEnd);
            searchParameters.setEnd(dateFormat);
            endDateTV.setText(txt +": " + dateFormat);
        }
    }

    @Override
    public void selectSpeciality(Speciality speciality) {
        searchParameters.setSpeciality(speciality);
        Log.d(MY_TAG, speciality.title);
    }

    @Override
    public void selectLocation(int location) {
        searchParameters.setLocation(location);
        Log.d(MY_TAG, location + "");
    }
}
