package ru.tulupov.alex.medalmanah.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ru.tulupov.alex.medalmanah.App;
import ru.tulupov.alex.medalmanah.model.dao.Events;
import ru.tulupov.alex.medalmanah.presenter.EventsPresenter;
import ru.tulupov.alex.medalmanah.R;
import ru.tulupov.alex.medalmanah.view.adapters.EventAdapter;


public class EventFragment extends BaseFragment implements EventView {

    public static final int LAYOUT = R.layout.event_fragment;

    protected RecyclerView recyclerView;
    protected Button buttonTryAgain;
    protected SwipeRefreshLayout refreshLayout;

    protected LinearLayoutManager manager;

    @Inject
    protected EventsPresenter presenter;

    public static EventFragment getInstance() {
        EventFragment fragment = new EventFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);

        App.getComponent().inject(this);
        presenter.onCreate(this);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewEvents);
        buttonTryAgain = (Button) view.findViewById(R.id.buttonTryAgain);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshRecycleView);
        buttonTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        initListOfEvents(mock());

        return view;
    }

    public void searchEvents () {

    }


    private void initListOfEvents (List<Events> list) {
        manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);

        EventAdapter adapter = new EventAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
    }

    protected List<Events> mock () {
        List<Events> list = new ArrayList<>();

        for (int i = 0; i < 5; i++ ) {
            Events events = new Events();
            events.setAnons("Ассоциация профессиональных участников хосписной помощи при поддержке Фонда помощи хосписам «Вера» проводит в Москве II Конференцию с международным участием «Развитие паллиативной помощи взрослым и детям».");
            events.setTitle("Развитие паллиативной помощи в России");
            events.setStart("20.11.1995");
            events.setEnd("08.10.2001");
            list.add(events);
        }

        return list;
    }
}
