package com.example.wind.smalldou.interfaces;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Wind1129 on 17/4/13.
 */


/**
 * 加载更多的Listener
 */
public abstract class LoadMoreScrollListener extends RecyclerView.OnScrollListener {
    //声明一个GridLayoutManager
    private GridLayoutManager mGridLayoutManager;

    //当前页，从0开始
    private int currentPage = 0;

    //已经加载出来的Item的数量
    private int totalItemCount;

    //主要用来存储上一个totalItemCount
    private int previousTotal = 0;

    //在屏幕上可见的item数量
    private int visibleItemCount;

    //在屏幕可见的Item中的第一个
    private int firstVisibleItem;

    //是否正在上拉数据
    private boolean loading = true;


    /**
     * 通过构造方法赋值GridLayoutManager
     * @param gridLayoutManager
     */
    // TODO: 17/4/14 这里写死了 可以加上LineLayoutManager或者别的
    public LoadMoreScrollListener(GridLayoutManager gridLayoutManager) {
        this.mGridLayoutManager = gridLayoutManager;
    }


    /**
     *  通过onScrolled的位置判断是否需要加载更多
     * @param recyclerView
     * @param dx
     * @param dy
     */
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = mGridLayoutManager.getItemCount();
        firstVisibleItem = mGridLayoutManager.findFirstVisibleItemPosition();
        if (loading) {
            if (totalItemCount > previousTotal) {
                //说明数据已经加载结束
                loading = false;
                previousTotal = totalItemCount;
            }
        }

        //已经到了recycleview最底下
        if (!loading && !recyclerView.canScrollVertically(1)) {
            currentPage++;
            onLoadMore(currentPage);
            loading = true;
        }
    }

    /**
     * 提供一个抽象方法，在Activity中监听这个LoadMoreScrollListener并实现这个方法
     * @param currentPage
     */
    public abstract void onLoadMore(int currentPage);

}
