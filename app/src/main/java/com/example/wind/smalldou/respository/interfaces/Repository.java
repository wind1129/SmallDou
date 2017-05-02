package com.example.wind.smalldou.respository.interfaces;

import com.example.wind.smalldou.mvp.model.bean.BookBean;
import com.example.wind.smalldou.mvp.model.bean.BookDetailsBean;
import com.example.wind.smalldou.mvp.model.bean.BookResult;
import com.example.wind.smalldou.mvp.model.bean.MovieBean;
import com.example.wind.smalldou.mvp.model.bean.MovieDetailsBean;
import com.example.wind.smalldou.mvp.model.bean.MovieReslut;

import java.util.List;

import rx.Observable;

/**
 * Created by Wind1129 on 17/4/6.
 */

public interface Repository {
    Observable<MovieReslut<List<MovieBean>>> getMovieByTag(String tag,int start,int count);
    Observable<MovieReslut<List<MovieBean>>> getMovieByHot(int start,int count);
    Observable<MovieReslut<List<MovieBean>>> getMovieByNew(int start,int count);
    Observable<MovieReslut<List<MovieBean>>> getMovieByTop(int start,int count);
    Observable<MovieReslut<List<MovieBean>>> getMovieByQ(String q,int start,int count);
    Observable<BookResult<List<BookBean>>> getBooksByTag(String tag,int start,int count);
    Observable<MovieDetailsBean> getMovieDetails(String movieId);
    Observable<BookDetailsBean> getBookDetails(String bookId);
    Observable<BookResult<List<BookBean>>> getBooksByQ(String q,int start,int count);
}
