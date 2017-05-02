package com.example.wind.smalldou.api;

import com.example.wind.smalldou.mvp.model.bean.BookBean;
import com.example.wind.smalldou.mvp.model.bean.BookDetailsBean;
import com.example.wind.smalldou.mvp.model.bean.BookResult;
import com.example.wind.smalldou.mvp.model.bean.MovieBean;
import com.example.wind.smalldou.mvp.model.bean.MovieDetailsBean;
import com.example.wind.smalldou.mvp.model.bean.MovieReslut;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Wind1129 on 17/4/5.
 */

public interface DouBanApiService {
    /**
     * 根据tag获取电影
     * https://api.douban.com/v2/movie/search?tag=喜剧&start=20
     *
     * @return
     */

    @GET("movie/search")
    Observable<MovieReslut<List<MovieBean>>> getMovieByTag
    (@Query("tag") String tag, @Query("start") int start, @Query("count") int count);

    /**
     * 获取正在热映的电影
     * https://api.douban.com/v2/movie/in_theaters
     */
    @GET("movie/in_theaters")
    Observable<MovieReslut<List<MovieBean>>> getMovieByHot
    (@Query("start") int start, @Query("count") int count);

    /**
     * 即将上映的电影
     * https://api.douban.com/v2/movie/coming_soon
     */
    @GET("movie/coming_soon")
    Observable<MovieReslut<List<MovieBean>>> getMovieByNew
    (@Query("start") int start, @Query("count") int count);

    /**
     * 电影top250
     * https://api.douban.com/v2/movie/top250?start=20&count=60
     */
    @GET("movie/top250")
    Observable<MovieReslut<List<MovieBean>>> getMovieByTop
    (@Query("start") int start, @Query("count") int count);

    /**
     * 根据关键字查找电影
     * https://api.douban.com/v2/movie/search?q=无敌&start=20&count=5
     *
     * @return
     */
    @GET("movie/search")
    Observable<MovieReslut<List<MovieBean>>> getMovieByQ
    (@Query("q") String q, @Query("start") int start, @Query("count") int count);

    /**
     * 根据tag获取图书
     * https://api.douban.com/v2/book/search?tag=日本文学&start=20&count=60
     *
     * @return
     */
    @GET("book/search")
    Observable<BookResult<List<BookBean>>> getBooksByTag
    (@Query("tag") String tag, @Query("start") int start, @Query("count") int count);


    @GET("movie/subject/{MovieId}")
    Observable<MovieDetailsBean> getMovieDetails
            (@Path("MovieId") String MovieId);



    @GET("book/{BookId}")
    Observable<BookDetailsBean> getBookDetails
            (@Path("BookId") String BookId);

    @GET("book/search")
    Observable<BookResult<List<BookBean>>> getBooksByQ
            (@Query("q") String q, @Query("start") int start, @Query("count") int count);
}
