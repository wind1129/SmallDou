package com.example.wind.smalldou.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wind.smalldou.Constants;
import com.example.wind.smalldou.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Wind1129 on 17/4/7.
 */

public class PagerFragment extends Fragment {
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.recycle_view)
    RecyclerView recyclerView;


    public View rootView;

    public View footer;

    //PagerFragment类型
    private int pagerType;
    //PagerFragment所在当前位置
    private int pagerPosition;


    public static PagerFragment newInstance(int type,int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.Fragment_TYPE, type);
        bundle.putInt(Constants.Fragment_POSITION,position);
        PagerFragment pagerFragment = null;
        if (type == Constants.MOVIE_TAG) {
            pagerFragment = new MovieFragment(Constants.MOVIE_TAG);
        } else if (type == Constants.MOVIE_HOT) {
            pagerFragment = new MovieFragment(Constants.MOVIE_HOT);
        } else if (type == Constants.MOVIE_SOON) {
            pagerFragment = new MovieFragment(Constants.MOVIE_SOON);
        } else if (type == Constants.MOVIE_TOP) {
            pagerFragment = new MovieTopFragment(Constants.MOVIE_TOP);
        }
        pagerFragment.setArguments(bundle);
        return pagerFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pagerType = getArguments().getInt(Constants.Fragment_TYPE);
        pagerPosition = getArguments().getInt(Constants.Fragment_POSITION);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_pager, container, false);
        ButterKnife.bind(this, rootView);

        //点击Tab让recycleView滚动到第一条
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        TabsFragment tabsFragment = (TabsFragment) fm.findFragmentByTag(TabsFragment.TAG);
        tabsFragment.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if(recyclerView.getAdapter().getItemCount()>=50){
                    recyclerView.scrollToPosition(0);
                }else {
                    recyclerView.smoothScrollToPosition(0);
                }

            }
        });

        return rootView;
    }

    public int getPagerType() {
        return pagerType;
    }

    public int getPagerPosition() {
        return pagerPosition;
    }
}
