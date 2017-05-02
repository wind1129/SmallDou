package com.example.wind.smalldou.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wind.smalldou.Constants;
import com.example.wind.smalldou.R;
import com.example.wind.smalldou.animation.PageTransformer;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Wind1129 on 17/4/7.
 */

public class TabsFragment extends Fragment{
    public static final String TAG = TabsFragment.class.getSimpleName();

    private View rootView;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewPager;

    /**
     * 目录TabsFragment类型
     */
    private int type;
    private FragmentPageradapter pageradapter;

    public static TabsFragment newInstance(int type){
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.Fragment_TYPE,type);
        TabsFragment tabsFragment = new TabsFragment();
        tabsFragment.setArguments(bundle);
        return tabsFragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tabs,container,false);
        ButterKnife.bind(this,rootView);
        type = getArguments().getInt(Constants.Fragment_TYPE);
        initPagerAdapt();

        return rootView;
    }

    private void initPagerAdapt() {
        pageradapter = new FragmentPageradapter(getChildFragmentManager());
        viewPager.setAdapter(pageradapter);

        if (pageradapter.getCount()<=5){
            tabLayout.setTabMode(TabLayout.MODE_FIXED);
        }else {
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
        viewPager.setOffscreenPageLimit(pageradapter.getCount());
        viewPager.setPageTransformer(true,new PageTransformer());
        tabLayout.setupWithViewPager(viewPager);


    }

    class FragmentPageradapter extends FragmentStatePagerAdapter {

        public FragmentPageradapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(type == Constants.TYPE_MOVIE){
                return PagerFragment.newInstance(Constants.MOVIE_TAG,position);
            }else if(type == Constants.TYPE_BOOK){
                return PagerFragment.newInstance(type,position);
            }else if(type == Constants.TYPE_BILLBOARD){
                //Log.d("++++++position",position+"");
                if(position==0) {
                    return PagerFragment.newInstance(Constants.MOVIE_HOT,position);
                }else if(position == 1){
                    return PagerFragment.newInstance(Constants.MOVIE_SOON,position);
                }else {
                    return PagerFragment.newInstance(Constants.MOVIE_TOP,position);
                }
            }
            return null;
        }

        @Override
        public int getCount() {
            if(type == Constants.TYPE_MOVIE){
                return Constants.MOVIETITLE.length;
            }else if(type == Constants.TYPE_BOOK){
                return Constants.BOOKTITLE.length;
            }else if(type == Constants.TYPE_BILLBOARD){
                return Constants.HOTTITLE.length;
            };
            return 0;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            if(type == Constants.TYPE_MOVIE){
                return Constants.MOVIETITLE[position];
            }else if(type == Constants.TYPE_BOOK){
                return Constants.BOOKTITLE[position];
            }else if(type == Constants.TYPE_BILLBOARD){
                return Constants.HOTTITLE[position];
            }
            return super.getPageTitle(position);
        }
    }
}
