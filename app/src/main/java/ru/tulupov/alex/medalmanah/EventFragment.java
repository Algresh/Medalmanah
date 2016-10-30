package ru.tulupov.alex.medalmanah;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class EventFragment extends BaseFragment {

    public static final int LAYOUT = R.layout.event_fragment;


    public static EventFragment getInstance() {
        EventFragment fragment = new EventFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
