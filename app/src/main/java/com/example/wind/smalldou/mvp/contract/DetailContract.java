package com.example.wind.smalldou.mvp.contract;

import com.example.wind.smalldou.mvp.presenter.BasePresenter;
import com.example.wind.smalldou.mvp.view.BaseView;

/**
 * Created by Wind1129 on 17/4/17.
 */

public interface DetailContract {
    interface View<T> extends BaseView {
        void showError(String errorString);

        void showStory(T t);

        void showProgressBar();

        void hideProgressBar();
    }


    interface Presenter extends BasePresenter<DetailContract.View> {
        void refresh(String movieId);
    }
}
