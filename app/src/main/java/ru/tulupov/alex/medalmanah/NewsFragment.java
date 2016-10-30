package ru.tulupov.alex.medalmanah;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NewsFragment extends BaseFragment {

    public static final int LAYOUT = R.layout.news_fragment;

    protected RecyclerView recyclerView;
    protected Button buttonTryAgain;
    protected SwipeRefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewNews);
        buttonTryAgain = (Button) view.findViewById(R.id.buttonTryAgain);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshRecycleView);
        buttonTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
