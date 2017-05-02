package com.example.wind.smalldou.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wind.smalldou.Constants;
import com.example.wind.smalldou.R;
import com.example.wind.smalldou.SmallDouApplication;
import com.example.wind.smalldou.inject.component.ApplicationComponent;
import com.example.wind.smalldou.inject.component.DaggerMovieComponent;
import com.example.wind.smalldou.inject.component.MovieComponent;
import com.example.wind.smalldou.inject.module.ActivityModule;
import com.example.wind.smalldou.inject.module.MovieModule;
import com.example.wind.smalldou.interfaces.OnItemClickLinkToListener;
import com.example.wind.smalldou.mvp.contract.CommonContract;
import com.example.wind.smalldou.mvp.model.bean.MovieBean;
import com.example.wind.smalldou.ui.activity.MovieDetailActivity;
import com.example.wind.smalldou.ui.adapter.PageMovieAdapter;
import com.example.wind.smalldou.interfaces.LoadMoreScrollListener;
import com.example.wind.smalldou.utils.IntentExtras;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Wind1129 on 17/4/12.
 */

public class MovieFragment extends PagerFragment implements CommonContract.View<List<MovieBean>> {
    @Inject
    CommonContract.Presenter presenter;

    private PageMovieAdapter pageMovieAdapter;

    public static final int RECORD_COUNT = 18;

    //电影的类型，分为hot，soon，top，tap四类
    private int mMovieType;


    public MovieFragment(int mMovieType) {
        this.mMovieType = mMovieType;
    }

    /*public static MovieFragment newInstance(int movieType) {
        MovieFragment fragment = new MovieFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.MOVIE_TYPE,movieType);
        fragment.setArguments(bundle);
        return fragment;
    }*/


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    /*初始化相关*/
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectDependences();
        presenter.attachView(this);
        pageMovieAdapter = new PageMovieAdapter(getActivity());

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //mMovieType = getArguments().getInt(Constants.MOVIE_TYPE);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecycleView();
        initListener();
        initFooter();
    }

    private void initListener() {
        pageMovieAdapter.setmListener(new OnItemClickLinkToListener() {
            @Override
            public void ItemClickListener(String id, String imgUrl) {
                Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                intent.putExtra(IntentExtras.KEY_MOVIE_ID, id);
                intent.putExtra(IntentExtras.KEY_IMAGE_URL, imgUrl);
                startActivity(intent);
            }
        });
    }


    /**
     * 初始化FooterView
     */
    private void initFooter() {
        footer = LayoutInflater.from(this.getActivity()).inflate(R.layout.item_footer, recyclerView, false);
        pageMovieAdapter.setFooterView(footer);
    }

    /**
     * 初始化RecycleView
     */
    private void initRecycleView() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.refresh(Constants.MOVIETITLE[getPagerPosition()], 0, RECORD_COUNT, mMovieType);
            }
        });

        recyclerView.addOnScrollListener(new LoadMoreScrollListener((GridLayoutManager) layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                /*判断pageMovieAdapter.getStart()==0  否则当初次加载首页的时候在没有任何数据的情况下会显示footerView*/
                if (pageMovieAdapter.getStart() == 0) return;
                if (mMovieType == Constants.MOVIE_HOT) return;
                //Log.i("+++++currentPage",currentPage+"");
                presenter.loadMore(Constants.MOVIETITLE[getPagerPosition()], currentPage * RECORD_COUNT,
                        RECORD_COUNT, mMovieType);
                footer.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setAdapter(pageMovieAdapter);
        presenter.refresh(Constants.MOVIETITLE[getPagerPosition()], 0, RECORD_COUNT, mMovieType);

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
        pageMovieAdapter.setDatas(movieBeen);

    }

    @Override
    public void appendStory(List<MovieBean> movieBeen) {
        pageMovieAdapter.appendDatas(movieBeen);

    }

    @Override
    public void hideFooter() {
        footer.setVisibility(View.GONE);
    }
}
