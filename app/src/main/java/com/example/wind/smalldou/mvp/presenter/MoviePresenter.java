package com.example.wind.smalldou.mvp.presenter;

import android.util.Log;

import com.example.wind.smalldou.mvp.contract.CommonContract;
import com.example.wind.smalldou.mvp.model.bean.MovieBean;
import com.example.wind.smalldou.mvp.model.bean.MovieReslut;
import com.example.wind.smalldou.mvp.view.BaseView;
import com.example.wind.smalldou.usecase.FetchMovieResultUsecase;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Wind1129 on 17/4/10.
 */

public class MoviePresenter implements CommonContract.Presenter {
    private FetchMovieResultUsecase movieResultUsecase;
    private CommonContract.View<List<MovieBean>> mView;
    private CompositeSubscription mCompositeSubscription;

    public MoviePresenter(FetchMovieResultUsecase movieResultUsecase) {
        this.movieResultUsecase = movieResultUsecase;
    }

    @Override
    public void attachView(CommonContract.View view) {
        this.mView = view;
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
    public void refresh(String tag,int start,int end,int movieType) {
        mView.showRefreshing();

        //设置movieResultUsecase的参数
        movieResultUsecase.setTag(tag);
        movieResultUsecase.setStart(start);
        movieResultUsecase.setEnd(end);
        movieResultUsecase.setType(movieType);



        Subscription subscription = movieResultUsecase.execute()
                .map(new Func1<MovieReslut<List<MovieBean>>, List<MovieBean>>() {
                    @Override
                    public List<MovieBean> call(MovieReslut<List<MovieBean>> listMovieReslut) {
                        if(listMovieReslut != null){
                            return  listMovieReslut.getSubjects();
                        }else {
                            throw new RuntimeException("出错了");
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(new Func1<Throwable, List<MovieBean>>() {
                    @Override
                    public List<MovieBean> call(Throwable throwable) {
                        mView.showError("refresh error");
                        mView.hideRefreshing();
                        return null;
                    }
                })
                .subscribe(new Action1<List<MovieBean>>() {
                    @Override
                    public void call(List<MovieBean> movieBeen) {
                        if(movieBeen!=null){
                            mView.hideRefreshing();
                            mView.showStory(movieBeen);
                        }
                    }
                });
        mCompositeSubscription.add(subscription);
    }


    @Override
    public void loadMore(String tag,int start,int end,int movieType) {

        //设置movieResultUsecase的参数
        movieResultUsecase.setTag(tag);
        movieResultUsecase.setStart(start);
        movieResultUsecase.setEnd(end);
        movieResultUsecase.setType(movieType);

        Subscription subscription = movieResultUsecase.execute()
                .map(new Func1<MovieReslut<List<MovieBean>>, List<MovieBean>>() {
                    @Override
                    public List<MovieBean> call(MovieReslut<List<MovieBean>> listMovieReslut) {
                        if(listMovieReslut != null){
                            return  listMovieReslut.getSubjects();
                        }else {
                            throw new RuntimeException("出错了");
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(new Func1<Throwable, List<MovieBean>>() {
                    @Override
                    public List<MovieBean> call(Throwable throwable) {
                        mView.showError("loadMore error");
                        mView.hideFooter();
                        return null;
                    }
                })
                .subscribe(new Action1<List<MovieBean>>() {
                    @Override
                    public void call(List<MovieBean> movieBeen) {
                        if(movieBeen!=null&&movieBeen.size()>0){
                            mView.appendStory(movieBeen);
                        }else{
                            mView.hideFooter();
                        }
                    }
                })
                ;
        mCompositeSubscription.add(subscription);

    }
}
