package com.example.wind.smalldou.mvp.model.bean;

/**
 * Created by Wind1129 on 17/4/5.
 */


/**
 *
     "count": 20,
     "start": 0,
     "total": 26,
     "subjects": [ ... ],
     "title": "正在上映的电影-北京"
 */

/**
 * 电影集合
 */
public class MovieReslut<T> {
    private int count;
    private int start;
    private int total;
    private T subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getSubjects() {
        return subjects;
    }

    public void setSubjects(T subjects) {
        this.subjects = subjects;
    }
}
