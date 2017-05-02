package com.example.wind.smalldou.usecase;

import rx.Observable;

/**
 * Created by Wind1129 on 17/4/10.
 */

public interface UseCase<T> {
    Observable<T> execute();
}
