package com.example.wind.smalldou.mvp.presenter;

import com.example.wind.smalldou.mvp.contract.DetailContract;
import com.example.wind.smalldou.mvp.model.bean.MovieDetailsBean;
import com.example.wind.smalldou.usecase.FetchMovieDetailsBeanUsecase;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Wind1129 on 17/4/17.
 */

public class MovieDetailPresenter implements DetailContract.Presenter {
    private FetchMovieDetailsBeanUsecase movieDetailsBeanUsecase;
    private DetailContract.View<MovieDetailsBean> mView;
    private CompositeSubscription mCompositeSubscription;


    public MovieDetailPresenter(FetchMovieDetailsBeanUsecase movieDetailsBeanUsecase) {
        this.movieDetailsBeanUsecase = movieDetailsBeanUsecase;
    }

    @Override
    public void attachView(DetailContract.View view) {
        mView = view;
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStop() {
        if (mCompositeSubscription != null && mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void refresh(String movieId) {
        //设置movieDetailsBeanUsecase的参数
        movieDetailsBeanUsecase.setMovieId(movieId);

        Subscription subscription = movieDetailsBeanUsecase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(new Func1<Throwable, MovieDetailsBean>() {

                    @Override
                    public MovieDetailsBean call(Throwable throwable) {
                        mView.hideProgressBar();
                        mView.showError("refresh error");
                        return null;
                    }
                })
                .subscribe(new Action1<MovieDetailsBean>() {
                    @Override
                    public void call(MovieDetailsBean movieDetailsBean) {
                        if(movieDetailsBean!=null) {
                            mView.hideProgressBar();
                            mView.showStory(movieDetailsBean);
                        }

                    }
                });
        mCompositeSubscription.add(subscription);
    }
}
