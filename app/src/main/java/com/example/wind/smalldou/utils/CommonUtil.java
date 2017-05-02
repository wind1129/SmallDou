package com.example.wind.smalldou.utils;

import android.content.res.Resources;
import com.example.wind.smalldou.SmallDouApplication;
import com.example.wind.smalldou.api.DouBanApiService;

/**
 * Created by jingbin on 2016/11/22.
 * 获取原生资源
 */
public class CommonUtil {


    private static Resources getResoure() {
        return SmallDouApplication.getContext().getResources();
    }

    public static String[] getStringArray(int resid) {
        return getResoure().getStringArray(resid);
    }

    public static String getString(int resid) {
        return getResoure().getString(resid);
    }

    public static float getDimens(int resId) {
        return getResoure().getDimension(resId);
    }

}
