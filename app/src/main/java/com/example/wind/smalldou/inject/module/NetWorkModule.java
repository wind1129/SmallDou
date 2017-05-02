package com.example.wind.smalldou.inject.module;

import com.example.wind.smalldou.inject.scope.PerApplication;
import com.example.wind.smalldou.respository.RepositoryImpl;
import com.example.wind.smalldou.respository.interfaces.Repository;
import com.example.wind.smalldou.utils.httpUtils.RetrofitUtil;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Wind1129 on 17/4/6.
 */

@Module
public class NetWorkModule {
    String baseUrl;

    public NetWorkModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @PerApplication
    @Provides
    Repository provideRepository(Retrofit retrofit){
        return new RepositoryImpl(retrofit);
    };

    @PerApplication
    @Provides
    Retrofit provideRetrofit(){
        return RetrofitUtil.getRetrofit(baseUrl);
    };
}
