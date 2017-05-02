package com.example.wind.smalldou.inject.scope;

/**
 * Created by Wind1129 on 17/4/6.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerApplication {

}
