package com.example.wind.smalldou.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by Wind1129 on 17/4/7.
 */

public class FileUtil {
    private static final String HTTP_CACHE_DIR = "http";

    public static final File getHttpCacheDir(Context context){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            return new File(context.getExternalCacheDir(),HTTP_CACHE_DIR);
        }else{
            return new File(context.getCacheDir(),HTTP_CACHE_DIR);
        }
    }
}
