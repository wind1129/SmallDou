package com.example.wind.smalldou.mvp.model.bean;

/**
 * Created by Wind1129 on 17/4/5.
 */

/**
 * "small": "https://img3.doubanio.com/img/celebrity/small/1444998211.72.jpg",
   "large": "https://img3.doubanio.com/img/celebrity/large/1444998211.72.jpg",
   "medium": "https://img3.doubanio.com/img/celebrity/medium/1444998211.72.jpg"
 */


/**
 * 头像实体类
 */
public class AvatarsBean {
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
