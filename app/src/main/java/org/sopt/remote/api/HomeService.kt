package org.sopt.remote.api

import org.sopt.remote.model.ResBanner
import org.sopt.remote.model.ResItem
import retrofit2.http.GET
import retrofit2.http.Headers

interface HomeService {
    @GET("main/banner")
    suspend fun getBanner(): ResBanner

    @GET("main/item")
    suspend fun getItem(): ResItem
}