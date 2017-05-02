package com.example.wind.smalldou.usecase;

import com.example.wind.smalldou.mvp.model.bean.MovieDetailsBean;
import com.example.wind.smalldou.respository.interfaces.Repository;

import rx.Observable;

/**
 * Created by Wind1129 on 17/4/17.
 */

public class FetchMovieDetailsBeanUsecase implements UseCase<MovieDetailsBean>{
    private Repository mRepository;
    private String movieId;

    public FetchMovieDetailsBeanUsecase(Repository mRepository) {
        this.mRepository = mRepository;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Override
    public Observable<MovieDetailsBean> execute() {
        return mRepository.getMovieDetails(movieId);
    }
}
