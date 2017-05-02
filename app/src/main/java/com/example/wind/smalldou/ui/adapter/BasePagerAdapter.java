package com.example.wind.smalldou.ui.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.example.wind.smalldou.interfaces.OnItemClickLinkToListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wind1129 on 17/4/10.
 */

public abstract  class BasePagerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<T> mDate;
    public Context mContext;
    public static final int TYPE_ITEM = 1;
    public static final int TYPE_FOOTER = 2;
    public View mFooterView;

    /**
     * 点击监听
     */
    public OnItemClickLinkToListener mListener;




    public BasePagerAdapter(Context context) {
        mContext = context;
        mDate = new ArrayList<>();
    }

    /**
     * 获得mDate.size()
     */
    public int getStart(){
        return mDate.size();
    }

    public void setDatas(List<T> dates) {
        mDate.clear();
        mDate.addAll(dates);
        notifyDataSetChanged();
    }

    public void appendDatas(List<T> dates){
        mDate.addAll(dates);
        notifyDataSetChanged();

    }

    public void setmListener(OnItemClickLinkToListener listener) {
        this.mListener = listener;
    }

    /**
     * 设置脚布局
     */
    public void setFooterView(View footerView) {
            mFooterView = footerView;
        if(mDate.size()!=0) {
            notifyItemInserted(getItemCount() - 1);
        }
    }

    public View getFooterView() {
        return mFooterView;
    }


    /**
     *  GridLayoutManager 是要设置SpanSize每行的占位大小
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                //这个方法的返回值决定了我们每个position上的item占据的单元格个数
                @Override
                public int getSpanSize(int position) {
                    if (getItemViewType(position) == TYPE_FOOTER) {
                        return gridManager.getSpanCount();
                    } else {
                        return 1;
                    }
                }
            });
        }
    }


    /**
     * StaggerLayoutManager 就是要获取StaggerLayoutManager的LayoutParams 的setFullSpan 方法来设置占位宽度
     *
     * @param holder
     */
    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp != null && lp instanceof StaggeredGridLayoutManager.LayoutParams && holder.getLayoutPosition() == getItemCount() - 1) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            p.setFullSpan(true);
        }
    }

    @Override
    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);


    @Override
    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position);


    @Override
    public int getItemViewType(int position) {
        if (mFooterView == null) return TYPE_ITEM;
        if (position == getItemCount() - 1) return TYPE_FOOTER;
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        if (mFooterView == null) {
            return mDate.size();
        } else {
            return mDate.size()+1;
        }
    }
}
