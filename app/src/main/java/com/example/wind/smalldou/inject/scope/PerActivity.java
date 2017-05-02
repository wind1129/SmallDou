package com.example.wind.smalldou.inject.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Wind1129 on 17/4/6.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {

}
