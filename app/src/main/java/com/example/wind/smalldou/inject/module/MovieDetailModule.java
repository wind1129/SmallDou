package com.example.wind.smalldou.inject.module;

import com.example.wind.smalldou.mvp.contract.DetailContract;
import com.example.wind.smalldou.mvp.presenter.MovieDetailPresenter;
import com.example.wind.smalldou.respository.interfaces.Repository;
import com.example.wind.smalldou.usecase.FetchMovieDetailsBeanUsecase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Wind1129 on 17/4/17.
 */

@Module
public class MovieDetailModule {
    @Provides
    public FetchMovieDetailsBeanUsecase providerMovieDetailsBeanUsecase(Repository repository) {
        return new FetchMovieDetailsBeanUsecase(repository);
    }

    @Provides
    protected DetailContract.Presenter providerMovieDetailPresenter(FetchMovieDetailsBeanUsecase movieDetailsBeanUsecase){
        return new MovieDetailPresenter(movieDetailsBeanUsecase);
    }
}
