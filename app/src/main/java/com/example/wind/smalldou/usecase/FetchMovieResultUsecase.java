package com.example.wind.smalldou.usecase;

import com.example.wind.smalldou.Constants;
import com.example.wind.smalldou.mvp.model.bean.MovieBean;
import com.example.wind.smalldou.mvp.model.bean.MovieReslut;
import com.example.wind.smalldou.respository.interfaces.Repository;

import java.util.List;

import rx.Observable;

/**
 * Created by Wind1129 on 17/4/10.
 */

public class FetchMovieResultUsecase implements UseCase<MovieReslut<List<MovieBean>>> {
    private Repository mRepository;
    private String tag;
    private int start;
    private int end;
    private int type;

    public FetchMovieResultUsecase(Repository mRepository) {
        this.mRepository = mRepository;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public Observable<MovieReslut<List<MovieBean>>> execute() {
        if(type == Constants.MOVIE_TAG) {
            return mRepository.getMovieByTag(tag, start, end);
        }else if(type == Constants.MOVIE_HOT){
            return mRepository.getMovieByHot(start,end);
        }else if(type == Constants.MOVIE_SOON){
            return mRepository.getMovieByNew(start,end);
        }else if(type == Constants.MOVIE_TOP){
            return mRepository.getMovieByTop(start,end);
        }

        return mRepository.getMovieByTag(tag, start, end);
    }
}
