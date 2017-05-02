package com.example.wind.smalldou;

/**
 * Created by Wind1129 on 17/4/7.
 */

public class Constants {
    public static final int HTTP_CACHE_SIZE = 20 * 1024 * 1024;//20MB
    public static final int HTTP_CONNECT_TIMEOUT = 15 * 1000;
    public static final int HTTP_READ_TIMEOUT = 20 * 1000;

    //豆瓣基础URL
    public static final String DOUBAN_BASE_URL = "https://api.douban.com/v2/";


    //目录的菜单类型
    public static final String Fragment_TYPE = "type";
    public static final int TYPE_MOVIE = 0;
    public static final int TYPE_BOOK = 1;
    public static final int TYPE_BILLBOARD = 2;

    public static final String Fragment_POSITION = "position";


    public static String[] MOVIETITLE = {"爱情", "喜剧", "动画", "科幻", "动作", "经典"};
    public static String[] BOOKTITLE = {"小说", "名著", "科幻", "历史", "爱情", "编程"};
    public static String[] HOTTITLE = {"正在热映", "即将上映", "Top250"};


    //电影类型
    public static final String MOVIE_TYPE = "MOVIE_TYPE";

    public static final int MOVIE_TAG = 4;
    public static final int MOVIE_HOT = 5;
    public static final int MOVIE_SOON = 6;
    public static final int MOVIE_TOP = 7;

}
