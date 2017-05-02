package com.example.wind.smalldou;

import android.app.Application;
import android.content.Context;

import com.example.wind.smalldou.inject.component.ApplicationComponent;
import com.example.wind.smalldou.inject.component.DaggerApplicationComponent;
import com.example.wind.smalldou.inject.module.ApplicationModule;
import com.example.wind.smalldou.inject.module.NetWorkModule;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Wind1129 on 17/4/6.
 */

public class SmallDouApplication extends Application{
    public static Context appContext;
    private static RefWatcher sRefWatcher;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        setCrashHandler();
        initLeakCanary();
        setupInjector();
    }

    private void setCrashHandler() {
        CrashHandler crashHandler = CrashHandler.getInstance(this);
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
    }

    private void initLeakCanary() {
        sRefWatcher= LeakCanary.install(this);
    }

    private void setupInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netWorkModule(new NetWorkModule(Constants.DOUBAN_BASE_URL))//这里传入了一个URL参数
                .build();
    }

    public static Context getContext() {
        return appContext;
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
