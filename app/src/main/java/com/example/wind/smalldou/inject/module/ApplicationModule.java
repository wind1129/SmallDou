package com.example.wind.smalldou.inject.module;

import android.app.Application;

import com.example.wind.smalldou.SmallDouApplication;
import com.example.wind.smalldou.inject.scope.PerApplication;

import javax.inject.Scope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Wind1129 on 17/4/6.
 */


@Module
public class ApplicationModule {
    SmallDouApplication mApplication;

    public ApplicationModule(SmallDouApplication application) {
        this.mApplication = application;
    }

    @PerApplication
    @Provides
    Application provideApplication(){
        return mApplication;
    }
}
