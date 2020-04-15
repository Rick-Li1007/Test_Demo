package com.rick.testdemo.test;


import com.rick.testdemo.entity.BaseEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * package: TestApi
 * author: Rick
 * date: 2020-04-03 11:23
 * desc:
 */

public interface TestApiService {

    @FormUrlEncoded
    @POST("/app/game/list")
    Observable<BaseEntity> queryMsgResult(@Field("gameId") String gameId);

}
