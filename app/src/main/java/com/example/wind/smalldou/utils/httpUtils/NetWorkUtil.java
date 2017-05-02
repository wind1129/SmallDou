package com.example.wind.smalldou.utils.httpUtils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Wind1129 on 17/4/7.
 */

public class NetWorkUtil {
    public static final boolean isNetWorkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo[] networkInfos=connectivityManager.getAllNetworkInfo();
            if (networkInfos != null) {
                for (NetworkInfo info : networkInfos) {
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
