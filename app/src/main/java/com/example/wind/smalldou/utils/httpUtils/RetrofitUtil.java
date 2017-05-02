package com.example.wind.smalldou.utils.httpUtils;

import android.content.Context;

import com.example.wind.smalldou.Constants;
import com.example.wind.smalldou.SmallDouApplication;
import com.example.wind.smalldou.interceptor.CacheInterceptor;
import com.example.wind.smalldou.utils.FileUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by Wind1129 on 17/4/6.
 */

public class RetrofitUtil {

    public static Retrofit getRetrofit(String baseUrl) {

        Gson gson = new GsonBuilder().create();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        //OKHttp日志
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //OkHttp配置(缓存，超时之类）
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(new Cache(FileUtil.getHttpCacheDir(SmallDouApplication.getContext()), Constants.HTTP_CACHE_SIZE))
                .connectTimeout(Constants.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(Constants.HTTP_READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .addInterceptor(new CacheInterceptor())
                .build();
        OkHttpClient newClient = client.newBuilder().addInterceptor(loggingInterceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(newClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }



}
