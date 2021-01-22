package com.wuk.jetpackdemo

import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST


/**
 * @author wuk
 * @date 2021/1/21
 */
interface APIService {

   // https://www.wanandroid.com
//    @FormUrlEncoded
    @POST("/banner/json")
    fun getAccessToken(): Call<BannerBean>

}