package org.sopt.remote.api

import org.sopt.remote.model.ResShoppingMall
import org.sopt.remote.model.ResStory
import retrofit2.http.GET
import retrofit2.http.Headers

interface StoreService {
    @GET("store")
    @Headers("token: token")
    suspend fun getShoppingMall(): List<ResShoppingMall>

    @GET("story")
    @Headers("token: token")
    suspend fun getStory(): List<ResStory>
}