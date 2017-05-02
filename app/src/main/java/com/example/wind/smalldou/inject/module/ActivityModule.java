package com.example.wind.smalldou.inject.module;

import android.app.Activity;
import android.content.Context;

import com.example.wind.smalldou.inject.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Wind1129 on 17/4/10.
 */

@Module
public class ActivityModule {
    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }


    @Provides
    @PerActivity
    public Context providerContext() {
        return mActivity;
    }
}
