package ru.tulupov.alex.medalmanah;

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

import ru.tulupov.alex.medalmanah.Presenter.NewsPresenter;

public class NewsFragment extends BaseFragment implements NewsView {

    public static final int LAYOUT = R.layout.news_fragment;

    protected RecyclerView recyclerView;
    protected Button buttonTryAgain;
    protected SwipeRefreshLayout refreshLayout;

    protected LinearLayoutManager manager;

    @Inject
    protected NewsPresenter presenter;

    public static NewsFragment getInstance() {
        NewsFragment fragment = new NewsFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);

        App.getComponent().inject(this);
        presenter.onCreate(this);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewNews);
        buttonTryAgain = (Button) view.findViewById(R.id.buttonTryAgain);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshRecycleView);
        buttonTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        initListOfNews(mock());

        return view;
    }

    protected void initListOfNews(List<News> newsList) {
        manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);

        NewsAdapter adapter = new NewsAdapter(newsList, getContext());
        recyclerView.setAdapter(adapter);
    }

    protected List<News> mock () {
        List<News> list = new ArrayList<>();

        for (int i = 0; i < 5; i++ ) {
            News news = new News();
            news.setAnons("Ассоциация профессиональных участников хосписной помощи при поддержке Фонда помощи хосписам «Вера» проводит в Москве II Конференцию с международным участием «Развитие паллиативной помощи взрослым и детям».");
            news.setTitle("Развитие паллиативной помощи в России");
            news.setCreated("20.11.1995");
            news.setRating(456);
            news.setLike(6);
            news.setDislike(3);
            news.setCommentCount(2);
            news.setPreview("/upload/publication/1477582267.png");
            list.add(news);
        }

        return list;
    }


    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }
}
