package com.example.wind.smalldou.inject.component;

import com.example.wind.smalldou.inject.module.ActivityModule;
import com.example.wind.smalldou.inject.module.MovieDetailModule;
import com.example.wind.smalldou.inject.scope.PerActivity;
import com.example.wind.smalldou.ui.fragment.MovieDetailFragment;

import javax.inject.Inject;

import dagger.Component;

/**
 * Created by Wind1129 on 17/4/17.
 */


@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = {ActivityModule.class, MovieDetailModule.class})
public interface MovieDetailComponent {
    void inject(MovieDetailFragment movieDetailFragment);

}
