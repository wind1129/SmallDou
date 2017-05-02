package com.example.wind.smalldou.mvp.presenter;

import com.example.wind.smalldou.mvp.view.BaseView;

/**
 * Created by Wind1129 on 17/4/10.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);

    void onCreate();

    void onStop();
}
