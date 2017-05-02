package com.example.wind.smalldou.mvp.model.bean;

/**
 * Created by Wind1129 on 17/4/5.
 */


/**
 *
     "alt": "https://movie.douban.com/celebrity/1314544/",
     "avatars": {
        "small": "https://img3.doubanio.com/img/celebrity/small/1444998211.72.jpg",
        "large": "https://img3.doubanio.com/img/celebrity/large/1444998211.72.jpg",
        "medium": "https://img3.doubanio.com/img/celebrity/medium/1444998211.72.jpg"
     },
     "name": "王凯",
     "id": "1314544"
 */


/**
 * 演员实体类
 */
public class CastsBean {


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
