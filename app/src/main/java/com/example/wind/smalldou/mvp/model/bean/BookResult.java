package com.example.wind.smalldou.mvp.model.bean;

/**
 * Created by Wind1129 on 17/4/5.
 */

public class BookResult<T> {
    private int count;
    private int start;
    private int total;
    private T books;

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

    public T getBooks() {
        return books;
    }

    public void setBooks(T books) {
        this.books = books;
    }
}
