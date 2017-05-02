package com.example.wind.smalldou.respository;

import com.example.wind.smalldou.api.DouBanApiService;
import com.example.wind.smalldou.mvp.model.bean.BookBean;
import com.example.wind.smalldou.mvp.model.bean.BookDetailsBean;
import com.example.wind.smalldou.mvp.model.bean.BookResult;
import com.example.wind.smalldou.mvp.model.bean.MovieBean;
import com.example.wind.smalldou.mvp.model.bean.MovieDetailsBean;
import com.example.wind.smalldou.mvp.model.bean.MovieReslut;
import com.example.wind.smalldou.respository.interfaces.Repository;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by Wind1129 on 17/4/6.
 */

public class RepositoryImpl implements Repository {
    private DouBanApiService mApiService;

    public RepositoryImpl(Retrofit retrofit) {
        mApiService = retrofit.create(DouBanApiService.class);
    }

    @Override
    public Observable<MovieReslut<List<MovieBean>>> getMovieByTag(String tag, int start, int count) {
        return mApiService.getMovieByTag(tag,start,count);
    }

    @Override
    public Observable<MovieReslut<List<MovieBean>>> getMovieByHot(int start, int count) {
        return mApiService.getMovieByHot(start, count);
    }

    @Override
    public Observable<MovieReslut<List<MovieBean>>> getMovieByNew(int start, int count) {
        return mApiService.getMovieByNew(start, count);
    }

    @Override
    public Observable<MovieReslut<List<MovieBean>>> getMovieByTop(int start, int count) {
        return mApiService.getMovieByTop(start, count);
    }

    @Override
    public Observable<MovieReslut<List<MovieBean>>> getMovieByQ(String q,int start, int count) {
        return mApiService.getMovieByQ(q, start, count);
    }

    @Override
    public Observable<BookResult<List<BookBean>>> getBooksByTag(String tag, int start, int count) {
        return mApiService.getBooksByTag(tag, start, count);
    }

    @Override
    public Observable<MovieDetailsBean> getMovieDetails(String movieId) {
        return mApiService.getMovieDetails(movieId);
    }

    @Override
    public Observable<BookDetailsBean> getBookDetails(String bookId) {
        return mApiService.getBookDetails(bookId);
    }

    @Override
    public Observable<BookResult<List<BookBean>>> getBooksByQ(String q, int start, int count) {
        return mApiService.getBooksByQ(q, start, count);
    }
}
