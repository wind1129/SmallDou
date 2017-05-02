package com.example.wind.smalldou.inject.component;

import com.example.wind.smalldou.inject.module.ActivityModule;
import com.example.wind.smalldou.inject.module.MovieModule;
import com.example.wind.smalldou.inject.module.NetWorkModule;
import com.example.wind.smalldou.inject.scope.PerActivity;
import com.example.wind.smalldou.ui.fragment.MovieFragment;
import com.example.wind.smalldou.ui.fragment.MovieTopFragment;
import com.example.wind.smalldou.ui.fragment.PagerFragment;

import javax.inject.Inject;

import dagger.Component;

/**
 * Created by Wind1129 on 17/4/10.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = {MovieModule.class, ActivityModule.class})
public interface MovieComponent {
    void inject(MovieFragment movieFragment);

    void inject(MovieTopFragment movieTopFragment);
}
