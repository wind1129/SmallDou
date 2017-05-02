package com.example.wind.smalldou.interceptor;

import com.example.wind.smalldou.SmallDouApplication;
import com.example.wind.smalldou.utils.httpUtils.NetWorkUtil;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Wind1129 on 17/4/7.
 */

public class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!NetWorkUtil.isNetWorkAvailable(SmallDouApplication.getContext())){
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)//仅仅使用缓存
                    .build();
        }
        Response response = chain.proceed(request);
        if (NetWorkUtil.isNetWorkAvailable(SmallDouApplication.getContext())) {// 有网络时 设置缓存超时时间0个小时
            int maxAge = 0 * 60;
            response.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .removeHeader("Pragma") // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                    .build();
        }else { // 无网络时，设置超时为4周
            int maxStale = 60 * 60 * 24 * 28;
            response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .removeHeader("Pragma")
                    .build();
        }
        return response;
    }
}
