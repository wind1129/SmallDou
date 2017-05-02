package com.example.wind.smalldou.mvp.model.bean;

/**
 * Created by Wind1129 on 17/4/5.
 */

import java.util.List;

/**
  *
     "rating": {
         "max": 10,
         "average": 6.6,
         "stars": "35",
         "min": 0
     },
     "reviews_count": 3011,
     "wish_count": 25149,
     "douban_site": "",
     "year": "2017",
     "images": {
         "small": "https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2448676053.jpg",
         "large": "https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2448676053.jpg",
         "medium": "https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2448676053.jpg"
     },
     "alt": "https://movie.douban.com/subject/26606743/",
     "id": "26606743",
     "mobile_url": "https://movie.douban.com/subject/26606743/mobile",
     "title": "嫌疑人X的献身",
     "do_count": null,
     "share_url": "https://m.douban.com/movie/subject/26606743",
     "seasons_count": null,
     "schedule_url": "https://movie.douban.com/subject/26606743/cinema/",
     "episodes_count": null,
     "countries": [
            "中国大陆"
     ],
     "genres": [
             "犯罪",
             "悬疑"
     ],
     "collect_count": 62515,
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
             },
             {
             "alt": "https://movie.douban.com/celebrity/1316291/",
             "avatars": {
                 "small": "https://img3.doubanio.com/img/celebrity/small/1466926813.73.jpg",
                 "large": "https://img3.doubanio.com/img/celebrity/large/1466926813.73.jpg",
                 "medium": "https://img3.doubanio.com/img/celebrity/medium/1466926813.73.jpg"
             },
             "name": "叶祖新",
             "id": "1316291"
             }
     ],
     "current_season": null,
     "original_title": "嫌疑人X的献身",
     "summary": "在刑警学院任职的物理天才唐川（王凯 饰）与中学教师石泓（张鲁一 饰）年少相识，因彼此对数学的共同兴趣而惺惺相惜，多年后唐川在调查一桩杀人案时， 身为石泓邻居的陈婧（林心如 饰）被列入警方的“嫌疑人”之中，石泓与唐川因此再度重逢，而唐川却在调查中发现了更大的秘密……被迫站在对立面的唐川、石泓由此展开了一场高智商对决，一步步推动故事走向既震撼人心又令人扼腕的结局。",
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
     "comments_count": 35779,
     "ratings_count": 60405,
     "aka": [
         "The Devotion of Suspect X",
         "Suspect X"
     ]
 */


/**
 * 电影详情
 */
public class MovieDetailsBean {
    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String douban_site;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private Object do_count;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private Object episodes_count;
    private int collect_count;
    private Object current_season;
    private String original_title;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<String> countries;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;
    private List<String> aka;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
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

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
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

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }
}
