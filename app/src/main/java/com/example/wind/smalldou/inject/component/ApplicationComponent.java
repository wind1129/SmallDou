package com.example.wind.smalldou.inject.component;

import android.app.Application;

import com.example.wind.smalldou.inject.module.ApplicationModule;
import com.example.wind.smalldou.inject.module.NetWorkModule;
import com.example.wind.smalldou.inject.scope.PerApplication;
import com.example.wind.smalldou.respository.interfaces.Repository;

import dagger.Component;

/**
 * Created by Wind1129 on 17/4/7.
 */

@PerApplication
@Component(modules = {ApplicationModule.class, NetWorkModule.class})
public interface ApplicationComponent {
    Application application();

    Repository repository();
}
