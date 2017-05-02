package com.example.wind.smalldou.mvp.model.bean;

/**
 * Created by Wind1129 on 17/4/5.
 */

/**
 * "small": "https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2448676053.jpg",
   "large": "https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2448676053.jpg",
   "medium": "https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2448676053.jpg"
 */

/**
 * 图片实体类
 */
public class ImagesBean {
    private String small;
    private String large;
    private String medium;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
