package com.example.wind.smalldou.mvp.model.bean;

/**
 * Created by Wind1129 on 17/4/5.
 */


/**
 * "max": 10,
   "average": 6.6,
   "stars": "35",
   "min": 0
 */

/**
 *评分实体类
 */
public class RatingBean {
    private int max;
    private double average;
    private String stars;
    private int min;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
