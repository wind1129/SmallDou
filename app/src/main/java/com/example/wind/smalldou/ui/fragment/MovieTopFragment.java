package com.example.wind.smalldou.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.wind.smalldou.Constants;
import com.example.wind.smalldou.R;
import com.example.wind.smalldou.SmallDouApplication;
import com.example.wind.smalldou.inject.component.ApplicationComponent;
import com.example.wind.smalldou.inject.component.DaggerMovieComponent;
import com.example.wind.smalldou.inject.component.MovieComponent;
import com.example.wind.smalldou.inject.module.ActivityModule;
import com.example.wind.smalldou.inject.module.MovieModule;
import com.example.wind.smalldou.interfaces.LoadMoreScrollListener;
import com.example.wind.smalldou.interfaces.OnItemClickLinkToListener;
import com.example.wind.smalldou.mvp.contract.CommonContract;
import com.example.wind.smalldou.mvp.model.bean.MovieBean;
import com.example.wind.smalldou.ui.activity.MovieDetailActivity;
import com.example.wind.smalldou.ui.adapter.PageMovieAdapter;
import com.example.wind.smalldou.ui.adapter.PageMovieTopAdapter;
import com.example.wind.smalldou.utils.IntentExtras;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Wind1129 on 17/4/20.
 */

public class MovieTopFragment extends PagerFragment implements CommonContract.View<List<MovieBean>> {
    @Inject
    CommonContract.Presenter presenter;

    private PageMovieTopAdapter pageMovieTopAdapter;

    //电影的类型，分为hot，soon，top，tap四类
    private int mMovieType;

    //这里偷个懒，就不加载到250了
    public static final int RECORD_COUNT = 100;

    public MovieTopFragment(int mMovieType) {
        this.mMovieType = mMovieType;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependences();
        presenter.attachView(this);
        pageMovieTopAdapter = new PageMovieTopAdapter(getActivity());
    }

    private void injectDependences() {
        ApplicationComponent applicationComponent = ((SmallDouApplication) (getActivity().getApplication()))
                .getApplicationComponent();
        MovieComponent movieComponent = DaggerMovieComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(new ActivityModule(getActivity()))
                .movieModule(new MovieModule())
                .build();
        movieComponent.inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecycleView();
        initListener();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setAdapter(pageMovieTopAdapter);
        presenter.refresh(Constants.MOVIETITLE[getPagerPosition()], 0, RECORD_COUNT, mMovieType);

    }


    /**
     * 初始化RecycleView
     */
    private void initRecycleView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.refresh(Constants.MOVIETITLE[getPagerPosition()], 0, RECORD_COUNT, mMovieType);
            }
        });


    }


    private void initListener() {
        pageMovieTopAdapter.setmListener(new OnItemClickLinkToListener() {
            @Override
            public void ItemClickListener(String id, String imgUrl) {
                Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                intent.putExtra(IntentExtras.KEY_MOVIE_ID, id);
                intent.putExtra(IntentExtras.KEY_IMAGE_URL, imgUrl);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showError(String errorString) {

    }

    @Override
    public void hideRefreshing() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showRefreshing() {

        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void showStory(List<MovieBean> movieBeen) {
        pageMovieTopAdapter.setDatas(movieBeen);

    }

    @Override
    public void appendStory(List<MovieBean> movieBeen) {

    }

    @Override
    public void hideFooter() {
        footer.setVisibility(View.GONE);
    }
}
