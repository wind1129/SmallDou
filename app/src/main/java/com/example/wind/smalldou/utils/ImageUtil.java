package com.example.wind.smalldou.utils;

import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;

import com.example.wind.smalldou.R;
import com.example.wind.smalldou.SmallDouApplication;

/**
 * Created by Wind1129 on 17/4/14.
 */

public class ImageUtil {
    /**
     * 根据bitmap提取颜色
     *
     * @param bitmap
     * @return
     */
    public static int getColor(Bitmap bitmap) {
        if (bitmap != null) {
            Palette p = Palette.from(bitmap).generate();
            Palette.Swatch s_dm = p.getDarkMutedSwatch();
            Palette.Swatch s_dv = p.getDarkVibrantSwatch();
            if (s_dm != null) {
                return s_dm.getRgb();
            } else {
                if (s_dv != null) {
                    return s_dv.getRgb();
                } else {
                    return SmallDouApplication.getContext().getResources().getColor(R.color.colorPrimary);
                }
            }
        } else {
            return SmallDouApplication.getContext().getResources().getColor(R.color.colorPrimary);
        }
    }
}
