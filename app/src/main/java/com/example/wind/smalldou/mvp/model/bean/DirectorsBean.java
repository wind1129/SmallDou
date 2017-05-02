package com.example.wind.smalldou.mvp.model.bean;

/**
 * Created by Wind1129 on 17/4/5.
 */


/**
 *
 *   "alt": "https://movie.douban.com/celebrity/1050540/",
     "avatars": {
         "small": "https://img3.doubanio.com/img/celebrity/small/27354.jpg",
         "large": "https://img3.doubanio.com/img/celebrity/large/27354.jpg",
         "medium": "https://img3.doubanio.com/img/celebrity/medium/27354.jpg"
     },
     "name": "苏有朋",
     "id": "1050540"
 */


/**
 * 导演实体类
 */
public class DirectorsBean {
    private String alt;
    private AvatarsBean avatars;
    private String name;
    private String id;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public AvatarsBean getAvatars() {
        return avatars;
    }

    public void setAvatars(AvatarsBean avatars) {
        this.avatars = avatars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
