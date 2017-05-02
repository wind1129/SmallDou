package com.example.wind.smalldou.mvp.model.bean;

import java.util.List;

/**
 * Created by Wind1129 on 17/4/5.
 */


/**
 *
 "rating": {
 "max": 10,
 "average": 6.6,
 "stars": "35",
 "min": 0
 },
 "genres": [
 "犯罪",
 "悬疑"
 ],
 "title": "嫌疑人X的献身",
 "casts": [
 {
 "alt": "https://movie.douban.com/celebrity/1314544/",
 "avatars": {
 "small": "https://img3.doubanio.com/img/celebrity/small/1444998211.72.jpg",
 "large": "https://img3.doubanio.com/img/celebrity/large/1444998211.72.jpg",
 "medium": "https://img3.doubanio.com/img/celebrity/medium/1444998211.72.jpg"
 },
 "name": "王凯",
 "id": "1314544"
 },
 {
 "alt": "https://movie.douban.com/celebrity/1323723/",
 "avatars": {
 "small": "https://img3.doubanio.com/img/celebrity/small/1416748988.73.jpg",
 "large": "https://img3.doubanio.com/img/celebrity/large/1416748988.73.jpg",
 "medium": "https://img3.doubanio.com/img/celebrity/medium/1416748988.73.jpg"
 },
 "name": "张鲁一",
 "id": "1323723"
 },
 {
 "alt": "https://movie.douban.com/celebrity/1005214/",
 "avatars": {
 "small": "https://img3.doubanio.com/img/celebrity/small/36663.jpg",
 "large": "https://img3.doubanio.com/img/celebrity/large/36663.jpg",
 "medium": "https://img3.doubanio.com/img/celebrity/medium/36663.jpg"
 },
 "name": "林心如",
 "id": "1005214"
 }
 ],
 "collect_count": 62383,
 "original_title": "嫌疑人X的献身",
 "subtype": "movie",
 "directors": [
 {
 "alt": "https://movie.douban.com/celebrity/1050540/",
 "avatars": {
 "small": "https://img3.doubanio.com/img/celebrity/small/27354.jpg",
 "large": "https://img3.doubanio.com/img/celebrity/large/27354.jpg",
 "medium": "https://img3.doubanio.com/img/celebrity/medium/27354.jpg"
 },
 "name": "苏有朋",
 "id": "1050540"
 }
 ],
 "year": "2017",
 "images": {
 "small": "https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2448676053.jpg",
 "large": "https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2448676053.jpg",
 "medium": "https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2448676053.jpg"
 },
 "alt": "https://movie.douban.com/subject/26606743/",
 "id": "26606743"

 */


/**
 * 电影们
 */
public class MovieBean {
    private RatingBean rating;
    private String title;
    private int collect_count;
    private String original_title;
    private String subtype;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }
}
