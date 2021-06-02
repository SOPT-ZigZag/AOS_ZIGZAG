package org.sopt.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.sopt.remote.api.HomeService
import org.sopt.remote.api.StoreService
import org.sopt.remote.network.ContentInterceptor

object ServiceCreator {
    private const val BASE_URL = "18.217.241.233:5000/api"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(getOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val homeService:HomeService = retrofit.create(HomeService::class.java)
    val storeService:StoreService = retrofit.create(StoreService::class.java)

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    private fun getOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor())
        .addInterceptor(ContentInterceptor())
        .build()
}