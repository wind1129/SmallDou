package com.example.wind.smalldou.widget;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

/**
 * Created by Wind1129 on 17/4/17.
 * 系统的滚动监听只能api23以上用，这为了兼容
 */

public class CompatNestedScrollView extends NestedScrollView {

    private ScrollInterfaceListener scrollInterfaceListener;

    /**
     * 定义滑动接口
     */
    public interface ScrollInterfaceListener {
        void onScrollChange(int scrollX, int scrollY, int oldScrollX, int oldScrollY);
    }

    public CompatNestedScrollView(Context context) {
        super(context);
    }

    public CompatNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CompatNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        if (scrollInterfaceListener != null) {
            scrollInterfaceListener.onScrollChange(l, t, oldl, oldt);
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public void setScrollInterfaceListener(ScrollInterfaceListener scrollInterfaceListener) {
        this.scrollInterfaceListener = scrollInterfaceListener;
    }
}
