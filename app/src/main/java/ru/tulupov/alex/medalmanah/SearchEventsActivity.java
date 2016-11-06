package ru.tulupov.alex.medalmanah;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SearchEventsActivity extends AppCompatActivity
        implements View.OnClickListener, MyDatePickerFragment.DatePickerListener {

    private static final String TYPE_DATE_START = "start";
    private static final String TYPE_DATE_END = "end";

    EditText searchLine;
    TextView startDateTV;
    TextView endDateTV;
    TextView specializationTV;
    TextView locationTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_events);

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

    private void setStartDate() {
        MyDatePickerFragment fragment = new MyDatePickerFragment();
        fragment.show(getFragmentManager(), TYPE_DATE_START);
    }

    private void setEndDate() {
        MyDatePickerFragment fragment = new MyDatePickerFragment();
        fragment.show(getFragmentManager(), TYPE_DATE_END);
    }

    private void setSpecialization() {

    }

    private void setLocation() {

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
}
