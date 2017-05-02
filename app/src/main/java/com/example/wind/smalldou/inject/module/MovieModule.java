package com.example.wind.smalldou.inject.module;

import com.example.wind.smalldou.mvp.contract.CommonContract;
import com.example.wind.smalldou.mvp.presenter.MoviePresenter;
import com.example.wind.smalldou.respository.interfaces.Repository;
import com.example.wind.smalldou.usecase.FetchMovieResultUsecase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Wind1129 on 17/4/10.
 */

@Module
public class MovieModule {
    @Provides
    public FetchMovieResultUsecase providerMovieResultUsecase(Repository repository){
        return new FetchMovieResultUsecase(repository);
    }

    @Provides
    public CommonContract.Presenter providerCommonPresenter(FetchMovieResultUsecase movieResultUsecase){
        return new MoviePresenter(movieResultUsecase);
    }

}
