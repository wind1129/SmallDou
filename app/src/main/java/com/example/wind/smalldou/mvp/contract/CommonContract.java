package com.example.wind.smalldou.mvp.contract;

import com.example.wind.smalldou.mvp.presenter.BasePresenter;
import com.example.wind.smalldou.mvp.view.BaseView;

/**
 * Created by Wind1129 on 17/4/10.
 */

public interface CommonContract {
    interface View<T> extends BaseView{
        void showError(String errorString);

        void hideRefreshing();

        void showRefreshing();

        void showStory(T t);

        void appendStory(T t);

        void hideFooter();
    }



    interface Presenter extends BasePresenter<View>{
        void refresh(String tag,int start,int end,int movieType);

        void loadMore(String tag,int start,int end,int movieType);
    }
}
